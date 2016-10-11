package editor;

import java.util.regex.*;

import utility.Utilities;

public class HitboxManager
{
	protected String[] code = null;
	
	protected boolean hasHitboxes = false;
	protected Hitbox[] hitboxes = null;
	
	protected int numberOfUniqueHitboxes = 0;
	protected int numberOfMultihitboxes = 0;
	
	protected Utilities utils = new Utilities();

	public HitboxManager(String[] code)
	{
		this.code = code;
		this.determineNumberOfHitboxes();
		this.determineNumberOfMultihitboxes();
	}
	
	public void determineNumberOfHitboxes()
	{
		for (int i = 0; i < this.code.length; i++)
		{
			if (this.code[i].contains("num_hitboxes"))
			{
				Pattern p = Pattern.compile("\"([^\"]*)\"");
				Matcher m = p.matcher(this.code[i]);
				m.find();
				
				int numberOfHitboxes = (int) Float.parseFloat(m.group(1));
				this.hitboxes = new Hitbox[numberOfHitboxes];
				if (numberOfHitboxes > 0)
				{
					this.hasHitboxes = true;
				}
				this.code = this.utils.removeEntry(this.code, i);
				break;
			}
		}
	}
	
	public void determineNumberOfMultihitboxes ()
	{
		for (int i = 0; i < this.code.length; i++)
		{
			if (this.code[i].contains("num_unique_hitboxes"))
			{
				Pattern p = Pattern.compile("\"([^\"]*)\"");
				Matcher m = p.matcher(this.code[i]);
				m.find();
				
				this.numberOfUniqueHitboxes = (int) Float.parseFloat(m.group(1));
				if (!(this.numberOfUniqueHitboxes == this.hitboxes.length))
				{
					return; //no multihitboxes
				}
				this.utils.removeEntry(this.code, i);
				break; //there are multihitboxes
			}
		}
		//determine how many multihitboxes there are
		
			//TO-DO: calculate number of multihitboxes
	}

	public String[] getCodeWithoutHitboxCommands()
	{
		return this.code;
	}
}