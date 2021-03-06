package model.characters;

import java.util.List;

import javax.swing.Icon;

import model.moves.*;
import model.utility.*;
import ui.Resources;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class RoACharacter
{
    protected File characterFile = null;
    protected List<String> content = new ArrayList<String>();
    
    protected String name = this.getClass().getName().replaceAll(".*\\.", "");

    protected CharacterGeneral general = new CharacterGeneral();
    protected List<Move> allMoves = new ArrayList<Move>();
    
    protected List<CharacterSpecificMove> characterSpecificMoves
                    = new ArrayList<CharacterSpecificMove>();
    protected String[] characterSpecificMoveNames = new String[0];


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
            }
            ifr.nextLine();
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
                    this.general = new CharacterGeneral(new ArrayList<>(this.content.subList(startIndex, endIndex)));
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
                            this.allMoves.add(charcterSpecificMove);
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
    
    public List<String> exportCode()
    {
        List<String> result = new ArrayList<>();
        
        for (Move move : this.allMoves)
        {
            result.addAll(move.exportCode());
        }
        result.addAll(this.general.exportCode());
        
        return result;
    }
    
    public void exportFile(File directory)
    {
        List<String> lines = this.exportCode();
        String name = this.characterFile.getName();
        int i = name.contains(".") ? name.lastIndexOf('.') : name.length();
        String newFileName = name.substring(0, i) + "_new" + name.substring(i);
        Path file = Paths.get(directory.getAbsolutePath(), newFileName);
        try
        {
            Files.write(file, lines, Charset.forName("UTF-8"));
        }
        catch (IOException e)
        {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        //Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
    }
    
    public void exportFile ()
    {
        this.exportFile(this.characterFile.getParentFile());
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

    public String getName()
    {
        return name;
    }

    public List<CharacterSpecificMove> getCharacterSpecificMoves()
    {
        return characterSpecificMoves;
    }

    public String[] getCharacterSpecificMoveNames()
    {
        return characterSpecificMoveNames;
    }
}
