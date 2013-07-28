package pipes.editing.actions;

import pipes.model.Measure;
import pipes.model.Note;

public class DeleteNoteAction implements EditAction {

	public void execute() {
		enclosingMeasure.remove(index);

		if (legalizeNoteAfter != null)
			legalizeNoteAfter.execute();
	}

	public void undo() {
		enclosingMeasure.addNote(index, targetNote);

		if (legalizeNoteAfter != null)
			legalizeNoteAfter.undo();
	}

	public DeleteNoteAction(Note toRemove, Measure enclosingMeasure) {
		this.enclosingMeasure = enclosingMeasure;
		targetNote = toRemove;
		index = enclosingMeasure.indexOf(targetNote);

		Note noteAfter = toRemove.getTune().getNoteAfter(toRemove);
		if (noteAfter != null)
			legalizeNoteAfter = new LegalizeEmbellishmentAction(noteAfter);
	}

	private Measure enclosingMeasure;
	private Note targetNote;
	private int index;

	private LegalizeEmbellishmentAction legalizeNoteAfter;
}
