package characters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import generals.KraggGeneral;
import moves.CharacterSpecificMove;
import moves.KraggFspecial;
import moves.KraggNspecial;
import utility.CommandStorage;

public class Kragg extends RoACharacter
{
    protected KraggGeneral kraggGeneral = new KraggGeneral();
    protected KraggNspecial nspecial = new KraggNspecial();
    protected KraggFspecial fspecial = new KraggFspecial();
    
    public Kragg(File file)
    {
        super(file, CommandStorage.kraggSpecificMoveNames);
        this.kraggGeneral = new KraggGeneral(this.generalCode);
        this.general = this.kraggGeneral;
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
            if(move.getName().equals("FSPECIAL"))
            {
                KraggFspecial fspecial = new KraggFspecial(move.getCode());
                characterSpecificMoves.add(fspecial);
                this.fspecial = fspecial;
            }
        }
        this.characterSpecificMoves = characterSpecificMoves;
    }

    public KraggGeneral getKraggGeneral()
    {
        return kraggGeneral;
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
