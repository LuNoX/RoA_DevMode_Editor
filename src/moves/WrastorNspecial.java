package moves;

import java.util.List;

import managers.Hitbox;
import managers.HitboxManager;
import utility.CommandStorage;

public class WrastorNspecial extends CharacterSpecificMove
{

    public WrastorNspecial(List<String> code)
    {
        super("NSPECIAL", code);
        this.initializeEverything();
        this.initializeValues();
    }

    public WrastorNspecial()
    {
    }

    public void initializeHitboxes()
    {
        this.hitboxManager = new HitboxManager();
        this.hitboxManager.setCode(this.other);

        int numberOfHitboxes = this.determineNumberOfHitboxes();
        boolean hasHitboxes = false;
        if (numberOfHitboxes > 0)
        {
            hasHitboxes = true;
        }
        int[][] tmp = this.determineMultihitAndFinalIds(numberOfHitboxes);
        int[] multihitIds = tmp[0];
        int[] finalIds = tmp[1];

        this.other = hitboxManager.getCodeWithoutHitboxCommands();
    }

    public void initializeValues()
    {
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
}
