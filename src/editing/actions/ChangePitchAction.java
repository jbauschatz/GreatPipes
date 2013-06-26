package editing.actions;

import model.Note;

public class ChangePitchAction implements EditAction {
	
	public void execute() {
		target.setPitch(newPitch);
	}
	
	public void undo() {
		target.setPitch(oldPitch);
	}
	
	public ChangePitchAction(Note target, int newPitch) {
		this.target = target;
		this.newPitch = newPitch;
		this.oldPitch = target.getPitch();
	}
	
	private Note target;
	private int oldPitch;
	private int newPitch;
}
