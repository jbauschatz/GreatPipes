package pipes.editing.actions;

import pipes.model.Measure;
import pipes.model.Note;

public class SetDotsAction implements EditAction {

	public boolean isLegal() {
		execute();
		boolean isLegal = m.getDuration() <= m.getTimeSignature().getMeasureDuration();
		undo();
		
		return isLegal;
	}
	
	public void execute() {
		n.setNumDots(newDots);
	}

	public void undo() {
		n.setNumDots(oldDots);
	}

	public SetDotsAction(Note n, int numDots, Measure m) {
		this.n = n;
		this.m = m;
		oldDots = n.getNumDots();
		newDots = numDots;
	}
	
	private Note n;
	private Measure m;
	private int oldDots;
	private int newDots;
}
