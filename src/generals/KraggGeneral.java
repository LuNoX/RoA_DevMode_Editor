package generals;

import java.util.List;

public class KraggGeneral extends CharacterGeneral
{

    public KraggGeneral(List<String> code)
    {
        this.code = code;
        this.other = code;
        this.initializeEverything();
    }

    public KraggGeneral()
    {
        super();
    }

}
