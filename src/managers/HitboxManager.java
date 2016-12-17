package managers;

import java.util.regex.*;

import utility.CommandStorage;
import utility.Utilities;

import java.util.*;

public class HitboxManager
{
    protected List<String> code = null;

    protected boolean hasHitboxes = false;
    protected boolean hasMultihitbox = false;
    protected List<Hitbox> hitboxes = new ArrayList<Hitbox>();

    protected int numberOfHitboxes = 0;
    protected int numberOfUniqueHitboxes = 0;
    protected int numberOfFinalHitboxes = 0;
    protected int numberOfMultihitboxes = 0;

    public HitboxManager(List<String> code)
    {
        this.code = code;
        this.determineNumberOfHitboxes();
        this.determineNumberOfMultihitboxes();
        this.createHitboxes();
    }

    public void createHitboxes()
    {
        for (int i = 0; i < this.code.size(); i++)
        {

        }
    }

    public void determineNumberOfHitboxes()
    {
        boolean numHitboxesSaved = false;
        boolean numUniqueHitboxesSaved = false;
        boolean numFinalHitboxesSaved = false;
        int[] commandPositions = new int[3];
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.code.size(); i++)
        {
            String command = this.code.get(i);
            if (Utilities.isSpecificCommand(command, CommandStorage.numHitboxes))
            {
                m = p.matcher(command);
                m.find();

                int numberOfHitboxes = (int) Float.parseFloat(m.group(1));
                this.numberOfHitboxes = numberOfHitboxes;
                if (numberOfHitboxes > 0)
                {
                    this.hasHitboxes = true;
                }
                numHitboxesSaved = true;
                commandPositions[0] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.numUniqueHitboxes))
            {
                m = p.matcher(command);
                m.find();
                int numberOfUniqueHitboxes = (int) Float.parseFloat(m.group(1));
                this.numberOfUniqueHitboxes = numberOfUniqueHitboxes;
                numUniqueHitboxesSaved = true;
                commandPositions[1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.numFinalHitboxes))
            {
                m = p.matcher(command);
                m.find();
                int numberOfFinalHitboxes = (int) Float.parseFloat(m.group(1));
                this.numberOfFinalHitboxes = numberOfFinalHitboxes;
                numFinalHitboxesSaved = true;
                commandPositions[2] = i;
            }
            if (numHitboxesSaved && numUniqueHitboxesSaved && numFinalHitboxesSaved)
            {
                break;
            }
        }

        Arrays.sort(commandPositions);
        for (int i = commandPositions.length - 1; i >= 0; i--)
        {
            this.code.remove(i);
        }
    }

    public void determineNumberOfMultihitboxes()
    {
        if (this.numberOfUniqueHitboxes == this.numberOfHitboxes)
        {
            this.numberOfMultihitboxes = 0;
            this.hasMultihitbox = false;
        }
        else
        {
            int[] parentIds = new int[this.numberOfHitboxes];
            Pattern p = Pattern.compile("\"([^\"]*)\"");
            Matcher m = null;
            for (int i = 0; i < this.code.size(); i++)
            {
                String command = this.code.get(i);
                if (Utilities.isSpecificCommand(command, CommandStorage.parentHitbox))
                {
                    int tmp = command.indexOf(CommandStorage.parentHitbox)
                                    + CommandStorage.parentHitbox.length();
                    int id = Integer.parseInt(command.substring(tmp, tmp + 1));

                    m = p.matcher(command);
                    m.find();
                    int value = (int) Float.parseFloat(m.group(1));

                    parentIds[id - 1] = value;
                }
            }
            int[] numberOfChildrenPerHitbox = new int[this.numberOfHitboxes];
            for (int i = 0; i < parentIds.length; i++)
            {
                numberOfChildrenPerHitbox[parentIds[i] - 1]++;
            }
            int numberOfMultihitboxes = 0;
            for (int i = 0; i < numberOfChildrenPerHitbox.length; i++)
            {
                if (numberOfChildrenPerHitbox[i] > 0)
                {
                    numberOfMultihitboxes++;
                }
            }
            this.numberOfMultihitboxes = numberOfMultihitboxes;
            if (this.numberOfMultihitboxes > 0) //just in case
            {
                this.hasMultihitbox = true;
            }
        }
    }

    public List<String> getCodeWithoutHitboxCommands()
    {
        return this.code;
    }

    public boolean isHasHitboxes()
    {
        return hasHitboxes;
    }

    public List<Hitbox> getHitboxes()
    {
        return hitboxes;
    }

    public int getNumberOfHitboxes()
    {
        return numberOfHitboxes;
    }

    public int getNumberOfUniqueHitboxes()
    {
        return numberOfUniqueHitboxes;
    }

    public int getNumberOfFinalHitboxes()
    {
        return numberOfFinalHitboxes;
    }

    public int getNumberOfMultihitboxes()
    {
        return numberOfMultihitboxes;
    }
}
