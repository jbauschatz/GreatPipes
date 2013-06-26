package model;

import static model.Embellishment.A_DOUBLING;
import static model.Embellishment.A_GRACE;
import static model.Embellishment.B_DOUBLING;
import static model.Embellishment.D_GRACE;
import static model.Embellishment.E_DOUBLING;
import static model.Embellishment.E_GRACE;
import static model.Embellishment.G_DOUBLING;
import static model.Embellishment.G_GRACE;
import static model.Embellishment.G_HALF_DOUBLING;

import java.util.LinkedList;

public class Tune extends LinkedList<Line> {
	private static final long serialVersionUID = 1L;

	public static Tune getTestTune() {
		Tune tune = new Tune();
		for (int i = 0; i<4; ++i) {
			Line l = new Line();
			for (int m = 0; m<4; ++m)
				l.add(new Measure());
			tune.add(l);
		}
		
		for (int l = 0; l<4; ++l) {
			tune.get(l).get(0).add(G_GRACE);
			tune.get(l).get(0).add(new Note(Note.LOW_A, Note.EIGHTH, true));
			tune.get(l).get(0).add(D_GRACE);
			tune.get(l).get(0).add(new Note(Note.B, Note.SIXTEENTH));
			tune.get(l).get(0).add(E_DOUBLING);
			tune.get(l).get(0).add(new Note(Note.E, Note.QUARTER));
			tune.get(l).get(0).add(A_DOUBLING);
			tune.get(l).get(0).add(new Note(Note.A, Note.QUARTER));
	
			tune.get(l).get(1).add(G_HALF_DOUBLING);
			tune.get(l).get(1).add(new Note(Note.G, Note.EIGHTH));
			tune.get(l).get(1).add(new Note(Note.E, Note.EIGHTH));
			tune.get(l).get(1).add(E_DOUBLING);
			tune.get(l).get(1).add(new Note(Note.E, Note.EIGHTH));
			tune.get(l).get(1).add(new Note(Note.D, Note.EIGHTH));
			tune.get(l).get(1).add(B_DOUBLING);
			tune.get(l).get(1).add(new Note(Note.B, Note.EIGHTH));
			tune.get(l).get(1).add(E_GRACE);
			tune.get(l).get(1).add(new Note(Note.LOW_A, Note.EIGHTH));
			
			tune.get(l).get(2).add(G_GRACE);
			tune.get(l).get(2).add(new Note(Note.LOW_A, Note.EIGHTH, true));
			tune.get(l).get(2).add(D_GRACE);
			tune.get(l).get(2).add(new Note(Note.B, Note.SIXTEENTH));
			tune.get(l).get(2).add(E_DOUBLING);
			tune.get(l).get(2).add(new Note(Note.E, Note.QUARTER));
			tune.get(l).get(2).add(A_DOUBLING);
			tune.get(l).get(2).add(new Note(Note.A, Note.QUARTER));
	
			tune.get(l).get(3).add(G_HALF_DOUBLING);
			tune.get(l).get(3).add(new Note(Note.G, Note.SIXTEENTH, true));
			tune.get(l).get(3).add(new Note(Note.F, Note.THIRTY_SECOND));
			tune.get(l).get(3).add(G_GRACE);
			tune.get(l).get(3).add(new Note(Note.E, Note.SIXTEENTH, true));
			tune.get(l).get(3).add(new Note(Note.D, Note.THIRTY_SECOND, true));
			tune.get(l).get(3).add(G_DOUBLING);
			tune.get(l).get(3).add(new Note(Note.G, Note.QUARTER));
			tune.get(l).get(3).add(A_GRACE);
			tune.get(l).get(3).add(new Note(Note.LOW_G, Note.QUARTER));
		}		
		
		return tune;
	}
}
