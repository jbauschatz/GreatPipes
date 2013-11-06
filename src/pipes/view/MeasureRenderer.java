package pipes.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.LinkedList;

import pipes.model.Measure;
import pipes.model.MelodyElement;
import pipes.model.Note;
import pipes.model.TimeSignature;

public class MeasureRenderer {
	public boolean contains(int x, int y) {
		return x >= this.x && x < this.x+width
			&& y >= this.y-20 && y < this.y+height+20;
	}

	public MelodyElementRenderer getRRenderer(int x, int y) {
		for (MelodyElementRenderer v : elementRenderers.values()) {
			if (v.contains(x, y))
				return v;
		}
		
		return null;
	}
	
	public NoteRenderer getRenderer(Note n) {
		return (NoteRenderer)elementRenderers.get(n);
	}

	public Note getNoteToLeft(int x) {
		if (measure.isEmpty())
			return null;
		
		Note left = null;
		for (Note n : measure) {			
			MelodyElementRenderer view = elementRenderers.get(n);
			if (view.getX() > x)
				break;
			
			left = n;
		}
		
		return left;
	}

	public Note getNoteToRight(int x) {
		return null;
	}

	public MelodyElementRenderer getRendererHorizontallyAt(int x) {
		for (MelodyElementRenderer v : elementRenderers.values()) {
			if (v.horizontallyContains(x))
				return v;
		}
		
		return null;
	}
	
	public void render(Graphics g) {
		int x = this.x;

		g.setColor(Color.black);
		g.drawLine(x+width, y, x+width, y+height);

		for (MelodyElementRenderer v : elementRenderers.values())
			v.render(g);

		for (StickAndBeamRenderer beam : beams)
			beam.render(g);
		
		for (TieRenderer tie : ties)
			tie.render(g);
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
			MelodyElementRenderer timeView = elementRenderers.get(time);
			spaceTaken += timeView.getWidth();
			timeView.setX(x);
			x += timeView.getWidth();
		}
		
		// Space taken by notes and embellishments
		for (Note note : measure) {
			NoteRenderer noteView = (NoteRenderer)elementRenderers.get(note);
			
			if (note.hasEmbellishment()) {
				EmbellishmentRenderer embView = (EmbellishmentRenderer)elementRenderers.get(note.getEmbellishment());
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
				MelodyElementRenderer embView = elementRenderers.get(n.getEmbellishment());
				embView.setX(x);
				x += embView.getWidth();
			}
			
			int notePadding = noteSpacing * n.getDuration();
			MelodyElementRenderer noteView = elementRenderers.get(n);
			noteView.setX(x);
			x += noteView.getWidth() + notePadding;
		}
	}
		
	public LineRenderer getLineRenderer() {
		return lineView;
	}
	
	public Measure getMeasure() {
		return measure;
	}
	
	public MeasureRenderer(Measure m, LineRenderer lineView) {
		measure = m;
		this.lineView = lineView;
		
		constructRenderers();
	}
	
	public void constructRenderers() {		
		// Create views for all the notes in the measure
		elementRenderers = new HashMap<MelodyElement, MelodyElementRenderer>();
		for (Note n : measure) {
			if (n.hasEmbellishment()) {
				EmbellishmentRenderer embView = new EmbellishmentRenderer(n.getEmbellishment(), this);
				elementRenderers.put(n.getEmbellishment(), embView);
			}
			
			NoteRenderer noteView = new NoteRenderer(n, this);
			elementRenderers.put(n, noteView);
		}
		
		BeamGroupingStrategy beamGrouping = BeamGroupingStrategy.getStrategy(measure.getTimeSignature());
		
		// Group the notes into beams
		beams = new LinkedList<StickAndBeamRenderer>();
		Iterable<Iterable<Note>> beamedGroups = beamGrouping.getNoteGroups(measure);
		for (Iterable<Note> beamedGroup : beamedGroups) {
			LinkedList<NoteRenderer> groupViews = new LinkedList<NoteRenderer>();
			for (Note n : beamedGroup)
				groupViews.add((NoteRenderer) elementRenderers.get(n));
			
			beams.add(new StickAndBeamRenderer(groupViews, this));
		}
		
		// Create ties
		ties = new LinkedList<TieRenderer>();
		Note tied = null;
		for (Note n : measure) {
			if (n.getIsTiedForward()) {
				if (tied != null)
					ties.add(new TieRenderer(this, (NoteRenderer)elementRenderers.get(tied), (NoteRenderer)elementRenderers.get(n)));
				tied = n;
			} else if (tied != null) {
				ties.add(new TieRenderer(this, (NoteRenderer)elementRenderers.get(tied), (NoteRenderer)elementRenderers.get(n)));
				tied = null;
			} else {
				tied = null;
			}
		}
		
		// Add a time signature view
		if (measure.isTimeSignatureChange())
			elementRenderers.put(measure.getTimeSignature(), 
					new TimeSignatureRenderer(measure.getTimeSignature(), this));
	}
	
	private Measure measure;
	private LineRenderer lineView;
	
	private int x;
	private int y;
	private int width;
	private int height;

	private HashMap<MelodyElement, MelodyElementRenderer> elementRenderers;
	private LinkedList<StickAndBeamRenderer> beams;
	private LinkedList<TieRenderer> ties;
}
