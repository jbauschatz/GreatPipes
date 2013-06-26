package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.LinkedList;

import model.Embellishment;
import model.Measure;
import model.MelodyElement;
import model.Note;

public class MeasureView {
	public boolean contains(int x, int y) {
		return x >= this.x && x < this.x+width
			&& y >= this.y-20 && y < this.y+height+20;
	}
	
	public MelodyElementView getView(int x, int y) {
		for (MelodyElementView v : elementViews.values()) {
			if (v.contains(x, y))
				return v;
		}
		
		return null;
	}
	
	public void draw(Graphics g) {
		int x = this.x;

		g.setColor(Color.black);
		g.drawLine(x+width, y, x+width, y+height);

		for (MelodyElement e : measure)
			elementViews.get(e).draw(g);

		for (StickAndBeamDrawer beam : beams)
			beam.draw(g);
	}
	
	public void setDimensions(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		int unitsInMeasure = Note.THIRTY_SECOND * 3/4; // TODO: Adjust for time signature
		int spaceTaken = 0;

		for (MelodyElement e : measure) {
			MelodyElementView view = elementViews.get(e);
			
			if (view instanceof EmbellishmentView) {
				// Set the size of embellishments
				((EmbellishmentView)view).setDimensions(lineView.getLineSpacing()-2, 4);
			} else if (view instanceof NoteView) {
				int headWidth = lineView.getLineSpacing();
				int headHeight = lineView.getLineSpacing();
				int leftMargin = e == measure.getFirst() ? headWidth*2 : headWidth/2;
				((NoteView)view).setDimensions(headWidth, headHeight, leftMargin, headWidth/2);
			}
			
			spaceTaken += view.getWidth();
		}

		int noteSpacing = (width-spaceTaken) / unitsInMeasure;
		
		// Place the notes
		for (MelodyElement e : measure) {
			if (e instanceof Note) {
				int notePadding = noteSpacing * Note.THIRTY_SECOND / ((Note)e).denominator;
				MelodyElementView view = elementViews.get(e);
				view.setX(x);
				x += view.getWidth() + notePadding;
			} else if (e instanceof Embellishment) {
				MelodyElementView v = elementViews.get(e);
				v.setX(x);
				x += v.getWidth();
			}
		}
	}
		
	public LineView getLineView() {
		return lineView;
	}
	
	public Measure getMeasure() {
		return measure;
	}
	
	public MeasureView(Measure m, LineView lineView) {
		measure = m;
		this.lineView = lineView;
		
		constructViews();
	}
	
	public void constructViews() {
		elementViews = new HashMap<MelodyElement, MelodyElementView>();
		beams = new LinkedList<StickAndBeamDrawer>();
		
		LinkedList<NoteView> beamedRun = new LinkedList<NoteView>();
		int beamedRunLength = 0; // sum of thirty-second notes
		
		for (MelodyElement e : measure) {
			if (e instanceof Embellishment) {
				 MelodyElementView view = new EmbellishmentView((Embellishment)e, this);
				 elementViews.put(e, view);
			} else if (e instanceof Note) {
				Note n = (Note)e;

				NoteView view = new NoteView(n, this);
				elementViews.put(e, view);

				// Add to run or make a new run
				if (n.denominator >= Note.EIGHTH && beamedRunLength + Note.THIRTY_SECOND / n.denominator <= Note.THIRTY_SECOND/Note.QUARTER) {
					beamedRun.add(view);
					beamedRunLength += Note.THIRTY_SECOND / n.denominator;
				} else {
					if (beamedRunLength > 0) {
						beams.add(new StickAndBeamDrawer(beamedRun, this));
						beamedRun = new LinkedList<NoteView>();
						beamedRunLength = 0;
					}

					if (n.denominator >= Note.HALF) {
						beamedRun.add(view);
						beamedRunLength += Note.THIRTY_SECOND / n.denominator;
					}
				}
			}
		}
		if (beamedRun.size() > 0)
			beams.add(new StickAndBeamDrawer(beamedRun, this));
	}
	
	private Measure measure;
	private LineView lineView;
	
	private int x;
	private int y;
	private int width;
	private int height;

	private HashMap<MelodyElement, MelodyElementView> elementViews;
	private LinkedList<StickAndBeamDrawer> beams;
}
