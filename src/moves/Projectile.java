package moves;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.CommandStorage;
import utility.Utilities;

public class Projectile extends Move
{
    protected double projectileHSpeed = 0;
    protected double projectileVSpeed = 0;
    protected double projectileGravity = 0;
    protected double projectileLifetime = 0;

    public Projectile(String name, List<String> code)
    {
        super(name, code);
        this.isProjectile = true;
        this.initializeProjectileValues();
    }

    public void initializeProjectileValues()
    {
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.other.size()];

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.other.size(); i++)
        {
            String command = this.other.get(i);

            if (Utilities.isSpecificCommand(command, CommandStorage.projectileHSpeed))
            {
                m = p.matcher(command);
                m.find();
                double value = Double.parseDouble(m.group(1));
                this.projectileHSpeed = value;

                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.projectileVSpeed))
            {
                m = p.matcher(command);
                m.find();
                double value = Double.parseDouble(m.group(1));
                this.projectileVSpeed = value;

                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.projectileGravity))
            {
                m = p.matcher(command);
                m.find();
                double value = Double.parseDouble(m.group(1));
                this.projectileGravity = value;

                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.projectileLifetime))
            {
                m = p.matcher(command);
                m.find();
                double value = Double.parseDouble(m.group(1));
                this.projectileLifetime = value;

                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
        }
        // remove the commands from the code
        Arrays.sort(commandPositions); // sort the indices and then go through the list backwards to
                                       // avoid index errors
        for (int i = numberOfCommands - 1; i >= 0; i--) // dont use commandPositions.length because
                                                        // the Array is far longer than needed
        {
            this.other.remove(commandPositions[i]);
        }
    }
}
