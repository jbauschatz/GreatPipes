package model;

import java.util.LinkedList;

public class Measure extends LinkedList<MelodyElement> {
	private static final long serialVersionUID = 1L;

	public boolean add(MelodyElement e) {
		if (!isEmpty() && getLast() instanceof Embellishment && e instanceof Note)
			((Note)e).setEmbellishment((Embellishment)getLast());
		
		return super.add(e);
	}
}
