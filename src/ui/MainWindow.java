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
        
        JToolBar toolBar = new JToolBar();
        frame.getContentPane().add(toolBar, BorderLayout.NORTH);
        
        JButton btnNewFile = new JButton("New File");
        toolBar.add(btnNewFile);
        
        JButton btnSaveFiles = new JButton("Save Files");
        toolBar.add(btnSaveFiles);
        
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
