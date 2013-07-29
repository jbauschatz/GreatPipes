package pipes.editing.actions;

import pipes.model.Measure;
import pipes.model.Note;

public class AddNoteAction implements EditAction {

	public boolean isLegal() {
		return measure.getDuration() + addThis.getDuration() <= measure.getTimeSignature().getMeasureDuration();
	}
	
	public void execute() {
		measure.insertAfter(addThis, afterThis);
		if (legalizeNextNote != null)
			legalizeNextNote.execute();
	}

	public void undo() {
		measure.remove(addThis);
		if (legalizeNextNote != null)
			legalizeNextNote.undo();
	}

	public AddNoteAction(Note addThis, Note afterThis, Measure measure) {
		this.addThis = addThis;
		this.afterThis = afterThis;
		this.measure = measure;

		Note noteAfter = addThis.getTune().getNoteAfter(afterThis);
		if (noteAfter != null)
			legalizeNextNote = new LegalizeEmbellishmentAction(noteAfter);
	}

	private Note addThis;
	private Note afterThis;
	private Measure measure;

	private LegalizeEmbellishmentAction legalizeNextNote;
}
