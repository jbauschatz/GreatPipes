package pipes.model.embellishment;

import pipes.model.Note;
import pipes.model.Pitch;

public class Crunluath extends Grip {

	public boolean canEmbellish(Note noteBefore, Note embellishedNote) {
		return embellishedNote.getPitch() == Pitch.E;
	}

	public Crunluath() {
		super("Crunluath", "crun");
		notAfterD = new Embellishment("Crunluath", GraceNote.LOW_G, GraceNote.D, GraceNote.LOW_G, GraceNote.E, GraceNote.LOW_A, GraceNote.F, GraceNote.LOW_A);
		afterD = new Embellishment("Crunluath", GraceNote.LOW_G, GraceNote.B, GraceNote.LOW_G, GraceNote.E, GraceNote.LOW_A, GraceNote.F, GraceNote.LOW_A);
	}
}
