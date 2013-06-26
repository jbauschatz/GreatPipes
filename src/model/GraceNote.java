package model;

public class GraceNote {
	public static final GraceNote A = new GraceNote(Note.A);
	public static final GraceNote G = new GraceNote(Note.G);
	public static final GraceNote F = new GraceNote(Note.F);
	public static final GraceNote E = new GraceNote(Note.E);
	public static final GraceNote D = new GraceNote(Note.D);
	public static final GraceNote C = new GraceNote(Note.C);
	public static final GraceNote B = new GraceNote(Note.B);
	public static final GraceNote LOW_A = new GraceNote(Note.LOW_A);
	public static final GraceNote LOW_G = new GraceNote(Note.LOW_G);
	
	public final int pitch;
	
	public GraceNote(int pitch) {
		this.pitch = pitch;
	}
}
