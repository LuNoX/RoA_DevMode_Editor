package model.managers;

import java.util.*;
import java.io.File;

import model.characters.*;
import model.settings.GeneralSettings;
import model.utility.*;

public class Project
{
    protected File directory = null;

    protected String name = "Project";
    
    protected List<RoACharacter> characters = new ArrayList<RoACharacter>();
    protected List<GeneralSettings> generals = new ArrayList<GeneralSettings>();
    
    //TODO add an ArrayList of strings that shouldnt be printed when saving a file to every class
    public Project()
    {
        RoAFileChooser rfc = new RoAFileChooser();
        this.directory = rfc.chooseDirectory();
        this.initializeEverything();
    }
    
    public Project (File directory, String name)
    {
        this.directory = directory;
        this.name = name;
        this.initializeEverything();
    }

    public Project(File directory)
    {
        this.directory = directory;
        this.name = directory.getAbsolutePath();
        this.initializeEverything();
    }

    public void initializeEverything()
    {
        File[] allFiles = this.directory.listFiles();
        for (int i = 0; i < allFiles.length; i++)
        {
            this.addCharacter(allFiles[i]);
        }
    }

    public void addCharacter(File file)
    {
        String name = file.getName();

        if (name.equals(CommandStorage.customAbsa))
        {
            Absa absa = new Absa(file);
            this.characters.add(absa);
        }
        else if (name.equals(CommandStorage.customEtalus))
        {
            Etalus etalus = new Etalus(file);
            this.characters.add(etalus);
        }
        else if (name.equals(CommandStorage.customForsburn))
        {
            Forsburn forsburn = new Forsburn(file);
            this.characters.add(forsburn);
        }
        else if (name.equals(CommandStorage.customKragg))
        {
            Kragg kragg = new Kragg(file);
            this.characters.add(kragg);
        }
        else if (name.equals(CommandStorage.customMaypul))
        {
            Maypul maypul = new Maypul(file);
            this.characters.add(maypul);
        }
        else if (name.equals(CommandStorage.customOrcane))
        {
            Orcane orcane = new Orcane(file);
            this.characters.add(orcane);
        }
        else if (name.equals(CommandStorage.customWrastor))
        {
            Wrastor wrastor = new Wrastor(file);
            this.characters.add(wrastor);
        }
        else if (name.equals(CommandStorage.customZetterburn))
        {
            Zetterburn zetterburn = new Zetterburn(file);
            this.characters.add(zetterburn);
        }
        else if (name.equals(CommandStorage.customGeneral))
        {
            GeneralSettings general = new GeneralSettings(file);
            this.generals.add(general);
        }
    }
    
    //TODO make these names consistent
    public void exportProject()
    {
        for (RoACharacter character : this.characters)
        {
            character.exportFile(this.directory);
        }
        //TODO add general settings
    }

    public File getDirectory()
    {
        return directory;
    }

    public List<RoACharacter> getCharacters()
    {
        return characters;
    }

    public List<GeneralSettings> getGenerals()
    {
        return generals;
    }

    public String getName()
    {
        return name;
    }
}
