package moves;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.CommandStorage;

public class Projectile extends Move
{
    protected float projectileLifetime = 0;
    
    public Projectile (String name,int startPosition, int endPosition, String[] content)
    {
        super(name, startPosition, endPosition, content);
        for (int i = 0; i < this.other.length; i++)
        {
            if (this.other[i].contains(CommandStorage.projectileLifetime))
            {
                Pattern p = Pattern.compile("\"([^\"]*)\"");
                Matcher m = p.matcher(this.other[i]);
                m.find();
                this.projectileLifetime = Float.parseFloat(m.group(1));
                break;
            }
        }
    }
}
