package pipes.model.embellishment;

import java.util.HashMap;

import pipes.model.Note;
import pipes.model.Pitch;

public abstract class EmbellishmentFamily {
	
	public static final EmbellishmentFamily BIRL = new BasicBirl();
	public static final EmbellishmentFamily DOUBLING = new Doubling();
	public static final EmbellishmentFamily THROW = new DThrow();
	
	// Single grace notes
	public static final EmbellishmentFamily A_GRACE = new SingleGraceEmbellishment(Pitch.A);
	public static final EmbellishmentFamily G_GRACE = new SingleGraceEmbellishment(Pitch.G);
	public static final EmbellishmentFamily D_GRACE = new SingleGraceEmbellishment(Pitch.D);
	public static final EmbellishmentFamily E_GRACE = new SingleGraceEmbellishment(Pitch.E);

	// *luaths
	public static final EmbellishmentFamily GRIP = new Grip();
	public static final EmbellishmentFamily TAOR = new Taorluath();
	public static final EmbellishmentFamily CRUN = new Crunluath();
	
	// Strikes
	public static final EmbellishmentFamily E_STRIKE = new StandardEmbellishment("Strike", "str", GraceNote.LOW_A);
	
	public static final EmbellishmentFamily[] EMBELLISHMENTS = {THROW, BIRL, DOUBLING, GRIP, TAOR, CRUN, G_GRACE, D_GRACE, E_GRACE, A_GRACE};
	
	private static final HashMap<String, EmbellishmentFamily> familiesByNames = new HashMap<String, EmbellishmentFamily>() {
		private static final long serialVersionUID = 1L;
		{
			put(THROW.getShortName(), THROW);
			put(BIRL.getShortName(), BIRL);
			put(DOUBLING.getShortName(), DOUBLING);
			put(GRIP.getShortName(), GRIP);
			put(TAOR.getShortName(), TAOR);
			put(CRUN.getShortName(), CRUN);
			put(A_GRACE.getShortName(), A_GRACE);
			put(G_GRACE.getShortName(), G_GRACE);
			put(D_GRACE.getShortName(), D_GRACE);
			put(E_GRACE.getShortName(), E_GRACE);
		}
	};
	
	public static EmbellishmentFamily getByName(String name) {
		if (familiesByNames.containsKey(name))
			return familiesByNames.get(name);		
		
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public abstract boolean canEmbellish(Note note);
	
	public abstract Embellishment getEmbellishment(Note noteBefore, Note embellishedNote);
	
	public EmbellishmentFamily(String name, String shortName) {
		this.name = name;
		this.shortName = shortName;
	}
	
	private String name;
	private String shortName;
}
