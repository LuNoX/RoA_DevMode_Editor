package characters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import generals.WrastorGeneral;
import moves.CharacterSpecificMove;
import moves.WrastorNspecial;
import utility.CommandStorage;

public class Wrastor extends RoACharacter
{    
    protected WrastorGeneral wrastorGeneral = new WrastorGeneral();
    protected WrastorNspecial nspecial = new WrastorNspecial();
    
    public Wrastor(File file)
    {
        super(file, CommandStorage.wrastorSpecificMoveNames);
        this.wrastorGeneral = new WrastorGeneral(this.generalCode);
        this.general = this.wrastorGeneral;
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
}
