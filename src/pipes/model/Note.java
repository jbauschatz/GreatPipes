package pipes.model;

import pipes.model.embellishment.Embellishment;
import pipes.model.embellishment.EmbellishmentFamily;

public class Note implements MelodyElement {
	
	public static Note fromString(Tune t, String s) {
		int hyph = s.indexOf('-');

		Pitch pitch = Pitch.fromString(s.substring(0, hyph));
		BeatDivision div;
		int dots;
		
		if (s.indexOf('.') == -1) {
			div = BeatDivision.fromInt(Integer.parseInt(s.substring(hyph+1)));
			dots = 0;
		} else {
			int dotIndex = s.indexOf('.');
			div = BeatDivision.fromInt(Integer.parseInt(s.substring(hyph+1, dotIndex)));
			dots = s.substring(dotIndex).length();
		}
		
		return new Note(t, pitch, div, dots);
	}
	
	public String toString() {
		return pitch + "-" + beatDivision.denominator;
	}
	
	public int getNumDots() {
		return numDots;
	}
	
	public void setNumDots(int numDots) {
		this.numDots = numDots;
	}
	
	public boolean hasEmbellishment() {
		return embellishment != null;
	}
	
	public Embellishment getEmbellishment() {
		return embellishment;
	}
	
	public void setEmbellishment(Embellishment e) {
		embellishment = e;
	}

	public EmbellishmentFamily getEmbellishmentFamily() {
		return embellishmentFamily;
	}
	
	public void setEmbellishmentFamily(EmbellishmentFamily family) {
		embellishmentFamily = family;
		if (embellishmentFamily != null) {
			embellishment = family.getEmbellishment(tune.getNoteBefore(this), this);
			embellishment.setNote(this);
		} else {
			embellishment = null;
		}
	}
	
	public Pitch getPitch() {
		return pitch;
	}
	
	public void setPitch(Pitch pitch) {
		this.pitch = pitch;
	}
	
	public BeatDivision getBeatDivision() {
		return beatDivision;
	}
	
	public int getDuration() {
		int length = beatDivision.duration;
		int dotValue = length/2;
		
		for (int i = numDots; i>0; --i) {
			length += dotValue;
			dotValue /= 2;
		}

		return length;
	}

	public Tune getTune() {
		return tune;
	}
	
	public Note(Tune tune, Pitch pitch, BeatDivision division) {
		this(tune, pitch, division, 0);
	}

	public Note(Tune tune, Pitch pitch, BeatDivision division, boolean dotted) {
		this(tune, pitch, division, dotted ? 1 : 0);
	}

	public Note(Tune tune, Pitch pitch, BeatDivision division, int numDots) {
		this.tune = tune;
		this.pitch = pitch;
		this.beatDivision = division;

		this.numDots = numDots;
	}

	private Tune tune;
	private BeatDivision beatDivision;
	private Embellishment embellishment;
	private EmbellishmentFamily embellishmentFamily;
	private Pitch pitch;
	private int numDots;
}
