package pipes.model.embellishment.grip;

import pipes.model.Note;
import pipes.model.Pitch;
import pipes.model.embellishment.Embellishment;
import pipes.model.embellishment.EmbellishmentFamily;
import pipes.model.embellishment.GraceNote;

public class BubblyNote extends EmbellishmentFamily {

	public boolean canEmbellish(Note noteBefore, Note embellishedNote) {
		// TODO is this true? Could we have one on an E or F?
		return Pitch.E.higherThan(embellishedNote.getPitch());
	}

	public Embellishment getEmbellishment(Note noteBefore, Note embellishedNote) {
		GraceNote gripNote = (embellishedNote.getPitch() == Pitch.D) ? GraceNote.B : GraceNote.D;
		GraceNote themeNote = new GraceNote(embellishedNote.getPitch(), true);
		
		GraceNote[] graces;
		if (noteBefore.getPitch().higherOrEqual(Pitch.G))
			graces = new GraceNote[] {themeNote, GraceNote.LOW_G.asLong(), gripNote, GraceNote.LOW_G};
		else
			graces = new GraceNote[] {GraceNote.G, themeNote, GraceNote.LOW_G.asLong(), gripNote, GraceNote.LOW_G};
		
		return new Embellishment(noteBefore + "-Bubbly", graces);
	}
	
	public BubblyNote() {
		super("Bubbly Note", "bbly");
	}
}
