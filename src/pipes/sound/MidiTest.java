package pipes.sound;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

import pipes.editing.io.TuneSerializer;
import pipes.model.Tune;

public class MidiTest {
	public static void main(String[] args) throws IOException {
		try {
			Sequencer s = MidiSystem.getSequencer();

			Tune tune = TuneSerializer.loadTune(new File("tunes/MacGregor of Rora.grp"));

			s.setTempoInBPM(100);
			s.open();
			try {
				s.setSequence(new TuneToMidi().convert(tune).sequence());
			} catch (InvalidMidiDataException imde) {

			}
			System.out.println("Starting");
			s.start();
		} catch (MidiUnavailableException mue) {

		}
	}
}
