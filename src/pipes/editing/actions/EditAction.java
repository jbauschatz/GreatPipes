package pipes.editing.actions;

/**
 * Represents and action that is taken, whether directly by the user or as a side effect of another action, that makes a change to a tune.
 * 
 * EditAction is an application of the Command Pattern; we represent an edit as an object so that it can be stored, validated, and executed in a context-independent manner.
 * An EditAction should only contain information about a change to a tune, and it is not meant to be tied to a UI context. 
 * EditActions should be equally valid in a console-based scripting environment as in a GUI application.
 *
 */
public interface EditAction {
	/**
	 * Execute the action. 
	 * Has a direct side effect on a Tune.
	 */
	public void execute();
	
	/**
	 * Undo the action.
	 * Has a direct side effect on a Tune.
	 */
	public void undo();
}
