package ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;

import model.characters.RoACharacter;
import model.managers.HitboxManager;
import model.managers.WindowManager;
import model.moves.CharacterGeneral;
import model.moves.Move;
import model.settings.Gameplay;
import model.settings.GeneralSettings;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class CharacterTreeCellRenderer extends DefaultTreeCellRenderer
{
    private JLabel label = this;

    CharacterTreeCellRenderer()
    {        
        //this.setBackgroundSelectionColor(Color.WHITE);
        this.setOpaque(false);
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                    boolean expanded, boolean leaf, int row, boolean hasFocus)
    {
        this.selected = selected;
        this.hasFocus = hasFocus;           

        if (selected) {
            super.setBackground(getBackgroundSelectionColor());
            setForeground(getTextSelectionColor());
        } else {
            super.setBackground(getBackgroundNonSelectionColor());
            setForeground(getTextNonSelectionColor());
        }
        
        //TODO remove duplicate code
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
        else if (o instanceof HitboxManager)
        {
            label.setText("Hitboxes");
            label.setIcon(null);
            return label;
        }
        else if (o instanceof WindowManager)
        {
            label.setText("Windows");
            label.setIcon(null);
            return label;
        }
        else if (o instanceof GeneralSettings)
        {
            GeneralSettings generalSettings = (GeneralSettings) o;
            label.setText(generalSettings.getName());
            label.setIcon(Resources.settingsIcon);
            return label;
        }
        else if (o instanceof CharacterGeneral)
        {
            CharacterGeneral characterGeneral = (CharacterGeneral) o;
            label.setText(characterGeneral.getName()); //TODO This shouldnt have a name
            label.setIcon(Resources.settingsIcon);
            return label;
        }
        else if (o instanceof Gameplay)
        {
            label.setText("GAMEPLAY");
            label.setIcon(Resources.startButtonIcon);
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
}