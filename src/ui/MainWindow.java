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
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import controller.Controller;
import model.characters.RoACharacter;
import model.managers.Project;
import model.managers.ProjectManager;
import model.moves.AbsaCloudBurst;
import model.moves.CharacterSpecificMove;
import model.moves.Move;
import model.moves.OrcaneBubbles;
import model.settings.GeneralSettings;

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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.Box;

public class MainWindow
{   
    protected JTree projectTree = null;
    protected JSplitPane splitPane = null;

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
        gridBagLayout.columnWidths = new int[]
        {175, 0};
        gridBagLayout.rowHeights = new int[]
        {23, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]
        {1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]
        {0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        frame.getContentPane().setLayout(gridBagLayout);

        JToolBar toolBar = new JToolBar();
        GridBagConstraints gbc_toolBar = new GridBagConstraints();
        gbc_toolBar.insets = new Insets(0, 0, 5, 0);
        gbc_toolBar.anchor = GridBagConstraints.WEST;
        gbc_toolBar.gridx = 0;
        gbc_toolBar.gridy = 0;
        frame.getContentPane().add(toolBar, gbc_toolBar);

        JButton btnSave = new JButton("Save");
        toolBar.add(btnSave);

        JButton btnNew = new JButton("New");
        toolBar.add(btnNew);
        
        JSplitPane splitPane = new JSplitPane();
        this.splitPane = splitPane;
        splitPane.setResizeWeight(0.25);; //TODO make this pretty (bad on minimizing window)
        GridBagConstraints gbc_splitPane = new GridBagConstraints();
        gbc_splitPane.gridheight = 7;
        gbc_splitPane.insets = new Insets(0, 0, 5, 0);
        gbc_splitPane.fill = GridBagConstraints.BOTH;
        gbc_splitPane.gridx = 0;
        gbc_splitPane.gridy = 1;
        frame.getContentPane().add(splitPane, gbc_splitPane);
                
                JScrollPane scrollPane = new JScrollPane();
                splitPane.setLeftComponent(scrollPane);
                        
                                JTree tree = new JTree();
                                scrollPane.setViewportView(tree);
                                this.projectTree = tree;
                                
                                JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
                                splitPane.setRightComponent(tabbedPane);
                                
                                JScrollPane scrollPane_2 = new JScrollPane();
                                tabbedPane.addTab("New tab", null, scrollPane_2, null);
                                
                                JPanel panel = new JPanel();
                                scrollPane_2.setViewportView(panel);
                                GridBagLayout gbl_panel = new GridBagLayout();
                                gbl_panel.columnWidths = new int[]{0, 1, 1, 15, 1, 0};
                                gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
                                gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
                                gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
                                panel.setLayout(gbl_panel);
                                
                                Component horizontalStrut_3 = Box.createHorizontalStrut(20);
                                GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
                                gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
                                gbc_horizontalStrut_3.gridx = 0;
                                gbc_horizontalStrut_3.gridy = 0;
                                panel.add(horizontalStrut_3, gbc_horizontalStrut_3);
                                
                                JLabel lblTesty = new JLabel("testy");
                                GridBagConstraints gbc_lblTesty = new GridBagConstraints();
                                gbc_lblTesty.anchor = GridBagConstraints.WEST;
                                gbc_lblTesty.insets = new Insets(0, 0, 5, 5);
                                gbc_lblTesty.gridx = 1;
                                gbc_lblTesty.gridy = 0;
                                panel.add(lblTesty, gbc_lblTesty);
                                
                                Component horizontalStrut = Box.createHorizontalStrut(20);
                                GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
                                gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
                                gbc_horizontalStrut.gridx = 2;
                                gbc_horizontalStrut.gridy = 0;
                                panel.add(horizontalStrut, gbc_horizontalStrut);
                                
                                JSpinner spinner = new JSpinner();
                                GridBagConstraints gbc_spinner = new GridBagConstraints();
                                gbc_spinner.anchor = GridBagConstraints.EAST;
                                gbc_spinner.insets = new Insets(0, 0, 5, 5);
                                gbc_spinner.gridx = 3;
                                gbc_spinner.gridy = 0;
                                panel.add(spinner, gbc_spinner);
                                
                                Component horizontalStrut_6 = Box.createHorizontalStrut(20);
                                GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
                                gbc_horizontalStrut_6.anchor = GridBagConstraints.EAST;
                                gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 0);
                                gbc_horizontalStrut_6.gridx = 4;
                                gbc_horizontalStrut_6.gridy = 0;
                                panel.add(horizontalStrut_6, gbc_horizontalStrut_6);
                                
                                Component horizontalStrut_4 = Box.createHorizontalStrut(20);
                                GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
                                gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
                                gbc_horizontalStrut_4.gridx = 0;
                                gbc_horizontalStrut_4.gridy = 1;
                                panel.add(horizontalStrut_4, gbc_horizontalStrut_4);
                                
                                JLabel lblTesty_1 = new JLabel("testy2");
                                GridBagConstraints gbc_lblTesty_1 = new GridBagConstraints();
                                gbc_lblTesty_1.anchor = GridBagConstraints.WEST;
                                gbc_lblTesty_1.insets = new Insets(0, 0, 5, 5);
                                gbc_lblTesty_1.gridx = 1;
                                gbc_lblTesty_1.gridy = 1;
                                panel.add(lblTesty_1, gbc_lblTesty_1);
                                
