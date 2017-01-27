package managers;

import java.util.regex.*;

import utility.CommandStorage;
import utility.Utilities;

import java.util.*;

public class HitboxManager
{
    // TODO add "other"-field
    protected List<String> code = new ArrayList<String>();

    protected boolean hasHitbox = false;
    protected boolean hasMultihitbox = false;
    protected List<Hitbox> hitboxes = new ArrayList<Hitbox>();

    protected int numberOfHitboxes = 0;
    protected int numberOfUniqueHitboxes = 0;
    protected int numberOfFinalHitboxes = 0;
    protected int numberOfMultihitboxes = 0;

    protected int[] multihitIds = new int[0];
    protected int[] finalIds = new int[0];

    public HitboxManager()
    {
    }

    public HitboxManager(List<String> code)
    {
        this.code = code;
        this.initializeEverything();
    }

    public void initializeEverything()
    {
        this.determineNumberOfHitboxes();
        this.determineNumberOfMultihitboxes();
        this.createHitboxes();
    }

    public void createHitboxes()
    {
        String append = "_";
        if (this.numberOfHitboxes == 1)
        {
            append = "";
        }
        this.createHitboxes(append);
    }

    public void createHitboxes(String specificAppend)
    {
        String[] tmp = new String[0];
        this.createHitboxes(specificAppend, tmp);
    }

    public void createHitboxes(String[] specificIds)
    {
        String append = "_";
        if (this.numberOfHitboxes == 1)
        {
            append = "";
        }
        this.createHitboxes(append, specificIds);
    }

    public void createHitboxes(String specificAppend, String[] specificIds)
    {
        // TODO instead of messing around with TempHitboxes just create a hitbox and then set the
        // values afterwards, rest is going to stay default
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.code.size()];
        String append = specificAppend;

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        String[][] tempHitboxes = Utilities.generateTempHitboxes(this.numberOfHitboxes);

