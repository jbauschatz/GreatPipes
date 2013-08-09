package pipes.model;

/**
 * Represents a unit of note-time; ie a whole note or a half note.
 *
 */
public enum BeatDivision {
	WHOLE(1, "whole"),
	HALF(2, "half"),
	QUARTER(4, "quarter"),
	EIGHTH(8, "eighth"),
	SIXTEENTH(16, "sixteenth"),
	THIRTY_SECOND(32, "thirty-second");
	
	public static BeatDivision fromInt(int denom) {
		for (BeatDivision div : values()) {
			if (div.denominator == denom)
				return div;
		}
		return null;
	}
	
	/**
	 * The human-friendly name for the division
	 */
	public final String name;
	
	/**
	 * The denominator of the fraction of a whole note.
	 * A quarter note = (whole note) / 4
	 */
	public final int denominator;
	
	/**
	 * The length of the beat division in arbitrary length units.
	 * These units are defined to scale appropriately to reflect the relative lengths of the beat divisions,
	 * so that for example a quarter note is the length of two eighth notes.
	 */
	public final int duration;
	
	/**
	 * Whether this beat division is noted with a stick.
	 * (Half notes and whole notes do not have a stick)
	 */
	public final boolean hasStick;
	
	/**
	 * Whether this beat division is noted with a flag.
	 * (Quarter notes do not have a flag)
	 */
	public final boolean hasFlag;

	/**
	 * Whether the head of this note is filled.
	 * (The head of a half note is not filled)
	 */
	public final boolean headFilled;
	
	BeatDivision(int denominator, String name) {
		this.denominator = denominator;
		this.name = name;
		duration = 32/denominator;
		hasStick = denominator >= 2;
		hasFlag = denominator >= 8;
		headFilled = denominator > 2;
	}
}
