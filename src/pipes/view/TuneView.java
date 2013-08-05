package pipes.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.JPanel;

import pipes.model.Line;
import pipes.model.Note;
import pipes.model.Tune;

public class TuneView extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int PAPER_LONG_SIDE = 1100;
	private static final int PAPER_SHORT_SIDE = 850;
	
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(Color.WHITE);
		g.fillRect(sheetLeft, sheetTop, sheetWidth, sheetHeight);

		g.setColor(Color.BLACK);
		g.drawRect(sheetLeft, sheetTop, sheetWidth, sheetHeight);
		
		if (lines != null) {
			for (LineView lv : lines)
				lv.draw(g);
		}
	}

	public void setTune(Tune t) {
		tune = t;
		updateMusic();
	}
	
	public TuneView() {
		setOpaque(true);
		
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
				TuneView.this.mouseMoved(e.getX(), e.getY());
			}
			public void mouseDragged(MouseEvent e) {
			}
		});
	}
	
	public LocationInfo getInfoAt(int x, int y) {
		LineView lineView = null;
		MeasureView measureView = null;
		MelodyElementView elementView = null;
		
		Note left = null;
		MelodyElementView center = null;
		Note right = null;
		
		for (LineView l : lines) {
			if (l.containsPoint(x, y)) {
				lineView = l;
				measureView = l.getMeasure(x, y);
				if (measureView != null) {
					elementView = measureView.getView(x, y);
					left = measureView.getNoteToLeft(x);
					center = measureView.getViewHorizontallyAt(x);
					right = measureView.getNoteToRight(x);
				}
			}
		}
		return new LocationInfo(lineView, measureView, elementView, left, center, right);
	}
	
	public void updateMusic() {
		lines = new LinkedList<LineView>();

		for (Line l : tune)
			lines.add(new LineView(l));

		layoutMusic();
		repaint();
	}

	private void layoutMusic() {
		if (tune.isPortraitLayout()) {
			sheetWidth = PAPER_SHORT_SIDE;
			sheetHeight = PAPER_LONG_SIDE;
		} else {
			sheetWidth = PAPER_LONG_SIDE;
			sheetHeight = PAPER_SHORT_SIDE;
		}
		lineWidth = (int)(sheetWidth * .9);
		
		setSize(new Dimension(sheetWidth+50, sheetHeight+50));		
		setPreferredSize(new Dimension(sheetWidth+50, sheetHeight+50));
		
		sheetLeft = (getWidth() - sheetWidth) / 2;
		sheetTop = (getHeight() - sheetHeight) / 2;

		// Layout lines
		int lineY = sheetTop + topLineMargin;
		for (LineView lv : lines) {
			lv.setDimensions(sheetLeft + (sheetWidth-lineWidth)/2, lineY, lineWidth, 50, 30);			
			lineY += 80;
		}
	}

	private void mouseMoved(int x, int y) {
		for (LineView l : lines) {
			if (l.containsPoint(x, y)) {
				MeasureView measureView = l.getMeasure(x, y);
				if (measureView != null) {
					MelodyElementView elementView = measureView.getView(x, y);
					if (elementView != null) {
						elementView.setHighlight(true);
						if (highlight != null && highlight != elementView)
							highlight.setHighlight(false);
						highlight = elementView;
						repaint();
					} else {
						if (highlight != null)
							highlight.setHighlight(false);
						highlight = null;
						repaint();
					}
				}
			}
		}
	}

	
	private int sheetWidth;
	private int sheetHeight;
	private int sheetLeft;
	private int sheetTop;
	
	private int topLineMargin = 80;
	private int lineWidth;
	
	private Tune tune;
	
	private LinkedList<LineView> lines;
	
	private MelodyElementView highlight;
}
