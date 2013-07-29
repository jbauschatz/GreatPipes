package pipes.sound;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import pipes.model.Pitch;

public class MidiTune {
	public Sequence sequence() {
		return sequence;
	}

	public void appendNote(Pitch p, int ticks) {
		try {
			MidiEvent onEvent = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, getMidiCode(p), 100), endTime);
			mainTrack.add(onEvent);

			endTime += ticks;
	
			MidiEvent offEvent = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, getMidiCode(p), 100), endTime);
			mainTrack.add(offEvent);
		} catch (InvalidMidiDataException imde) {

		}
	}
	
	public MidiTune(int ticksPerQuarter) {
		try {
			sequence = new Sequence(Sequence.PPQ, ticksPerQuarter);
			mainTrack = sequence.createTrack();
			mainTrack.add(new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, 111, 0), 0));
		} catch (InvalidMidiDataException imde) {

		}
	}

	private int getMidiCode(Pitch p) {
		switch (p) {
			case A: return 69;
			case G: return 67;
			case F: return 66;
			case E: return 64;
			case D: return 62;
			case C: return 61;
			case B: return 59;
			case LOW_A: return 57;
			case LOW_G: return 55;
			default: return 0;
		}		
	}

	private Track mainTrack;
	private Sequence sequence;

	// Time in Ticks
	private long endTime;
}
