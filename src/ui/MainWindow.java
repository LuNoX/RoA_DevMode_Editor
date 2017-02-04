package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JSplitPane;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;

public class MainWindow
{

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    MainWindow window = new MainWindow();
                    window.frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainWindow()
    {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{-7, 159, 0};
        gridBagLayout.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        frame.getContentPane().setLayout(gridBagLayout);
        
        JToolBar toolBar = new JToolBar();
        GridBagConstraints gbc_toolBar = new GridBagConstraints();
        gbc_toolBar.gridwidth = 2;
        gbc_toolBar.insets = new Insets(0, 0, 5, 0);
        gbc_toolBar.anchor = GridBagConstraints.WEST;
        gbc_toolBar.gridx = 0;
        gbc_toolBar.gridy = 0;
        frame.getContentPane().add(toolBar, gbc_toolBar);
        
        JButton btnSave = new JButton("Save");
        toolBar.add(btnSave);
        
        JButton btnNew = new JButton("New");
        toolBar.add(btnNew);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridheight = 7;
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 1;
        frame.getContentPane().add(panel, gbc_panel);
        
        JSplitPane splitPane = new JSplitPane();
        GridBagConstraints gbc_splitPane = new GridBagConstraints();
        gbc_splitPane.gridheight = 7;
        gbc_splitPane.fill = GridBagConstraints.BOTH;
        gbc_splitPane.gridx = 1;
        gbc_splitPane.gridy = 1;
        frame.getContentPane().add(splitPane, gbc_splitPane);
        
        JSplitPane splitPane_1 = new JSplitPane();
        splitPane.setRightComponent(splitPane_1);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        
        JMenu mnNew = new JMenu("New");
        mnFile.add(mnNew);
        
        JMenuItem mntmProject = new JMenuItem("Project");
        mnNew.add(mntmProject);
        
        JMenuItem mntmProject_1 = new JMenuItem("Project...");
        mnNew.add(mntmProject_1);
        
        JMenuItem mntmEmptyProject = new JMenuItem("Empty Project");
        mnNew.add(mntmEmptyProject);
        
        JSeparator separator = new JSeparator();
        mnNew.add(separator);
        
        JMenuItem mntmCharacterFrom = new JMenuItem("Character From...");
        mnNew.add(mntmCharacterFrom);
        
        JMenuItem mntmAbsa = new JMenuItem("Absa");
        mnNew.add(mntmAbsa);
        
        JMenuItem mntmForsburn = new JMenuItem("Forsburn");
        mnNew.add(mntmForsburn);
        
        JMenuItem mntmKragg = new JMenuItem("Kragg");
        mnNew.add(mntmKragg);
        
        JMenuItem mntmMaypul = new JMenuItem("Maypul");
        mnNew.add(mntmMaypul);
        
        JMenuItem mntmOrcane = new JMenuItem("Orcane");
        mnNew.add(mntmOrcane);
        
        JMenuItem mntmWrastor = new JMenuItem("Wrastor");
        mnNew.add(mntmWrastor);
        
        JMenuItem mntmZetterburn = new JMenuItem("Zetterburn");
        mnNew.add(mntmZetterburn);
        
        JSeparator separator_1 = new JSeparator();
        mnFile.add(separator_1);
        
        JMenuItem mntmClose = new JMenuItem("Close");
        mnFile.add(mntmClose);
        
        JMenuItem mntmCloseAll = new JMenuItem("Close All");
        mnFile.add(mntmCloseAll);
        
        JSeparator separator_2 = new JSeparator();
        mnFile.add(separator_2);
        
        JMenuItem mntmSave = new JMenuItem("Save");
        mnFile.add(mntmSave);
        
        JMenuItem mntmSaveAs = new JMenuItem("Save As...");
        mnFile.add(mntmSaveAs);
        
        JMenuItem mntmSaveAll = new JMenuItem("Save All");
        mnFile.add(mntmSaveAll);
        
        JSeparator separator_3 = new JSeparator();
        mnFile.add(separator_3);
        
        JMenuItem mntmImport = new JMenuItem("Import...");
        mnFile.add(mntmImport);
        
        JMenuItem mntmExport = new JMenuItem("Export...");
        mnFile.add(mntmExport);
        
        JMenu mnEdit = new JMenu("Edit");
        menuBar.add(mnEdit);
        
        JMenuItem mntmUndo = new JMenuItem("Undo");
        mnEdit.add(mntmUndo);
        
        JMenuItem mntmRedo = new JMenuItem("Redo");
        mnEdit.add(mntmRedo);
        
        JSeparator separator_4 = new JSeparator();
        mnEdit.add(separator_4);
        
        JMenuItem mntmCut = new JMenuItem("Cut");
        mnEdit.add(mntmCut);
        
        JMenuItem mntmCopy = new JMenuItem("Copy");
        mnEdit.add(mntmCopy);
        
        JMenuItem mntmPaste = new JMenuItem("Paste");
        mnEdit.add(mntmPaste);
        
        JSeparator separator_5 = new JSeparator();
        mnEdit.add(separator_5);
        
        JMenuItem mntmDelete = new JMenuItem("Delete");
        mnEdit.add(mntmDelete);
        
        JMenuItem mntmSelectAll = new JMenuItem("Select All");
        mnEdit.add(mntmSelectAll);
        
        JMenu mnSettings = new JMenu("Settings");
        menuBar.add(mnSettings);
        
        JMenuItem mntmColorScheme = new JMenuItem("Color Scheme");
        mnSettings.add(mntmColorScheme);
        
        JMenuItem mntmKeybindings = new JMenuItem("Keybindings");
        mnSettings.add(mntmKeybindings);
        
        JMenuItem mntmToolbar = new JMenuItem("Toolbar");
        mnSettings.add(mntmToolbar);
        
        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);
        
        JMenuItem mntmWelcome = new JMenuItem("Welcome");
        mnHelp.add(mntmWelcome);
        
        JSeparator separator_7 = new JSeparator();
        mnHelp.add(separator_7);
        
        JMenuItem mntmCheckForUpdates = new JMenuItem("Check for Updates");
        mnHelp.add(mntmCheckForUpdates);
        
        JMenuItem mntmInstallationDetails = new JMenuItem("Installation Details");
        mnHelp.add(mntmInstallationDetails);
        
        JSeparator separator_6 = new JSeparator();
        mnHelp.add(separator_6);
        
        JMenuItem mntmAbout = new JMenuItem("About");
        mnHelp.add(mntmAbout);
    }

}
