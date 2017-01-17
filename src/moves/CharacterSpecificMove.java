package moves;

import java.util.List;

public class CharacterSpecificMove extends Move
{    
    /**
     * Placeholder constructor to avoid errors in all CharacterSpecificMove classes
     */
    public CharacterSpecificMove()
    {
        // TODO make this constructor do at least something
    }
    
    public CharacterSpecificMove(String name, List<String> code)
    {
        this.name = name;
        this.code = code;
    }
}
