package pipes.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import pipes.model.Line;
import pipes.model.Measure;
import pipes.model.Pitch;

public class LineRenderer {
	public MeasureRenderer getMeasure(int x, int y) {
		for (MeasureRenderer m : measureRenderers) {
			if (m.contains(x, y))
				return m;
		}
		
		return null;
	}
	
	public boolean containsPoint(int x, int y) {
		return x >= this.x && x < this.x+width
			&& y >= this.y && y < this.y+height;
	}
	
	public int getLineSpacing() {
		return lineSpacing;
	}
	
	public int getStaffTop() {
		return staffY;
	}
	
	public int getStaffBottom() {
		return staffY + staffHeight;
	}
	
	public int getYForPitch(Pitch pitch) {
		return staffY + 3*lineSpacing - getMulitplier(pitch)*lineSpacing/2;
	}
	
	public boolean hasPitchAtY(int y) {
		return y >= getYForPitch(Pitch.A)-lineSpacing/2
			&& y <= getYForPitch(Pitch.LOW_G)+lineSpacing/2;
	}
	
	public Pitch getPitchForY(int y) {
		return Pitch.values()[2*(getYForPitch(Pitch.LOW_G) - y) / lineSpacing];
	}
	
	public void render(Graphics g) {		
		// Draw staff
		g.setColor(Color.black);
		for (int l = 0; l<4; ++l) {
			int lineY = staffY + lineSpacing*l;
			g.drawLine(x, lineY, x+width, lineY);
		}
		g.drawLine(x, staffY+staffHeight, x+width, staffY+staffHeight);

		// Draw each measure
		for (MeasureRenderer m : measureRenderers)
			m.render(g);
		
		// Draw ties
		for (TieRenderer tie : ties)
			tie.render(g);
	}
	
	public void updateMusic() {
		measureRenderers = new LinkedList<MeasureRenderer>();
		for (Measure m : line)
			measureRenderers.add(new MeasureRenderer(m, this));
		
		ties = new LinkedList<TieRenderer>();
		for (MeasureRenderer measureRend : measureRenderers) {
			Measure measure = measureRend.getMeasure();
			if (!measure.isEmpty() && measure.getLast().getIsTiedForward()) {
				if (measure != line.getLast()) {
					NoteRenderer last = measureRend.getRenderer(measure.getLast());
					
					MeasureRenderer nextMeasureRend = measureRenderers.get(measureRenderers.indexOf(measureRend)+1);
					NoteRenderer first = nextMeasureRend.getRenderer(nextMeasureRend.getMeasure().getFirst());
					ties.add(new TieRenderer(measureRend, last, first));
				} else {
					// TODO - Ties across lines
				}
			}
		}
	}
	
	public void setDimensions(int x, int y, int width, int height, int staffHeight) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.staffHeight = staffHeight;
		
		staffY = y + (height - staffHeight)/2;
		lineSpacing = staffHeight / 4;

		// Size and place each measure
		int measureWidth = width / line.size();
		int measureX = x;
		for (MeasureRenderer m : measureRenderers) {
			// Give the last MeasureView the remainder of the space
			if (m == measureRenderers.getLast())
				m.setDimensions(measureX, staffY, width-measureX+x, staffHeight);
			else
				m.setDimensions(measureX, staffY, measureWidth, staffHeight);
			measureX += measureWidth;
		}
	}
	
	public LineRenderer(Line l) {
		line = l;
		
		updateMusic();
	}
	
	private int getMulitplier(Pitch p) {
		return p.ordinal();
	}
	
	private Line line;
	private LinkedList<MeasureRenderer> measureRenderers;
	private LinkedList<TieRenderer> ties;
	
	private int x;
	private int y;
	private int staffY;
	private int width;
	private int height;
	private int lineSpacing;
	private int staffHeight;
}
