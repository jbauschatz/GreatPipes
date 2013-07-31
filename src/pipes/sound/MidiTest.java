package pipes.sound;

import java.io.File;
import java.io.IOException;

import pipes.editing.io.TuneSerializer;

public class MidiTest {
	public static void main(String[] args) throws IOException {
		TunePlayer player = new TunePlayer();	
		player.setBPM(100);
		player.setTune(TuneSerializer.loadTune(new File("tunes/MacGregor of Rora.grp")));
	}
}
