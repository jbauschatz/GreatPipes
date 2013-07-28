package pipes.model;

public enum BeatDivision {
	WHOLE(1),
	HALF(2),
	QUARTER(4),
	EIGHTH(8),
	SIXTEENTH(16),
	THIRTY_SECOND(32);
	
	public static BeatDivision fromInt(int denom) {
		for (BeatDivision div : values()) {
			if (div.denominator == denom)
				return div;
		}
		return null;
	}
	
	public final int denominator;
	public final int duration;
	public final boolean hasStick;
	public final boolean hasFlag;
	public final boolean headFilled;
	
	BeatDivision(int denominator) {
		this.denominator = denominator;
		duration = 32/denominator;
		hasStick = denominator >= 2;
		hasFlag = denominator >= 8;
		headFilled = denominator > 2;
	}
}
