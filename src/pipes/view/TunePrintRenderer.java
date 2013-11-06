package pipes.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import pipes.model.Tune;

public class TunePrintRenderer implements Printable {
	public TunePrintRenderer(Tune t) {
		tune = t;
	}
	
	public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex > 0)
			return Printable.NO_SUCH_PAGE;
		
		Graphics2D g2 = (Graphics2D)g;
		
		int iWidth = (int)pageFormat.getImageableWidth();
		int iHeight = (int)pageFormat.getImageableHeight();
		int iXMargin = (int)pageFormat.getImageableX();
		int iYMargin = (int)pageFormat.getImageableY();
		
		// rotate if the orientations don't match
		if ((pageFormat.getWidth() > pageFormat.getHeight() && tune.isPortraitLayout()) ||
				(pageFormat.getHeight() < pageFormat.getHeight() && !tune.isPortraitLayout())) {
			g2.rotate(Math.PI / 2);
			g2.translate(0, pageFormat.getWidth());
			
			// swap sizes and margins
			int t = iWidth;
			iWidth = iHeight;
			iHeight = t;
			t = iXMargin;
			iXMargin = iYMargin;
			iYMargin = t;
		}
		
		// translate the margins away
		g2.translate(iXMargin, iYMargin);
		
		TuneRenderer renderer = new TuneRenderer(tune);
		
		// scale to how wide the renderer wants to be
		double scale = 1.0 * iWidth / renderer.getSheetRect().width;
		g2.scale(scale, scale);
		
		renderer.render(g);
		
		return Printable.PAGE_EXISTS;
	}
	
	private Tune tune;
}
