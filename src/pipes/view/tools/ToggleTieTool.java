package pipes.view.tools;

import pipes.editing.TuneEditController;
import pipes.editing.actions.SetTieAction;
import pipes.model.Note;
import pipes.view.LocationInfo;
import pipes.view.NoteView;
import pipes.view.TuneView;

public class ToggleTieTool extends EditTool {

	public void mouseClicked(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		if (info.elementView != null) {
			if (info.elementView instanceof NoteView) {
				Note n = ((NoteView)info.elementView).getElement();
				SetTieAction action = new SetTieAction(n, !n.getIsTiedForward(), controller.getTune());
								
				if (action.isLegal())
					controller.execute(action);
			}
		}
	}
	
	public ToggleTieTool(TuneView view, TuneEditController controller) {
		super("Tie");
		this.view = view;
		this.controller = controller;
	}
	
	private TuneView view;
	private TuneEditController controller;
}
