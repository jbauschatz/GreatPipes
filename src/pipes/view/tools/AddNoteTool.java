package pipes.view.tools;

import pipes.model.BeatDivision;
import pipes.model.Note;
import pipes.model.Pitch;
import pipes.view.LocationInfo;
import pipes.view.TuneView;
import pipes.editing.TuneEditController;
import pipes.editing.actions.AddNoteAction;

public class AddNoteTool extends EditTool {

	public void mouseUp(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		
		if (info.measureView != null && info.lineView.hasPitchAtY(y)) {
			Pitch pitch = info.lineView.getPitchForY(y);
			AddNoteAction action = new AddNoteAction(new Note(controller.getTune(), pitch, beat), info.noteToLeft, info.measureView.getMeasure());
			if (action.isLegal())
				controller.execute(action);
		}
	}
	
	public AddNoteTool(BeatDivision beat, TuneView view, TuneEditController controller) {
		super("Add " + beat.name());
		this.beat = beat;
		this.view = view;
		this.controller = controller;
	}
	
	private BeatDivision beat;
	private TuneView view;
	private TuneEditController controller;
}
