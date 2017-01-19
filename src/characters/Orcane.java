package characters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import moves.CharacterSpecificMove;
import moves.OrcaneBubbles;
import utility.CommandStorage;

public class Orcane extends RoACharacter
{
    protected OrcaneBubbles bubbles = new OrcaneBubbles();
    
    public Orcane(File file)
    {
        super(file, CommandStorage.orcaneSpecificMoveNames);
        this.initializeSpecificMoves();
    }
    
    public void initializeSpecificMoves()
    {
        List<CharacterSpecificMove> characterSpecificMoves = new ArrayList<CharacterSpecificMove>();
        for (CharacterSpecificMove move : this.characterSpecificMoves)
        {
            if(move.getName().equals("BUBBLES"))
            {
                OrcaneBubbles bubbles = new OrcaneBubbles(move.getCode());
                characterSpecificMoves.add(bubbles);
                this.bubbles = bubbles;
            }
        }
        this.characterSpecificMoves = characterSpecificMoves;
    }

    public OrcaneBubbles getBubbles()
    {
        return bubbles;
    }
}
