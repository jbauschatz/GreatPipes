package pipes.view;

import java.awt.Color;
import java.awt.Graphics;

import pipes.model.MelodyElement;


public class TieRenderer implements MelodyElementRenderer {
	
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

	public void render(Graphics g) {
		g.setColor(isHighlighted ? Color.GREEN : Color.BLACK);
		
		int width = to.getNoteX() - from.getNoteX();
		int height = measure.getLineRenderer().getLineSpacing()*2;
		int x = from.getNoteX() + from.getNoteWidth()/2;
		int y = measure.getLineRenderer().getStaffTop() - 2*height;
		
		g.drawArc(x, y, width, height, 180, -180);
	}

	public MelodyElement getElement() {
		return null;
	}

	public void setHighlight(boolean b) {
		isHighlighted = b;
	}
	
	public TieRenderer(MeasureRenderer measure, NoteRenderer from, NoteRenderer to) {
		this.measure = measure;
		this.from = from;
		this.to = to;
	}
	
	private MeasureRenderer measure;
	private NoteRenderer from;
	private NoteRenderer to;
	private boolean isHighlighted;
}
