package model.characters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.moves.AbsaCloudBurst;
import model.moves.CharacterSpecificMove;
import model.utility.CommandStorage;

public class Absa extends RoACharacter
{
    protected AbsaCloudBurst cloudBurst = new AbsaCloudBurst();
    
    public Absa(File file)
    {
        super(file, CommandStorage.absaSpecificMoveNames);
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
}
