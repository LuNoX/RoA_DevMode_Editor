package ui;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.Controller;
import model.managers.HitboxManager;
import model.moves.CharacterSpecificMove;
import model.moves.Move;

public class NodeSelectionListener implements TreeSelectionListener
{
    protected JTree tree = null;

    public NodeSelectionListener(JTree tree)
    {
        this.tree = tree;
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent)
    {
        // Returns the last path element of the selection.
        // This method is useful only when the selection model allows a single
        // selection.
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null)
            // Nothing is selected.
            return;
        
        //TODO make it so nodes have to be double clicked
        Object nodeInfo = node.getUserObject();
        if (node.isLeaf())
        {
            if (nodeInfo instanceof HitboxManager)
            {
                //System.out.println("true");
                Controller.setCodePanel((HitboxManager)nodeInfo);
            }
            else if (nodeInfo instanceof CharacterSpecificMove)
            {
                
            }
        }
    }

}
