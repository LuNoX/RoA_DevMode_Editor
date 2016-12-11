package utility;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities
{
    public static int getStringPositionInArray(String searchForThis, String[] searchThroughThis)
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

    public static String[] removeEntry(String[] arrayToRemoveFrom, int entryNumber)
    {
        String[] result = new String[arrayToRemoveFrom.length - 1];

        int tmp = 0;
        for (int i = 0; i < result.length; i++)
        {
            if (i == entryNumber)
            {
                tmp = 1;
            }
            result[i] = arrayToRemoveFrom[i + tmp];
        }

        return result;
    }
    
    public static boolean isSpecificCommand(String toBeChecked, String command)
    {
        if (!toBeChecked.contains(command))
        {
            return false;
        }
        for (int i = 0; i < CommandStorage.duplicateCommands.length; i++)
        {
            if (!CommandStorage.duplicateCommands[i].equals(command) && toBeChecked.contains(
                            CommandStorage.duplicateCommands[i]))
            {
                return false;
            }
        }
        return true;
    }

    public static List<float[]> addTempWindowCommand(List<float[]> listToBeAddedTo,
                    String commandToBeAdded, int commandPosition)
    {
        List<float[]> result = listToBeAddedTo;
        String[] windowCommands = CommandStorage.windowCommands;

        int tmp = commandToBeAdded.indexOf(windowCommands[commandPosition])
                        + windowCommands[commandPosition].length();
        int id = Integer.parseInt(commandToBeAdded.substring(tmp, tmp + 1));

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(commandToBeAdded);
        m.find();
        Float value = Float.parseFloat(m.group(1));

        boolean belongsToExistingWindow = false;
        for (float[] window : result)
        {
            if (id == window[0])
            {
                window[commandPosition] = value;
                belongsToExistingWindow = true;
            }
        }
        if (!belongsToExistingWindow)
        {
            float[] window = new float[windowCommands.length];
            window[0] = id;
            for (int i = 1; i < window.length; i++)
            {
                if (i == commandPosition)
                {
                    window[i] = value;
                }
                else
                {
                    window[i] = 0;
                }
            }
            result.add(window);
        }

        return result;
    }
}
