package pipes.view;

import java.util.LinkedList;

import pipes.model.BeatDivision;
import pipes.model.Measure;
import pipes.model.Note;
import pipes.model.TimeSignature;

/**
 * Takes a list of Notes and produces groups of Notes that should share a beam.
 * This follows the typesetting rules that depend on the time signature. In a 2/2 or 4/4, groups should be no longer than a quarter note.
 * In a 6/8, 9/8, or the like, group length is that of a dotted quarter.
 *
 */
public class BeamGroupingStrategy {

	public static BeamGroupingStrategy getStrategy(TimeSignature time) {
		int groupDuration;
		
		if (time.getBeatsInMeasure() % 3 == 0 && time.getBeatUnit() == BeatDivision.EIGHTH)
			groupDuration = BeatDivision.QUARTER.duration + BeatDivision.EIGHTH.duration;
		else
			groupDuration = BeatDivision.QUARTER.duration;
		
		return new BeamGroupingStrategy(groupDuration);
	}

	public Iterable<Iterable<Note>> getNoteGroups(Measure measure) {
		LinkedList<Iterable<Note>> beams = new LinkedList<Iterable<Note>>();
		
		LinkedList<Note> beamedRun = new LinkedList<Note>();
		int beamedRunLength = 0;
		
		// Create views for all the notes in the measure
		for (Note n : measure) {
			// Add to run or make a new run
			if (n.getBeatDivision().hasFlag && beamedRunLength + n.getDuration() <= groupDuration) {
				beamedRun.add(n);
				beamedRunLength += n.getDuration();
			} else {
				if (beamedRunLength > 0) {
					beams.add(beamedRun);
					beamedRun = new LinkedList<Note>();
					beamedRunLength = 0;
				}

				if (n.getBeatDivision().hasStick) {
					beamedRun.add(n);
					beamedRunLength += n.getDuration();
				}
			}
		}
		if (beamedRun.size() > 0)
			beams.add(beamedRun);
		
		return beams;
	}
	
	private BeamGroupingStrategy(int groupDuration) {
		this.groupDuration = groupDuration;
	}
	
	/**
	 * The maximum sum a group of Notes' durations should be
	 */
	private int groupDuration;
}
