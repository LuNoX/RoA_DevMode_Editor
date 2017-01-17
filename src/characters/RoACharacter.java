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

    protected List<Move> allMoves = new ArrayList<Move>();
    protected List<Move> characterSpecificMoves = new ArrayList<Move>();
    protected CharacterGeneral general = null;

    // TODO make this abstract
    public RoACharacter(File character)
    {
        this.characterFile = character;
        this.initializeEveryting();
    }

    /**
     * Placeholder constructor to avoid errors in all Character classes
     */
    public RoACharacter()
    {
        // TODO make this constructor do at least something
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

        // save the file as an Array of Strings
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
        int startIndex = this.content.size();
        int endIndex = startIndex;

        for (int i = this.content.size() - 1; i >= 0; i--)
        {
            line = this.content.get(i);
            if (line.contains("[") && line.contains("]"))
            {
                endIndex = startIndex;
                startIndex = i;

                String name = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
                if (name.equals("GENERAL"))
                {
                    this.general = new CharacterGeneral(this.content.subList(startIndex, endIndex));
                }
                else
                {
                    boolean isCharacterSpecific = false;
                    for (int j = 0; j < CommandStorage.characterSpecificMoveNames.length; j++)
                    {
                        if(name.equals(CommandStorage.characterSpecificMoveNames[j]))
                        {
                            isCharacterSpecific = true;
                            CharacterSpecificMove charcterSpecificMove = new CharacterSpecificMove(name, this.content.subList(
                                                startIndex, endIndex));
                            this.characterSpecificMoves.add(charcterSpecificMove);
                            break;
                        }
                    }
                    if (!isCharacterSpecific)
                    {
                        boolean isProjectile = false;
                        for (int k = startIndex; k < endIndex; k++)
                        {
                            if (this.content.get(k).contains(CommandStorage.projectileLifetime))
                            {
                                isProjectile = true;
                                break;
                            }
                        }
                        if (isProjectile)
                        {
                            if (!name.equals("CLOUD_BURST")) // TODO implement character specific
                                                             // move classes
                            {
                                Projectile projectile = new Projectile(name, this.content.subList(
                                                startIndex, endIndex));
                                this.allMoves.add(projectile);
                            }
                        }
                        else if (!name.equals("BUBBLES")) // TODO remove this since its for
                                                          // debugging only
                        {
                            Move move = new Move(name, this.content.subList(startIndex, endIndex));
                            this.allMoves.add(move);
                        }
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
