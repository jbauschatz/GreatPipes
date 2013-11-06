package pipes.view.tools;

import pipes.editing.TuneEditController;
import pipes.editing.actions.SetTieAction;
import pipes.model.Note;
import pipes.view.LocationInfo;
import pipes.view.NoteRenderer;
import pipes.view.TunePanel;

public class ToggleTieTool extends EditTool {

	public void mouseClicked(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		if (info.elementRenderer != null) {
			if (info.elementRenderer instanceof NoteRenderer) {
				Note n = ((NoteRenderer)info.elementRenderer).getElement();
				SetTieAction action = new SetTieAction(n, !n.getIsTiedForward(), controller.getTune());
								
				if (action.isLegal())
					controller.execute(action);
			}
		}
	}
	
	public ToggleTieTool(TunePanel view, TuneEditController controller) {
		super("Tie");
		this.view = view;
		this.controller = controller;
	}
	
	private TunePanel view;
	private TuneEditController controller;
}
