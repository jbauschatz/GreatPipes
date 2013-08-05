package pipes.model;

import java.util.LinkedList;

public class Tune extends LinkedList<Line> {
	private static final long serialVersionUID = 1L;

	public boolean isPortraitLayout() {
		return false;
	}
	
	public Note getNoteBefore(Note n) {
		int mIndex;
		int lineIndex;
		int noteIndex = 0;
		
		for (lineIndex = 0 ; lineIndex<size(); ++lineIndex) {
			Line l = get(lineIndex);
			for (mIndex = 0; mIndex<l.size(); ++mIndex) {
				Measure m = l.get(mIndex);
				noteIndex = m.indexOf(n);
				if (noteIndex == 0) {
					Measure measureBefore;
					if (mIndex == 0) {
						// get the line before this one
						if (lineIndex == 0)
							return null;
						measureBefore = get(lineIndex - 1).getLast();
					} else {
						measureBefore = l.get(mIndex-1);
					}
					return (Note)measureBefore.getLast();
				} else if (noteIndex > 0) {
					return (Note)m.get(noteIndex - 1);
				}
			}
		}
		
		return null;
	}
	
	public Note getNoteAfter(Note n) {
		for (Line line : this) {
			for (Measure measure : line) {
				if (measure.contains(n)) {					
					if (n != measure.getLast()) {
						// Next not in this measure
						return (Note) measure.get(measure.indexOf(n) + 1);
					}
					// Get next measure
					Measure nextMeasure;
					if (measure != line.getLast()) {
						nextMeasure = line.get(line.indexOf(measure) + 1);
					} else if (line.isEmpty() || line == getLast()) {
						return null;
					} else {
						nextMeasure = get(indexOf(line) + 1).getFirst();
					}
					return nextMeasure.isEmpty() ? null : (Note) nextMeasure.getFirst();
				}
			}
		}
		
		return null;
	}
}
