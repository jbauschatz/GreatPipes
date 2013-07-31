package pipes.sound;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

import pipes.model.Tune;

public class TunePlayer {
	public void setTune(Tune t) {		
		sequencer.setTempoInBPM(beatsPerMinute);
		try {
			sequencer.open();
			sequencer.setSequence(converter.convert(t).sequence());
		} catch (MidiUnavailableException | InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

	public void setBPM(int bpm) {
		beatsPerMinute = bpm;
	}
	
	public void play() {
		sequencer.start();
	}
	
	public void pause() {
		
	}
	
	public void stop() {
		
	}
	
	public TunePlayer() {
		beatsPerMinute = 100;
		converter = new BasicMidiConverter();
		try {
			sequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	private TuneToMidiConverter converter;
	private Sequencer sequencer;
	private int beatsPerMinute;
}
