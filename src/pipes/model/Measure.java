package pipes.model;

import java.util.Iterator;
import java.util.LinkedList;

public class Measure implements Iterable<Note> {	
	public void insertAfter(Note insert, Note afterThis) {
		internal.add(internal.indexOf(afterThis) + 1, insert);
	}
	
	public Note get(int i) {
		return internal.get(i);
	}
	
	public Note addNote(Note n) {
		internal.add(n);
		return n;
	}
	
	public Note addNote(int index, Note n) {
		internal.add(index, n);
		return n;
	}

	public void remove(Note element) {
		internal.remove(element);
	}
	
	public void remove(int index) {
		remove(internal.get(index));
	}

	public int size() {
		return internal.size();
	}
	
	public int indexOf(Note n) {
		return internal.indexOf(n);
	}

	public Note getLast() {
		return internal.isEmpty() ? null : internal.getLast();
	}

	public Note getFirst() {
		return internal.getFirst();
	}

	public boolean isEmpty() {
		return internal.isEmpty();
	}
	
	public Iterator<Note> iterator() {
		return internal.iterator();
	}
	
	public boolean contains(Note n) {
		return internal.contains(n);
	}
	
	public boolean isTimeSignatureChange() {
		return isTimeSignatureChange;
	}
	
	public void setIsTimeSignatureChange(boolean change) {
		isTimeSignatureChange = change;
	}
	
	public TimeSignature getTimeSignature() {
		return timeSignature;
	}
	
	public void setTimeSignature(TimeSignature time) {
		timeSignature = time;
	}
	
	public int getDuration() {
		int d = 0;
		for (Note n : internal)
			d += n.getNoteLength();
		
		return d;
	}
	
	public Measure(TimeSignature timeSignature) {
		this.timeSignature = timeSignature;
		internal = new LinkedList<Note>();
	}

	private LinkedList<Note> internal;
	private TimeSignature timeSignature;
	private boolean isTimeSignatureChange;
}
