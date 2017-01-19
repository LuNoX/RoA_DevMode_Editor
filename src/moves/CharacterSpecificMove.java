package moves;

import java.util.List;

public class CharacterSpecificMove
{    
    protected String name = null;

    protected List<String> code = null;
    protected List<String> other = null;
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
