package pipes.sound;

import pipes.model.Note;
import pipes.model.Tune;

/**
 * Converts a Tune to a MidiTune
 * 
 * This is an opportunity to simulate any kind of expression or musicality by lengthening or shortening notes according to rules
 */
public interface TuneToMidiConverter {
	public MidiTune convert(Tune t);
	
	public MidiTune convert(Note n);
}
