package moves;

import java.util.ArrayList;
import java.util.List;

//TODO make this a child of Move
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

    public String getName()
    {
        return name;
    }

    public List<String> getCode()
    {
        return code;
    }

    public List<String> getOther()
    {
        return other;
    }
}
