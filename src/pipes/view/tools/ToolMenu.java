package pipes.view.tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

import pipes.editing.ToolSelectionListener;
import pipes.editing.TuneEditController;
import pipes.model.embellishment.EmbellishmentFamily;
import pipes.view.TunePanel;

public class ToolMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	public ToolMenu(TuneEditController controller, TunePanel tunePanel) {
		super("Tools");
        setMnemonic('t');
        this.controller = controller;
        this.tunePanel = tunePanel;
        
        final LinkedList<EmbellishmentMenuItem> menuItems = new LinkedList<>();
        
        for (EmbellishmentCategory cat : EmbellishmentCategory.CATEGORIES) {
        	JMenu catMenu = new JMenu(cat.toString());
        	add(catMenu);
        	for (final EmbellishmentFamily emb : cat.getEmbellishments()) {
        		EmbellishmentMenuItem embItem = new EmbellishmentMenuItem(emb);
        		catMenu.add(embItem);
        		menuItems.add(embItem);
        	}
        }
        
        for (EmbellishmentFamily emb : EmbellishmentCategory.MISCELLANEOUS.getEmbellishments()) {
        	EmbellishmentMenuItem embItem = new EmbellishmentMenuItem(emb);
    		add(embItem);
    		menuItems.add(embItem);
        }
        
        this.controller.addToolListener(new ToolSelectionListener() {
			public void ToolSelected(EditTool tool) {
				for (EmbellishmentMenuItem item : menuItems) {
					if (tool instanceof SetEmbellishmentFamilyTool) {
						SetEmbellishmentFamilyTool familyTool = (SetEmbellishmentFamilyTool)tool;
						item.setSelected(item.family == familyTool.getEmbellishment());
					} else {
						item.setSelected(false);
					}					
				}
			}
		});
	}
	
	private class EmbellishmentMenuItem extends JRadioButtonMenuItem {
		private static final long serialVersionUID = 1L;

		public EmbellishmentMenuItem(EmbellishmentFamily family) {
			super(family.getName());

			this.family = family;
			tool = new SetEmbellishmentFamilyTool(tunePanel, controller, family);

			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	        		controller.setCurrentTool(tool);
				}
			});
		}
		
		SetEmbellishmentFamilyTool tool;
		EmbellishmentFamily family;
	}
	
	private TuneEditController controller;
	private TunePanel tunePanel;
}
