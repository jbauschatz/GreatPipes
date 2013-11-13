package pipes.view;

import java.awt.Color;
import java.awt.Graphics;

import pipes.model.Note;


public class TieRenderer implements MelodyElementRenderer {
	
	public int getWidth() {
		return width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
	}

	public boolean contains(int x, int y) {
		return x >= this.x && x <= this.x + width
			&& y >= this.y && y <= this.y + height;
	}

	public boolean horizontallyContains(int x) {
		return x >= this.x && x <= this.x + width;
	}

	public void render(Graphics g) {
		width = to.getNoteX() - from.getNoteX();
		height = measure.getLineRenderer().getLineSpacing()*2;
		x = from.getNoteX() + from.getNoteWidth()/2;
		y = measure.getLineRenderer().getStaffTop() - 2*height;

		g.setColor(isHighlighted ? Color.GREEN : Color.BLACK);
		g.drawArc(x, y, width, height, 180, -180);
	}

	public Note getElement() {
		return from.getNote();
	}
	
	public Note getTieStart() {
		return from.getNote();
	}

	public void setHighlight(boolean b) {
		isHighlighted = b;
	}

    public String getToolTipText() {
        return null;
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
	private int x;
	private int y;
	private int width;
	private int height;
}
