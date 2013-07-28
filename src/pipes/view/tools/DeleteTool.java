package pipes.view.tools;

import pipes.view.LocationInfo;
import pipes.view.NoteView;
import pipes.view.TuneView;
import pipes.editing.TuneEditController;
import pipes.editing.actions.DeleteElementAction;
import pipes.editing.actions.DeleteNoteAction;

public class DeleteTool extends EditTool {
	public void mouseClicked(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		if (info.elementView != null) {
			if (info.elementView instanceof NoteView)
				controller.execute(new DeleteNoteAction(((NoteView)info.elementView).getElement(), info.measureView.getMeasure()));
			else
				controller.execute(new DeleteElementAction(info.elementView.getElement(), info.measureView.getMeasure()));
		}
	}
	
	public DeleteTool(TuneView view, TuneEditController controller) {
		super("Delete");
		this.view = view;
		this.controller = controller;
	}
	
	private TuneView view;
	private TuneEditController controller;
}
