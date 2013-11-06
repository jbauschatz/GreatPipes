package pipes.view.tools;

import pipes.model.Note;
import pipes.model.Pitch;
import pipes.view.LocationInfo;
import pipes.view.NoteRenderer;
import pipes.view.TunePanel;
import pipes.editing.TuneEditController;
import pipes.editing.actions.ChangePitchAction;

public class ChangePitchTool extends EditTool {
	public void mouseDown(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		gesturedMove = null;
		if (info.lineRenderer != null && info.centeredElement != null && info.centeredElement instanceof NoteRenderer) {
			mouseDownNote = ((NoteRenderer)info.centeredElement).getNote();
			oldPitch = mouseDownNote.getPitch();
		}
	}
	
	public void mouseUp(int x, int y) {
		if (gesturedMove != null) {
			controller.execute(gesturedMove);
			mouseDownNote = null;
		}
	}
	
	public void mouseDragged(int x, int y) {
		if (mouseDownNote != null) {
			LocationInfo info = view.getInfoAt(x, y);
			if (info.lineRenderer != null && info.centeredElement != null && info.centeredElement.getElement() == mouseDownNote) {
				if (info.lineRenderer.hasPitchAtY(y)) {
					newPitch = info.lineRenderer.getPitchForY(y);
					
					if (newPitch != oldPitch) {
						// Previous gesture may have caused side-effects
						if (gesturedMove != null)
							gesturedMove.undo();
						gesturedMove = new ChangePitchAction(mouseDownNote, newPitch);
						controller.executeNoHistory(gesturedMove);
					}
				}
			}
		}
	}
	
	public ChangePitchTool(TunePanel view, TuneEditController controller) {
		super("Change Pitch");
		this.view = view;
		this.controller = controller;
	}

	private Pitch oldPitch;
	private Pitch newPitch;
	private ChangePitchAction gesturedMove;
	private Note mouseDownNote;
	
	private TunePanel view;
	private TuneEditController controller;
}
