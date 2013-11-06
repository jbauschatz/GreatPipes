package pipes.view;

import pipes.model.Note;

public class LocationInfo {
	public final MelodyElementRenderer elementRenderer;
	public final MeasureRenderer measureRenderer;
	public final LineRenderer lineRenderer;
	
	public final Note noteToLeft;
	public final MelodyElementRenderer centeredElement;
	public final Note noteToRight;
	
	public LocationInfo(LineRenderer lineView, MeasureRenderer measureView, MelodyElementRenderer elementView, 
			Note noteToLeft, MelodyElementRenderer centeredElement, Note noteToRight) {
		this.lineRenderer = lineView;
		this.measureRenderer = measureView;
		this.elementRenderer = elementView;
		this.noteToLeft = noteToLeft;
		this.centeredElement = centeredElement;
		this.noteToRight = noteToRight;
	}
}
