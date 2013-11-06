package pipes.editing.actions;

import pipes.model.Note;
import pipes.model.Tune;

public class SetTieAction implements EditAction {

	public boolean isLegal() {
		// It is always legal to turn off a tie, otherwise it's only legal if the next Note is the same Pitch
		Note after = tune.getNoteAfter(note);
		return isTied == false || (after != null && after.getPitch() == note.getPitch());
	}
	
	public void execute() {
		note.setIsTiedForward(isTied);
	}

	public void undo() {
		note.setIsTiedForward(!isTied);
	}

	public SetTieAction(Note note, boolean isTied, Tune tune) {
		this.note = note;
		this.isTied = isTied;
		this.tune = tune;
	}
	
	private Note note;
	private boolean isTied;
	private Tune tune;
}
