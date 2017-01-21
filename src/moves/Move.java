package moves;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import managers.HitboxManager;
import managers.WindowManager;
import utility.CommandStorage;
import utility.Utilities;

public class Move
{
    protected String name = "";

    protected List<String> code = new ArrayList<String>(); // TODO think about the consequences of removing this.other,
                                        // is there a reason to have the copy?

    protected HitboxManager hm = new HitboxManager();
    protected WindowManager wm = null;

    protected boolean hasCooldown = false;
    protected double cooldown = 0;
    protected boolean isAutocancelable = false;
    protected double autocancelFrame = 0;
    protected double landingLag = 0;
    protected boolean isHasWhiffLanding = false;
    protected double hasWhiffLanding = 0;
    //TODO add armor

    protected List<String> other = new ArrayList<String>();

    public Move()
    {     
    }

    public Move(String name, List<String> code)
    {
        this.name = name;
        this.code = code;
        this.other = code;
        this.initializeWindows();
        this.initializeHitboxes();
        this.initializeOtherValues();
    }

    public void initializeWindows()
    {
        this.wm = new WindowManager(this.other);
        this.other = wm.getCodeWithoutWindowCommands();
    }

    public void initializeHitboxes()
    {
        this.hm = new HitboxManager(this.other);
        this.other = hm.getCodeWithoutHitboxCommands();
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

    public String getName()
    {
        return name;
    }

    public List<String> getCode()
    {
        return this.code;
    }

    public List<String> getOther()
    {
        return this.other;
    }

    public HitboxManager getHm()
    {
        return hm;
    }

    public WindowManager getWm()
    {
        return wm;
    }

    public boolean isHasCooldown()
    {
        return hasCooldown;
    }

    public double getCooldown()
    {
        return cooldown;
    }

    public boolean isAutocancelable()
    {
        return isAutocancelable;
    }

    public double getAutocancelFrame()
    {
        return autocancelFrame;
    }

    public double getLandingLag()
    {
        return landingLag;
    }
}
