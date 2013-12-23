package pipes.editing.actions;

import pipes.model.Measure;

public class ToggleRepeatAction implements EditAction {

	public void execute() {
		if (openRepeat)
			measure.setOpenRepeat(!measure.hasOpenRepeat());
		else
			measure.setCloseRepeat(!measure.hasCloseRepeat());
	}

	public void undo() {
		if (openRepeat)
			measure.setOpenRepeat(!measure.hasOpenRepeat());
		else
			measure.setCloseRepeat(!measure.hasCloseRepeat());
	}

	public ToggleRepeatAction(Measure measure, boolean openRepeat) {
		this.measure = measure;
		this.openRepeat = openRepeat;
	}
	
	private Measure measure;
	private boolean openRepeat;
}
