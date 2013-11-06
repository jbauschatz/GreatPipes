package pipes.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import pipes.model.Line;
import pipes.model.Measure;
import pipes.model.Pitch;

public class LineView {
	public MeasureView getMeasure(int x, int y) {
		for (MeasureView m : measureViews) {
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
	
	public void draw(Graphics g) {		
		// Draw staff
		g.setColor(Color.black);
		for (int l = 0; l<4; ++l) {
			int lineY = staffY + lineSpacing*l;
			g.drawLine(x, lineY, x+width, lineY);
		}
		g.drawLine(x, staffY+staffHeight, x+width, staffY+staffHeight);

		// Draw each measure
		for (MeasureView m : measureViews)
			m.draw(g);
		
		// Draw ties
		for (TieView tie : ties)
			tie.draw(g);
	}
	
	public void updateMusic() {
		measureViews = new LinkedList<MeasureView>();
		for (Measure m : line)
			measureViews.add(new MeasureView(m, this));
		
		ties = new LinkedList<TieView>();
		for (MeasureView measureView : measureViews) {
			Measure measure = measureView.getMeasure();
			if (!measure.isEmpty() && measure.getLast().getIsTiedForward()) {
				if (measure != line.getLast()) {
					NoteView last = measureView.getView(measure.getLast());
					
					MeasureView nextMeasureView = measureViews.get(measureViews.indexOf(measureView)+1);
					NoteView first = nextMeasureView.getView(nextMeasureView.getMeasure().getFirst());
					ties.add(new TieView(measureView, last, first));
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
		for (MeasureView m : measureViews) {
			// Give the last MeasureView the remainder of the space
			if (m == measureViews.getLast())
				m.setDimensions(measureX, staffY, width-measureX+x, staffHeight);
			else
				m.setDimensions(measureX, staffY, measureWidth, staffHeight);
			measureX += measureWidth;
		}
	}
	
	public LineView(Line l) {
		line = l;
		
		updateMusic();
	}
	
	private int getMulitplier(Pitch p) {
		return p.ordinal();
	}
	
	private Line line;
	private LinkedList<MeasureView> measureViews;
	private LinkedList<TieView> ties;
	
	private int x;
	private int y;
	private int staffY;
	private int width;
	private int height;
	private int lineSpacing;
	private int staffHeight;
}
