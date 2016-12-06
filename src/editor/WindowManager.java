package editor;

import utility.*;

public class WindowManager
{
	protected String[] code = null;

	protected boolean hasWindows = false;
	protected Window[] windows = null;
	
	protected CommandStorage cs = new CommandStorage();

	public WindowManager(String[] code)
	{
		this.code = code;
		
		this.determineNumberOfWindows();
		this.createWindows();
	}

	public void determineNumberOfWindows()
	{
		int numberOfWindows = 0;

		for (int i = 0; i < this.code.length; i++)
		{
			if (this.code[i].contains("window_length_"))
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
	
	public void createWindows ()
	{
		int[] commandPositions = new int[10];
		String length = null;
		String hBoost = null;
		String vBoost = null;
		String hBoostConst = null;
		String vBoostConst = null;
		String hasSfx = null;
		String sfx = null;
		String sfxFrame = null;
		String whiffFrames = null;
		String invincibility = null;
		
		for (int i = 1; i <= this.windows.length; i++)
		{
			length = this.cs.getWindow_length() + i;
			hBoost = this.cs.getWindow_hBoost() + i;
			vBoost = this.cs.getWindow_vBoost() + i;
			hBoostConst = this.cs.getWindow_hBoostConst() + i;
			vBoostConst = this.cs.getWindow_vBoostConst() + i;
			hasSfx = this.cs.getWindow_hasSfx() + i;
			sfx = this.cs.getWindow_sfx() + i;
			sfxFrame = this.cs.getWindow_sfxFrame() + i;
			whiffFrames = this.cs.getWindow_whiffFrames() + i;
			invincibility = this.cs.getWindow_invincibility() + i;
			
			for (int j = 0; j < this.code.length; j++)
			{
				if (this.code[j].contains(length))
				{
					length = this.code[j];
					commandPositions[0] = j;
				}
				else if (this.code[j].contains(hBoost))
				{
					hBoost = this.code[j];
					commandPositions[1] = j;
				}
				else if (this.code[j].contains(vBoost))
				{
					vBoost = this.code[j];
					commandPositions[2] = j;
				}
				else if (this.code[j].contains(hBoostConst))
				{
					hBoostConst = this.code[j];
					commandPositions[3] = j;
				}
				else if (this.code[j].contains(vBoostConst))
				{
					vBoostConst = this.code[j];
					commandPositions[4] = j;
				}
				else if (this.code[j].contains(hasSfx))
				{
					hasSfx = this.code[j];
					commandPositions[5] = j;
				}
				else if (this.code[j].contains(sfx))
				{
					sfx = this.code[j];
					commandPositions[6] = j;
				}
				else if (this.code[j].contains(sfxFrame))
				{
					sfxFrame = this.code[j];
					commandPositions[7] = j;
				}
				else if (this.code[j].contains(whiffFrames))
				{
					whiffFrames = this.code[j];
					commandPositions[8] = j;
				}
				else if (this.code[j].contains(invincibility))
				{
					invincibility = this.code[j];
					commandPositions[9] = j;
				}
			}
			this.windows[i-1] = new Window("" + i + "", length, hBoost, vBoost, hBoostConst, vBoostConst, hasSfx, sfx, sfxFrame, whiffFrames, invincibility);
		}
		
		//remove everything related to the Window from the code
		for (int i = 0; i < commandPositions.length; i++)
		{
			this.code = Utilities.removeEntry(this.code, commandPositions[i]);
		}
	}
	
	public String[] getCodeWithoutWindowCommands()
	{
		return this.code;
	}

	public String[] getCode()
	{
		return code;
	}

	public boolean isHasWindows()
	{
		return hasWindows;
	}

	public Window[] getWindows()
	{
		return windows;
	}

	public CommandStorage getCs()
	{
		return cs;
	}
}
