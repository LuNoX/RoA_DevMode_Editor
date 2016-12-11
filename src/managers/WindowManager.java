package managers;

import utility.*;
import java.util.*;

public class WindowManager
{
    protected List<String> code = null;

    protected ArrayList<Window> windows = new ArrayList<Window>();

    protected CommandStorage cs = new CommandStorage();

    public WindowManager(List<String> code)
    {
        this.code = code;
        this.createWindows();
    }

    public void createWindows()
    {
        String[] windowCommands = CommandStorage.windowCommands;
        int[] commandPositions = new int[this.code.size()];
        int numberOfCommands = 0;

        List<float[]> tempWindows = new ArrayList<float[]>();
        // windows are going to be saved temporarily like this {localID, length,
        // hboost, vboost, hBoostConst, vBoostConst, hasSfx, sfx, sfxFrame,
        // whiffFrames, invincibility}

        for (int i = 0; i < this.code.size(); i++)
        {
            String command = this.code.get(i);
            for (int j = 0; j < windowCommands.length; j++)
            {
                if (CommandStorage.isSpecificCommand(command, windowCommands[j]))
                {
                    tempWindows = CommandStorage.addTempWindowCommand(tempWindows, command, j);
                    numberOfCommands++;
                    commandPositions[numberOfCommands - 1] = i;
                }
            }
        }
        // add the temporary local windows to the actual window
        for (float[] tempWindow : tempWindows)
        {
            Window window = new Window("" + tempWindow[0] + "", tempWindow[1], tempWindow[2],
                            tempWindow[3], tempWindow[4], tempWindow[5], tempWindow[6],
                            tempWindow[7], tempWindow[8], tempWindow[9], tempWindow[10]);
            this.windows.add(window);
        }
        // remove everything related to the Window from the code
        for (int i = 0; i < numberOfCommands; i++)
        {
            this.code.remove(commandPositions[i]);
        }
    }

    public List<String> getCodeWithoutWindowCommands()
    {
        return this.code;
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
