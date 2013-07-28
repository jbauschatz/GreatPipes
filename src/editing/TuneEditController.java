package editing;

import model.Note;
import model.Tune;
import editing.actions.ChangePitchAction;
import editing.actions.EditAction;

public class TuneEditController {
	public boolean canUndo() {
		return history.canUndo();
	}
	
	public boolean canRedo() {
		return history.canRedo();
	}
	
	public void undo() {
		EditAction undone = history.pullFromUndoHistory();
		undone.undo();
	}
	
	public void redo() {
		EditAction redone = history.pullFromRedoHistory();
		redone.execute();
	}
	
	public void editingGuesture(EditGuestureEvent event) {
		//EditAction action = new DeleteElementAction(event.getTargetedElement(), event.getMeasure());
		if (event.getTargetedElement() instanceof Note) {
			EditAction action = new ChangePitchAction((Note)event.getTargetedElement(), Note.LOW_A);
			action.execute();
			history.addToHistory(action);
		}
	}
	
	public TuneEditController(Tune tune) {		
		history = new TuneEditHistory();
	}
	
	private TuneEditHistory history;
}
