package managers;

import java.io.File;

import characters.RoACharacter;

public class Project
{
	protected File directory = null;
	
	protected RoACharacter[] characters = null;
	
	public Project (File directory)
	{
		this.directory = directory;
		this.initializeEverything();
	}
	
	public void initializeEverything()
	{
		
	}
}
