package model.moves;

import java.util.ArrayList;
import java.util.List;

public class CharacterSpecificMove extends Move
{    
    public CharacterSpecificMove()
    {
        super();
    }
    
    public CharacterSpecificMove(String name, List<String> code)
    {
        this.name = name;
        this.code = code;
        this.other = code;
    }
    
    //TODO implement this method for the subclasses
    public List<String> exportCode()
    {
        List<String> result = new ArrayList<>();
        return result;
    }
}
