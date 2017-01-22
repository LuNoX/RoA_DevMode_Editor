package moves;

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
}