                                Component horizontalStrut_1 = Box.createHorizontalStrut(20);
                                GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
                                gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
                                gbc_horizontalStrut_1.gridx = 2;
                                gbc_horizontalStrut_1.gridy = 1;
                                panel.add(horizontalStrut_1, gbc_horizontalStrut_1);
                                
                                JSpinner spinner_1 = new JSpinner();
                                GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
                                gbc_spinner_1.anchor = GridBagConstraints.EAST;
                                gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
                                gbc_spinner_1.gridx = 3;
                                gbc_spinner_1.gridy = 1;
                                panel.add(spinner_1, gbc_spinner_1);
                                
                                Component horizontalStrut_7 = Box.createHorizontalStrut(20);
                                GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
                                gbc_horizontalStrut_7.anchor = GridBagConstraints.EAST;
                                gbc_horizontalStrut_7.insets = new Insets(0, 0, 5, 0);
                                gbc_horizontalStrut_7.gridx = 4;
                                gbc_horizontalStrut_7.gridy = 1;
                                panel.add(horizontalStrut_7, gbc_horizontalStrut_7);
                                
                                Component horizontalStrut_5 = Box.createHorizontalStrut(20);
                                GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
                                gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
                                gbc_horizontalStrut_5.gridx = 0;
                                gbc_horizontalStrut_5.gridy = 2;
                                panel.add(horizontalStrut_5, gbc_horizontalStrut_5);
                                
                                JLabel lblTesty_2 = new JLabel("testy3");
                                GridBagConstraints gbc_lblTesty_2 = new GridBagConstraints();
                                gbc_lblTesty_2.anchor = GridBagConstraints.WEST;
                                gbc_lblTesty_2.insets = new Insets(0, 0, 5, 5);
                                gbc_lblTesty_2.gridx = 1;
                                gbc_lblTesty_2.gridy = 2;
                                panel.add(lblTesty_2, gbc_lblTesty_2);
                                
                                Component horizontalStrut_2 = Box.createHorizontalStrut(20);
                                GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
                                gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
                                gbc_horizontalStrut_2.gridx = 2;
                                gbc_horizontalStrut_2.gridy = 2;
                                panel.add(horizontalStrut_2, gbc_horizontalStrut_2);
                                
                                JSpinner spinner_2 = new JSpinner();
                                GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
                                gbc_spinner_2.anchor = GridBagConstraints.EAST;
                                gbc_spinner_2.insets = new Insets(0, 0, 5, 5);
                                gbc_spinner_2.gridx = 3;
                                gbc_spinner_2.gridy = 2;
                                panel.add(spinner_2, gbc_spinner_2);
                                
                                Component horizontalStrut_8 = Box.createHorizontalStrut(20);
                                GridBagConstraints gbc_horizontalStrut_8 = new GridBagConstraints();
                                gbc_horizontalStrut_8.anchor = GridBagConstraints.EAST;
                                gbc_horizontalStrut_8.insets = new Insets(0, 0, 5, 0);
                                gbc_horizontalStrut_8.gridx = 4;
                                gbc_horizontalStrut_8.gridy = 2;
                                panel.add(horizontalStrut_8, gbc_horizontalStrut_8);
                                
                                JLabel lblNewLabel = new JLabel("New label");
                                GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
                                gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
                                gbc_lblNewLabel.gridx = 1;
                                gbc_lblNewLabel.gridy = 3;
                                panel.add(lblNewLabel, gbc_lblNewLabel);

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
    
    public void initalizeTree(ProjectManager projectManager)
    {
        this.projectTree.setRootVisible(false);
        DefaultTreeModel model = (DefaultTreeModel)this.projectTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        this.projectTree.setCellRenderer(new CharacterTreeCellRenderer());
        this.projectTree.addTreeSelectionListener(new NodeSelectionListener(this.projectTree));
        for (Project prj : projectManager.getProjects())
        {
            DefaultMutableTreeNode project = new DefaultMutableTreeNode(prj.getName());
            for(RoACharacter chr : prj.getCharacters())
            {
                DefaultMutableTreeNode character = new DefaultMutableTreeNode(chr);
                for(Move mov : chr.getAllMoves())
                {
                    DefaultMutableTreeNode move = new DefaultMutableTreeNode(mov);
                    //TODO open settings when selecting node instead of saving as subnode
                    if (!(mov instanceof CharacterSpecificMove))
                    {
                        DefaultMutableTreeNode windows = new DefaultMutableTreeNode(mov.getWindowManager());
                        DefaultMutableTreeNode hitboxes = new DefaultMutableTreeNode(mov.getHitboxManager());
                        move.add(windows);
                        move.add(hitboxes);
                    }
                    character.add(move);
                }
                DefaultMutableTreeNode general = new DefaultMutableTreeNode(chr.getGeneral());
                character.add(general);
                
                project.add(character);
            }
            for (GeneralSettings stn : prj.getGenerals())
            {
                DefaultMutableTreeNode settings = new DefaultMutableTreeNode(stn);
                DefaultMutableTreeNode gameplay = new DefaultMutableTreeNode(stn.getGameplay());
                DefaultMutableTreeNode reset = new DefaultMutableTreeNode(stn.getReset());
                settings.add(gameplay);
                settings.add(reset);
                
                project.add(settings);
            }
            root.add(project);
        }
        model.reload(root);
    }
    
    public void setCodePanel (JComponent component)
    {
        //TODO test this with the controller
        this.splitPane.setRightComponent(component);
    }

    public JTree getProjectTree()
    {
        return projectTree;
    }

    public JFrame getFrame()
    {
        return frame;
    }
}
