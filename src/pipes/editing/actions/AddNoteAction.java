package pipes.editing.actions;

import pipes.model.Measure;
import pipes.model.Note;

public class AddNoteAction extends ContextSensitiveEdit {

	public boolean isLegal() {
		return measure.getDuration() + addThis.getDuration() <= measure.getTimeSignature().getMeasureDuration();
	}
	
	public void execute() {
		measure.insertAfter(addThis, afterThis);

		super.execute();
	}

	public void undo() {
		measure.remove(addThis);

		super.undo();
	}

	public Note getNoteAdded() {
		return addThis;
	}
	
	public AddNoteAction(Note addThis, Note afterThis, Measure measure) {
		super(afterThis, addThis.getTune().getNoteAfter(afterThis));
		this.addThis = addThis;
		this.afterThis = afterThis;
		this.measure = measure;
	}

	private Note addThis;
	private Note afterThis;
	private Measure measure;
}
