package ui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTree;

import model.managers.Hitbox;
import model.managers.HitboxManager;
import model.utility.Utilities;

public class CodePanel
{
    public static JTabbedPane getHitboxPane(HitboxManager manager)
    {
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        JScrollPane scrollPane = new JScrollPane();

        if (manager.getNumberOfHitboxes() != manager.getHitboxes().size())
        {
            System.out.println("Hitbox number discrepancy. "
                            + "Presumed number of Hitboxes does not equal actual number of Hitboxes.");
        }

        Component horizontalStrut = Box.createHorizontalStrut(20);

        for (Hitbox hitbox : manager.getHitboxes())
        {
            tabbedPane.addTab(hitbox.getId(), null, scrollPane, null);

            JPanel panel = new JPanel();
            scrollPane.setViewportView(panel);
            GridBagLayout gbl_panel = new GridBagLayout();
            gbl_panel.columnWidths = new int[]
            { 0, 1, 1, 15, 1, 0 };
            gbl_panel.rowHeights = new int[]
            { 0, 0, 0, 0, 0, 0 };
            gbl_panel.columnWeights = new double[]
            { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
            gbl_panel.rowWeights = new double[]
            { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
            panel.setLayout(gbl_panel);

            for (int i = 0; i < 1; i++) // For every attribute
            {
                GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
                gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
                gbc_horizontalStrut.gridx = 0;
                gbc_horizontalStrut.gridy = i;
                panel.add(horizontalStrut, gbc_horizontalStrut);

                JLabel lblTesty = new JLabel(Utilities.parseCommandName("Attribute name"));
                GridBagConstraints gbc_lblTesty = new GridBagConstraints();
                gbc_lblTesty.anchor = GridBagConstraints.WEST;
                gbc_lblTesty.insets = new Insets(0, 0, 5, 5);
                gbc_lblTesty.gridx = 1;
                gbc_lblTesty.gridy = i;
                panel.add(lblTesty, gbc_lblTesty);

                GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
                gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
                gbc_horizontalStrut_2.gridx = 2;
                gbc_horizontalStrut_2.gridy = i;
                panel.add(horizontalStrut, gbc_horizontalStrut_2);

                JSpinner spinner = new JSpinner();
                GridBagConstraints gbc_spinner = new GridBagConstraints();
                gbc_spinner.anchor = GridBagConstraints.EAST;
                gbc_spinner.insets = new Insets(0, 0, 5, 5);
                gbc_spinner.gridx = 3;
                gbc_spinner.gridy = i;
                panel.add(spinner, gbc_spinner);

                GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
                gbc_horizontalStrut_3.anchor = GridBagConstraints.EAST;
                gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 0);
                gbc_horizontalStrut_3.gridx = 4;
                gbc_horizontalStrut_3.gridy = i;
                panel.add(horizontalStrut, gbc_horizontalStrut_3);
            }
        }

        return tabbedPane;
    }
}
