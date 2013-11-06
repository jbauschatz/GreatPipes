package pipes.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import pipes.model.Tune;

public class TunePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		Rectangle sheetRect = renderer.getSheetRect();
		
		g.setColor(Color.WHITE);
		g.fillRect(sheetRect.x, sheetRect.y, sheetRect.width, sheetRect.height);

		g.setColor(Color.BLACK);
		g.drawRect(sheetRect.x, sheetRect.y, sheetRect.width, sheetRect.height);
		
		renderer.render(g);
	}

	public void setTune(Tune t) {
		tune = t;
		renderer = new TuneRenderer(tune, getWidth(), getHeight());
		
		Dimension size = renderer.getSheetSize();
		setSize(size);
		setPreferredSize(size);
		
		repaint();
	}
	
	public void updateMusic() {
		// TODO this is a hack, need to figure out a non-breaking way to change this flow better
		setTune(tune);
	}
	
	public LocationInfo getInfoAt(int x, int y) {
		return renderer.getInfoAt(x, y);
	}
	
	public TunePanel() {
		setOpaque(true);
		
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
				renderer.updateHighlight(e.getX(), e.getY());
				repaint();
			}
			public void mouseDragged(MouseEvent e) {
			}
		});
	}

	private Tune tune;
	private TuneRenderer renderer;
}
