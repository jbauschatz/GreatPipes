package pipes.editing.actions;

import pipes.model.Measure;
import pipes.model.MelodyElement;
import pipes.model.Note;
import pipes.model.embellishment.Embellishment;

public class DeleteElementAction implements EditAction {

	public void execute() {
		if (removeEmbOnly)
			targetNote.setEmbellishment(null);
		else
			enclosingMeasure.remove(index);
	}

	public void undo() {
		if (removeEmbOnly)
			targetNote.setEmbellishment(targetEmb);
		else
			enclosingMeasure.addNote(index, targetNote);
	}

	public DeleteElementAction(MelodyElement toRemove, Measure enclosingMeasure) {
		if (toRemove instanceof Note) {
			this.enclosingMeasure = enclosingMeasure;
			targetNote = (Note) toRemove;
			index = enclosingMeasure.indexOf(targetNote);
		} else if (toRemove instanceof Embellishment) {
			targetEmb = (Embellishment) toRemove;
			targetNote = targetEmb.getNote();
			removeEmbOnly = true;
		}
	}

	private Measure enclosingMeasure;
	private Note targetNote;
	private int index;
	private boolean removeEmbOnly;
	private Embellishment targetEmb;
}
