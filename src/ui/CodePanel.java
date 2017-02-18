package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import model.managers.Hitbox;
import model.managers.HitboxManager;
import model.moves.CustomCommand;
import model.utility.Utilities;

public class CodePanel
{
    protected static Component horizontalStrut = Box.createHorizontalStrut(20);

    public static JTabbedPane getHitboxPanel(HitboxManager manager)
    {
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        if (manager.getNumberOfHitboxes() != manager.getHitboxes().size())
        {
            System.out.println("Hitbox number discrepancy. "
                            + "Presumed number of Hitboxes does not equal actual number of Hitboxes.");
        }
        
        for (Hitbox hitbox : manager.getHitboxes())
        {
            JScrollPane scrollPane = new JScrollPane();
            tabbedPane.addTab(hitbox.getId(), null, scrollPane, null);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);

            int offset = 0;
            
            JPanel panel = new JPanel();
            scrollPane.setViewportView(panel);
            GridBagLayout gbl_panel = new GridBagLayout();
            gbl_panel.columnWidths = new int[]{1, 0, 0};
            gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
            panel.setLayout(gbl_panel);

            // TODO add ID textfield
            CustomCommand[] hitboxCommands = hitbox.getHitboxCommands();
            for (int i = 0; i < hitboxCommands.length; i++) // For every attribute
            {
                panel = addCommand(panel, hitboxCommands[i].getName(), hitboxCommands[i].getValue(), i);
            }
            
            offset = hitboxCommands.length;
            
            // TODO grey out if Projectile is false
            CustomCommand[] projectileCommands = hitbox.getProjectileCommands();
            for (int i = 0; i < projectileCommands.length; i++)
            {
                panel = addCommand(panel, projectileCommands[i].getName(), projectileCommands[i].getValue(), i+offset);
            }
           
            offset = offset + projectileCommands.length +1;
            double[] weights = new double[offset];
            weights[offset-1] = 1.0;
            gbl_panel.rowWeights = weights;
        }

        return tabbedPane;
    }

    public static JPanel addCommand(JPanel panel, String commandName, double commandValue, int row)
    {

        JLabel lblName = new JLabel(Utilities.parseCommandName(commandName));
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        
        gbc_lblName.anchor = GridBagConstraints.WEST;
        gbc_lblName.insets = new Insets(0, 25, 5, 5);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = row;
        panel.add(lblName, gbc_lblName);
        
        double value = commandValue;
        double minimum = -1024.0;
        double maximum = 1024.0;
        double stepSize = 1.0;
        SpinnerModel model = new SpinnerNumberModel(value, minimum, maximum, stepSize);
        
        JSpinner spinner = new JSpinner(model);
        JComponent field = ((JSpinner.DefaultEditor) spinner.getEditor());
        Dimension prefSize = field.getPreferredSize();
        prefSize = new Dimension(28, prefSize.height);
        field.setPreferredSize(prefSize);
        
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.anchor = GridBagConstraints.EAST;
        gbc_spinner.insets = new Insets(0, 0, 0, 15);
        gbc_spinner.gridx = 1;
        gbc_spinner.gridy = row;
        panel.add(spinner, gbc_spinner);

        return panel;
    }
}
