package pipes.model.embellishment;

import pipes.model.Note;
import pipes.model.Pitch;

public class Taorluath extends Grip {

	public boolean canEmbellish(Note noteBefore, Note embellishedNote) {
		return embellishedNote.getPitch() == Pitch.LOW_A || embellishedNote.getPitch() == Pitch.B || embellishedNote.getPitch() == Pitch.C;
	}

	public Taorluath() {
		super("Taorluath", "taor");
		notAfterD = new Embellishment("Taorluath", GraceNote.LOW_G, GraceNote.D, GraceNote.LOW_G, GraceNote.E);
		afterD = new Embellishment("Taorluath", GraceNote.LOW_G, GraceNote.B, GraceNote.LOW_G, GraceNote.E);
	}
}
