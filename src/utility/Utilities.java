package utility;

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
}
