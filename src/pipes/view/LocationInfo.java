package pipes.view;

import pipes.model.Note;

public class LocationInfo {
	public final MelodyElementView elementView;
	public final MeasureView measureView;
	public final LineView lineView;
	
	public final Note noteToLeft;
	public final MelodyElementView centeredElement;
	public final Note noteToRight;
	
	public LocationInfo(LineView lineView, MeasureView measureView, MelodyElementView elementView, 
			Note noteToLeft, MelodyElementView centeredElement, Note noteToRight) {
		this.lineView = lineView;
		this.measureView = measureView;
		this.elementView = elementView;
		this.noteToLeft = noteToLeft;
		this.centeredElement = centeredElement;
		this.noteToRight = noteToRight;
	}
}
