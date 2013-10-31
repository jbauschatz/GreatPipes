package pipes.view;

import pipes.model.Tune;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

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

		String tuneName = tune.getName();
		g.setFont(titleFont);
		g.drawString(tuneName, x+(width-titleMetrics.stringWidth(tuneName))/2, y+(height+titleMetrics.getHeight())/2);

		String tuneAuthor = tune.getAuthor();
		g.setFont(subFont);
		g.drawString(leftText, x, y+height);
		int rightWidth = subMetrics.stringWidth(tuneAuthor);
		g.drawString(tuneAuthor, x+width-rightWidth, y+height);
	}
	
	public TitleAreaView(Tune tune) {
		this.tune = tune;
		leftText = new SimpleDateFormat("MMMMM yyyy").format(new Date());
		titleFont = new Font("Times New Roman", Font.BOLD, 24);
		subFont = new Font("Times New Roman", Font.BOLD, 16);
	}

	private Tune tune;
	private Font titleFont;
	private Font subFont;
	private FontMetrics titleMetrics;
	private FontMetrics subMetrics;
	private String leftText;

	private int height;
	private int width;
	private int x;
	private int y;
}
