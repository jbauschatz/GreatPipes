package editing;

import model.Measure;
import model.MelodyElement;

public class EditGuestureEvent {

	public MelodyElement getTargetedElement() {
		return target;
	}

	public Measure getMeasure() {
		return measure;
	}
	
	public EditGuestureEvent(MelodyElement target, Measure measure) {
		this.target = target;
		this.measure = measure;
	}
	
	private MelodyElement target;
	private Measure measure;
}
