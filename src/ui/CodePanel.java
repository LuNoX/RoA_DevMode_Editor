package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.lang.reflect.Field;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.managers.Hitbox;
import model.managers.HitboxManager;
import model.managers.Window;
import model.managers.WindowManager;
import model.moves.CustomCommand;
import model.settings.Gameplay;
import model.utility.Utilities;

public class CodePanel
{
    protected static Component horizontalStrut = Box.createHorizontalStrut(20);
    
    public static JTabbedPane getWindowPanel(WindowManager manager)
    {
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        for (Window window : manager.getWindows())
        {
            JScrollPane scrollPane = new JScrollPane();
            tabbedPane.addTab(window.getId(), null, scrollPane, null);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);

            int offset = 0;
            
            JPanel panel = new JPanel();
            scrollPane.setViewportView(panel);
            GridBagLayout gbl_panel = new GridBagLayout();
            gbl_panel.columnWidths = new int[]{1, 0, 0};
            gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
            panel.setLayout(gbl_panel);
           
            Component verticalGlue = Box.createVerticalGlue();
            GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
            gbc_verticalGlue.gridwidth = 2;
            gbc_verticalGlue.insets = new Insets(0, 0, 5, 5);
            gbc_verticalGlue.gridx = 0;
            gbc_verticalGlue.gridy = 0;
            panel.add(verticalGlue, gbc_verticalGlue);

            // TODO add ID textfield
            CustomCommand[] windowCommands = window.getWindowCommands();
            for (int i = 0; i < windowCommands.length; i++) // For every attribute
            {
                panel = addCommand(panel, windowCommands[i].getName(), windowCommands[i].getValue(), window, i+1);
            }
            
            //TODO add cancelable and cancel frame
            
            offset = windowCommands.length+1;
            
            Component verticalGlue2 = Box.createVerticalGlue();
            GridBagConstraints gbc_verticalGlue2 = new GridBagConstraints();
            gbc_verticalGlue2.gridwidth = 2;
            gbc_verticalGlue2.insets = new Insets(0, 0, 5, 5);
            gbc_verticalGlue2.gridx = offset;
            gbc_verticalGlue2.gridy = 0;
            panel.add(verticalGlue, gbc_verticalGlue);
           

            double[] weights = new double[offset+1];
            for (int i = 0; i < weights.length; i++)
            {
                weights[i] = 0;
            }
            weights[offset] = Double.MIN_VALUE;
            gbl_panel.rowWeights = weights;
        }
        
        return tabbedPane;
    }

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
           
            Component verticalGlue = Box.createVerticalGlue();
            GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
            gbc_verticalGlue.gridwidth = 2;
            gbc_verticalGlue.insets = new Insets(0, 0, 5, 5);
            gbc_verticalGlue.gridx = 0;
            gbc_verticalGlue.gridy = 0;
            panel.add(verticalGlue, gbc_verticalGlue);

            // TODO add ID textfield
            CustomCommand[] hitboxCommands = hitbox.getHitboxCommands();
            for (int i = 0; i < hitboxCommands.length; i++) // For every attribute
            {
                panel = addCommand(panel, hitboxCommands[i].getName(), hitboxCommands[i].getValue(), hitbox, i+1);
            }
            
            offset = hitboxCommands.length+1;
            
            // TODO grey out if Projectile is false
            CustomCommand[] projectileCommands = hitbox.getProjectileCommands();
            for (int i = 0; i < projectileCommands.length; i++)
            {
                panel = addCommand(panel, projectileCommands[i].getName(), projectileCommands[i].getValue(), hitbox, i+offset);
            }
            offset = offset + projectileCommands.length;
            
            Component verticalGlue2 = Box.createVerticalGlue();
            GridBagConstraints gbc_verticalGlue2 = new GridBagConstraints();
            gbc_verticalGlue2.gridwidth = 2;
            gbc_verticalGlue2.insets = new Insets(0, 0, 5, 5);
            gbc_verticalGlue2.gridx = offset;
            gbc_verticalGlue2.gridy = 0;
            panel.add(verticalGlue, gbc_verticalGlue);
           

            double[] weights = new double[offset+1];
            for (int i = 0; i < weights.length; i++)
            {
                weights[i] = 0;
            }
            weights[offset] = Double.MIN_VALUE;
            gbl_panel.rowWeights = weights;
        }

        return tabbedPane;
    }

    public static JPanel addCommand(JPanel panel, String commandName, double commandValue, Object spinnerObject, int row)
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
        
        FieldSpinner spinner = new FieldSpinner(model, spinnerObject, commandName);
        JComponent field = ((JSpinner.DefaultEditor) spinner.getEditor());
        Dimension prefSize = field.getPreferredSize();
        prefSize = new Dimension(28, prefSize.height);
        field.setPreferredSize(prefSize);
        
        spinner.addChangeListener(new ChangeListener()
        {       
            @Override
            public void stateChanged(ChangeEvent arg0)
            {
                double newValue = (Double) spinner.getValue();
                System.out.println("Value changed to: " + newValue);
                Field declaredField = null;
                try
                {
                    String fieldName = commandName;
                    declaredField = spinnerObject.getClass().getDeclaredField(fieldName);
                    boolean accessible = declaredField.isAccessible();

                    declaredField.setAccessible(true);
                    declaredField.set(spinnerObject, newValue);
                    declaredField.setAccessible(accessible);
                }
                catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                                | IllegalAccessException e)
                {
                    System.out.println(e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        });
        
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.anchor = GridBagConstraints.EAST;
        gbc_spinner.insets = new Insets(0, 0, 0, 15);
        gbc_spinner.gridx = 1;
        gbc_spinner.gridy = row;
        panel.add(spinner, gbc_spinner);

        return panel;
    }
}
