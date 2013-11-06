package pipes.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import pipes.model.BeatDivision;
import pipes.model.Pitch;

public class StickAndBeamRenderer {
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		int spacing = measure.getLineRenderer().getLineSpacing();
		int stickLength = 4*spacing;
		int bottomLine = measure.getLineRenderer().getYForPitch(Pitch.LOW_G) + stickLength;
		
		if (notes.length == 1) {
			NoteRenderer v = notes[0];
			int x = v.getNoteX();
			int y = v.getNoteY();

			g.drawLine(x, y, x, y + stickLength);
			
			int flagY = v.getNoteY() + stickLength;
			for (int d = BeatDivision.EIGHTH.denominator; d<=v.getNote().getBeatDivision().denominator; d*=2) {
				drawBeam(g, v.getNoteX(), v.getNoteX()+5, flagY);
				flagY -= 8;
			}
		} else {
			for (int n = 0; n<notes.length-1; ++n) {
				NoteRenderer v = notes[n];
				NoteRenderer right = notes[n+1];
				int beamY = bottomLine;
				for (int d = BeatDivision.EIGHTH.denominator; d<=v.getNote().getBeatDivision().denominator; d*=2) {
					if (d <= right.getNote().getBeatDivision().denominator) {
						drawBeam(g, v.getNoteX(), right.getNoteX(), beamY);
					} else {
						if (n == 0)
							drawBeam(g, v.getNoteX(), v.getNoteX()+8, beamY);
						else
							drawBeam(g, v.getNoteX()-8, v.getNoteX(), beamY);
					}
					beamY -= 8;
				}

				g.drawLine(v.getNoteX(), v.getNoteY(), v.getNoteX(), bottomLine);
			}
			
			NoteRenderer right = notes[notes.length-1];
			NoteRenderer penult = notes[notes.length-2];
			int beamY = bottomLine;
			for (int d = BeatDivision.EIGHTH.denominator; d<=right.getNote().getBeatDivision().denominator; d*=2) {
				if (d <= penult.getNote().getBeatDivision().denominator) {
					drawBeam(g, penult.getNoteX(), right.getNoteX(), beamY);
				} else {
					drawBeam(g, right.getNoteX()-8, right.getNoteX(), beamY);
				}
				beamY -= 8;
			}
			
			g.drawLine(right.getNoteX(), right.getNoteY(), right.getNoteX(), bottomLine);
		}
	}
	
	private void drawBeam(Graphics g, int leftx, int rightx, int y) {
		g.fillRect(leftx, y - 3, rightx - leftx, 4);
	}

	public StickAndBeamRenderer(List<NoteRenderer> noteViews, MeasureRenderer measure) {
		this.measure = measure;
		notes = noteViews.toArray(new NoteRenderer[noteViews.size()]);
		
	}

	public StickAndBeamRenderer(NoteRenderer note, MeasureRenderer measure) {
		this.measure = measure;
		notes = new NoteRenderer[]{note};
	}
	
	private NoteRenderer[] notes;
	private MeasureRenderer measure;
}
