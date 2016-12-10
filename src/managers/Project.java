package managers;

import java.util.*;
import java.io.File;
import characters.*;
import utility.*;

public class Project
{
	protected File directory = null;
	
	protected ArrayList<RoACharacter> characters = new ArrayList<RoACharacter>();
	protected GeneralSettings general = null;
	
	public Project ()
	{
		RoAFileChooser rfc = new RoAFileChooser();
		this.directory = rfc.chooseDirectory();
		this.initializeEverything();
	}
	
	public Project (File directory)
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
	
	public void addCharacter (File file)
	{
		//TODO use code storage for the file names
		String name = file.getName();
		
		if (name.equals("custom_absa.ini"))
		{
			Absa absa = new Absa(file);
			this.characters.add(absa);
		}
		else if (name.equals("custom_etalus.ini"))
		{
			Etalus etalus = new Etalus(file);
			this.characters.add(etalus);
		}
		else if (name.equals("custom_forsburn.ini"))
		{
			Forsburn forsburn = new Forsburn(file);
			this.characters.add(forsburn);
		}
		else if (name.equals("custom_kragg.ini"))
		{
			Kragg kragg = new Kragg(file);
			this.characters.add(kragg);
		}
		else if (name.equals("custom_maypul.ini"))
		{
			Maypul maypul = new Maypul(file);
			this.characters.add(maypul);
		}
		else if (name.equals("custom_maypul.ini"))
		{
			Orcane orcane = new Orcane(file);
			this.characters.add(orcane);
		}
		else if (name.equals("custom_wrastor.ini"))
		{
			Wrastor wrastor = new Wrastor(file);
			this.characters.add(wrastor);
		}
		else if (name.equals("custom_zetterburn.ini"))
		{
			Zetterburn zetterburn = new Zetterburn(file);
			this.characters.add(zetterburn);
		}
		else if (name.equals("custom_general.ini"))
		{
			GeneralSettings general = new GeneralSettings(file);
			this.general = general;
		}
		
	}

    public File getDirectory()
    {
        return directory;
    }

    public ArrayList<RoACharacter> getCharacters()
    {
        return characters;
    }

    public GeneralSettings getGeneral()
    {
        return general;
    }
}
