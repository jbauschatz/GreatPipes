package pipes.model.embellishment;

import pipes.model.Note;
import pipes.model.Pitch;

public class SingleGraceEmbellishment extends EmbellishmentFamily {

	public boolean canEmbellish(Note note) {
		Note noteBefore = note.getTune().getNoteBefore(note);
		
		return grace.pitch.higherThan(note.getPitch()) && 
				(noteBefore == null || grace.pitch.higherThan(noteBefore.getPitch()));
	}

	public Embellishment getEmbellishment(Note noteBefore, Note embellishedNote) {
		return new Embellishment(toString(), grace);
	}
	
	public SingleGraceEmbellishment(Pitch p) {
		super(p.shortName+"-grace", "'"+p.shortName);
		grace = new GraceNote(p);
	}

	private GraceNote grace;
}
