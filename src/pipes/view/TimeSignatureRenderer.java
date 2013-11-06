package pipes.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pipes.model.TimeSignature;

public class TimeSignatureRenderer implements MelodyElementRenderer {

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

	public void render(Graphics g) {
		int top = enclosingMeasure.getLineRenderer().getStaffTop();
		int bottom = enclosingMeasure.getLineRenderer().getStaffBottom();
		int middle = top + (bottom-top)/2;
		
		g.setColor(Color.black);
		g.setFont(font);
		g.drawString(model.getBeatsInMeasure()+"", x, middle);
		g.drawString(model.getBeatUnit().denominator+"", x, bottom);
	}

	public TimeSignature getElement() {
		return model;
	}

	public void setHighlight(boolean b) {
		
	}

	public TimeSignatureRenderer(TimeSignature sig, MeasureRenderer enclosingMeasure) {
		model = sig;
		this.enclosingMeasure = enclosingMeasure;
		font = new Font("Times New Roman", Font.PLAIN, 16);
	}
	
	private Font font;
	private int x;
	private TimeSignature model;
	private MeasureRenderer enclosingMeasure;
}
