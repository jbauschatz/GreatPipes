package pipes.model.embellishment.grip;

import pipes.model.Note;
import pipes.model.Pitch;
import pipes.model.embellishment.Embellishment;
import pipes.model.embellishment.GraceNote;

public class Crunluath extends Grip {

	public boolean canEmbellish(Note noteBefore, Note embellishedNote) {
		return embellishedNote.getPitch() == Pitch.E;
	}

	public Crunluath() {
		super("Crunluath", "crun");
		notAfterD = new Embellishment("Crunluath", GraceNote.LOW_G.asLong(), GraceNote.D, GraceNote.LOW_G.asLong(), GraceNote.E, GraceNote.LOW_A.asLong(), GraceNote.F, GraceNote.LOW_A.asLong());
		afterD = new Embellishment("Crunluath", GraceNote.LOW_G.asLong(), GraceNote.B, GraceNote.LOW_G.asLong(), GraceNote.E, GraceNote.LOW_A.asLong(), GraceNote.F, GraceNote.LOW_A.asLong());
	}
}
