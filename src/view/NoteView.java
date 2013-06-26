package view;

import java.awt.Color;
import java.awt.Graphics;

import model.Note;

public class NoteView implements MelodyElementView {
	public boolean contains(int x, int y) {
		return x >= this.x && x < this.x+getWidth()
			&& y >= getHeadY() && y < getHeadY()+headHeight;
	}
	
	public Note getElement() {
		return note;
	}
	
	public String toString() {
		return note.toString();
	}
	
	public int getWidth() {
		return leftMargin + headWidth + rightMargin;
	}

	public int getNoteX() {
		return x + leftMargin;
	}

	public int getHeadY() {
		return y - headHeight/2;
	}
	
	public int getNoteY() {
		return y;
	}
	
	public Note getNote() {
		return note;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setHighlight(boolean b) {
		highlighted = b;
	}
	
	public void setDimensions(int headWidth, int headHeight, int leftMargin, int rightMargin) {
		this.headWidth = headWidth;
		this.headHeight = headHeight;
		this.leftMargin = leftMargin;
		this.rightMargin = rightMargin;
		y = measure.getLineView().getYForPitch(note.getPitch());
	}
	
	public void draw(Graphics g) {
		g.setColor(highlighted ? Color.GREEN : Color.black);
		int headY = y-headHeight/2-1;
		
		if (note.denominator <= Note.HALF)
			g.drawOval(x+leftMargin, headY, headWidth, headHeight);
		else
			g.fillOval(x+leftMargin, headY, headWidth, headHeight);
		
		if (note.getPitch() == Note.A)
			g.drawLine(x, y, x+leftMargin+headWidth+rightMargin, y);
	}
	
	public NoteView(Note n, MeasureView measureView) {
		measure = measureView;
		note = n;
	}
	
	private Note note;
	private MeasureView measure;
	
	private int x;
	private int y;
	
	private int headWidth;
	private int headHeight;
	private int leftMargin;
	private int rightMargin;
	
	private boolean highlighted;
}
