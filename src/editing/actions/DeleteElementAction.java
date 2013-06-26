package editing.actions;

import java.util.LinkedList;

import model.Embellishment;
import model.Measure;
import model.MelodyElement;
import model.Note;

public class DeleteElementAction implements EditAction {
	
	public void execute() {
		for (MelodyElement e : toRemove)
			enclosingMeasure.remove(e);
	}
	
	public void undo() {
		for (MelodyElement e : toRemove)
			enclosingMeasure.add(removeIndex, e);
	}
	
	public DeleteElementAction(MelodyElement toRemove, Measure enclosingMeasure) {
		this.toRemove = new LinkedList<MelodyElement>();
		this.enclosingMeasure = enclosingMeasure;

		removeIndex = enclosingMeasure.indexOf(toRemove);
		this.toRemove.add(toRemove);
		if (toRemove instanceof Note) {
			Embellishment e = ((Note)toRemove).getEmbellishment();
			if (e != null) {
				this.toRemove.addLast(e);
				--removeIndex;
			}
		}		
	}
	
	private LinkedList<MelodyElement> toRemove;
	private Measure enclosingMeasure;
	private int removeIndex;
}
