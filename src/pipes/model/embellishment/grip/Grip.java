package pipes.model.embellishment.grip;

import pipes.model.Note;
import pipes.model.Pitch;
import pipes.model.embellishment.Embellishment;
import pipes.model.embellishment.EmbellishmentFamily;
import pipes.model.embellishment.GraceNote;

public class Grip extends EmbellishmentFamily {

	public boolean canEmbellish(Note noteBefore, Note embellishedNote) {
		return embellishedNote.getPitch() != Pitch.LOW_G;
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
		notAfterD = new Embellishment("Grip", GraceNote.LOW_G.asLong(), GraceNote.D, GraceNote.LOW_G.asLong());
		afterD = new Embellishment("Grip", GraceNote.LOW_G.asLong(), GraceNote.B, GraceNote.LOW_G.asLong());
	}
	
	protected Grip(String name, String shortName) {
		super(name, shortName);
		notAfterD = new Embellishment(name, GraceNote.LOW_G.asLong(), GraceNote.D, GraceNote.LOW_G.asLong());
		afterD = new Embellishment(name, GraceNote.LOW_G.asLong(), GraceNote.B, GraceNote.LOW_G.asLong());
	}

	protected Embellishment afterD;
	protected Embellishment notAfterD;
}
