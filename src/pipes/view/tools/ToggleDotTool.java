package pipes.view.tools;

import pipes.model.Note;
import pipes.view.LocationInfo;
import pipes.view.NoteView;
import pipes.view.TuneView;
import pipes.editing.TuneEditController;
import pipes.editing.actions.SetDotsAction;

public class ToggleDotTool extends EditTool {
	public void mouseClicked(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		if (info.elementView != null) {
			if (info.elementView instanceof NoteView) {
				Note n = ((NoteView)info.elementView).getElement();
				SetDotsAction action;
				if (n.getNumDots() == 0)
					action = new SetDotsAction(n, 1, info.measureView.getMeasure());
				else
					action = new SetDotsAction(n, 0, info.measureView.getMeasure());
				
				if (action.isLegal())
					controller.execute(action);
			}
		}
	}
	
	public ToggleDotTool(TuneView view, TuneEditController controller) {
		super(".");
		this.view = view;
		this.controller = controller;
	}
	
	private TuneView view;
	private TuneEditController controller;
}
