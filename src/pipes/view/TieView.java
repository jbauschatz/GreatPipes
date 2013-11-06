package pipes.view;

import java.awt.Color;
import java.awt.Graphics;

import pipes.model.MelodyElement;


public class TieView implements MelodyElementView {
	
	public int getWidth() {
		return 0;
	}

	public int getX() {
		return 0;
	}

	public void setX(int x) {
	}

	public boolean contains(int x, int y) {
		return false;
	}

	public boolean horizontallyContains(int x) {
		return false;
	}

	public void draw(Graphics g) {
		g.setColor(isHighlighted ? Color.GREEN : Color.BLACK);
		
		int width = to.getNoteX() - from.getNoteX();
		int height = view.getLineView().getLineSpacing()*2;
		int x = from.getNoteX() + from.getNoteWidth()/2;
		int y = view.getLineView().getStaffTop() - 2*height;
		
		g.drawArc(x, y, width, height, 180, -180);
	}

	public MelodyElement getElement() {
		return null;
	}

	public void setHighlight(boolean b) {
		isHighlighted = b;
	}
	
	public TieView(MeasureView view, NoteView from, NoteView to) {
		this.view = view;
		this.from = from;
		this.to = to;
	}
	
	private MeasureView view;
	private NoteView from;
	private NoteView to;
	private boolean isHighlighted;
}
