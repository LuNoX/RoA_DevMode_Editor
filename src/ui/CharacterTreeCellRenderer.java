package ui;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;

import model.characters.RoACharacter;
import model.moves.Move;
import model.settings.GeneralSettings;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class CharacterTreeCellRenderer implements TreeCellRenderer
{
    private JLabel label;

    CharacterTreeCellRenderer()
    {
        label = new JLabel();
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                    boolean expanded, boolean leaf, int row, boolean hasFocus)
    {
        Object o = ((DefaultMutableTreeNode) value).getUserObject();
        if (o instanceof RoACharacter)
        {
            RoACharacter character = (RoACharacter) o;
            label.setText(character.getName());
            Icon icon = Resources.getCharacterIcon(character.getName());
            label.setIcon(Resources.getCharacterIcon(character.getName()));
            return label;
        }
        else if (o instanceof Move)
        {
            Move move = (Move) o;
            label.setText(move.getName());
            label.setIcon(Resources.getMoveIcon(move.getName()));
            return label;
        }
        else if (o instanceof GeneralSettings)
        {
            GeneralSettings generalSettings = (GeneralSettings) o;
            label.setText(generalSettings.getName());
            label.setIcon(Resources.settingsIcon);
            return label;
        }
        //TODO add icons for CSMs and Reset/Gameplay
        else
        {
            DefaultTreeCellRenderer dtcr = new DefaultTreeCellRenderer();
            return dtcr.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row,
                            hasFocus);
        }

    }

    public void setIcon(Icon icon)
    {
        if (icon == null)
        {

        }
    }
}