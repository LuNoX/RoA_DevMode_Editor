package managers;

import utility.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WindowManager
{
    protected String[] code = null;

    protected boolean hasWindows = false;

    protected ArrayList<Window> windows = new ArrayList<Window>();

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
            if (this.code[i].contains(CommandStorage.window_length))
            {
                numberOfWindows++;
            }
        }

        // this.windows = new Window[numberOfWindows];

        if (numberOfWindows > 0)
        {
            this.hasWindows = true;
        }
    }

    public void createWindows()
    {
        int[] commandPositions = new int[this.code.length];
        int numberOfCommands = 0;

        ArrayList<float[]> tempWindows = new ArrayList<float[]>();
        // windows are going to be saved temporarily like this {localID, length,
        // hboost, vboost, hBoostConst, vBoostConst, hasSfx, sfx, sfxFrame,
        // whiffFrames, invincibility}

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        String length = CommandStorage.window_length;
        String hBoost = CommandStorage.window_hBoost;
        String vBoost = CommandStorage.window_vBoost;
        String hBoostConst = CommandStorage.window_hBoostConst;
        String vBoostConst = CommandStorage.window_vBoostConst;
        String hasSfx = CommandStorage.window_hasSfx;
        String sfx = CommandStorage.window_sfx;
        String sfxFrame = CommandStorage.window_sfxFrame;
        String whiffFrames = CommandStorage.window_whiffFrames;
        String invincibility = CommandStorage.window_invincibility;

        Float value = null;
        int id = 0;
        int tmp = 0;

        for (int j = 0; j < this.code.length; j++)
        {
            if (CommandStorage.isSpecificCommand(this.code[j], length))
            {
                tmp = this.code[j].indexOf(length) + length.length();
                id = Integer.parseInt(this.code[j].substring(tmp, tmp + 1));

                m = p.matcher(this.code[j]);
                m.find();
                value = Float.parseFloat(m.group(1));

                boolean belongsToExistingWindow = false;
                for (float[] window : tempWindows)
                {
                    if (id == window[0])
                    {
                        window[1] = value;
                        belongsToExistingWindow = true;
                    }
                }
                if (!belongsToExistingWindow)
                {
                    float[] window =
                    { id, value, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                    tempWindows.add(window);
                }
                numberOfCommands++;
                commandPositions[numberOfCommands-1] = j;
            }
            else if (CommandStorage.isSpecificCommand(this.code[j], hBoost))
            {
                tmp = this.code[j].indexOf(hBoost) + hBoost.length();
                id = Integer.parseInt(this.code[j].substring(tmp, tmp + 1));

                m = p.matcher(this.code[j]);
                m.find();
                value = Float.parseFloat(m.group(1));

                boolean belongsToExistingWindow = false;
                for (float[] window : tempWindows)
                {
                    if (id == window[0])
                    {
                        window[2] = value;
                        belongsToExistingWindow = true;
                    }
                }
                if (!belongsToExistingWindow)
                {
                    float[] window =
                    { id, 0, value, 0, 0, 0, 0, 0, 0, 0, 0};
                    tempWindows.add(window);
                }
                numberOfCommands++;
                commandPositions[numberOfCommands-1] = j;
            }
            else if (CommandStorage.isSpecificCommand(this.code[j], vBoost))
            {
                tmp = this.code[j].indexOf(vBoost) + vBoost.length();
                id = Integer.parseInt(this.code[j].substring(tmp, tmp + 1));

                m = p.matcher(this.code[j]);
                m.find();
                value = Float.parseFloat(m.group(1));

                boolean belongsToExistingWindow = false;
                for (float[] window : tempWindows)
                {
                    if (id == window[0])
                    {
                        window[3] = value;
                        belongsToExistingWindow = true;
                    }
                }
                if (!belongsToExistingWindow)
                {
                    float[] window =
                    { id, 0, 0, value, 0, 0, 0, 0, 0, 0, 0};
                    tempWindows.add(window);
                }
                numberOfCommands++;
                commandPositions[numberOfCommands-1] = j;
            }
            else if (CommandStorage.isSpecificCommand(this.code[j], hBoostConst))
            {
                tmp = this.code[j].indexOf(hBoostConst) + hBoostConst.length();
                id = Integer.parseInt(this.code[j].substring(tmp, tmp + 1));

                m = p.matcher(this.code[j]);
                m.find();
                value = Float.parseFloat(m.group(1));

                boolean belongsToExistingWindow = false;
                for (float[] window : tempWindows)
                {
                    if (id == window[0])
                    {
                        window[4] = value;
                        belongsToExistingWindow = true;
                    }
                }
                if (!belongsToExistingWindow)
                {
                    float[] window =
                    { id, 0, 0, 0, value, 0, 0, 0, 0, 0, 0};
                    tempWindows.add(window);
                }
                numberOfCommands++;
                commandPositions[numberOfCommands-1] = j;
            }
            else if (CommandStorage.isSpecificCommand(this.code[j], vBoostConst))
            {
                tmp = this.code[j].indexOf(vBoostConst) + vBoostConst.length();
                id = Integer.parseInt(this.code[j].substring(tmp, tmp + 1));

                m = p.matcher(this.code[j]);
                m.find();
                value = Float.parseFloat(m.group(1));

                boolean belongsToExistingWindow = false;
                for (float[] window : tempWindows)
                {
                    if (id == window[0])
                    {
                        window[5] = value;
                        belongsToExistingWindow = true;
                    }
                }
                if (!belongsToExistingWindow)
                {
                    float[] window =
                    { id, 0, 0, 0, 0, value, 0, 0, 0, 0, 0};
                    tempWindows.add(window);
                }
                numberOfCommands++;
                commandPositions[numberOfCommands-1] = j;
            }
            else if (CommandStorage.isSpecificCommand(this.code[j], hasSfx))
            {
                tmp = this.code[j].indexOf(hasSfx) + hasSfx.length();
                id = Integer.parseInt(this.code[j].substring(tmp, tmp + 1));

                m = p.matcher(this.code[j]);
                m.find();
                value = Float.parseFloat(m.group(1));

                boolean belongsToExistingWindow = false;
                for (float[] window : tempWindows)
                {
                    if (id == window[0])
                    {
                        window[6] = value;
                        belongsToExistingWindow = true;
                    }
                }
                if (!belongsToExistingWindow)
                {
                    float[] window =
                    { id, 0, 0, 0, 0, 0, value, 0, 0, 0, 0};
                    tempWindows.add(window);
                }
                numberOfCommands++;
                commandPositions[numberOfCommands-1] = j;
            }
            else if (CommandStorage.isSpecificCommand(this.code[j], sfx))
            {
                tmp = this.code[j].indexOf(sfx) + sfx.length();
                id = Integer.parseInt(this.code[j].substring(tmp, tmp + 1));

                m = p.matcher(this.code[j]);
                m.find();
                value = Float.parseFloat(m.group(1));

                boolean belongsToExistingWindow = false;
                for (float[] window : tempWindows)
                {
                    if (id == window[0])
                    {
                        window[7] = value;
                        belongsToExistingWindow = true;
                    }
                }
                if (!belongsToExistingWindow)
                {
                    float[] window =
                    { id, 0, 0, 0, 0, 0, 0, value, 0, 0, 0};
                    tempWindows.add(window);
                }
                numberOfCommands++;
                commandPositions[numberOfCommands-1] = j;
            }
            else if (CommandStorage.isSpecificCommand(this.code[j], sfxFrame))
            {
                tmp = this.code[j].indexOf(sfxFrame) + sfxFrame.length();
                id = Integer.parseInt(this.code[j].substring(tmp, tmp + 1));

                m = p.matcher(this.code[j]);
                m.find();
                value = Float.parseFloat(m.group(1));

                boolean belongsToExistingWindow = false;
                for (float[] window : tempWindows)
                {
                    if (id == window[0])
                    {
                        window[8] = value;
                        belongsToExistingWindow = true;
                    }
                }
                if (!belongsToExistingWindow)
                {
                    float[] window =
                    { id, 0, 0, 0, 0, 0, 0, 0, value, 0, 0};
                    tempWindows.add(window);
                }
                numberOfCommands++;
                commandPositions[numberOfCommands-1] = j;
            }
            else if (CommandStorage.isSpecificCommand(this.code[j], whiffFrames))
            {
                tmp = this.code[j].indexOf(whiffFrames) + whiffFrames.length();
                id = Integer.parseInt(this.code[j].substring(tmp, tmp + 1));

                m = p.matcher(this.code[j]);
                m.find();
                value = Float.parseFloat(m.group(1));

                boolean belongsToExistingWindow = false;
                for (float[] window : tempWindows)
                {
                    if (id == window[0])
                    {
                        window[9] = value;
                        belongsToExistingWindow = true;
                    }
                }
                if (!belongsToExistingWindow)
                {
                    float[] window =
                    { id, 0, 0, 0, 0, 0, 0, 0, 0, value, 0};
                    tempWindows.add(window);
                }
                numberOfCommands++;
                commandPositions[numberOfCommands-1] = j;
            }
            else if (CommandStorage.isSpecificCommand(this.code[j], invincibility))
            {
                tmp = this.code[j].indexOf(invincibility) + invincibility.length();
                id = Integer.parseInt(this.code[j].substring(tmp, tmp + 1));

                m = p.matcher(this.code[j]);
                m.find();
                value = Float.parseFloat(m.group(1));

                boolean belongsToExistingWindow = false;
                for (float[] window : tempWindows)
                {
                    if (id == window[0])
                    {
                        window[10] = value;
                        belongsToExistingWindow = true;
                    }
                }
                if (!belongsToExistingWindow)
                {
                    float[] window =
                    { id, 0, 0, 0, 0, 0, 0, 0, 0, 0, value};
                    tempWindows.add(window);
                }
                numberOfCommands++;
                commandPositions[numberOfCommands-1] = j;
            }
        }
        for (float[] tempWindow : tempWindows)
        {
            Window window = new Window("" + tempWindow[0] + "", tempWindow[1], tempWindow[2],
                    tempWindow[3], tempWindow[4], tempWindow[5], tempWindow[6], tempWindow[7],
                    tempWindow[8], tempWindow[9], tempWindow[10]);
            this.windows.add(window);
        }
        // remove everything related to the Window from the code
        for (int i = 0; i < numberOfCommands; i++)
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

    public ArrayList<Window> getWindows()
    {
        return windows;
    }

    public CommandStorage getCs()
    {
        return cs;
    }
}
