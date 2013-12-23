package pipes.model.embellishment.grip;

import pipes.model.Note;
import pipes.model.Pitch;
import pipes.model.embellishment.Embellishment;
import pipes.model.embellishment.GraceNote;

public class Taorluath extends Grip {

	public boolean canEmbellish(Note noteBefore, Note embellishedNote) {
		return embellishedNote.getPitch() == Pitch.LOW_A || embellishedNote.getPitch() == Pitch.B || embellishedNote.getPitch() == Pitch.C;
	}

	public Taorluath() {
		super("Taorluath", "taor");
		notAfterD = new Embellishment("Taorluath", GraceNote.LOW_G.asLong(), GraceNote.D, GraceNote.LOW_G.asLong(), GraceNote.E);
		afterD = new Embellishment("Taorluath", GraceNote.LOW_G.asLong(), GraceNote.B, GraceNote.LOW_G.asLong(), GraceNote.E);
	}
}
