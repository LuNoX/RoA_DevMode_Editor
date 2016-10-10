package editor;

public class Move
{
	protected String name = null;
	
	protected String[] code = null;
	
	protected Hitbox[] hitboxes = null;
	protected boolean hasHitboxes = false;
	protected Window[] windows = null;
	protected boolean hasWindows = false;
	protected String[] other = null;
	
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
		this.initializeWindowsSize();
		
		int[] commandPositions = new int[10];
		for (int i = 1; i <= this.windows.length; i++)
		{
			String length = "window_length_" + i;
			String hBoost = "window_h_boost_" + i;
			String vBoost = "window_v_boost_" + i;
			String hBoostConst = "window_h_boost_is_const_" + i;
			String vBoostConst = "window_v_boost_is_const_" + i;
			String hasSfx = "window_has_sfx_" + i;
			String sfx = "window_sfx_" + i;
			String sfxFrame = "window_sfx_frame_" + i;
			String whiffFrames = "window_whiff_frames_" + i;
			String invincibility = "invincibility_" + i;
			
			for (int j = 0; j < this.other.length; j++)
			{
				if (this.other[j].contains(length))
				{
					length = this.other[j];
					commandPositions[0] = j;
				}
				else if (this.other[j].contains(hBoost))
				{
					hBoost = this.other[j];
					commandPositions[1] = j;
				}
				else if (this.other[j].contains(vBoost))
				{
					vBoost = this.other[j];
					commandPositions[2] = j;
				}
				else if (this.other[j].contains(hBoostConst))
				{
					hBoostConst = this.other[j];
					commandPositions[3] = j;
				}
				else if (this.other[j].contains(vBoostConst))
				{
					vBoostConst = this.other[j];
					commandPositions[4] = j;
				}
				else if (this.other[j].contains(hasSfx))
				{
					hasSfx = this.other[j];
					commandPositions[5] = j;
				}
				else if (this.other[j].contains(sfx))
				{
					sfx = this.other[j];
					commandPositions[6] = j;
				}
				else if (this.other[j].contains(sfxFrame))
				{
					sfxFrame = this.other[j];
					commandPositions[7] = j;
				}
				else if (this.other[j].contains(whiffFrames))
				{
					whiffFrames = this.other[j];
					commandPositions[8] = j;
				}
				else if (this.other[j].contains(invincibility))
				{
					invincibility = this.other[j];
					commandPositions[9] = j;
				}
			}
			this.windows[i-1] = new Window("" + i + "", length, hBoost, vBoost, hBoostConst, vBoostConst, hasSfx, sfx, sfxFrame, whiffFrames, invincibility);
		}
		for (int i = 0; i < commandPositions.length; i++)
		{
			this.other = this.removeEntry(this.other, commandPositions[i]);
		}
	}
	
	public void initializeWindowsSize ()
	{
		int numberOfWindows = 0;
		
		for (int i = 0; i < this.other.length; i++)
		{
			if (this.other[i].contains("window_length_"))
			{
				numberOfWindows++;
			}
		}
		
		this.windows = new Window[numberOfWindows];
		
		if (numberOfWindows > 0)
		{
			this.hasWindows = true;
		}
	}
	
	public void initializeHitboxes ()
	{
		
	}
	
	public int getStringPositionInArray (String searchForThis, String[] searchThroughThis)
	{
		int result = -1;
		
		for (int i = 0; i < searchThroughThis.length; i++)
		{
			if (searchThroughThis[i].contains(searchForThis))
			{
				result = i;
				break;
			}
		}
		
		return result;
	}
	
	public String[] removeEntry (String[] arrayToRemoveFrom, int entryNumber)
	{
		String[] result = new String[arrayToRemoveFrom.length-1];
		
		int tmp = 0;
		for (int i = 0; i < result.length; i++)
		{
			if (i == entryNumber)
			{
				tmp = 1;
			}
			else
			{
				result[i] = arrayToRemoveFrom[i+tmp];
			}
		}
		
		return result;
	}

	public String getName()
	{
		return name;
	}

	public String[] getCode()
	{
		return code;
	}

	public Hitbox[] getHitboxes()
	{
		if (!this.hasHitboxes)
		{
			System.out.println("The move " + this.name + " does not have a hitbox.");
		}
		return hitboxes;
	}

	public Window[] getWindows()
	{
		if (!this.hasWindows)
		{
			System.out.println("The move " + this.name + " does not have a window.");
		}
		return windows;
	}

	public String[] getOther()
	{
		return other;
	}
}