        for (int i = 0; i < this.code.size(); i++)
        {
            String command = this.code.get(i);

            for (int j = 0; j < CommandStorage.hitboxCommands.length; j++)
            {
                String specificCommand = CommandStorage.hitboxCommands[j] + append;
                if (Utilities.isSpecificCommand(command, CommandStorage.hitboxCommands[j]))
                {
                    m = p.matcher(command);
                    m.find();
                    String value = "\"" + m.group(1) + "\"";
                    if (this.hasMultihitbox && CommandStorage.isMultihitOrFinalCommand[j])
                    {
                        int[] respectiveHitboxIds = this.multihitIds;
                        String additionalAppend = "multihit_";
                        if (command.contains("final"))
                        {
                            respectiveHitboxIds = this.finalIds;
                            additionalAppend = "final_";
                        }

                        if (respectiveHitboxIds.length > 1)
                        {
                            int id = 1;
                            if (this.numberOfHitboxes > 0)
                            {
                                int tmp = command.indexOf(specificCommand + additionalAppend)
                                                + (specificCommand + additionalAppend).length();
                                id = Integer.parseInt(command.substring(tmp, tmp + 1));
                            }
                            tempHitboxes[respectiveHitboxIds[id - 1] - 1][j] = value;
                        }
                        else
                        {
                            tempHitboxes[respectiveHitboxIds[0] - 1][j] = value;
                        }

                    }
                    else
                    {
                        int tmp = command.indexOf(specificCommand) + specificCommand.length();
                        int id = 1;
                        if (this.numberOfHitboxes > 1)
                        {
                            boolean hasSpecificId = false;
                            for (int k = 0; k < specificIds.length; k++)
                            {
                                if (command.substring(tmp, tmp + specificIds[k].length()).equals(
                                                specificIds[k]))
                                // possible bug if some specificIds are substrings of others
                                {
                                    hasSpecificId = true;
                                    id = k + 1;
                                    break;
                                }
                            }

                            if (!hasSpecificId)
                            {
                                id = Integer.parseInt(command.substring(tmp, tmp + 1));
                            }
                        }
                        tempHitboxes[id - 1][j] = value;
                    }
                    numberOfCommands++;
                    commandPositions[numberOfCommands - 1] = i;
                    break;
                }
            }
        }
        // create Hitboxes
        for (int i = 0; i < tempHitboxes.length; i++)
        {
            Hitbox hitbox = new Hitbox(tempHitboxes[i]);
            this.hitboxes.add(hitbox);
        }
        // remove everything related to the Hitboxes from the code
        Arrays.sort(commandPositions); // sort the indices and then go through the list backwards to
                                       // avoid index errors
        for (int i = 1; i <= numberOfCommands; i++) // dont use commandPositions.length because
        // the Array is far longer than needed
        {
            this.code.remove(commandPositions[commandPositions.length - i]);
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

                int numberOfHitboxes = (int) Double.parseDouble(m.group(1));
                this.numberOfHitboxes = numberOfHitboxes;
                if (numberOfHitboxes > 0)
                {
                    this.hasHitbox = true;
                }
                numHitboxesSaved = true;
                commandPositions[0] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.numUniqueHitboxes))
            {
                m = p.matcher(command);
                m.find();
                int numberOfUniqueHitboxes = (int) Double.parseDouble(m.group(1));
                this.numberOfUniqueHitboxes = numberOfUniqueHitboxes;
                numUniqueHitboxesSaved = true;
                commandPositions[1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.numFinalHitboxes))
            {
                m = p.matcher(command);
                m.find();
                int numberOfFinalHitboxes = (int) Double.parseDouble(m.group(1));
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
            this.code.remove(commandPositions[i]);
        }
    }

    public void determineNumberOfMultihitboxes()
    {
        if (this.numberOfUniqueHitboxes == this.numberOfHitboxes)
        {
            this.numberOfMultihitboxes = 0;
            this.hasMultihitbox = false;
            this.determineMultihitAndFinalIds(new int[0]);
        }
        else if (this.numberOfHitboxes == 1)
        {
            this.numberOfMultihitboxes = 0;
            this.hasMultihitbox = false;
            this.determineMultihitAndFinalIds(new int[0]);
        }
        else if (this.numberOfUniqueHitboxes == 1)
        {
            this.numberOfMultihitboxes = 1;
            this.hasMultihitbox = true;
            int[] numberOfChildrenPerHitbox = new int[this.numberOfHitboxes];
            numberOfChildrenPerHitbox[0] = this.numberOfHitboxes;
            this.determineMultihitAndFinalIds(numberOfChildrenPerHitbox);
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
                    int tmp = command.indexOf(CommandStorage.parentHitbox + "_")
                                    + (CommandStorage.parentHitbox + "_").length();
                    int id = Integer.parseInt(command.substring(tmp, tmp + 1));

                    m = p.matcher(command);
                    m.find();
                    int value = (int) Double.parseDouble(m.group(1));

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
            this.numberOfMultihitboxes = numberOfMultihitboxes - this.numberOfFinalHitboxes;
            if (this.numberOfMultihitboxes > 0) // just in case
            {
                this.hasMultihitbox = true;
            }

            this.determineMultihitAndFinalIds(numberOfChildrenPerHitbox);
        }
    }

    public void determineMultihitAndFinalIds(int[] numberOfChildrenPerHitbox)
    {
        int[] multihitIds = new int[this.numberOfMultihitboxes];
        int[] finalIds = new int[this.numberOfFinalHitboxes];

        int tmp = 0;

        for (int i = 0; i < numberOfChildrenPerHitbox.length; i++)
        {
            if (numberOfChildrenPerHitbox[i] > 0)
            {
                if (tmp < multihitIds.length)
                {
                    multihitIds[tmp] = i + 1;
                    tmp++;
                }
                else
                {
                    finalIds[tmp - multihitIds.length] = i + 1;
                    tmp++;
                }
            }
        }
        this.multihitIds = multihitIds;
        this.finalIds = finalIds;
    }

    public List<String> getCodeWithoutHitboxCommands()
    {
        return this.code;
    }

    public boolean isHasHitboxes()
    {
        return hasHitbox;
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

    public int[] getMultihitIds()
    {
        return multihitIds;
    }

    public int[] getFinalIds()
    {
        return finalIds;
    }

    public List<String> getCode()
    {
        return code;
    }

    public boolean isHasHitbox()
    {
        return hasHitbox;
    }

    public boolean isHasMultihitbox()
    {
        return hasMultihitbox;
    }

    public void setNumberOfHitboxes(int numberOfHitboxes)
    {
        this.numberOfHitboxes = numberOfHitboxes;
    }

    public void setNumberOfUniqueHitboxes(int numberOfUniqueHitboxes)
    {
        this.numberOfUniqueHitboxes = numberOfUniqueHitboxes;
    }

    public void setNumberOfFinalHitboxes(int numberOfFinalHitboxes)
    {
        this.numberOfFinalHitboxes = numberOfFinalHitboxes;
    }

    public void setNumberOfMultihitboxes(int numberOfMultihitboxes)
    {
        this.numberOfMultihitboxes = numberOfMultihitboxes;
    }

    public void setCode(List<String> code)
    {
        this.code = code;
    }

    public void setHasHitbox(boolean hasHitbox)
    {
        this.hasHitbox = hasHitbox;
    }

    public void setHasMultihitbox(boolean hasMultihitbox)
    {
        this.hasMultihitbox = hasMultihitbox;
    }

    public void setMultihitIds(int[] multihitIds)
    {
        this.multihitIds = multihitIds;
    }

    public void setFinalIds(int[] finalIds)
    {
        this.finalIds = finalIds;
    }
}
