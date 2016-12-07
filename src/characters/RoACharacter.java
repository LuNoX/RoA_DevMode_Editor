package characters;

import java.io.File;

import moves.MoveGeneral;
import moves.Move;
import utility.*;

public class RoACharacter
{
	protected File characterFile = null;
	protected String[] content = null;

	protected Move[] allMoves = null;
	protected MoveGeneral general = null;

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

	}

	public void initializeEveryting()
	{
		this.initializeContent();
		this.initializeAllMovesAndGeneral();
	}

	public void initializeAllMovesAndGeneral()
	{
		// determine how many moves there are
		int numberOfMoves = -1;
		for (int j = 0; j < this.content.length; j++)
		{
			if (this.content[j].contains("[") && this.content[j].contains("]"))
			{
				numberOfMoves++;
			}
		}
		this.allMoves = new Move[numberOfMoves];

		// create the move-objects and place them into the Array, also create
		// the general-object
		String name = null;
		int tmp = this.content.length;
		for (int i = this.content.length - 1; i >= 0; i--)
		{
			if (this.content[i].contains("[") && this.content[i].contains("]"))
			{
				name = this.content[i].substring(this.content[i].indexOf("[") + 1, this.content[i].indexOf("]"));

				if (name.equals("GENERAL"))
				{
					this.general = new MoveGeneral(i, tmp, this.content);
				}
				else
				{
					numberOfMoves--;
					this.allMoves[numberOfMoves] = new Move(name, i, tmp, this.content);
				}
				tmp = i - 1;
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

	public MoveGeneral getGeneral()
	{
		return general;
	}

}
