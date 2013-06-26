package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Tune;
import editing.EditGuestureEvent;
import editing.TuneEditController;

public class AppView extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String... arg) {
		new AppView();
	}
	
	public AppView() {
		Tune tune = Tune.getTestTune();
		controller = new TuneEditController(tune);

		tuneView = new TuneView(tune);
		tuneView.addClickListener(new TuneClickedListener() {
			public void clicked(MelodyElementView v, MeasureView measureView) {
				controller.editingGuesture(new EditGuestureEvent(v.getElement(), measureView.getMeasure()));

				tuneChanged();
			}
		});
		
		tuneView.setSize(1100, 850);
		tuneView.setPreferredSize(new Dimension(1100, 850));
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(tuneView, BorderLayout.CENTER);
		
		setSize(1200, 900);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		undoButton = new JButton("undo");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.undo();
				tuneChanged();
			}
		});
		
		redoButton = new JButton("redo");
		redoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redo();
				tuneChanged();
			}
		});
		
		JPanel menu = new JPanel();
		menu.add(undoButton);
		menu.add(redoButton);
		getContentPane().add(menu, BorderLayout.NORTH);
		
		tuneChanged();
	}
	
	private void tuneChanged() {
		tuneView.updateMusic();
		tuneView.layoutMusic();
		tuneView.repaint();

		undoButton.setEnabled(controller.canUndo());
		redoButton.setEnabled(controller.canRedo());
	}
	
	private TuneEditController controller;
	private TuneView tuneView;
	private JButton undoButton;
	private JButton redoButton;
}
