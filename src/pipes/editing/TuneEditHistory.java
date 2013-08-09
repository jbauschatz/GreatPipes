package pipes.editing;

import java.util.Stack;

import pipes.editing.actions.EditAction;

/**
 * Maintains a history of changes made to a Tune, for purposes of navigating the changes using Undo and Redo commands.
 *
 */
public class TuneEditHistory {
	
	/**
	 * @return true if there are EditActions in the history.
	 */
	public boolean canUndo() {
		return !undoActions.isEmpty();
	}

	/**
	 * @return true if there are previously undone EditActions that can be redone; ie after the user has hit Undo but before changes have been made.
	 */
	public boolean canRedo() {
		return !redoActions.isEmpty();
	}
	
	/**
	 * Adds an EditAction to the history.
	 * This clears out Redo stack. It is assumed at this point that "action" has already been executed.
	 */
	public void addToHistory(EditAction action) {
		undoActions.add(action);
		redoActions.clear();
	}

	/**
	 * Pulls out the most recent EditAction in the history. It is assumed that this action is then Undone, so it is pushed onto the Redo stack.
	 * @return the most recent EditAction in the history
	 */
	public EditAction pullFromUndoHistory() {
		EditAction undoAction = undoActions.pop();
		redoActions.push(undoAction);
		return undoAction;
	}

	/**
	 * @return the most recently Undone EditAction
	 */
	public EditAction pullFromRedoHistory() {
		EditAction redoAction = redoActions.pop();
		undoActions.push(redoAction);
		return redoAction;
	}
	
	/**
	 * Empties all Undo and Redo history.
	 */
	public void clear() {
		undoActions.clear();
		redoActions.clear();
	}
	
	public TuneEditHistory() {
		undoActions = new Stack<EditAction>();
		redoActions = new Stack<EditAction>();
	}
	
	/**
	 * EditActions that have been executed and so can be undone.
	 */
	private Stack<EditAction> undoActions;
	
	/**
	 * EditActions that have been undone and so can be re-executed.
	 */
	private Stack<EditAction> redoActions;
}
