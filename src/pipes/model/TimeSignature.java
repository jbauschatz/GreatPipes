package pipes.model;

public class TimeSignature implements MelodyElement {
	public static final TimeSignature FOUR_FOUR = new TimeSignature(4, BeatDivision.QUARTER);
	public static final TimeSignature TWO_FOUR = new TimeSignature(2, BeatDivision.QUARTER);
	public static final TimeSignature TWO_TWO = new TimeSignature(2, BeatDivision.HALF);

	public static final TimeSignature THREE_FOUR = new TimeSignature(3, BeatDivision.QUARTER);
	public static final TimeSignature SIX_EIGHT= new TimeSignature(6, BeatDivision.EIGHTH);
	public static final TimeSignature NINE_EIGHT = new TimeSignature(9, BeatDivision.EIGHTH);
	public static final TimeSignature TWELVE_EIGHT = new TimeSignature(12, BeatDivision.EIGHTH);
	
	public static final TimeSignature[] STANDARD_TIMES = {FOUR_FOUR, TWO_FOUR, TWO_TWO, THREE_FOUR, SIX_EIGHT, NINE_EIGHT, TWELVE_EIGHT};
	
	public static TimeSignature fromString(String s) {
		int slash = s.indexOf('/');
		return new TimeSignature(
				Integer.parseInt(s.substring(1, slash)), 
				BeatDivision.fromInt(Integer.parseInt(s.substring(slash+1, s.length()-1))));
	}
	
	public String toString() {
		return beatsInMeasure + "/" + beatUnit.denominator;
	}
	
	public int getBeatsInMeasure() {
		return beatsInMeasure;
	}
	
	public BeatDivision getBeatUnit() {
		return beatUnit;
	}
	
	public int getMeasureDuration() {
		return beatUnit.duration * beatsInMeasure;
	}
	
	public TimeSignature(int beatsInMeasure, BeatDivision beatUnit) {
		this.beatsInMeasure = beatsInMeasure;
		this.beatUnit = beatUnit;
	}
	
	private int beatsInMeasure;
	private BeatDivision beatUnit;
}
