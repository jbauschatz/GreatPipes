package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import model.Line;
import model.Measure;

public class LineView {
	public MeasureView getMeasure(int x, int y) {
		for (MeasureView m : measures) {
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
	
	public int getYForPitch(int pitch) {
		return staffY + 3*lineSpacing - pitch*lineSpacing/2;
	}
	
	public void draw(Graphics g) {
		// Draw staff
		g.setColor(Color.black);
		for (int l = 0; l<5; ++l) {
			int lineY = staffY + lineSpacing*l;
			g.drawLine(x, lineY, x+width, lineY);
		}

		// Draw each measure
		for (MeasureView m : measures)
			m.draw(g);
	}
	
	public void updateMusic() {
		measures = new LinkedList<MeasureView>();
		for (Measure m : line)
			measures.add(new MeasureView(m, this));
	}
	
	public void setDimensions(int x, int y, int width, int height, int staffHeight) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		staffY = y + (height - staffHeight)/2;
		lineSpacing = staffHeight / 4;

		// Size and place each measure
		int measureWidth = width / line.size();
		int measureX = x;
		for (MeasureView m : measures) {
			m.setDimensions(measureX, staffY, measureWidth, staffHeight);
			measureX += measureWidth;
		}
	}
	
	public LineView(Line l) {
		line = l;
		
		updateMusic();
	}
	
	private Line line;
	private LinkedList<MeasureView> measures;
	
	private int x;
	private int y;
	private int staffY;
	private int width;
	private int height;
	private int lineSpacing;
}
