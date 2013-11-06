package pipes.view.tools;

import pipes.model.Note;
import pipes.view.LocationInfo;
import pipes.view.NoteRenderer;
import pipes.view.TunePanel;
import pipes.editing.TuneEditController;
import pipes.editing.actions.SetDotsAction;

public class ToggleDotTool extends EditTool {
	public void mouseClicked(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		if (info.elementRenderer != null) {
			if (info.elementRenderer instanceof NoteRenderer) {
				Note n = ((NoteRenderer)info.elementRenderer).getElement();
				SetDotsAction action;
				if (n.getNumDots() == 0)
					action = new SetDotsAction(n, 1, info.measureRenderer.getMeasure());
				else
					action = new SetDotsAction(n, 0, info.measureRenderer.getMeasure());
				
				if (action.isLegal())
					controller.execute(action);
			}
		}
	}
	
	public ToggleDotTool(TunePanel view, TuneEditController controller) {
		super("Dotted Note");
		this.view = view;
		this.controller = controller;
	}
	
	private TunePanel view;
	private TuneEditController controller;
}
