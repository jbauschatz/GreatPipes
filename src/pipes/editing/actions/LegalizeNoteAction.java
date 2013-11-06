package pipes.editing.actions;

import pipes.model.Note;
import pipes.model.embellishment.EmbellishmentFamily;

/**
 * This action ensures that the Note obeys the rules of bagpipe sheet music.
 * 
 * When it is executed, the Note's Embellishment will be in the proper form based on the context.
 * 
 * An improper tie will be corrected - that is, if a Note ties into a Note of a different Pitch, or
 * when there is no following Note at all, the tie will be removed.
 *
 */
public class LegalizeNoteAction implements EditAction {

	public void execute() {
		if (oldFamily != null && !oldFamily.canEmbellish(target.getTune().getNoteBefore(target), target))
			target.setEmbellishmentFamily(null);
		else
			target.setEmbellishmentFamily(oldFamily);
		
		Note nextNote = target.getTune().getNoteAfter(target);
		if (nextNote == null || nextNote.getPitch() != target.getPitch())
			target.setIsTiedForward(false);
	}

	public void undo() {
		target.setEmbellishmentFamily(oldFamily);
		target.setIsTiedForward(oldIsTied);
	}

	public LegalizeNoteAction(Note n) {
		target = n;
		oldFamily = n.getEmbellishmentFamily();
		oldIsTied = n.getIsTiedForward();
	}
	
	private Note target;
	private EmbellishmentFamily oldFamily;
	private boolean oldIsTied;
}
