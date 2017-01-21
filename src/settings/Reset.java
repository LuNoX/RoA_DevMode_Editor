package settings;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.CommandStorage;
import utility.Utilities;

public class Reset
{
    protected List<String> code = new ArrayList<String>();
    protected List<String> other = new ArrayList<String>();
    
    public double resetAbsa = 0;
    public double resetEtalus = 0;
    public double resetForsburn = 0;
    public double resetKragg = 0;
    public double resetMaypul = 0;
    public double resetOrcane = 0;
    public double resetWrastor = 0;
    public double resetZetterburn = 0;
    public double resetGeneral = 0;
    public double resetEverything = 0; 
    
    public Reset()
    {
    }

    public Reset(List<String> code)
    {
        this.code = code;
        this.other = code;
        this.initializeValues();
    }

    public void initializeValues()
    {
        String[] resetCommands = CommandStorage.resetCommands;
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.other.size()];

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.other.size(); i++)
        {
            String command = this.other.get(i);
            for (int j = 0; j < resetCommands.length; j++)
            {
                if (Utilities.isSpecificCommand(command, resetCommands[j]))
                {
                    m = p.matcher(command);
                    m.find();
                    double value = Double.parseDouble(m.group(1));
                    Field declaredField = null;
                    try
                    {
                        String fieldName = Utilities.convertLowerCaseUnderscoresToCamelCase(
                                        resetCommands[j]);
                        declaredField = Reset.class.getDeclaredField(fieldName);
                        boolean accessible = declaredField.isAccessible();

                        declaredField.setAccessible(true);
                        declaredField.set(this, value);
                        declaredField.setAccessible(accessible);

                    }
                    catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                                    | IllegalAccessException e)
                    {
                        System.out.println(e.getLocalizedMessage());
                        e.printStackTrace();
                    }
                    numberOfCommands++;
                    commandPositions[numberOfCommands - 1] = i;
                    break;
                }
            }
        }
        // remove all commands from code
        Arrays.sort(commandPositions); // sort the indices and then go through the list backwards to
                                       // avoid index errors
        for (int i = 1; i <= numberOfCommands; i++) // dont use commandPositions.length because
        // the Array is far longer than needed
        {
            this.other.remove(commandPositions[commandPositions.length - i]);
        }
    }

    public List<String> getCode()
    {
        return code;
    }

    public List<String> getOther()
    {
        return other;
    }

    public double getResetAbsa()
    {
        return resetAbsa;
    }

    public double getResetEtalus()
    {
        return resetEtalus;
    }

    public double getResetForsburn()
    {
        return resetForsburn;
    }

    public double getResetKragg()
    {
        return resetKragg;
    }

    public double getResetMaypul()
    {
        return resetMaypul;
    }

    public double getResetOrcane()
    {
        return resetOrcane;
    }

    public double getResetWrastor()
    {
        return resetWrastor;
    }

    public double getResetZetterburn()
    {
        return resetZetterburn;
    }

    public double getResetGeneral()
    {
        return resetGeneral;
    }

    public double getResetEverything()
    {
        return resetEverything;
    }

}
