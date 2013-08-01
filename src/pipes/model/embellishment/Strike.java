package pipes.model.embellishment;

import java.util.HashMap;

import pipes.model.Note;
import pipes.model.Pitch;
import static pipes.model.embellishment.GraceNote.*;

public class Strike extends EmbellishmentFamily {

	public boolean canEmbellish(Note noteBefore, Note embellishedNote) {
		return embellishedNote.getPitch().higherThan(Pitch.LOW_G) &&
				(embellishedNote.getPitch() == Pitch.LOW_A || 
				(noteBefore != null && noteBefore.getPitch() == embellishedNote.getPitch()));
	}

	public Embellishment getEmbellishment(Note noteBefore, Note embellishedNote) {
		Embellishment e = forNotes.get(embellishedNote.getPitch()).clone();
		
		return e;
	}
	
	public Strike() {
		super("Strike", "str");
		forNotes = new HashMap<Pitch, Embellishment>();
		forNotes.put(Pitch.A, new Embellishment("a-Strike", G.asLong()));
		forNotes.put(Pitch.G, new Embellishment("g-Strike", F.asLong()));
		forNotes.put(Pitch.F, new Embellishment("F-Strike", E.asLong()));
		forNotes.put(Pitch.E, new Embellishment("E-Strike", LOW_A.asLong()));
		forNotes.put(Pitch.D, new Embellishment("D-Strike", C.asLong()));
		forNotes.put(Pitch.C, new Embellishment("C-Strike", LOW_G.asLong()));
		forNotes.put(Pitch.B, new Embellishment("B-Strike", LOW_G.asLong()));
		forNotes.put(Pitch.LOW_A, new Embellishment("A-Strike", LOW_G.asLong()));
	}

	private HashMap<Pitch, Embellishment> forNotes;
}
