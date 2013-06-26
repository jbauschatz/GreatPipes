package editing;

import java.util.Stack;

import editing.actions.EditAction;

public class TuneEditHistory {
	public boolean canUndo() {
		return !undoActions.isEmpty();
	}

	public boolean canRedo() {
		return !redoActions.isEmpty();
	}
	
	public void addToHistory(EditAction action) {
		undoActions.add(action);
		redoActions.clear();
	}

	public EditAction pullFromUndoHistory() {
		EditAction undoAction = undoActions.pop();
		redoActions.push(undoAction);
		return undoAction;
	}

	public EditAction pullFromRedoHistory() {
		EditAction redoAction = redoActions.pop();
		undoActions.push(redoAction);
		return redoAction;
	}
	
	public TuneEditHistory() {
		undoActions = new Stack<EditAction>();
		redoActions = new Stack<EditAction>();
	}
	
	private Stack<EditAction> undoActions;
	private Stack<EditAction> redoActions;
}
