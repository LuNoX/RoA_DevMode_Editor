package moves;

import java.util.ArrayList;
import java.util.List;

public class CharacterSpecificMove
{    
    protected String name = "";

    protected List<String> code = new ArrayList<String>();
    protected List<String> other = new ArrayList<String>();

    public CharacterSpecificMove()
    {
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
