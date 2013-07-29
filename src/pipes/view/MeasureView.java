package pipes.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.LinkedList;

import pipes.model.Measure;
import pipes.model.MelodyElement;
import pipes.model.Note;
import pipes.model.TimeSignature;

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

	public Note getNoteToLeft(int x) {
		if (measure.isEmpty())
			return null;
		
		Note left = null;
		for (Note n : measure) {			
			MelodyElementView view = elementViews.get(n);
			if (view.getX() > x)
				break;
			
			left = n;
		}
		
		return left;
	}

	public Note getNoteToRight(int x) {
		return null;
	}

	public MelodyElementView getViewHorizontallyAt(int x) {
		for (MelodyElementView v : elementViews.values()) {
			if (v.horizontallyContains(x))
				return v;
		}
		
		return null;
	}
	
	public void draw(Graphics g) {
		int x = this.x;

		g.setColor(Color.black);
		g.drawLine(x+width, y, x+width, y+height);

		for (MelodyElementView v : elementViews.values())
			v.draw(g);

		for (StickAndBeamDrawer beam : beams)
			beam.draw(g);
	}
	
	public void setDimensions(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		TimeSignature time = measure.getTimeSignature();
		int unitsInMeasure = time.getBeatsInMeasure() * time.getBeatUnit().duration;
		int spaceTaken = 0;

		// Space taken by the time signature, clef, key signature, etc
		if (measure.isTimeSignatureChange()) {
			MelodyElementView timeView = elementViews.get(time);
			spaceTaken += timeView.getWidth();
			timeView.setX(x);
			x += timeView.getWidth();
		}
		
		// Space taken by notes and embellishments
		for (Note note : measure) {
			NoteView noteView = (NoteView)elementViews.get(note);
			
			if (note.hasEmbellishment()) {
				EmbellishmentView embView = (EmbellishmentView)elementViews.get(note.getEmbellishment());
				embView.setDimensions(lineView.getLineSpacing()-2, 4);
				spaceTaken += embView.getWidth();
			}
			
			int headWidth = lineView.getLineSpacing();
			int headHeight = lineView.getLineSpacing();
			int leftMargin = note == measure.getFirst() && !note.hasEmbellishment() ? headWidth*2 : headWidth/2;
			noteView.setDimensions(headWidth, headHeight, leftMargin, headWidth/2);

			spaceTaken += noteView.getWidth();
		}

		int noteSpacing = (width-spaceTaken) / unitsInMeasure;
		
		// Place the notes
		for (Note n : measure) {
			if (n.hasEmbellishment()) {
				MelodyElementView embView = elementViews.get(n.getEmbellishment());
				embView.setX(x);
				x += embView.getWidth();
			}
			
			int notePadding = noteSpacing * n.getDuration();
			MelodyElementView noteView = elementViews.get(n);
			noteView.setX(x);
			x += noteView.getWidth() + notePadding;
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
		// Create views for all the notes in the measure
		elementViews = new HashMap<MelodyElement, MelodyElementView>();
		for (Note n : measure) {
			if (n.hasEmbellishment()) {
				EmbellishmentView embView = new EmbellishmentView(n.getEmbellishment(), this);
				elementViews.put(n.getEmbellishment(), embView);
			}
			
			NoteView noteView = new NoteView(n, this);
			elementViews.put(n, noteView);
		}
		
		BeamGroupingStrategy beamGrouping = BeamGroupingStrategy.getStrategy(measure.getTimeSignature());
		
		// Group the notes into beams
		beams = new LinkedList<StickAndBeamDrawer>();
		Iterable<Iterable<Note>> beamedGroups = beamGrouping.getNoteGroups(measure);
		for (Iterable<Note> beamedGroup : beamedGroups) {
			LinkedList<NoteView> groupViews = new LinkedList<NoteView>();
			for (Note n : beamedGroup)
				groupViews.add((NoteView) elementViews.get(n));
			
			beams.add(new StickAndBeamDrawer(groupViews, this));
		}
		
		// Add a time signature view
		if (measure.isTimeSignatureChange())
			elementViews.put(measure.getTimeSignature(), 
					new TimeSignatureView(measure.getTimeSignature(), this));
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
