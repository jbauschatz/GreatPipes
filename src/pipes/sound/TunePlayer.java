package pipes.sound;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

import pipes.editing.TuneEditListener;
import pipes.editing.actions.AddNoteAction;
import pipes.editing.actions.EditAction;
import pipes.editing.actions.SetEmbellishmentFamilyAction;
import pipes.model.Note;
import pipes.model.Tune;

public class TunePlayer implements TuneEditListener {
	
	public void tuneEdited(EditAction action) {
		if (action instanceof AddNoteAction) {
			play(((AddNoteAction)action).getNoteAdded());
		} else if (action instanceof SetEmbellishmentFamilyAction) {
			SetEmbellishmentFamilyAction setFam = (SetEmbellishmentFamilyAction)action;
			play(setFam.getNote());
		}
	}
	
	public void play(Note n) {
		sequencer.close();
		try {
			sequencer.open();
			sequencer.setSequence(converter.convert(n).sequence());
			sequencer.start();
		} catch (MidiUnavailableException | InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
	
	public void setTune(Tune t) {
		sequencer.close();
		try {
			sequencer.open();
			sequencer.setSequence(converter.convert(t).sequence());
		} catch (MidiUnavailableException | InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

	public int getBPM() {
		return beatsPerMinute;
	}
	
	public void setBPM(int bpm) {
		beatsPerMinute = bpm;
		sequencer.setTempoInBPM(beatsPerMinute);
	}
	
	public void play() {
		sequencer.start();
	}
	
	public void pause() {
		
	}
	
	public void stop() {
		
	}
	
	public TunePlayer() {
		converter = new BasicMidiConverter();
		try {
			sequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		setBPM(100);
	}
	
	private TuneToMidiConverter converter;
	private Sequencer sequencer;
	private int beatsPerMinute;
}
