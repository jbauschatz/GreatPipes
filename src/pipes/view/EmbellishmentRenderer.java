package pipes.view;

import java.awt.Color;
import java.awt.Graphics;

import pipes.model.Pitch;
import pipes.model.embellishment.Embellishment;
import pipes.model.embellishment.GraceNote;

public class EmbellishmentRenderer implements MelodyElementRenderer {
	public boolean contains(int x, int y) {
		return x >= this.x && x < this.x+getWidth()
			&& y >= top && y <= bottom;
	}

	public boolean horizontallyContains(int x) {
		return x >= this.x && x < this.x+getWidth();
	}
	
	public Embellishment getElement() {
		return emb;
	}

	public void setHighlight(boolean b) {
		highlighted = b;
	}
	
	public void render(Graphics g) {
		g.setColor(highlighted ? Color.green : Color.black);
		for (int i = 0; i<emb.size(); ++i)
			drawGraceNote(g, xs[i], headYs[i], tailYs[i], emb.element().pitch);
		
		// Draw beams
		if (emb.size() >= 2) {
			drawBeams(g, xs[0]+headWidth, xs[emb.size()-1]+headWidth, tailYs[0], tailYs[emb.size()-1]);
		} else {
			int x = xs[0]+headWidth;
			int y = tailYs[0];
			drawBeams(g, x, x+margin, y, y+margin);
		}
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
		
		x += margin;
		stickLength = measureView.getLineRenderer().getLineSpacing() * 3;

		top = Integer.MAX_VALUE;
		bottom = Integer.MIN_VALUE;
		
		// Place heads
		for (int i = 0; i<emb.size(); ++i) {
			GraceNote g = emb.get(i);
			xs[i] = x;
			headYs[i] = measureView.getLineRenderer().getYForPitch(g.pitch);
			
			top = Math.min(top, headYs[i] - stickLength);
			bottom = Math.max(bottom,  headYs[i] + headWidth/2);
			
			x += headWidth + margin;
		}

		// Place tails
		if (emb.size() <= 2) {
			// One or two notes means to draw tails of a fixed length
			for (int i = 0; i<emb.size(); ++i) {
				tailYs[i] = headYs[i] - stickLength;
			}
		} else {			
			for (int i = 0; i<emb.size(); ++i)
				tailYs[i] = top;
		}
	}

	private void drawGraceNote(Graphics g, int x, int headY, int stickTop, Pitch pitch) {
		g.fillOval(x, headY - headWidth/2, headWidth, headWidth);
		g.drawLine(x+headWidth, headY, x+headWidth, stickTop);
		if (pitch == Pitch.A)
			g.drawLine(x, headY, x+headWidth+margin, headY);
	}
	
	private void drawBeams(Graphics g, int left, int right, int leftTop, int rightTop) {
		for (int i = 0; i<3; ++i) {
			g.fillPolygon(new int[]{left, left, right, right}, 
					new int[]{leftTop, leftTop+beamWidth, rightTop+beamWidth, rightTop}, 4);
			leftTop += beamWidth*2;
			rightTop += beamWidth*2;
		}
	}
	
	public int getWidth() {
		return emb.size()*headWidth + (emb.size()+1)*margin;
	}
	
	public void setDimensions(int headWidth, int margin) {
		this.headWidth = headWidth;
		this.margin = margin;

		xs = new int[emb.size()];
		headYs = new int[emb.size()];
		tailYs = new int[emb.size()];
	}
	
	public EmbellishmentRenderer(Embellishment emb, MeasureRenderer measureView) {
		this.emb = emb;
		this.measureView = measureView;
		beamWidth = 2;
	}
	
	private Embellishment emb;
	private MeasureRenderer measureView;
	
	private int x;
	private int headWidth;
	private int margin;
	private int beamWidth;
	private int stickLength;
	
	private int[] xs;
	private int[] headYs;
	private int[] tailYs;

	private int top;
	private int bottom;
	
	private boolean highlighted;
}
