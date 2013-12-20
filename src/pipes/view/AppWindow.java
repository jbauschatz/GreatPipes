package pipes.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.print.PrinterException;
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
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import pipes.editing.TuneEditController;
import pipes.editing.TuneEditListener;
import pipes.editing.actions.EditAction;
import pipes.editing.io.TuneSerializer;
import pipes.model.EditTuneParameters;
import pipes.model.NewTuneParameters;
import pipes.model.TimeSignature;
import pipes.model.Tune;
import pipes.model.TuneType;
import pipes.view.tools.ToolMenu;
import pipes.view.tools.Toolbar;

public class AppWindow extends JFrame implements TuneEditListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_CAPTION = "Great Pipes";

	public static void main(String... arg) {
		new AppWindow();
	}
	
	public void tuneEdited(EditAction ation) {
		updateTitle();
	}
	
	public AppWindow() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		tunePanel = new TunePanel();
		JScrollPane tuneScroller = new JScrollPane(tunePanel);

		controller = new TuneEditController(tunePanel);
		controller.addEditListener(this);
		controller.newTune(NewTuneParameters.DEFAULT);

        recentFilesManager = new RecentFilesManager();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(tuneScroller, BorderLayout.CENTER);
		
		Toolbar toolbar = new Toolbar(tunePanel, controller);
		getContentPane().add(toolbar, BorderLayout.NORTH);

		buildMenu();

		updateTitle();
		setSize(1200, 900);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				tunePanel.updateMusic();
			}
		});
	}

	private void buildMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

        // FILE

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
                openDialog();
			}
		});

        final JMenu openRecentMenu = new JMenu("Open Recent");
        openRecentMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                openRecentMenu.removeAll();
                final File[] recentFiles = recentFilesManager.getRecentFiles();
                for (final File recentFile : recentFiles) {
                    JMenuItem item = new JMenuItem(recentFile.getAbsolutePath());
                    item.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            openRecent(recentFile);
                        }
                    });
                    openRecentMenu.add(item);
                }
                if (openRecentMenu.getItemCount() == 0) {
                    JMenuItem noRecentFilesItem = new JMenuItem("(no recent files)");
                    noRecentFilesItem.setEnabled(false);
                    openRecentMenu.add(noRecentFilesItem);
                }
            }
            @Override public void menuDeselected(MenuEvent e) { }
            @Override public void menuCanceled(MenuEvent e) { }
        });
        fileMenu.add(openRecentMenu);

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
		
		JMenuItem printItem = new JMenuItem("Print");
		fileMenu.add(printItem);
		printItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				print();
			}
		});

        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

        // EDIT

        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('e');
        menuBar.add(editMenu);

        JMenuItem editTunePropertiesItem = new JMenuItem("Tune Properties");
        editMenu.add(editTunePropertiesItem);
        editTunePropertiesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editTuneProperties();
            }
        });
        
        // TOOLS
        menuBar.add(new ToolMenu(controller, tunePanel));        
    }

    private void save() {
		if (controller.getIsDirty()) {
			if (controller.getEditingFile() == null) {
				saveAs();
			} else {
				try {
					controller.saveTune();
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
				controller.saveTune(chooser.getSelectedFile());
				updateTitle();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "An error occured while saving your tune.");
				e.printStackTrace();
			}
		}
	}

    /**
     * Brings up the Open File Dialog, but promts the user to save first if necessary.
     */
	private void openDialog() {
		// save changes
        if (checkSaveChanges()) return;

        // open
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("Great Pipes tune file", TuneSerializer.FILE_EXTENSION));
		chooser.setMultiSelectionEnabled(false);
		chooser.setAcceptAllFileFilterUsed(false);
		
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            openFile(chooser.getSelectedFile());
		}
	}

    /**
     * Opens the specified 'recent' file, but prompts the user to save first if necessary.
     * @param file File to open.
     */
    private void openRecent(File file) {
        // save changes
        if (checkSaveChanges()) return;

        // open
        openFile(file);
    }

    /**
     * Opens the specified File with no save check.
     * @param file File to open.
     */
    private void openFile(File file) {
        try {
            controller.loadTune(file);
            recentFilesManager.addRecentFile(file);
            updateTitle();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "An error occurred while loading the file.");
            e.printStackTrace();
        }
    }

    /**
     * Prompts the user to save changes to their tune, if changes have been made.
     * @return True if the user clicked "Cancel", false if user clicked "Yes" or "No"
     */
    private boolean checkSaveChanges() {
        if (controller.getIsDirty()) {
            int result = JOptionPane.showConfirmDialog(this, "Save changes to your tune?", "Save changes", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.CANCEL_OPTION)
                return true;
            if (result == JOptionPane.YES_OPTION)
                save();
        }
        return false;
    }
	
	private void newTune() {
		// save changes
        if (checkSaveChanges()) return;

        // New tune
		JTextField tuneName = new JTextField(NewTuneParameters.DEFAULT.getName(), 2);
		JTextField tuneAuthor = new JTextField(NewTuneParameters.DEFAULT.getAuthor(), 2);
		JComboBox<TuneType> tuneType = buildTuneTypeComboBox();
		JTextField numLines = new JTextField(String.valueOf(NewTuneParameters.DEFAULT.getLines()), 2);
		JTextField measuresPerLine = new JTextField(String.valueOf(NewTuneParameters.DEFAULT.getMeasuresPerLine()), 4);
		JComboBox<TimeSignature> timeSigs = new JComboBox<TimeSignature>(TimeSignature.STANDARD_TIMES);
		
		JComponent[] message = new JComponent[] {
				new JLabel("Name: "),
				tuneName,
				new JLabel("Author: "),
				tuneAuthor,
				new JLabel("Type: "),
				tuneType,
				new JLabel("Lines: "),
				numLines,
				new JLabel("Measures per Line: "),
				measuresPerLine,
				new JLabel("Time Signature: "),
				timeSigs};
		Object[] inputs = new Object[] {"OK", "Cancel"};
		
		boolean valid = false;
		while (!valid) {
			if (JOptionPane.showOptionDialog(this, message, "New tune", JOptionPane.PLAIN_MESSAGE, JOptionPane.CLOSED_OPTION, null, inputs, message[0])
					== JOptionPane.OK_OPTION) {
				try {
					String tuneNameChoice = tuneName.getText();
					String tuneAuthorChoice = tuneAuthor.getText();
					String tuneTypeChoice = tuneType.getSelectedItem().toString();
					int numLinesChoice = Integer.parseInt(numLines.getText());
					int measuresPerChoice = Integer.parseInt(measuresPerLine.getText());
					TimeSignature timeSigChoice = (TimeSignature)timeSigs.getSelectedItem();
					controller.newTune(new NewTuneParameters(tuneNameChoice, tuneAuthorChoice, tuneTypeChoice, timeSigChoice, numLinesChoice, measuresPerChoice));
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

	private void print() {
		try {
			PrintController.print(controller.getTune());
		} catch (PrinterException e) {
			JOptionPane.showMessageDialog(this, "Error encountered while printing:\n" + e.getMessage());
		}
	}

    private void exit() {
        if (checkSaveChanges()) return;
        System.exit(0);
    }

    private void editTuneProperties() {
        Tune currentTune = controller.getTune();

        JTextField tuneName = new JTextField(currentTune.getName(), 2);
        JTextField tuneAuthor = new JTextField(currentTune.getAuthor(), 2);
		JComboBox<TuneType> tuneType = buildTuneTypeComboBox();
		tuneType.setSelectedItem(currentTune.getType());

        JComponent[] message = new JComponent[]{
                new JLabel("Name: "),
                tuneName,
                new JLabel("Author: "),
                tuneAuthor,
                new JLabel("Type: "),
                tuneType};
        Object[] inputs = new Object[]{"OK", "Cancel"};

        boolean valid = false;
        while (!valid) {
            if (JOptionPane.showOptionDialog(this, message, "Edit Tune Properties", JOptionPane.PLAIN_MESSAGE, JOptionPane.CLOSED_OPTION, null, inputs, message[0])
                    == JOptionPane.OK_OPTION) {
                try {
                    String tuneNameChoice = tuneName.getText();
                    String tuneAuthorChoice = tuneAuthor.getText();
                    String tuneTypeChoice = tuneType.getSelectedItem().toString();
                    controller.editTune(new EditTuneParameters(tuneNameChoice, tuneAuthorChoice, tuneTypeChoice));
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
		if (controller.getEditingFile() != null) {
			setTitle(WINDOW_CAPTION + " - " + controller.getEditingFile().getName() + (controller.getIsDirty() ? "*" : ""));
		} else {
			setTitle(WINDOW_CAPTION);
		}
	}

	private JComboBox<TuneType> buildTuneTypeComboBox() {
		JComboBox<TuneType> tuneType = new JComboBox<>(TuneType.values());
		tuneType.setEditable(true);
		AutoCompleteDecorator.decorate(tuneType);
		return tuneType;
	}

	private TuneEditController controller;
	private TunePanel tunePanel;
    private RecentFilesManager recentFilesManager;
}
