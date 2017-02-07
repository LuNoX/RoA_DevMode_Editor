package ui;

import javax.swing.JTree;
import javax.swing.tree.*;

import model.managers.ProjectManager;

public class ProjectTree extends JTree
{
    /**
     * 
     */
    private static final long serialVersionUID = -1864928814280147695L;

    public ProjectTree ()
    {
        super();
    }
    
    public ProjectTree(ProjectManager manager)
    {
        super();
        this.setRootVisible(false);
        DefaultTreeModel model = (DefaultTreeModel)this.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        DefaultMutableTreeNode project = new DefaultMutableTreeNode("project1");
        DefaultMutableTreeNode character  = new DefaultMutableTreeNode("character1");
        DefaultMutableTreeNode project2 = new DefaultMutableTreeNode("project2");
        DefaultMutableTreeNode character2  = new DefaultMutableTreeNode("character2");
        project.add(character);
        root.add(project);
        project2.add(character2);
        root.add(project2);
        model.reload(root);
    }
}
