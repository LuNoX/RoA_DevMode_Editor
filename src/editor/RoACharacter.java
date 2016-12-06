package editor;

import java.io.File;
import utility.*;
import editor.Move;

public class CharacterManager
{
	protected File characterFile = null;
	protected String[] content = null;

	protected Move[] allMoves = null;
	protected General general = null;

	public CharacterManager(File character)
	{
		this.initializeEveryting(character);
	}

	/**
	 * Placeholder constructor to avoid errors in all [Character Name
	 * here]Managers
	 */
	public CharacterManager()
	{
		
	}

	public void initializeEveryting(File character)
	{
		this.characterFile = character;

		this.initializeContent();
		this.initializeAllMovesAndGeneral();
	}

	public void initializeAllMovesAndGeneral()
	{	
		//determine how many moves there are
		int numberOfMoves = -1;
		for (int j = 0; j < this.content.length; j++)
		{
			if (this.content[j].contains("[") && this.content[j].contains("]"))
			{
				numberOfMoves++;
			}
		}
		this.allMoves = new Move[numberOfMoves];
		
		//create the move-objects and place them into the Array, also create the general-object
		String name = null;
		int tmp = this.content.length;
		for (int i = this.content.length-1; i >= 0; i--)
		{
			if (this.content[i].contains("[") && this.content[i].contains("]"))
			{
				name = this.content[i].substring(this.content[i].indexOf("[") + 1, this.content[i].indexOf("]"));
				
				if (name.equals("GENERAL"))
				{
					this.general = new General (i, tmp, this.content);
				}
				else
				{
					numberOfMoves--;
					this.allMoves[numberOfMoves] = new Move (name, i, tmp, this.content);
				}
				tmp = i-1;
			}
		}
	}

	public void initializeContent()
	{
		IniFileReader ifr = new IniFileReader(this.characterFile);

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
		ifr = new IniFileReader(this.characterFile);
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

	public Move[] getAllMoves()
	{
		return allMoves;
	}

	public General getGeneral()
	{
		return general;
	}

}
