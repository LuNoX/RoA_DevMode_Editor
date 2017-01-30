package characters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import moves.CharacterSpecificMove;
import moves.WrastorNspecial;
import utility.CommandStorage;

public class Wrastor extends RoACharacter
{    
    protected WrastorNspecial nspecial = new WrastorNspecial();
    
    public Wrastor(File file)
    {
        super(file, CommandStorage.wrastorSpecificMoveNames);
        this.initializeSpecificMoves();
    }
    
    public void initializeSpecificMoves()
    {
        List<CharacterSpecificMove> characterSpecificMoves = new ArrayList<CharacterSpecificMove>();
        for (CharacterSpecificMove move : this.characterSpecificMoves)
        {
            if(move.getName().equals("NSPECIAL"))
            {
                WrastorNspecial nspecial = new WrastorNspecial(move.getCode());
                characterSpecificMoves.add(nspecial);
                this.nspecial = nspecial;
            }
        }
        this.characterSpecificMoves = characterSpecificMoves;
    }

    public WrastorNspecial getNspecial()
    {
        return nspecial;
    }
}
