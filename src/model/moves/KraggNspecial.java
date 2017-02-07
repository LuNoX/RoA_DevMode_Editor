package model.moves;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.managers.HitboxManager;
import model.utility.CommandStorage;
import model.utility.Utilities;

public class KraggNspecial extends CharacterSpecificMove
{
    protected double rockHealth = 0;

    public KraggNspecial()
    {
    }

    public KraggNspecial(List<String> code)
    {
        super("NSPECIAL", code);
        this.initializeEverything();
    }


    public void initializeHitboxes()
    {
        this.hitboxManager = new HitboxManager();
        this.hitboxManager.setCode(this.other);
        this.hitboxManager.setHasHitbox(true);
        this.hitboxManager.setHasMultihitbox(false);
        this.hitboxManager.setNumberOfFinalHitboxes(0);
        this.hitboxManager.setNumberOfHitboxes(1);
        this.hitboxManager.setNumberOfMultihitboxes(0);
        this.hitboxManager.setNumberOfUniqueHitboxes(1);
        this.hitboxManager.createHitboxes("_debris");
        this.hitboxManager.getHitboxes().get(0).setId("debris");
        this.hitboxManager.getHitboxes().get(0).setHasCustomId(true);
        this.other = hitboxManager.getCodeWithoutHitboxCommands();
    }
    
    public void initializeOtherValues()
    {
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.other.size()];

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.other.size(); i++)
        {
            String command = this.other.get(i);

            if (Utilities.isSpecificCommand(command, CommandStorage.hasCooldown))
            {
                m = p.matcher(command);
                m.find();
                double value = Double.parseDouble(m.group(1));
                if (value > 0)
                {
                    this.hasCooldown = true;
                }

                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.cooldown))
            {
                m = p.matcher(command);
                m.find();
                double value = Double.parseDouble(m.group(1));
                this.cooldown = value;

                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.hasWhiffLanding))
            {
                m = p.matcher(command);
                m.find();
                double value = Double.parseDouble(m.group(1));
                this.isHasWhiffLanding = true;
                this.hasWhiffLanding = value;

                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.autocancelFrame))
            {
                m = p.matcher(command);
                m.find();
                double value = Double.parseDouble(m.group(1));
                this.isAutocancelable = true;
                this.autocancelFrame = value;

                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.landingLag))
            {
                m = p.matcher(command);
                m.find();
                double value = Double.parseDouble(m.group(1));
                this.isAutocancelable = true;
                this.landingLag = value;

                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if(Utilities.isSpecificCommand(command, CommandStorage.rockHealth))
            {
                m = p.matcher(command);
                m.find();
                double value = Double.parseDouble(m.group(1));
                this.rockHealth = value;

                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
        }

        // remove the commands from the code
        Arrays.sort(commandPositions); // sort the indices and then go through the list backwards to
                                       // avoid index errors
        for (int i = 1; i <= numberOfCommands; i++) // dont use commandPositions.length because
        // the Array is far longer than needed
        {
            this.other.remove(commandPositions[commandPositions.length - i]);
        }
    }

    public double getRockHealth()
    {
        return rockHealth;
    }


}
