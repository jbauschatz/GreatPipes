package pipes.editing.actions;

import pipes.model.Measure;
import pipes.model.Note;

public class DeleteNoteAction extends ContextSensitiveEdit {

	public void execute() {
		enclosingMeasure.remove(index);

		super.execute();
	}

	public void undo() {
		enclosingMeasure.addNote(index, targetNote);

		super.undo();
	}

	public DeleteNoteAction(Note toRemove, Measure enclosingMeasure) {
		super(toRemove.getTune().getNoteBefore(toRemove), toRemove.getTune().getNoteAfter(toRemove));
		this.enclosingMeasure = enclosingMeasure;
		targetNote = toRemove;
		index = enclosingMeasure.indexOf(targetNote);
	}

	private Measure enclosingMeasure;
	private Note targetNote;
	private int index;
}
