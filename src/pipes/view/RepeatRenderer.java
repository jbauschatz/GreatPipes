package pipes.view;

import java.awt.Color;
import java.awt.Graphics;

public class RepeatRenderer {
	
	public int getWidth() {
		return width;
	}
	
	public void render(Graphics g) {
		int top = measure.getLineRenderer().getStaffTop();
		int height = measure.getLineRenderer().getStaffBottom() - top;
		g.setColor(Color.black);
		
		if (open) {
			int x = measure.getX();
			
			// fat line
			g.fillRect(x, top, fatWidth, height);
			
			// skinny line
			x += fatWidth + spacing;
			g.fillRect(x, top, skinnyWidth, height);
			
			// dots
			x += skinnyWidth + spacing;
			g.fillOval(x, top + (int)(1.5*lineSpacing) - dotWidth/2, dotWidth, dotWidth);
			g.fillOval(x, top + (int)(2.5*lineSpacing) - dotWidth/2, dotWidth, dotWidth);
		} else {
			int x = measure.getX()+measure.getWidth()-fatWidth-2*spacing-dotWidth;
			
			// dots
			g.fillOval(x, top + (int)(1.5*lineSpacing) - dotWidth/2, dotWidth, dotWidth);
			g.fillOval(x, top + (int)(2.5*lineSpacing) - dotWidth/2, dotWidth, dotWidth);			

			// skinny line
			x += dotWidth + spacing;
			g.fillRect(x, top, skinnyWidth, height);
			
			// fat line
			x += skinnyWidth + spacing;
			g.fillRect(x, top, fatWidth, height);
		}
	}
	
	public void doLayout() {
		lineSpacing = measure.getLineRenderer().getLineSpacing();
		fatWidth = lineSpacing/2;
		skinnyWidth = 1;
		spacing = lineSpacing/3;
		dotWidth = 2*lineSpacing/3;
		width = fatWidth+2*spacing+dotWidth;
	}
	
	public RepeatRenderer(MeasureRenderer measure, boolean open) {
		this.measure = measure;
		this.open = open;
	}
	
	private MeasureRenderer measure;
	private boolean open;
	private int width;
	private int lineSpacing;
	private int fatWidth;
	private int skinnyWidth;
	private int spacing;
	private int dotWidth;
	
}
