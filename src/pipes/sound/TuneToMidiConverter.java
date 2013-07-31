package pipes.sound;

import pipes.model.Tune;

public interface TuneToMidiConverter {
	public MidiTune convert(Tune t);
}
