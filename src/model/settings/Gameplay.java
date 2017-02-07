package model.settings;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.utility.CommandStorage;
import model.utility.Utilities;

public class Gameplay
{
    protected List<String> code = new ArrayList<String>();
    protected List<String> other = new ArrayList<String>();

    protected double driftDiMaxPercent = 0;
    protected double driftDiMinPercent = 0;
    protected double asdiStrength = 0;
    protected double knockdownStateTime = 0;
    protected double maxSpeedToActOutOfTumble = 0;
    protected double postHitpauseDiFrames = 0;
    protected double driftDiStrength = 0;
    protected double tumbleDiMaxAngle = 0;
    protected double diMaxAngle = 0;
    protected double parryStun = 0;
    protected double parryMode = 0;

    public Gameplay()
    {
    }

    public Gameplay(List<String> code)
    {
        this.code = code;
        this.other = code;
        this.initializeValues();
    }

    public void initializeValues()
    {
        String[] gameplayCommands = CommandStorage.gameplayCommands;
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.other.size()];

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.other.size(); i++)
        {
            String command = this.other.get(i);
            for (int j = 0; j < gameplayCommands.length; j++)
            {
                if (Utilities.isSpecificCommand(command, gameplayCommands[j]))
                {
                    m = p.matcher(command);
                    m.find();
                    double value = Double.parseDouble(m.group(1));
                    Field declaredField = null;
                    try
                    {
                        String fieldName = Utilities.convertLowerCaseUnderscoresToCamelCase(
                                        gameplayCommands[j]);
                        declaredField = Gameplay.class.getDeclaredField(fieldName);
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

    public double getDriftDiMaxPercent()
    {
        return driftDiMaxPercent;
    }

    public double getDriftDiMinPercent()
    {
        return driftDiMinPercent;
    }

    public double getAsdiStrength()
    {
        return asdiStrength;
    }

    public double getKnockdownStateTime()
    {
        return knockdownStateTime;
    }

    public double getMaxSpeedToActOutOfTumble()
    {
        return maxSpeedToActOutOfTumble;
    }

    public double getPostHitpauseDiFrames()
    {
        return postHitpauseDiFrames;
    }

    public double getDriftDiStrength()
    {
        return driftDiStrength;
    }

    public double getTumbleDiMaxAngle()
    {
        return tumbleDiMaxAngle;
    }

    public double getDiMaxAngle()
    {
        return diMaxAngle;
    }

    public double getParryStun()
    {
        return parryStun;
    }

    public double getParryMode()
    {
        return parryMode;
    }


}
