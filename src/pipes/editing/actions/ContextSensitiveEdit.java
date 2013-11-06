package pipes.editing.actions;

import pipes.model.Note;

public abstract class ContextSensitiveEdit implements EditAction {

	public void execute() {
		if (legalizeNoteBefore != null)
			legalizeNoteBefore.execute();
		if (legalizeNoteAfter != null)
			legalizeNoteAfter.execute();
	}
	
	public void undo() {
		if (legalizeNoteBefore != null)
			legalizeNoteBefore.undo();
		if (legalizeNoteAfter != null)
			legalizeNoteAfter.undo();
	}
	
	public ContextSensitiveEdit(Note noteBefore, Note noteAfter) {
		if (noteBefore != null)
			legalizeNoteBefore = new LegalizeNoteAction(noteBefore);
		if (noteAfter != null)
			legalizeNoteAfter = new LegalizeNoteAction(noteAfter);
	}
	
	protected EditAction legalizeNoteBefore;
	protected EditAction legalizeNoteAfter;
}
