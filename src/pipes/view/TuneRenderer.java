package pipes.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pipes.model.Line;
import pipes.model.Note;
import pipes.model.Tune;

public class TuneRenderer {
	private static final int PAPER_LONG_SIDE = 1100;
	private static final int PAPER_SHORT_SIDE = 850;
	
	public TuneRenderer(Tune t) {
		tune = t;
		if (t.isPortraitLayout())
			updateMusic(PAPER_SHORT_SIDE, PAPER_LONG_SIDE);
		else
			updateMusic(PAPER_LONG_SIDE, PAPER_SHORT_SIDE);
	}
	
	public TuneRenderer(Tune t, int width, int height) {
		tune = t;
		updateMusic(width, height);
	}
	
	public void render(Graphics g) {
		title.draw(g);
		
		if (lines != null) {
			for (LineView lv : lines)
				lv.draw(g);
		}
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
	
	private void updateMusic(int width, int height) {
		title = new TitleAreaView(tune);
		lines = new LinkedList<LineView>();

		for (Line l : tune)
			lines.add(new LineView(l));

		layoutMusic(width, height);
	}

	private void layoutMusic(int width, int height) {
		if (tune.isPortraitLayout()) {
			sheetWidth = PAPER_SHORT_SIDE;
			sheetHeight = PAPER_LONG_SIDE;
		} else {
			sheetWidth = PAPER_LONG_SIDE;
			sheetHeight = PAPER_SHORT_SIDE;
		}
		lineWidth = (int)(sheetWidth * .9);
		
		sheetLeft = (width - sheetWidth) / 2;
		sheetTop = (height - sheetHeight) / 2;
		int lineLeft = sheetLeft + (sheetWidth-lineWidth)/2;
		
		title.setPosition(lineLeft, sheetTop);
		title.setSize(lineWidth, 180);
		
		// Layout lines
		int lineY = sheetTop + title.getHeight() + 80;
		for (LineView lv : lines) {
			lv.setDimensions(sheetLeft + (sheetWidth-lineWidth)/2, lineY, lineWidth, 50, 30);			
			lineY += 80;
		}
	}
	
	public Dimension getSheetSize() {
		return new Dimension(sheetWidth+50, sheetHeight+50);
	}
	
	public Rectangle getSheetRect() {
		return new Rectangle(sheetLeft, sheetTop, sheetWidth, sheetHeight);
	}
	
	public void updateHighlight(int x, int y) {
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
					} else {
						if (highlight != null)
							highlight.setHighlight(false);
						highlight = null;
					}
				}
			}
		}
	}
	
	private int sheetWidth;
	private int sheetHeight;
	private int sheetLeft;
	private int sheetTop;
	
	private int lineWidth;
	
	private Tune tune;
	
	private TitleAreaView title;
	private LinkedList<LineView> lines;
	
	private MelodyElementView highlight;
}
