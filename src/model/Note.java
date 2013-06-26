package model;

public class Note implements MelodyElement {
	public static final int LOW_G = 0;
	public static final int LOW_A = 1;
	public static final int B = 2;
	public static final int C = 3;
	public static final int D = 4;
	public static final int E = 5;
	public static final int F = 6;
	public static final int G = 7;
	public static final int A = 8;

	public static final int WHOLE = 1;
	public static final int HALF = 2;
	public static final int QUARTER = 4;
	public static final int EIGHTH = 8;
	public static final int SIXTEENTH = 16;
	public static final int THIRTY_SECOND = 32;

	public final int denominator;
	public final boolean dotted;

	public String toString() {
		String string = "";
		switch (pitch) {
		case LOW_G: string += "g"; break;
		case LOW_A: string += "a"; break;
		case B: string += "B"; break;
		case C: string += "C"; break;
		case D: string += "D"; break;
		case E: string += "E"; break;
		case F: string += "F"; break;
		case G: string += "G"; break;
		case A: string += "A"; break;
		}
		
		return string + "-" + denominator;
	}
	
	public Embellishment getEmbellishment() {
		return embellishment;
	}
	
	public void setEmbellishment(Embellishment e) {
		embellishment = e;
	}

	public int getPitch() {
		return pitch;
	}
	
	public void setPitch(int pitch) {
		this.pitch = pitch;
	}
	
	public Note(int pitch, int duration) {
		this.pitch = pitch;
		this.denominator = duration;
		dotted = false;
	}

	public Note(int pitch, int duration, boolean dotted) {
		this.pitch = pitch;
		this.denominator = duration;
		this.dotted = dotted;
	}
	
	private Embellishment embellishment;
	private int pitch;
}
