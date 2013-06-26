package model;

import java.util.LinkedList;
import static model.GraceNote.*;

public class Embellishment extends LinkedList<GraceNote> implements MelodyElement {
	
	// Single grace notes
	public static final Embellishment A_GRACE = new Embellishment(A);
	public static final Embellishment G_GRACE = new Embellishment(G);
	public static final Embellishment D_GRACE = new Embellishment(D);
	public static final Embellishment E_GRACE = new Embellishment(E);

	// Doublings
	public static final Embellishment A_DOUBLING = new Embellishment(A, G);
	public static final Embellishment G_DOUBLING = new Embellishment(G, F);
	public static final Embellishment E_DOUBLING = new Embellishment(G, E, F);
	public static final Embellishment B_DOUBLING = new Embellishment(G, B, D);
	
	// Half doublings
	public static final Embellishment G_HALF_DOUBLING = new Embellishment(F);
	
	// *luaths
	public static final Embellishment GRIP = new Embellishment(LOW_G, D, LOW_G);
	
	// Strikes
	public static final Embellishment E_STRIKE = new Embellishment(LOW_A);
	
	private static final long serialVersionUID = 1L;

	public Embellishment(GraceNote... notes) {
		for (GraceNote n : notes)
			add(n);
	}
}
