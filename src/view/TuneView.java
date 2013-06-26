package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.JPanel;

import model.Line;
import model.Tune;

public class TuneView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.WHITE);
		g.fillRect(sheetLeft, sheetTop, sheetWidth, sheetHeight);

		g.setColor(Color.BLACK);
		g.drawRect(sheetLeft, sheetTop, sheetWidth, sheetHeight);
		
		for (LineView lv : lines)
			lv.draw(g);
	}
	
	public void addClickListener(TuneClickedListener list) {
		clickListeners.add(list);
	}
	
	public TuneView(Tune tune) {
		this.tune = tune;
		
		setOpaque(true);
		sheetWidth = 1000;
		sheetHeight = 800;
		lineWidth = 800;
		
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
				TuneView.this.mouseMoved(e.getX(), e.getY());
			}
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				TuneView.this.mouseClicked(e.getX(), e.getY());
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});

		clickListeners = new LinkedList<TuneClickedListener>();
		
		updateMusic();
		layoutMusic();
	}

	public void updateMusic() {
		lines = new LinkedList<LineView>();

		for (Line l : tune)
			lines.add(new LineView(l));
	}

	public void layoutMusic() {
		sheetLeft = (getWidth() - sheetWidth) / 2;
		sheetTop = (getHeight() - sheetHeight) / 2;

		// Layout lines
		int lineY = sheetTop + topLineMargin;
		for (LineView lv : lines) {
			lv.setDimensions(sheetLeft + (sheetWidth-lineWidth)/2, lineY, lineWidth, 50, 30);			
			lineY += 80;
		}
	}

	private void mouseClicked(int x, int y) {
		for (LineView l : lines) {
			if (l.containsPoint(x, y)) {
				MeasureView measureView = l.getMeasure(x, y);
				if (measureView != null) {
					MelodyElementView elementView = measureView.getView(x, y);
					if (elementView != null) {
						for (TuneClickedListener list : clickListeners)
							list.clicked(elementView, measureView);
					}
				}
			}
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
	private LinkedList<TuneClickedListener> clickListeners;
}
