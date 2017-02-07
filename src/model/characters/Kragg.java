package model.characters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.moves.CharacterSpecificMove;
import model.moves.KraggFspecial;
import model.moves.KraggNspecial;
import model.utility.CommandStorage;

public class Kragg extends RoACharacter
{
    protected KraggNspecial nspecial = new KraggNspecial();
    protected KraggFspecial fspecial = new KraggFspecial();
    
    public Kragg(File file)
    {
        super(file, CommandStorage.kraggSpecificMoveNames);
        this.initializeSpecificMoves();
    }
    
    public void initializeSpecificMoves()
    {
        List<CharacterSpecificMove> characterSpecificMoves = new ArrayList<CharacterSpecificMove>();
        for (CharacterSpecificMove move : this.characterSpecificMoves)
        {
            if(move.getName().equals("NSPECIAL"))
            {
                KraggNspecial nspecial = new KraggNspecial(move.getCode());
                characterSpecificMoves.add(nspecial);
                this.nspecial = nspecial;
            }
            else if(move.getName().equals("FSPECIAL"))
            {
                KraggFspecial fspecial = new KraggFspecial(move.getCode());
                characterSpecificMoves.add(fspecial);
                this.fspecial = fspecial;
            }
        }
        this.characterSpecificMoves = characterSpecificMoves;
    }

    public KraggNspecial getNspecial()
    {
        return nspecial;
    }

    public KraggFspecial getFspecial()
    {
        return fspecial;
    }
}
