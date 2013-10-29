package pipes.model;

public class NewTuneParameters {
	
	public static final NewTuneParameters DEFAULT = new NewTuneParameters("New Tune", "Anonymous", TimeSignature.FOUR_FOUR, 4, 4);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public TimeSignature getTimeSignature() {
		return timeSignature;
	}

	public int getLines() {
		return lines;
	}

	public int getMeasuresPerLine() {
		return measuresPerLine;
	}

	public NewTuneParameters(String name, String author, TimeSignature timeSignature, int lines, int measuresPerLine) {
		this.name = name;
		this.author = author;
		this.timeSignature = timeSignature;
		this.lines = lines;
		this.measuresPerLine = measuresPerLine;
	}

	private String name;
	private String author;
	private final TimeSignature timeSignature;
	private final int lines;
	private final int measuresPerLine;
}
