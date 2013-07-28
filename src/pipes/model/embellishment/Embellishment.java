package pipes.model.embellishment;

import java.util.LinkedList;

import pipes.model.MelodyElement;
import pipes.model.Note;

public class Embellishment extends LinkedList<GraceNote> implements MelodyElement {
	
	private static final long serialVersionUID = 1L;

	public Embellishment clone() {
		Embellishment clone = new Embellishment(name);
		clone.addAll(this);
		return clone;
	}
	
	public String toString() {
		return name;
	}
	
	public boolean equals(Object other) {
		return this == other;
	}
	
	public void setNote(Note n) {
		note = n;
	}
	
	public Note getNote() {
		return note;
	}
	
	public Embellishment(String name, GraceNote... notes) {
		this.name = name;
		for (GraceNote n : notes)
			add(n);
	}

	private Note note;
	private String name;
}
