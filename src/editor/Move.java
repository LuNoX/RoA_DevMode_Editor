package editor;

import utility.*;

public class Move
{
	protected String name = null;
	
	protected String[] code = null;
	
	protected HitboxManager hm = null;
	protected WindowManager wm = null;

	protected String[] other = null;
	
	protected Utilities utils = new Utilities();
	
	public Move (String name,int startPosition, int endPosition, String[] content)
	{
		this.name = name;
		this.code = new String[1+endPosition-startPosition];
		
		int tmp = 0;
		for (int i = startPosition; i <= endPosition; i++)
		{
			this.code[tmp] = content[i];
			tmp++;
		}
		
		this.other = this.code;		
		this.initializeWindows();
		this.initializeHitboxes();
	}
	
	public void initializeWindows ()
	{
		this.wm = new WindowManager(this.other);
		this.other = wm.getCodeWithoutWindowCommands();
	}
	
	public void initializeHitboxes ()
	{
		this.hm = new HitboxManager (this.other);
		this.other = hm.getCodeWithoutHitboxCommands();
	}

	public String getName()
	{
		return name;
	}

	public String[] getCode()
	{
		return code;
	}

	public String[] getOther()
	{
		return other;
	}

	public HitboxManager getHm()
	{
		return hm;
	}

	public WindowManager getWm()
	{
		return wm;
	}

	public Utilities getUtils()
	{
		return utils;
	}
}
