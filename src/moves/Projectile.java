package moves;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.CommandStorage;

public class Projectile extends Move
{
    protected float projectileHSpeed = 0;
    protected float projectileVSpeed = 0;
    protected float projectileGravity = 0;
    protected float projectileLifetime = 0;

    public Projectile(String name, int startPosition, int endPosition, String[] content)
    {
        super(name, startPosition, endPosition, content);
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.other.length; i++)
        {
            if (this.other[i].contains(CommandStorage.projectileHSpeed))
            {
                m = p.matcher(this.other[i]);
                m.find();
                this.projectileLifetime = Float.parseFloat(m.group(1));
            }
            else if (this.other[i].contains(CommandStorage.projectileVSpeed))
            {
                m = p.matcher(this.other[i]);
                m.find();
                this.projectileLifetime = Float.parseFloat(m.group(1));
            }
            else if (this.other[i].contains(CommandStorage.projectileGravity))
            {
                m = p.matcher(this.other[i]);
                m.find();
                this.projectileLifetime = Float.parseFloat(m.group(1));
            }
            if (this.other[i].contains(CommandStorage.projectileLifetime))
            {
                m = p.matcher(this.other[i]);
                m.find();
                this.projectileLifetime = Float.parseFloat(m.group(1));
            }
        }
    }
}
