package model.characters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.moves.AbsaCloudBurst;
import model.moves.CharacterSpecificMove;
import model.moves.Move;
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
        for (int i = 0; i < this.allMoves.size(); i++)
        {
            Move move = this.allMoves.get(i);
            if(move.getName().equals("CLOUD_BURST"))
            {
                AbsaCloudBurst  cloudBurst = new AbsaCloudBurst(move.getCode());
                this.allMoves.set(i, cloudBurst);
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
