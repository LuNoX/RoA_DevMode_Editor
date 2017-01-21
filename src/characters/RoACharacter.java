package characters;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

import generals.CharacterGeneral;
import moves.*;
import utility.*;

public class RoACharacter
{
    protected File characterFile = null;
    protected List<String> content = new ArrayList<String>();

    protected CharacterGeneral general = new CharacterGeneral();
    protected List<String> generalCode = new ArrayList<String>();
    protected List<Move> allMoves = new ArrayList<Move>();
    
    protected List<CharacterSpecificMove> characterSpecificMoves
                    = new ArrayList<CharacterSpecificMove>();
    protected String[] characterSpecificMoveNames = new String[0];


    // TODO make this abstract
    public RoACharacter(File character)
    {
        this.characterFile = character;
        this.initializeEveryting();
    }

    public RoACharacter(File character, String[] characterSpecificMoveNames)
    {
        this.characterSpecificMoveNames = characterSpecificMoveNames;
        this.characterFile = character;
        this.initializeEveryting();
    }


    public RoACharacter()
    {
    }

    public void initializeEveryting()
    {
        this.initializeContent();
        this.initializeAllMovesAndGeneral();
    }

    public void initializeContent()
    {
        RoAFileReader ifr = new RoAFileReader(this.characterFile);
        ifr.nextLine();

        // save the file as an ArrayList of Strings
        while (ifr.getActiveLine() != null)
        {
            if (!ifr.getActiveLine().equals(""))
            {
                this.content.add(ifr.getActiveLine());
                ifr.nextLine();
            }
        }
        ifr.close();
    }

    public void initializeAllMovesAndGeneral()
    {
        String line = null;
        int startIndex = this.content.size() + 1;

        for (int i = this.content.size() - 1; i >= 0; i--)
        {
            line = this.content.get(i);
            if (line.contains("[") && line.contains("]"))
            {
                int endIndex = startIndex - 1;
                startIndex = i + 1;

                String name = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
                if (name.equals("GENERAL"))
                {
                    // Not copying the list throws CME
                    this.generalCode = new ArrayList<>(this.content.subList(startIndex, endIndex));
                }
                else
                {
                    boolean isCharacterSpecific = false;
                    for (int j = 0; j < this.characterSpecificMoveNames.length; j++)
                    {
                        if (name.equals(this.characterSpecificMoveNames[j]))
                        {
                            isCharacterSpecific = true;
                            CharacterSpecificMove charcterSpecificMove = new CharacterSpecificMove(
                                            name, new ArrayList<>(this.content.subList(startIndex,
                                                            endIndex)));
                            this.characterSpecificMoves.add(charcterSpecificMove);
                            break;
                        }
                    }
                    if (!isCharacterSpecific)
                    {
                        Move move = new Move(name, new ArrayList<>(this.content.subList(startIndex,
                                        endIndex)));
                        this.allMoves.add(move);
                    }
                }
            }
        }
    }

    public File getCharacterFile()
    {
        return characterFile;
    }

    public List<String> getContent()
    {
        return content;
    }

    public List<Move> getAllMoves()
    {
        return allMoves;
    }

    public CharacterGeneral getGeneral()
    {
        return general;
    }

}
