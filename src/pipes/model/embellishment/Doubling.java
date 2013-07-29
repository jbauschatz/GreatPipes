package pipes.model.embellishment;

import java.util.HashMap;

import pipes.model.Note;
import pipes.model.Pitch;
import static pipes.model.embellishment.GraceNote.*;

public class Doubling extends EmbellishmentFamily {

	public boolean canEmbellish(Note noteBefore, Note embellishedNote) {
		return true;
	}

	public Embellishment getEmbellishment(Note noteBefore, Note embellishedNote) {
		Embellishment e = forNotes.get(embellishedNote.getPitch()).clone();

		if (noteBefore != null && noteBefore.getPitch().higherOrEqual(e.getFirst().pitch))
			e.removeFirst();
		
		return e;
	}
	
	public Doubling() {
		super("Doubling", "dbl");
		forNotes = new HashMap<Pitch, Embellishment>();
		forNotes.put(Pitch.A, new Embellishment("A-Doubling", A.asLong(), G));
		forNotes.put(Pitch.G, new Embellishment("G-Doubling", G.asLong(), F));
		forNotes.put(Pitch.F, new Embellishment("F-Doubling", G, F.asLong(), G));
		forNotes.put(Pitch.E, new Embellishment("E-Doubling", G, E.asLong(), F));
		forNotes.put(Pitch.D, new Embellishment("D-Doubling", G, D.asLong(), E));
		forNotes.put(Pitch.C, new Embellishment("C-Doubling", G, C.asLong(), D));
		forNotes.put(Pitch.B, new Embellishment("B-Doubling", G, B.asLong(), D));
		forNotes.put(Pitch.LOW_A, new Embellishment("low A-Doubling", G, LOW_A.asLong(), D));
		forNotes.put(Pitch.LOW_G, new Embellishment("low G-Doubling", G, LOW_G.asLong(), D));
	}

	private HashMap<Pitch, Embellishment> forNotes;
}
