package pipes.model.embellishment;

import pipes.model.Note;
import pipes.model.Pitch;

public class Grip extends EmbellishmentFamily {

	public boolean canEmbellish(Note note) {
		return note.getPitch() != Pitch.LOW_G;
	}

	public boolean canComeAfter(Note note) {
		return true;
	}

	public Embellishment getEmbellishment(Note noteBefore, Note embellishedNote) {
		Embellishment e;
		
		if (noteBefore != null && noteBefore.getPitch() == Pitch.D)
			e = afterD.clone();
		else
			e = notAfterD.clone();
		
		if (noteBefore != null && noteBefore.getPitch() == Pitch.LOW_G)
			e.removeFirst();
		
		return e;
	}
	
	public Grip() {
		super("Grip", "grip");
		notAfterD = new Embellishment("Grip", GraceNote.LOW_G, GraceNote.D, GraceNote.LOW_G);
		afterD = new Embellishment("Grip", GraceNote.LOW_G, GraceNote.B, GraceNote.LOW_G);
	}
	
	protected Grip(String name, String shortName) {
		super(name, shortName);
		notAfterD = new Embellishment(name, GraceNote.LOW_G, GraceNote.D, GraceNote.LOW_G);
		afterD = new Embellishment(name, GraceNote.LOW_G, GraceNote.B, GraceNote.LOW_G);
	}

	protected Embellishment afterD;
	protected Embellishment notAfterD;
}
