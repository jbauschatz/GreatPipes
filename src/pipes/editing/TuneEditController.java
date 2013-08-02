package pipes.editing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import pipes.editing.actions.EditAction;
import pipes.model.Tune;
import pipes.sound.TunePlayer;
import pipes.view.TuneView;
import pipes.view.tools.EditTool;
import pipes.view.tools.NullTool;

public class TuneEditController {
	public boolean canUndo() {
		return history.canUndo();
	}
	
	public boolean canRedo() {
		return history.canRedo();
	}
	
	public void undo() {
		EditAction undone = history.pullFromUndoHistory();
		undone.undo();
		notifyEdit(undone);
	}
	
	public void redo() {
		EditAction redone = history.pullFromRedoHistory();
		redone.execute();
		notifyEdit(redone);
	}

	public void execute(EditAction action) {
		action.execute();
		history.addToHistory(action);
		notifyEdit(action);
	}

	public void executeNoHistory(EditAction action) {
		action.execute();
		notifyEdit(action);
	}
	
	public void addEditListener(TuneEditListener l) {
		listeners.add(l);
	}

	public void setCurrentTool(EditTool tool) {
		currentTool = tool;
	}

	public void setTune(Tune tune) {
		this.tune = tune;
	}
	
	public Tune getTune() {
		return tune;
	}

	public TunePlayer getPlayer() {
		return player;
	}
	
	public TuneEditController(final TuneView view) {
		player = new TunePlayer();
		history = new TuneEditHistory();
		currentTool = new NullTool();
		
		view.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				currentTool.mouseUp(e.getX(), e.getY());
			}
			public void mousePressed(MouseEvent e) {
				currentTool.mouseDown(e.getX(), e.getY());
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				currentTool.mouseClicked(e.getX(), e.getY());
			}
		});
		
		view.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
			}
			public void mouseDragged(MouseEvent e) {
				currentTool.mouseDragged(e.getX(), e.getY());
			}
		});
		
		listeners = new LinkedList<TuneEditListener>();
		listeners.add(new TuneEditListener() {
			public void tuneEdited(EditAction action) {
				view.updateMusic();
			}
		});
		listeners.add(player);
	}

	private void notifyEdit(EditAction action) {
		for (TuneEditListener l : listeners)
			l.tuneEdited(action);
	}

	private Tune tune;
	private TunePlayer player;
	private EditTool currentTool;
	private TuneEditHistory history;
	
	private LinkedList<TuneEditListener> listeners;
}
