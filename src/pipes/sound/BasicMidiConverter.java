package pipes.sound;

import pipes.model.BeatDivision;
import pipes.model.Line;
import pipes.model.Measure;
import pipes.model.Note;
import pipes.model.Pitch;
import pipes.model.Tune;
import pipes.model.embellishment.Embellishment;
import pipes.model.embellishment.GraceNote;

public class BasicMidiConverter implements TuneToMidiConverter {

	public MidiTune convert(Tune tune) {
		MidiTune midi = new MidiTune(ticksPerQuarter);
		
		boolean isBuildingTiedRun = false;
		Pitch tiedPitch = null;
		int tiedTime = 0;
		
		for (Line l : tune) {
			for (Measure m : l) {
				for (Note n : m) {
					if (n.hasEmbellishment()) {
						Embellishment e = n.getEmbellishment();
						for (GraceNote g : e)
							midi.appendNote(g.pitch, g.isLong ? longGraceNoteTicks : shortGraceNoteTicks);
					}
					int noteTime = ticksPerTimeUnit*n.getDuration();
					if (n.getIsTiedForward()) {
						tiedPitch = n.getPitch();
						tiedTime += noteTime;
						isBuildingTiedRun = true;
					} else {
						if (isBuildingTiedRun) {
							// This note is the end of a tied run
							midi.appendNote(tiedPitch, tiedTime + noteTime);
						} else {
							// There is no tie involved, just play the note
							midi.appendNote(n.getPitch(), noteTime);
						}
						isBuildingTiedRun = false;
						tiedTime = 0;
					}
				}
				
				// Fill the unused time in the measure with silence
				int unusedTime = m.getTimeSignature().getMeasureDuration() - m.getDuration();
				midi.appendRest(ticksPerTimeUnit * unusedTime);
			}
		}

		midi.engageDrones();
		
		return midi;
	}
	
	public MidiTune convert(Note n) {
		MidiTune midi = new MidiTune(ticksPerQuarter);

		if (n.hasEmbellishment()) {
			Embellishment e = n.getEmbellishment();
			for (GraceNote g : e)
				midi.appendNote(g.pitch, g.isLong ? longGraceNoteTicks : shortGraceNoteTicks);
		}
		
		midi.appendNote(n.getPitch(), ticksPerTimeUnit*n.getDuration());
		return midi;
	}
	
	public BasicMidiConverter() {
		ticksPerQuarter = 128;
		ticksPerTimeUnit = ticksPerQuarter / BeatDivision.QUARTER.duration;

		shortGraceNoteTicks = ticksPerQuarter/10;
		longGraceNoteTicks = 3*shortGraceNoteTicks/2;
	}
	
	private int ticksPerQuarter;
	private int ticksPerTimeUnit;

	private int shortGraceNoteTicks;
	private int longGraceNoteTicks;
}
