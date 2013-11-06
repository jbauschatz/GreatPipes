package pipes.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import pipes.model.Tune;

public class TitleAreaRenderer {
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.black);
		
		if (titleMetrics == null)
			titleMetrics = g.getFontMetrics(titleFont);

		if (subMetrics == null)
			subMetrics = g.getFontMetrics(subFont);

		// Draw the title, centered in large text
		String tuneName = tune.getName();
		g.setFont(titleFont);
		g.drawString(tuneName, x+(width-titleMetrics.stringWidth(tuneName))/2, y+(height+titleMetrics.getHeight())/2);

		// Align the tune author on the right side
		g.setFont(subFont);
		String tuneAuthor = tune.getAuthor();
		int rightWidth = subMetrics.stringWidth(tuneAuthor);
		g.drawString(tuneAuthor, x+width-rightWidth, y+height);
		
		// Align the tune type on the left side
		g.drawString(tune.getType(), x, y+height);
	}
	
	public TitleAreaRenderer(Tune tune) {
		this.tune = tune;
		titleFont = new Font("Times New Roman", Font.BOLD, 24);
		subFont = new Font("Times New Roman", Font.BOLD, 16);
	}

	private Tune tune;
	private Font titleFont;
	private Font subFont;
	private FontMetrics titleMetrics;
	private FontMetrics subMetrics;

	private int height;
	private int width;
	private int x;
	private int y;
}
