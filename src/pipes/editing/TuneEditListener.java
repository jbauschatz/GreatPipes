package pipes.editing;

import pipes.editing.actions.EditAction;

/**
 * Receives notification whenever an EditAction is executed upon a Tune.
 */
public interface TuneEditListener {
	
	/**
	 * Should be called whenever an EditAction is executed upon a Tune.
	 */
	public void tuneEdited(EditAction action);
}
