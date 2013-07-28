package pipes.view;

import java.awt.Color;
import java.awt.Graphics;

import pipes.model.TimeSignature;

public class TimeSignatureView implements MelodyElementView {

	public int getWidth() {
		return 30;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean contains(int x, int y) {
		return false;
	}

	public boolean horizontallyContains(int x) {
		return false;
	}

	public void draw(Graphics g) {
		int top = enclosingMeasure.getLineView().getStaffTop();
		int bottom = enclosingMeasure.getLineView().getStaffBottom();
		int middle = top + (bottom-top)/2;
		
		g.setColor(Color.black);
		g.drawString(model.getBeatsInMeasure()+"", x, middle);
		g.drawString(model.getBeatUnit().denominator+"", x, bottom);
	}

	public TimeSignature getElement() {
		return model;
	}

	public void setHighlight(boolean b) {
		
	}

	public TimeSignatureView(TimeSignature sig, MeasureView enclosingMeasure) {
		model = sig;
		this.enclosingMeasure = enclosingMeasure;
	}
	
	private int x;
	private TimeSignature model;
	private MeasureView enclosingMeasure;
}
