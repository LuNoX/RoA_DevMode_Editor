package characters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import generals.AbsaGeneral;
import moves.AbsaCloudBurst;
import moves.CharacterSpecificMove;
import utility.CommandStorage;

public class Absa extends RoACharacter
{
    protected AbsaCloudBurst cloudBurst = new AbsaCloudBurst();
    protected AbsaGeneral absaGeneral = new AbsaGeneral();
    
    public Absa(File file)
    {
        super(file, CommandStorage.absaSpecificMoveNames);
        this.absaGeneral = new AbsaGeneral(this.generalCode);
        this.general = this.absaGeneral;
        this.initializeSpecificMoves();
    }
    
    public void initializeSpecificMoves()
    {
        List<CharacterSpecificMove> characterSpecificMoves = new ArrayList<CharacterSpecificMove>();
        for (CharacterSpecificMove move : this.characterSpecificMoves)
        {
            if(move.getName().equals("CLOUD_BURST"))
            {
                AbsaCloudBurst  cloudBurst = new AbsaCloudBurst(move.getCode());
                characterSpecificMoves.add(cloudBurst);
                this.cloudBurst = cloudBurst;
            }
        }
        this.characterSpecificMoves = characterSpecificMoves;
    }

    public AbsaCloudBurst getCloudBurst()
    {
        return cloudBurst;
    }

    public AbsaGeneral getAbsaGeneral()
    {
        return absaGeneral;
    }
}
