package pipes.view;

import java.util.LinkedList;

import pipes.model.BeatDivision;
import pipes.model.Measure;
import pipes.model.Note;
import pipes.model.TimeSignature;

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
			if (n.getBeatDivision().hasFlag && beamedRunLength + n.getNoteLength() <= groupDuration) {
				beamedRun.add(n);
				beamedRunLength += n.getNoteLength();
			} else {
				if (beamedRunLength > 0) {
					beams.add(beamedRun);
					beamedRun = new LinkedList<Note>();
					beamedRunLength = 0;
				}

				if (n.getBeatDivision().hasStick) {
					beamedRun.add(n);
					beamedRunLength += n.getNoteLength();
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
	
	private int groupDuration;
}
