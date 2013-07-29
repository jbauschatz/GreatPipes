package pipes.model.embellishment;

import pipes.model.Note;
import pipes.model.Pitch;

public class DThrow extends EmbellishmentFamily {

	private static Embellishment afterG = new Embellishment("D throw", GraceNote.D, GraceNote.C.asLong());
	private static Embellishment notAfterG = new Embellishment("D throw", GraceNote.LOW_G.asLong(), GraceNote.D, GraceNote.C.asLong());
	
	public boolean canEmbellish(Note noteBefore, Note embellishedNote) {
		return embellishedNote.getPitch() == Pitch.D;
	}

	public Embellishment getEmbellishment(Note noteBefore, Note embellishedNote) {
		return (noteBefore == null || noteBefore.getPitch() != Pitch.LOW_G) 
				? notAfterG.clone() : afterG.clone();
	}
	
	public DThrow() {
		super("D throw", "thrw");
	}
}
