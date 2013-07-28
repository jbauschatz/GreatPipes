package pipes.model.embellishment;

import pipes.model.Note;
import pipes.model.Pitch;

public class Taorluath extends Grip {

	public boolean canEmbellish(Note note) {
		return note.getPitch() == Pitch.LOW_A;
	}

	public Taorluath() {
		super("Taorluath", "taor");
		notAfterD = new Embellishment("Taorluath", GraceNote.LOW_G, GraceNote.D, GraceNote.LOW_G, GraceNote.E);
		afterD = new Embellishment("Taorluath", GraceNote.LOW_G, GraceNote.B, GraceNote.LOW_G, GraceNote.E);
	}
}
