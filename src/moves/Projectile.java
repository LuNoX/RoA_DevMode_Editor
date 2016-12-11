package moves;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.CommandStorage;

public class Projectile extends Move
{
    protected float projectileHSpeed = 0;
    protected float projectileVSpeed = 0;
    protected float projectileGravity = 0;
    protected float projectileLifetime = 0;

    public Projectile(String name, List<String> code)
    {
        super(name, code);
        this.isProjectile = true;

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (String command: this.other)
        {
            if (command.contains(CommandStorage.projectileHSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.projectileLifetime = Float.parseFloat(m.group(1));
            }
            else if (command.contains(CommandStorage.projectileVSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.projectileLifetime = Float.parseFloat(m.group(1));
            }
            else if (command.contains(CommandStorage.projectileGravity))
            {
                m = p.matcher(command);
                m.find();
                this.projectileLifetime = Float.parseFloat(m.group(1));
            }
            if (command.contains(CommandStorage.projectileLifetime))
            {
                m = p.matcher(command);
                m.find();
                this.projectileLifetime = Float.parseFloat(m.group(1));
            }
        }
    }
}
