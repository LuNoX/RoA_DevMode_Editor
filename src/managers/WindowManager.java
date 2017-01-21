package managers;

import utility.*;
import java.util.*;

public class WindowManager
{
    // TODO add "other"-field
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
        int[] commandPositions = new int[this.code.size()];
        int numberOfCommands = 0;

        List<double[]> tempWindows = new ArrayList<double[]>();
        // windows are going to be saved temporarily like this {localID, length,
        // hboost, vboost, hBoostConst, vBoostConst, hasSfx, sfx, sfxFrame,
        // whiffFrames, invincibility}

        for (int i = 0; i < this.code.size(); i++)
        {
            String command = this.code.get(i);
            for (int j = 0; j < CommandStorage.windowCommands.length; j++)
            {
                if (Utilities.isSpecificCommand(command, CommandStorage.windowCommands[j]))
                {
                    tempWindows = Utilities.addTempWindowCommand(tempWindows, command, j);
                    numberOfCommands++;
                    commandPositions[numberOfCommands - 1] = i;
                    break;
                }
            }
        }
        // add the temporary local windows to the actual window
        for (double[] tempWindow : tempWindows)
        {
            Window window = new Window("" + tempWindow[0] + "", tempWindow[1], tempWindow[2],
                            tempWindow[3], tempWindow[4], tempWindow[5], tempWindow[6],
                            tempWindow[7], tempWindow[8], tempWindow[9], tempWindow[10], tempWindow[11]);
            this.windows.add(window);
        }
        // remove everything related to the Window from the code
        Arrays.sort(commandPositions); // sort the indices and then go through the list backwards to
                                       // avoid index errors
        for (int i = 1; i <= numberOfCommands; i++) // dont use commandPositions.length because
        // the Array is far longer than needed
        {
            this.code.remove(commandPositions[commandPositions.length - i]);
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
