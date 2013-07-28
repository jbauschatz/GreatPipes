package pipes.editing.actions;

import pipes.model.Note;
import pipes.model.Pitch;

public class ChangePitchAction implements EditAction {
	
	public void execute() {
		note.setPitch(newPitch);
		
		legalizeNote.execute();
		
		if (legalizeNextNote != null)
			legalizeNextNote.execute();
	}
	
	public void undo() {
		note.setPitch(oldPitch);
		
		legalizeNote.undo();
		
		if (legalizeNextNote != null)
			legalizeNextNote.undo();
	}
	
	public ChangePitchAction(Note note, Pitch newPitch) {
		this.note = note;
		this.newPitch = newPitch;
		this.oldPitch = note.getPitch();
		
		legalizeNote = new LegalizeEmbellishmentAction(note);
		
		Note nextNote = note.getTune().getNoteAfter(note);
		if (nextNote != null) {
			legalizeNextNote = new LegalizeEmbellishmentAction(nextNote);
		}
	}

	private LegalizeEmbellishmentAction legalizeNote;
	private LegalizeEmbellishmentAction legalizeNextNote;
	private Note note;
	private Pitch oldPitch;
	private Pitch newPitch;
}
