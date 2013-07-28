package pipes.view.tools;

import pipes.model.Note;
import pipes.model.embellishment.EmbellishmentFamily;
import pipes.view.EmbellishmentView;
import pipes.view.LocationInfo;
import pipes.view.NoteView;
import pipes.view.TuneView;
import pipes.editing.TuneEditController;
import pipes.editing.actions.SetEmbellishmentFamilyAction;

public class SetEmbellishmentFamilyTool extends EditTool {

	public void mouseUp(int x, int y) {
		LocationInfo info = view.getInfoAt(x, y);
		
		if (info.centeredElement != null) {
			Note n = null;
			if (info.centeredElement instanceof NoteView)
				n = ((NoteView)info.centeredElement).getElement();
			else if (info.centeredElement instanceof EmbellishmentView)
				n = ((EmbellishmentView)info.centeredElement).getElement().getNote();

			SetEmbellishmentFamilyAction action = new SetEmbellishmentFamilyAction(n, embellishment);
			if (action.isLegal())
				controller.execute(action);
		}
	}
	
	public SetEmbellishmentFamilyTool(TuneView view, TuneEditController controller, EmbellishmentFamily embellishment) {
		super(embellishment.getName());
		this.view = view;
		this.controller = controller;
		this.embellishment = embellishment;
	}
	
	private TuneView view;
	private TuneEditController controller;
	private EmbellishmentFamily embellishment;
}
