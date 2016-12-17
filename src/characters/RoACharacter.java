package characters;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

import generals.CharacterGeneral;
import moves.Move;
import moves.Projectile;
import utility.*;

public class RoACharacter
{
    protected File characterFile = null;
    protected List<String> content = new ArrayList<String>();

    protected List<Move> allMoves = new ArrayList<Move>();
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
        // TODO filter blank lines
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
                    boolean isProjectile = false;
                    for (int j = startIndex; j < endIndex; j++)
                    {
                        if (this.content.get(j).contains(CommandStorage.projectileLifetime))
                        {
                            isProjectile = true;
                            break;
                        }
                    }
                    if (isProjectile)
                    {
                        Projectile projectile = new Projectile(name, this.content.subList(
                                        startIndex, endIndex));
                        this.allMoves.add(projectile);
                    }
                    else
                    {
                        Move move = new Move(name, this.content.subList(startIndex, endIndex));
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
