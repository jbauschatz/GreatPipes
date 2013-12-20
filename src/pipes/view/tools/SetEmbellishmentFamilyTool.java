package pipes.view.tools;

import pipes.model.Note;
import pipes.model.embellishment.EmbellishmentFamily;
import pipes.view.EmbellishmentRenderer;
import pipes.view.LocationInfo;
import pipes.view.NoteRenderer;
import pipes.view.TunePanel;
import pipes.editing.TuneEditController;
import pipes.editing.actions.SetEmbellishmentFamilyAction;

public class SetEmbellishmentFamilyTool extends EditTool {

	public void mouseUp(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		
		if (info.centeredElement != null) {
			Note n = null;
			if (info.centeredElement instanceof NoteRenderer)
				n = ((NoteRenderer)info.centeredElement).getElement();
			else if (info.centeredElement instanceof EmbellishmentRenderer)
				n = ((EmbellishmentRenderer)info.centeredElement).getElement().getNote();

			SetEmbellishmentFamilyAction action = new SetEmbellishmentFamilyAction(n, embellishment);
			if (action.isLegal())
				controller.execute(action);
		}
	}
	
	public EmbellishmentFamily getEmbellishment() {
		return embellishment;
	}

	public SetEmbellishmentFamilyTool(TunePanel view, TuneEditController controller, EmbellishmentFamily embellishment) {
		super(embellishment.getName());
		this.view = view;
		this.controller = controller;
		this.embellishment = embellishment;
	}
	
	private TunePanel view;
	private TuneEditController controller;
	private EmbellishmentFamily embellishment;
}
