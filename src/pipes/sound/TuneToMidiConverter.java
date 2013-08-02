package pipes.sound;

import pipes.model.Note;
import pipes.model.Tune;

public interface TuneToMidiConverter {
	public MidiTune convert(Tune t);
	
	public MidiTune convert(Note n);
}
