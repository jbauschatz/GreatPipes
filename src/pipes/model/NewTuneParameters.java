package pipes.model;

public class NewTuneParameters {
	
	public static final NewTuneParameters DEFAULT = new NewTuneParameters(TimeSignature.FOUR_FOUR, 4, 4);
	
	public final TimeSignature timeSignature;
	public final int lines;
	public final int measuresPerLine;
	
	public NewTuneParameters(TimeSignature timeSignature, int lines, int measuresPerLine) {
		this.timeSignature = timeSignature;
		this.lines = lines;
		this.measuresPerLine = measuresPerLine;
	}
}
