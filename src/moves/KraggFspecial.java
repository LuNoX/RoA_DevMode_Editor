package moves;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import managers.Hitbox;
import managers.HitboxManager;
import utility.CommandStorage;
import utility.Utilities;

public class KraggFspecial extends CharacterSpecificMove
{
    protected double maxGroundSpeed = 0;
    protected double initialFallSpeed = 0;
    protected double initialAerialSpeed = 0;
    protected double maxRollTime = 0;
    protected double minRollTime = 0;
    protected double rollAccel = 0;
    protected double minTimeBeforeTurn = 0;
    protected double turnAccel = 0;

    public KraggFspecial(List<String> code)
    {
        super("NSPECIAL", code);
        this.initializeEverything();
        this.initializeValues();
    }

    public KraggFspecial()
    {
    }

    public void initializeHitboxes()
    {
        this.hitboxManager = new HitboxManager();
        this.hitboxManager.setCode(this.other);
        this.hitboxManager.determineNumberOfHitboxes();
        this.hitboxManager.determineNumberOfMultihitboxes();
        String[] specificIds =
        {"ground", "air"};
        this.hitboxManager.createHitboxes(specificIds);

        for (int i = 0; i < specificIds.length; i++)
        {
            for (Hitbox hitbox : this.hitboxManager.getHitboxes())
            {
                int j = i+1;
                String tmp = "" + j;
                if (hitbox.getId().equals(tmp))
                {
                    hitbox.setId(specificIds[i]);
                    hitbox.setHasCustomId(true);
                }
            }
        }
        this.other = hitboxManager.getCodeWithoutHitboxCommands();
    }
    
    public void initializeValues()
    {
        String[] fspecialCommands = CommandStorage.kraggFspecialCommands;
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.other.size()];

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.other.size(); i++)
        {
            String command = this.other.get(i);
            for (int j = 0; j < fspecialCommands.length; j++)
            {
                if (Utilities.isSpecificCommand(command, fspecialCommands[j]))
                {
                    m = p.matcher(command);
                    m.find();
                    double value = Double.parseDouble(m.group(1));
                    Field declaredField = null;
                    try
                    {
                        String fieldName = Utilities.convertLowerCaseUnderscoresToCamelCase(
                                        fspecialCommands[j]);
                        declaredField = KraggFspecial.class.getDeclaredField(fieldName);
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

    public double getMaxGroundSpeed()
    {
        return maxGroundSpeed;
    }

    public double getInitialFallSpeed()
    {
        return initialFallSpeed;
    }

    public double getInitialAerialSpeed()
    {
        return initialAerialSpeed;
    }

    public double getMaxRollTime()
    {
        return maxRollTime;
    }

    public double getMinRollTime()
    {
        return minRollTime;
    }

    public double getRollAccel()
    {
        return rollAccel;
    }

    public double getMinTimeBeforeTurn()
    {
        return minTimeBeforeTurn;
    }

    public double getTurnAccel()
    {
        return turnAccel;
    }
}
