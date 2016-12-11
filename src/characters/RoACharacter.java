package characters;

import java.io.File;
import java.util.ArrayList;

import generals.CharacterGeneral;
import moves.Move;
import moves.Projectile;
import utility.*;

public class RoACharacter
{
    protected File characterFile = null;
    protected String[] content = null;

    protected ArrayList<Move> allMoves = new ArrayList<Move>();
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

    public void initializeAllMovesAndGeneral()
    {
        // create the move-objects and place them into the Array, also create
        // the general-object
        String name = null;
        int tmp = this.content.length;
        for (int i = this.content.length - 1; i >= 0; i--)
        {
            if (this.content[i].contains("[") && this.content[i].contains("]"))
            {
                name = this.content[i].substring(this.content[i].indexOf("[") + 1, this.content[i]
                        .indexOf("]"));

                if (name.equals("GENERAL"))
                {
                    this.general = new CharacterGeneral(i, tmp, this.content);
                }
                else
                {
                    boolean isProjectile = false;
                    for (int j = 0; j < 1 + tmp - i; j++)
                    {
                        if (this.content[j].contains(CommandStorage.projectileLifetime))
                        {
                            isProjectile = true;
                            break;
                        }
                    }
                    if (isProjectile)
                    {
                        Projectile projectile = new Projectile(name, i, tmp, this.content);
                        this.allMoves.add(projectile);
                    }
                    else
                    {
                        Move move = new Move(name, i, tmp, this.content);
                        this.allMoves.add(move);
                    }
                }
                tmp = i - 1;
            }
        }
    }

    public void initializeContent()
    {
        RoAFileReader ifr = new RoAFileReader(this.characterFile);

        // determine the number of lines in the File
        ifr.nextLine();
        int numberOfLines = 0;
        while (ifr.getActiveLine() != null)
        {
            numberOfLines++;
            ifr.nextLine();
        }
        this.content = new String[numberOfLines];

        // save the file as an Array of Strings
        ifr = new RoAFileReader(this.characterFile);
        for (int i = 0; i < numberOfLines; i++)
        {
            ifr.nextLine();
            this.content[i] = ifr.getActiveLine();
        }
        ifr.close();
    }

    public File getCharacterFile()
    {
        return characterFile;
    }

    public String[] getContent()
    {
        return content;
    }

    public ArrayList<Move> getAllMoves()
    {
        return allMoves;
    }

    public CharacterGeneral getGeneral()
    {
        return general;
    }

}
