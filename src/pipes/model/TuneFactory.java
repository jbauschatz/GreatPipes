package pipes.model;

import static pipes.model.BeatDivision.EIGHTH;
import static pipes.model.BeatDivision.QUARTER;
import static pipes.model.BeatDivision.SIXTEENTH;
import static pipes.model.BeatDivision.THIRTY_SECOND;
import static pipes.model.Pitch.A;
import static pipes.model.Pitch.B;
import static pipes.model.Pitch.D;
import static pipes.model.Pitch.E;
import static pipes.model.Pitch.F;
import static pipes.model.Pitch.G;
import static pipes.model.Pitch.LOW_A;
import static pipes.model.Pitch.LOW_G;
import static pipes.model.embellishment.EmbellishmentFamily.A_GRACE;
import static pipes.model.embellishment.EmbellishmentFamily.DOUBLING;
import static pipes.model.embellishment.EmbellishmentFamily.D_GRACE;
import static pipes.model.embellishment.EmbellishmentFamily.E_GRACE;
import static pipes.model.embellishment.EmbellishmentFamily.G_GRACE;
import static pipes.model.embellishment.EmbellishmentFamily.GRIP;
import static pipes.model.embellishment.EmbellishmentFamily.THROW;

public class TuneFactory {

	public static Tune getNewTune(NewTuneParameters parameters) {
		Tune t = new Tune();
		
		for (int i = 0; i<parameters.lines; ++i) {
			Line l = new Line();
			t.add(l);
			for (int j = 0; j<parameters.measuresPerLine; ++j)
				l.add(new Measure(parameters.timeSignature));
		}
		
		t.getFirst().getFirst().setIsTimeSignatureChange(true);
		
		return t;
	}
	
