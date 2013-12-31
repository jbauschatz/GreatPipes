package pipes.view.tools;

import pipes.editing.TuneEditController;
import pipes.editing.actions.ToggleRepeatAction;
import pipes.model.Measure;
import pipes.view.LocationInfo;
import pipes.view.TunePanel;

public class ToggleRepeatTool extends EditTool {
	
	public void mouseUp(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		if (info.measureRenderer != null) {
			Measure measure = info.measureRenderer.getMeasure();
			
			// Don't add a repeat to the front of the tune
			if (!openRepeat || measure != controller.getTune().getFirst().getFirst())
				controller.execute(new ToggleRepeatAction(measure, openRepeat));
		}
	}

	public ToggleRepeatTool(TuneEditController controller, TunePanel view, boolean openRepeat) {
		super((openRepeat ? "Start" : "End") + " Repeat");
		this.controller = controller;
		this.view = view;
		this.openRepeat = openRepeat;
	}
	
	private TuneEditController controller;
	private TunePanel view;
	private boolean openRepeat;
}
