package model.characters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.moves.CharacterSpecificMove;
import model.moves.Move;
import model.moves.WrastorNspecial;
import model.utility.CommandStorage;

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
        for (int i = 0; i < this.allMoves.size(); i++)
        {
            Move move = this.allMoves.get(i);
            if(move.getName().equals("NSPECIAL"))
            {
                WrastorNspecial nspecial = new WrastorNspecial(move.getCode());
                characterSpecificMoves.add(nspecial);
                this.allMoves.set(i, nspecial);
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
