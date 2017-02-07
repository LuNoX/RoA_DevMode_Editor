package model.moves;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.utility.CommandStorage;
import model.utility.Utilities;

public class OrcaneBubbles extends CharacterSpecificMove
{
    double hitstun = 0;
    double hitstop = 0;
    double lockoutTime = 0;
    double fairVKnockback = 0;
    double fairHKnockback = 0;
    double dspecialVKnockback = 0;
    double dspecialHKnockback = 0;
    double damage = 0;
    double fairInputDrift = 0;
    double fairVSpeedRange = 0;
    double fairHSpeedMin = 0;
    double fairHSpeedMax = 0;
    double bubblesPerFrameFair = 0;
    double dspecialInputDrift = 0;
    double dspecialVSpeedMin = 0;
    double dspecialVSpeedMax = 0;
    double dspecialHSpeedRange = 0;
    double bubblesPerFrameDspecial = 0;

    public OrcaneBubbles()
    {
    }

    public OrcaneBubbles(double hitstun, double hitstop, double lockoutTime, double fairVKnockback,
                    double fairHKnockback, double dspecialVKnockback, double dspecialHKnockback,
                    double damage, double fairInputDrift, double fairVSpeedRange,
                    double fairHSpeedMin, double fairHSpeedMax, double bubblesPerFrameFair,
                    double dspecialInputDrift, double dspecialVSpeedMin, double dspecialVSpeedMax,
                    double dspecialHSpeedRange, double bubblesPerFrameDspecial)
    {
        this.hitstun = hitstun;
        this.hitstop = hitstop;
        this.lockoutTime = lockoutTime;
        this.fairVKnockback = fairVKnockback;
        this.fairHKnockback = fairHKnockback;
        this.dspecialVKnockback = dspecialVKnockback;
        this.dspecialHKnockback = dspecialHKnockback;
        this.damage = damage;
        this.fairInputDrift = fairInputDrift;
        this.fairVSpeedRange = fairVSpeedRange;
        this.fairHSpeedMin = fairHSpeedMin;
        this.fairHSpeedMax = fairHSpeedMax;
        this.bubblesPerFrameFair = bubblesPerFrameFair;
        this.dspecialInputDrift = dspecialInputDrift;
        this.dspecialVSpeedMin = dspecialVSpeedMin;
        this.dspecialVSpeedMax = dspecialVSpeedMax;
        this.dspecialHSpeedRange = dspecialHSpeedRange;
        this.bubblesPerFrameDspecial = bubblesPerFrameDspecial;
    }

    public OrcaneBubbles(List<String> code)
    {
        super("BUBBLES", code);
        this.initializeValues();
    }

    public void initializeValues()
    {
        String[] bubblesCommands = CommandStorage.orcaneBubblesCommands;
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.other.size()];

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.other.size(); i++)
        {
            String command = this.other.get(i);
            for (int j = 0; j < bubblesCommands.length; j++)
            {
                if (Utilities.isSpecificCommand(command, bubblesCommands[j]))
                {
                    m = p.matcher(command);
                    m.find();
                    double value = Double.parseDouble(m.group(1));
                    Field declaredField = null;
                    try
                    {
                        String fieldName = Utilities.convertLowerCaseUnderscoresToCamelCase(
                                        bubblesCommands[j]);
                        declaredField = OrcaneBubbles.class.getDeclaredField(fieldName);
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

    public double getHitstun()
    {
        return hitstun;
    }

    public double getHitstop()
    {
        return hitstop;
    }

    public double getLockoutTime()
    {
        return lockoutTime;
    }

    public double getFairVKnockback()
    {
        return fairVKnockback;
    }

    public double getFairHKnockback()
    {
        return fairHKnockback;
    }

    public double getDspecialVKnockback()
    {
        return dspecialVKnockback;
    }

    public double getDspecialHKnockback()
    {
        return dspecialHKnockback;
    }

    public double getDamage()
    {
        return damage;
    }

    public double getFairInputDrift()
    {
        return fairInputDrift;
    }

    public double getFairVSpeedRange()
    {
        return fairVSpeedRange;
    }

    public double getFairHSpeedMin()
    {
        return fairHSpeedMin;
    }

    public double getFairHSpeedMax()
    {
        return fairHSpeedMax;
    }

    public double getBubblesPerFrameFair()
    {
        return bubblesPerFrameFair;
    }

    public double getDspecialInputDrift()
    {
        return dspecialInputDrift;
    }

    public double getDspecialVSpeedMin()
    {
        return dspecialVSpeedMin;
    }

    public double getDspecialVSpeedMax()
    {
        return dspecialVSpeedMax;
    }

    public double getDspecialHSpeedRange()
    {
        return dspecialHSpeedRange;
    }

    public double getBubblesPerFrameDspecial()
    {
        return bubblesPerFrameDspecial;
    }
}
