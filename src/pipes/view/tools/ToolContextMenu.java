package pipes.view.tools;

import pipes.editing.TuneEditController;
import pipes.editing.actions.DeleteNoteAction;
import pipes.editing.actions.SetEmbellishmentFamilyAction;
import pipes.model.MelodyElement;
import pipes.model.Note;
import pipes.model.embellishment.EmbellishmentFamily;
import pipes.view.LocationInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolContextMenu {
    public static boolean hasContextMenu(LocationInfo info) {
        if (info.centeredElement == null)
            return false;

        MelodyElement element = info.centeredElement.getElement();
        return element instanceof Note;
    }

    public static JPopupMenu getContextMenu(final LocationInfo info, final TuneEditController controller) {
        MelodyElement element = info.centeredElement.getElement();

        if (element instanceof Note) {
            final Note note = (Note)element;
            final JPopupMenu menu = new JPopupMenu();

            // Add an item for each Embellishment that can apply to the Note
            ButtonGroup group = new ButtonGroup();
            for (final EmbellishmentFamily emb : EmbellishmentFamily.EMBELLISHMENTS) {
                Note noteBefore = controller.getTune().getNoteBefore(note);
                if (emb.canEmbellish(noteBefore, note)) {
                    JRadioButton embRadio = new JRadioButton(emb.getName());
                    embRadio.setSelected(emb == note.getEmbellishmentFamily());
                    embRadio.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent actionEvent) {
                            controller.execute(new SetEmbellishmentFamilyAction(note, emb));
                            menu.setVisible(false);
                        }
                    });
                    group.add(embRadio);
                    menu.add(embRadio);
                }
            }

            // Add an item to delete the Note
            menu.add(new JSeparator());
            JMenuItem delete = new JMenuItem("Delete Note");
            delete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    controller.execute(new DeleteNoteAction(note, info.measureRenderer.getMeasure()));
                    menu.setVisible(false);
                }
            });
            menu.add(delete);

            return menu;
        }

        return null;
    }
}
