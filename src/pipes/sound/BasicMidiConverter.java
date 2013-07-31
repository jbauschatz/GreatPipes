package pipes.sound;

import pipes.model.BeatDivision;
import pipes.model.Line;
import pipes.model.Measure;
import pipes.model.Note;
import pipes.model.Tune;
import pipes.model.embellishment.Embellishment;
import pipes.model.embellishment.GraceNote;

public class BasicMidiConverter implements TuneToMidiConverter {

	public MidiTune convert(Tune tune) {
		int ticksPerQuarter = 128;
		int ticksPerTimeUnit = ticksPerQuarter / BeatDivision.QUARTER.duration;

		int shortGraceNoteTicks = ticksPerQuarter/10;
		int longGraceNoteTicks = 3*shortGraceNoteTicks/2;
		
		MidiTune midi = new MidiTune(ticksPerQuarter);
		
		for (Line l : tune) {
			for (Measure m : l) {
				for (Note n : m) {
					if (n.hasEmbellishment()) {
						Embellishment e = n.getEmbellishment();
						for (GraceNote g : e)
							midi.appendNote(g.pitch, g.isLong ? longGraceNoteTicks : shortGraceNoteTicks);
					}
					
					midi.appendNote(n.getPitch(), ticksPerTimeUnit*n.getDuration());
				}
			}
		}

		return midi;
	}
}
