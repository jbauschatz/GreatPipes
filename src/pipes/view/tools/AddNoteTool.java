package pipes.view.tools;

import pipes.model.BeatDivision;
import pipes.model.Note;
import pipes.model.Pitch;
import pipes.view.LocationInfo;
import pipes.view.TunePanel;
import pipes.editing.TuneEditController;
import pipes.editing.actions.AddNoteAction;

public class AddNoteTool extends EditTool {

	public void mouseUp(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		
		if (info.measureRenderer != null && info.lineRenderer.hasPitchAtY(y)) {
			Pitch pitch = info.lineRenderer.getPitchForY(y);
			AddNoteAction action = new AddNoteAction(new Note(controller.getTune(), pitch, beat), info.noteToLeft, info.measureRenderer.getMeasure());
			if (action.isLegal())
				controller.execute(action);
		}
	}
	
	public AddNoteTool(BeatDivision beat, TunePanel view, TuneEditController controller) {
		super("Add " + beat.name + " note");
		this.beat = beat;
		this.view = view;
		this.controller = controller;
	}
	
	private BeatDivision beat;
	private TunePanel view;
	private TuneEditController controller;
}
