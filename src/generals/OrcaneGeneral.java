package generals;

import java.util.List;

public class OrcaneGeneral extends CharacterGeneral
{
    public OrcaneGeneral(List<String> code)
    {
        this.code = code;
        this.other = code;
        this.initializeEverything();
    }

    public OrcaneGeneral()
    {
        super();
    }

}
