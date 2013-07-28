package pipes.model.embellishment;

import pipes.model.Note;
import pipes.model.Pitch;

public class BasicBirl extends EmbellishmentFamily {

	public boolean canEmbellish(Note note) {
		return note.getPitch() == Pitch.LOW_A;
	}

	public boolean canComeAfter(Note note) {
		return true;
	}

	public Embellishment getEmbellishment(Note noteBefore, Note embellishedNote) {
		if (noteBefore != null && noteBefore.getPitch() == Pitch.LOW_A)
			return onA.clone();
		
		return notOnA.clone();
	}
	
	public BasicBirl() {
		super("Birl", "birl");
		notOnA = new Embellishment("Birl", GraceNote.LOW_A, GraceNote.LOW_G, GraceNote.LOW_A, GraceNote.LOW_G);
		onA = new Embellishment("Birl", GraceNote.LOW_G, GraceNote.LOW_A, GraceNote.LOW_G);
	}

	private Embellishment notOnA;
	private Embellishment onA;
}
