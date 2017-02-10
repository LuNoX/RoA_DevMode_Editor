package model.characters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.moves.CharacterSpecificMove;
import model.moves.Move;
import model.moves.OrcaneBubbles;
import model.utility.CommandStorage;

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
        for (int i = 0; i < this.allMoves.size(); i++)
        {
            Move move = this.allMoves.get(i);
            if(move.getName().equals("BUBBLES"))
            {
                OrcaneBubbles bubbles = new OrcaneBubbles(move.getCode());
                this.allMoves.set(i, bubbles);
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
