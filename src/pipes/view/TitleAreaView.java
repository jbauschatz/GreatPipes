package pipes.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class TitleAreaView {
	
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
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		
		if (titleMetrics == null)
			titleMetrics = g.getFontMetrics(titleFont);

		if (subMetrics == null)
			subMetrics = g.getFontMetrics(subFont);
		
		g.setFont(titleFont);
		g.drawString(titleText, x+(width-titleMetrics.stringWidth(titleText))/2, y+(height+titleMetrics.getHeight())/2);

		g.setFont(subFont);
		g.drawString(leftText, x, y+height);
		int rightWidth = subMetrics.stringWidth(rightText);
		g.drawString(rightText, x+width-rightWidth, y+height);
	}
	
	public TitleAreaView() {
		titleText = "Scotland the Brave";
		leftText = "March";
		rightText = "Gordon Duncan";
		titleFont = new Font("Times New Roman", Font.BOLD, 24);
		subFont = new Font("Times New Roman", Font.BOLD, 16);
	}

	private Font titleFont;
	private Font subFont;
	private FontMetrics titleMetrics;
	private FontMetrics subMetrics;
	private String titleText;
	private String leftText;
	private String rightText;
	
	private int height;
	private int width;
	private int x;
	private int y;
}
