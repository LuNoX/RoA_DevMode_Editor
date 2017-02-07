package model.moves;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.managers.HitboxManager;
import model.utility.CommandStorage;
import model.utility.Utilities;

public class WrastorNspecial extends CharacterSpecificMove
{
    protected double timeBetweenMultihitLoops = 0;
    protected double riseAcceleration = 0;
    protected double maxRiseSpeed = 0;
    protected double maxSpinTime = 0;
    protected double minSpinTime = 0;
    
    
    public WrastorNspecial(List<String> code)
    {
        super("NSPECIAL", code);
        this.initializeValues();
        this.initializeEverything();
    }

    public WrastorNspecial()
    {
    }

    public void initializeHitboxes()
    {
        this.hitboxManager = new HitboxManager();

        int numberOfHitboxes = this.determineNumberOfHitboxes();
        boolean hasHitboxes = false;
        boolean hasMultihits = false;
        if (numberOfHitboxes > 0)
        {
            hasHitboxes = true;
            hasMultihits = true;
        }
        int[][] tmp = this.determineMultihitAndFinalIds(numberOfHitboxes);
        int[] multihitIds = tmp[0];
        int[] finalIds = tmp[1];
        
        this.hitboxManager.setCode(this.other);
        this.hitboxManager.setHasHitbox(hasHitboxes);
        this.hitboxManager.setNumberOfHitboxes(numberOfHitboxes);
        this.hitboxManager.setNumberOfUniqueHitboxes(numberOfHitboxes);
        this.hitboxManager.setHasMultihitbox(hasMultihits);
        this.hitboxManager.setNumberOfMultihitboxes(multihitIds.length);
        this.hitboxManager.setNumberOfFinalHitboxes(finalIds.length);
        this.hitboxManager.setFinalIds(finalIds);
        this.hitboxManager.setMultihitIds(multihitIds);
        
        this.hitboxManager.createHitboxes();

        this.other = hitboxManager.getCodeWithoutHitboxCommands();
    }

    public void initializeValues()
    {
        String[] nspecialCommands = CommandStorage.wrastorNspecialCommands;
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.other.size()];

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.other.size(); i++)
        {
            String command = this.other.get(i);
            for (int j = 0; j < nspecialCommands.length; j++)
            {
                if (Utilities.isSpecificCommand(command, nspecialCommands[j]))
                {
                    m = p.matcher(command);
                    m.find();
                    double value = Double.parseDouble(m.group(1));
                    Field declaredField = null;
                    try
                    {
                        String fieldName = Utilities.convertLowerCaseUnderscoresToCamelCase(
                                        nspecialCommands[j]);
                        declaredField = WrastorNspecial.class.getDeclaredField(fieldName);
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

    public int determineNumberOfHitboxes()
    {
        int numberOfHitboxes = 0;
        boolean hasMoreThanOneHitbox = false;
        for (String command : this.other)
        {
            if (command.contains(CommandStorage.hitboxLifetime))
            {
                String specificCommand = CommandStorage.hitboxLifetime + "_";
                if (command.contains(specificCommand))
                {
                    int tmp = command.indexOf(specificCommand) + specificCommand.length();
                    numberOfHitboxes = Integer.parseInt(command.substring(tmp, tmp + 1));
                    hasMoreThanOneHitbox = true;
                }
                else
                {
                    numberOfHitboxes = 1;
                }
                break;
            }
        }

        if (hasMoreThanOneHitbox)
        {
            String specificCommand = CommandStorage.hitboxLifetime + "_";
            for (String command : this.other)
            {
                if (command.contains(specificCommand))
                {
                    int tmp = command.indexOf(specificCommand) + specificCommand.length();
                    int id = Integer.parseInt(command.substring(tmp, tmp + 1));
                    if (id > numberOfHitboxes)
                    {
                        numberOfHitboxes = id;
                    }
                }
            }
        }
        return numberOfHitboxes;
    }

    public int[][] determineMultihitAndFinalIds(int numberOfHitboxes)
    {
        int numberOfMultihits = 0;
        int numberOfFinals = 0;
        if (numberOfHitboxes <= 1)
        {
            numberOfMultihits = numberOfHitboxes;
        }
        else
        {
            String multihitCommand = "multihit_";
            String finalCommand = "final_";
            for (String command : this.other)
            {
                if (command.contains(multihitCommand))
                {
                    int tmp = command.indexOf(multihitCommand) + multihitCommand.length();
                    int id = Integer.parseInt(command.substring(tmp, tmp + 1));
                    if (id > numberOfMultihits)
                    {
                        numberOfMultihits = id;
                    }
                }
                else if (command.contains(finalCommand))
                {
                    int tmp = command.indexOf(finalCommand) + finalCommand.length();
                    int id = Integer.parseInt(command.substring(tmp, tmp + 1));
                    if (id > numberOfFinals)
                    {
                        numberOfFinals = id;
                    }
                }
            }
        }

        int[] multihitIds = new int[numberOfMultihits];
        for(int i = 0; i < numberOfMultihits; i++)
        {
            multihitIds[i] = i+1;
        }
        int[] finalIds = new int[numberOfFinals];
        for(int i = 0; i < numberOfFinals; i++)
        {
            finalIds[i] = i+1+numberOfMultihits;
        }

        int[][] result = {multihitIds, finalIds};
        return result;
    }

    public double getTimeBetweenMultihitLoops()
    {
        return timeBetweenMultihitLoops;
    }

    public double getRiseAcceleration()
    {
        return riseAcceleration;
    }

    public double getMaxRiseSpeed()
    {
        return maxRiseSpeed;
    }

    public double getMaxSpinTime()
    {
        return maxSpinTime;
    }

    public double getMinSpinTime()
    {
        return minSpinTime;
    }
}