	public static Tune getThreeFour() {
		// MacGregor of Rora
		Tune tune = new Tune();
		for (int i = 0; i<4; ++i) {
			Line l = new Line();
			for (int m = 0; m<4; ++m)
				l.add(new Measure(TimeSignature.THREE_FOUR));
			tune.add(l);
		}
		
		tune.getFirst().getFirst().setIsTimeSignatureChange(true);
		
		// Line 1
		
		// Line 2
		tune.get(1).get(0).addNote(new Note(tune, D, EIGHTH)).setEmbellishmentFamily(THROW);
		tune.get(1).get(0).addNote(new Note(tune, B, EIGHTH)).setEmbellishmentFamily(E_GRACE);
		tune.get(1).get(0).addNote(new Note(tune, D, QUARTER)).setEmbellishmentFamily(THROW);
		tune.get(1).get(0).addNote(new Note(tune, E, EIGHTH, true)).setEmbellishmentFamily(DOUBLING);
		tune.get(1).get(0).addNote(new Note(tune, D, SIXTEENTH));

		tune.get(1).get(1).addNote(new Note(tune, B, EIGHTH)).setEmbellishmentFamily(DOUBLING);
		tune.get(1).get(1).addNote(new Note(tune, LOW_A, EIGHTH)).setEmbellishmentFamily(E_GRACE);
		tune.get(1).get(1).addNote(new Note(tune, LOW_A, EIGHTH)).setEmbellishmentFamily(DOUBLING);
		tune.get(1).get(1).addNote(new Note(tune, LOW_G, EIGHTH)).setEmbellishmentFamily(E_GRACE);
		tune.get(1).get(1).addNote(new Note(tune, G, EIGHTH, true)).setEmbellishmentFamily(DOUBLING);
		tune.get(1).get(1).addNote(new Note(tune, F, SIXTEENTH));
		
		tune.get(1).get(2).addNote(new Note(tune, E, EIGHTH, true)).setEmbellishmentFamily(DOUBLING);
		tune.get(1).get(2).addNote(new Note(tune, D, SIXTEENTH));
		tune.get(1).get(2).addNote(new Note(tune, B, SIXTEENTH)).setEmbellishmentFamily(G_GRACE);
		tune.get(1).get(2).addNote(new Note(tune, D, EIGHTH, false));
		tune.get(1).get(2).addNote(new Note(tune, LOW_G, QUARTER));
		
		tune.get(1).get(3).addNote(new Note(tune, LOW_A, QUARTER)).setEmbellishmentFamily(G_GRACE);
		tune.get(1).get(3).addNote(new Note(tune, B, QUARTER)).setEmbellishmentFamily(GRIP);
		tune.get(1).get(3).addNote(new Note(tune, LOW_A, QUARTER));
		
		// Line 3
		tune.get(2).get(0).addNote(new Note(tune, LOW_A, EIGHTH, true)).setEmbellishmentFamily(G_GRACE);
		tune.get(2).get(0).addNote(new Note(tune, B, SIXTEENTH)).setEmbellishmentFamily(D_GRACE);
		tune.get(2).get(0).addNote(new Note(tune, E, QUARTER)).setEmbellishmentFamily(DOUBLING);
		tune.get(2).get(0).addNote(new Note(tune, A, QUARTER)).setEmbellishmentFamily(DOUBLING);

		tune.get(2).get(1).addNote(new Note(tune, G, EIGHTH)).setEmbellishmentFamily(DOUBLING);
		tune.get(2).get(1).addNote(new Note(tune, E, EIGHTH));
		tune.get(2).get(1).addNote(new Note(tune, E, EIGHTH)).setEmbellishmentFamily(DOUBLING);
		tune.get(2).get(1).addNote(new Note(tune, D, EIGHTH));
		tune.get(2).get(1).addNote(new Note(tune, B, EIGHTH)).setEmbellishmentFamily(DOUBLING);
		tune.get(2).get(1).addNote(new Note(tune, LOW_A, EIGHTH)).setEmbellishmentFamily(E_GRACE);
		
		tune.get(2).get(2).addNote(new Note(tune, LOW_A, EIGHTH, true)).setEmbellishmentFamily(G_GRACE);
		tune.get(2).get(2).addNote(new Note(tune, B, SIXTEENTH)).setEmbellishmentFamily(D_GRACE);
		tune.get(2).get(2).addNote(new Note(tune, E, QUARTER)).setEmbellishmentFamily(DOUBLING);
		tune.get(2).get(2).addNote(new Note(tune, A, QUARTER)).setEmbellishmentFamily(DOUBLING);

		tune.get(2).get(3).addNote(new Note(tune, G, SIXTEENTH, true)).setEmbellishmentFamily(DOUBLING);
		tune.get(2).get(3).addNote(new Note(tune, F, THIRTY_SECOND));
		tune.get(2).get(3).addNote(new Note(tune, E, SIXTEENTH, true)).setEmbellishmentFamily(G_GRACE);
		tune.get(2).get(3).addNote(new Note(tune, D, THIRTY_SECOND));
		tune.get(2).get(3).addNote(new Note(tune, G, QUARTER)).setEmbellishmentFamily(DOUBLING);
		tune.get(2).get(3).addNote(new Note(tune, LOW_G, QUARTER)).setEmbellishmentFamily(A_GRACE);

		// Line 4
		tune.get(3).get(0).addNote(new Note(tune, D, EIGHTH)).setEmbellishmentFamily(THROW);
		tune.get(3).get(0).addNote(new Note(tune, B, EIGHTH)).setEmbellishmentFamily(E_GRACE);
		tune.get(3).get(0).addNote(new Note(tune, D, QUARTER)).setEmbellishmentFamily(THROW);
		tune.get(3).get(0).addNote(new Note(tune, E, EIGHTH, true)).setEmbellishmentFamily(DOUBLING);
		tune.get(3).get(0).addNote(new Note(tune, D, SIXTEENTH));

		tune.get(3).get(1).addNote(new Note(tune, B, EIGHTH)).setEmbellishmentFamily(DOUBLING);
		tune.get(3).get(1).addNote(new Note(tune, LOW_A, EIGHTH)).setEmbellishmentFamily(E_GRACE);
		tune.get(3).get(1).addNote(new Note(tune, LOW_A, EIGHTH)).setEmbellishmentFamily(DOUBLING);
		tune.get(3).get(1).addNote(new Note(tune, LOW_G, EIGHTH)).setEmbellishmentFamily(E_GRACE);
		tune.get(3).get(1).addNote(new Note(tune, G, EIGHTH, true)).setEmbellishmentFamily(DOUBLING);
		tune.get(3).get(1).addNote(new Note(tune, F, SIXTEENTH));
		
		tune.get(3).get(2).addNote(new Note(tune, E, EIGHTH, true)).setEmbellishmentFamily(DOUBLING);
		tune.get(3).get(2).addNote(new Note(tune, D, SIXTEENTH));
		tune.get(3).get(2).addNote(new Note(tune, B, SIXTEENTH)).setEmbellishmentFamily(G_GRACE);
		tune.get(3).get(2).addNote(new Note(tune, D, EIGHTH, false));
		tune.get(3).get(2).addNote(new Note(tune, LOW_G, QUARTER));
		
		tune.get(3).get(3).addNote(new Note(tune, LOW_A, QUARTER)).setEmbellishmentFamily(G_GRACE);
		tune.get(3).get(3).addNote(new Note(tune, B, QUARTER)).setEmbellishmentFamily(GRIP);
		tune.get(3).get(3).addNote(new Note(tune, LOW_A, QUARTER));
		
		return tune;
	}
}
