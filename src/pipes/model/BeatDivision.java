package pipes.model;

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
	
	public final String name;
	public final int denominator;
	public final int duration;
	public final boolean hasStick;
	public final boolean hasFlag;
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
