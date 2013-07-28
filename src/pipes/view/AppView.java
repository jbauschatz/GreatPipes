package pipes.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import pipes.editing.TuneEditController;
import pipes.editing.TuneEditListener;
import pipes.editing.io.TuneSerializer;
import pipes.model.TimeSignature;
import pipes.model.Tune;
import pipes.model.TuneFactory;
import pipes.view.tools.Toolbar;

public class AppView extends JFrame implements TuneEditListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_CAPTION = "Great Pipes";

	public static void main(String... arg) {
		new AppView();
	}
	
	public void tuneEdited() {
		editState.isDirty = true;
		updateTitle();
	}
	
	public AppView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		editState = new TuneEditingState();
		
		tuneView = new TuneView();
		tuneView.setSize(1100, 850);
		tuneView.setPreferredSize(new Dimension(1100, 850));
		JScrollPane tuneScroller = new JScrollPane(tuneView);

		controller = new TuneEditController(tuneView);
		controller.addEditListener(this);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(tuneScroller, BorderLayout.CENTER);
		
		Toolbar toolbar = new Toolbar(tuneView, controller);
		controller.addEditListener(toolbar);
		getContentPane().add(toolbar, BorderLayout.NORTH);

		buildMenu();

		updateTitle();
		setSize(1200, 900);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setEditingTune(TuneFactory.getNewTune(TimeSignature.FOUR_FOUR, 4, 4));
		
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				tuneView.updateMusic();
			}
		});
	}

	private void buildMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('f');
		menuBar.add(fileMenu);

		JMenuItem newItem = new JMenuItem("New");
		fileMenu.add(newItem);
		newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newTune();
			}
		});

		JMenuItem openItem = new JMenuItem("Open...");
		fileMenu.add(openItem);
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});

		JMenuItem saveItem = new JMenuItem("Save");
		fileMenu.add(saveItem);
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		JMenuItem saveAsItem = new JMenuItem("Save As...");
		fileMenu.add(saveAsItem);
		saveAsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAs();
			}
		});
	}
	
	private void save() {
		if (editState.isDirty) {
			if (editState.editingFile == null) {
				saveAs();
			} else {
				try {
					TuneSerializer.saveTune(editState.tune, editState.editingFile);
					editState.isDirty = false;
					updateTitle();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, "An error occured while saving your tune.");
				}
			}
		}
	}
	
	private void saveAs() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("Great Pipes tune file", TuneSerializer.FILE_EXTENSION));
		chooser.setMultiSelectionEnabled(false);
		chooser.setAcceptAllFileFilterUsed(false);
				
		if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				editState.editingFile = TuneSerializer.saveTune(editState.tune, chooser.getSelectedFile());
				editState.isDirty = false;
				updateTitle();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "An error occured while saving your tune.");
				e.printStackTrace();
			}
		}
	}

	private void open() {
		// save changes
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("Great Pipes tune file", TuneSerializer.FILE_EXTENSION));
		chooser.setMultiSelectionEnabled(false);
		chooser.setAcceptAllFileFilterUsed(false);
		
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				setEditingTune(TuneSerializer.loadTune(chooser.getSelectedFile()));
				editState.editingFile = chooser.getSelectedFile();
				editState.isDirty = false;
				updateTitle();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "An error occured while loading the file.");
				e.printStackTrace();
			}
		}
	}
	
	private void newTune() {
		// Save changes
		
		// New tune
		JTextField numLines = new JTextField("4", 2);
		JTextField measuresPerLine = new JTextField("4", 4);
		JComboBox<TimeSignature> timeSigs = new JComboBox<TimeSignature>(TimeSignature.STANDARD_TIMES);
		
		JComponent[] message = new JComponent[] {
				new JLabel("Lines: "),
				numLines,
				new JLabel("Measures per line: "),
				measuresPerLine,
				new JLabel("Time signature"),
				timeSigs};
		Object[] inputs = new Object[] {"Ok", "Cancel"};
		
		boolean valid = false;
		while (!valid) {
			if (JOptionPane.showOptionDialog(this, message, "New tune", JOptionPane.PLAIN_MESSAGE, JOptionPane.CLOSED_OPTION, null, inputs, inputs[0])
					== JOptionPane.OK_OPTION) {
				try {
					int numLinesChosen = Integer.parseInt(numLines.getText());
					int measuresPerChosen = Integer.parseInt(measuresPerLine.getText());
					setEditingTune(TuneFactory.getNewTune((TimeSignature)timeSigs.getSelectedItem(), numLinesChosen, measuresPerChosen));
					editState.isDirty = false;
					updateTitle();
					valid = true;
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Please enter valid inputs.");
				}
			} else {
				break;
			}
		}
	}
	
	private void updateTitle() {
		if (editState.editingFile != null) {
			setTitle(WINDOW_CAPTION + " - " + editState.editingFile.getName() + (editState.isDirty ? "*" : ""));
		} else {
			setTitle(WINDOW_CAPTION);
		}
	}

	private void setEditingTune(Tune t) {
		editState.tune = t;
		tuneView.setTune(t);
		controller.setTune(t);
		tuneView.updateMusic();
	}
	
	private class TuneEditingState {
		Tune tune;
		File editingFile;
		boolean isDirty;
	}
	
	private TuneEditController controller;
	private TuneView tuneView;
	private TuneEditingState editState;
}
