package pipes.model.embellishment;

import pipes.model.Note;
import pipes.model.Pitch;

public class BasicBirl extends EmbellishmentFamily {

	public boolean canEmbellish(Note noteBefore, Note embellishedNote) {
		return embellishedNote.getPitch() == Pitch.LOW_A;
	}

	public Embellishment getEmbellishment(Note noteBefore, Note embellishedNote) {
		if (noteBefore != null && noteBefore.getPitch() == Pitch.LOW_A)
			return onA.clone();
		
		return notOnA.clone();
	}
	
	public BasicBirl() {
		super("Birl", "birl");
		notOnA = new Embellishment("Birl", GraceNote.LOW_A, GraceNote.LOW_G.asLong(), GraceNote.LOW_A, GraceNote.LOW_G.asLong());
		onA = new Embellishment("Birl", GraceNote.LOW_G.asLong(), GraceNote.LOW_A, GraceNote.LOW_G.asLong());
	}

	private Embellishment notOnA;
	private Embellishment onA;
}
