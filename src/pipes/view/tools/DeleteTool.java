package pipes.view.tools;

import pipes.view.LocationInfo;
import pipes.view.NoteRenderer;
import pipes.view.TieRenderer;
import pipes.view.TunePanel;
import pipes.editing.TuneEditController;
import pipes.editing.actions.DeleteElementAction;
import pipes.editing.actions.DeleteNoteAction;
import pipes.editing.actions.SetTieAction;

public class DeleteTool extends EditTool {
	public void mouseClicked(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		if (info.elementRenderer != null) {
			if (info.elementRenderer instanceof NoteRenderer)
				controller.execute(new DeleteNoteAction(((NoteRenderer)info.elementRenderer).getElement(), info.measureRenderer.getMeasure()));
			else if (info.elementRenderer instanceof TieRenderer)
				controller.execute(new SetTieAction(((TieRenderer)info.elementRenderer).getTieStart(), false, controller.getTune()));
			else
				controller.execute(new DeleteElementAction(info.elementRenderer.getElement(), info.measureRenderer.getMeasure()));
		}
	}
	
	public DeleteTool(TunePanel view, TuneEditController controller) {
		super("Delete");
		this.view = view;
		this.controller = controller;
	}
	
	private TunePanel view;
	private TuneEditController controller;
}
