package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JSplitPane;

import model.characters.RoACharacter;
import model.moves.Move;

public class RoACharacterView extends ClassView
{
    protected RoACharacter character = null;
    
    public RoACharacterView(RoACharacter character)
    {
        this.character = character;
        this.initializeEverything();
    }
    
    public void initializeChildClassView()
    {
        //this.childClassView = new MoveView(this.character.getAllMoves().get(0);
    }
    
    public JComponent generateChildComponent(JComponent component)
    {
        JSplitPane childComponent = new JSplitPane();
        List<String> names = new ArrayList<String>();
        for(Move move : this.character.getAllMoves())
        {
            names.add(move.getName());
        }
        //make List component out of names
        //childComponent.setLeftComponent(nameList);
        
        childComponent.setRightComponent(component);
        
        return childComponent;
    }
}
