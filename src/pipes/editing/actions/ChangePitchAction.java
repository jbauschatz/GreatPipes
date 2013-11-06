package pipes.editing.actions;

import pipes.model.Note;
import pipes.model.Pitch;

public class ChangePitchAction extends ContextSensitiveEdit {
	
	public void execute() {
		note.setPitch(newPitch);		
		legalizeNote.execute();
		
		super.execute();
	}
	
	public void undo() {
		note.setPitch(oldPitch);		
		legalizeNote.undo();
		
		super.undo();
	}
	
	public ChangePitchAction(Note note, Pitch newPitch) {
		super(note.getTune().getNoteBefore(note), note.getTune().getNoteAfter(note));
		this.note = note;
		this.newPitch = newPitch;
		this.oldPitch = note.getPitch();
		
		legalizeNote = new LegalizeNoteAction(note);
	}

	private LegalizeNoteAction legalizeNote;
	private Note note;
	private Pitch oldPitch;
	private Pitch newPitch;
}
