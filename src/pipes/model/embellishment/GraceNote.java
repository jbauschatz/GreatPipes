package pipes.model.embellishment;

import pipes.model.Pitch;

public class GraceNote {
	public static final GraceNote A = new GraceNote(Pitch.A);
	public static final GraceNote G = new GraceNote(Pitch.G);
	public static final GraceNote F = new GraceNote(Pitch.F);
	public static final GraceNote E = new GraceNote(Pitch.E);
	public static final GraceNote D = new GraceNote(Pitch.D);
	public static final GraceNote C = new GraceNote(Pitch.C);
	public static final GraceNote B = new GraceNote(Pitch.B);
	public static final GraceNote LOW_A = new GraceNote(Pitch.LOW_A);
	public static final GraceNote LOW_G = new GraceNote(Pitch.LOW_G);
	
	public final Pitch pitch;
	
	public GraceNote(Pitch pitch) {
		this.pitch = pitch;
	}
}
