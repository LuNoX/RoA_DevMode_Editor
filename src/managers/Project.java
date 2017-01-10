package managers;

import java.util.*;
import java.io.File;
import characters.*;
import utility.*;

public class Project
{
    protected File directory = null;

    protected List<RoACharacter> characters = new ArrayList<RoACharacter>();
    protected GeneralSettings general = null;

    public Project()
    {
        RoAFileChooser rfc = new RoAFileChooser();
        this.directory = rfc.chooseDirectory();
        this.initializeEverything();
    }

    public Project(File directory)
    {
        this.directory = directory;
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
        String name = file.getName(); //TODO think about making this an enum

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
            this.general = general;
        }

    }

    public File getDirectory()
    {
        return directory;
    }

    public List<RoACharacter> getCharacters()
    {
        return characters;
    }

    public GeneralSettings getGeneral()
    {
        return general;
    }
}
