package pipes.model.embellishment;

import java.util.HashMap;

import pipes.model.Note;
import pipes.model.embellishment.grip.BubblyNote;
import pipes.model.embellishment.grip.Crunluath;
import pipes.model.embellishment.grip.Grip;
import pipes.model.embellishment.grip.Taorluath;

/**
 * Represents the range of forms an Embellishment could take based on the Notes it could be placed on.
 * 
 * Embellishment Family is not a piping term, it's meant to group Embellishments that are strictly different,
 * like an F-doubling vs. an E-doubling, under the idea of the "doubling family". 
 */
public abstract class EmbellishmentFamily {
	
	public static final EmbellishmentFamily BIRL = new BasicBirl();
	public static final EmbellishmentFamily DOUBLING = new Doubling();
	public static final EmbellishmentFamily THROW = new DThrow();
	
	// Single grace notes
	public static final EmbellishmentFamily A_GRACE = new SingleGraceEmbellishment(GraceNote.A);
	public static final EmbellishmentFamily G_GRACE = new SingleGraceEmbellishment(GraceNote.G);
	public static final EmbellishmentFamily D_GRACE = new SingleGraceEmbellishment(GraceNote.D);
	public static final EmbellishmentFamily E_GRACE = new SingleGraceEmbellishment(GraceNote.E);

	// Strikes
	public static final EmbellishmentFamily STRIKE = new Strike();

	// *luaths
	public static final EmbellishmentFamily GRIP = new Grip();
	public static final EmbellishmentFamily TAOR = new Taorluath();
	public static final EmbellishmentFamily CRUN = new Crunluath();
	public static final EmbellishmentFamily BUBBLY = new BubblyNote();
	
	public static final EmbellishmentFamily[] EMBELLISHMENTS = {THROW, BIRL, DOUBLING, STRIKE, GRIP, TAOR, BUBBLY, CRUN, G_GRACE, D_GRACE, E_GRACE, A_GRACE};
	
	private static final HashMap<String, EmbellishmentFamily> familiesByNames = new HashMap<String, EmbellishmentFamily>() {
		private static final long serialVersionUID = 1L;
		{
			for (EmbellishmentFamily fam : EMBELLISHMENTS)
				put(fam.getShortName(), fam);
		}
	};
	
	public static EmbellishmentFamily getByName(String name) {
		if (familiesByNames.containsKey(name))
			return familiesByNames.get(name);
		
		return null;
	}
	
	/**
	 * @return the full name of the Embellishments in this family, for example "Taorluath"
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the abbreviated name of the Embellishments in this family, for example "taor"
	 */
	public String getShortName() {
		return shortName;
	}
	
	/**
	 * Validates whether placing an Embellishment from this family would be legal between the given Notes
	 * @param noteBefore the Note before the Note the Embellishment would be placed on
	 * @param embellishedNote the Note the Embellishment would be placed on
	 * @return true if the Embellishment can legally be placed
	 */
	public abstract boolean canEmbellish(Note noteBefore, Note embellishedNote);
	
	/**
	 * Gets the very specific form of this family given the Notes in context
	 * @param noteBefore the Note before the Note the Embellishment would be placed on
	 * @param embellishedNote the Note the Embellishment would be placed on
	 * @return a specific instance of Embellishment that represents the legal form based on the given Notes
	 */
	public abstract Embellishment getEmbellishment(Note noteBefore, Note embellishedNote);

    @Override
    public String toString() {
        return name;
    }

	public EmbellishmentFamily(String name, String shortName) {
		this.name = name;
		this.shortName = shortName;
	}
	
	private String name;
	private String shortName;
}
