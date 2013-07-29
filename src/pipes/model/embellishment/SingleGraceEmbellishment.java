package pipes.model.embellishment;

import pipes.model.Note;

public class SingleGraceEmbellishment extends EmbellishmentFamily {

	public boolean canEmbellish(Note noteBefore, Note embellishedNote) {		
		return grace.pitch.higherThan(embellishedNote.getPitch()) && 
				(noteBefore == null || grace.pitch.higherThan(noteBefore.getPitch()));
	}

	public Embellishment getEmbellishment(Note noteBefore, Note embellishedNote) {
		return new Embellishment(toString(), grace);
	}
	
	public SingleGraceEmbellishment(GraceNote g) {
		super(g.pitch.shortName+"-grace", "'"+g.pitch.shortName);
		grace = g;
	}

	private GraceNote grace;
}
