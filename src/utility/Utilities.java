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
        // System.out.println(toBeChecked + " " + command);
        if (!toBeChecked.contains(command))
        {
            return false;
        }
        for (int i = 0; i < CommandStorage.duplicateCommands.length; i++)
        {
            //System.out.println(CommandStorage.duplicateCommands[i]);
            // System.out.println(!CommandStorage.duplicateCommands[i].equals(command) + " "
            // + toBeChecked.contains(CommandStorage.duplicateCommands[i]));
            if (toBeChecked.contains(CommandStorage.duplicateCommands[i]) && !command.equals(
                            CommandStorage.duplicateCommands[i]))
            {
                return false;

            }
        }
        // System.out.println(toBeChecked + " " + command);
        // System.out.println(matches);
        return true;
    }

    public static List<float[]> addTempWindowCommand(List<float[]> listToBeAddedTo,
                    String commandToBeAdded, int commandPosition)
    {
        List<float[]> result = listToBeAddedTo;

        int tmp = commandToBeAdded.indexOf(CommandStorage.windowCommands[commandPosition])
                        + CommandStorage.windowCommands[commandPosition].length();
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
            float[] window = new float[CommandStorage.windowCommands.length];
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

    public static String convertLowerCaseUnderscoresToCamelCase(
                    String stringInLowerCaseAndSeperatedByUnderscores)
    {
        String result = stringInLowerCaseAndSeperatedByUnderscores;
        String[] stringSplitByUnderscores = result.split("_");

        if (stringSplitByUnderscores.length <= 1)
        {
            return result;
        }
        result = stringSplitByUnderscores[0];
        for (int i = 1; i < stringSplitByUnderscores.length; i++)
        {
            result = result + stringSplitByUnderscores[i].substring(0, 1).toUpperCase()
                            + stringSplitByUnderscores[i].substring(1);
        }
        return result;
    }

    public static String[][] generateTempHitboxes(int numberOfHitboxes)
    {
        String[][] result = new String[numberOfHitboxes][CommandStorage.hitboxCommands.length];
        for (int i = 0; i < result.length; i++)
        {
            for (int j = 0; j < result[i].length; j++)
            {
                result[i][j] = "\"0\"";
            }
        }
        for (int i = 0; i < result.length; i++)
        {
            int id = i + 1;
            result[i][0] = id + "";
        }
        return result;
    }
}
