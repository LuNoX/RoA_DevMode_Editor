package managers;

import java.util.regex.*;
import java.util.*;

public class HitboxManager
{
    protected List<String> code = null;

    protected boolean hasHitboxes = false;
    protected List<Hitbox> hitboxes = new ArrayList<Hitbox>();

    protected int numberOfUniqueHitboxes = 0;
    protected int numberOfMultihitboxes = 0;

    public HitboxManager(List<String> code)
    {
        this.code = code;
        this.determineNumberOfHitboxes();
        this.determineNumberOfMultihitboxes();
        this.createHitboxes();
    }
    
    public void createHitboxes ()
    {
        for (int i = 0; i < this.code.size(); i++)
        {
            
        }
    }
    
    //TODO think about removing these methods
    public void determineNumberOfHitboxes()
    {
        for (int i = 0; i < this.code.size(); i++)
        {
            String command = this.code.get(i);
            if (command.contains("num_hitboxes"))
            {
                Pattern p = Pattern.compile("\"([^\"]*)\"");
                Matcher m = p.matcher(command);
                m.find();

                int numberOfHitboxes = (int) Float.parseFloat(m.group(1));
                if (numberOfHitboxes > 0)
                {
                    this.hasHitboxes = true;
                }
                this.code.remove(i);
                break;
            }
        }
    }

    public void determineNumberOfMultihitboxes()
    {
        for (int i = 0; i < this.code.size(); i++)
        {
            String command = this.code.get(i);
            if (command.contains("num_unique_hitboxes"))
            {
                Pattern p = Pattern.compile("\"([^\"]*)\"");
                Matcher m = p.matcher(command);
                m.find();

                this.numberOfUniqueHitboxes = (int) Float.parseFloat(m.group(1));
                if (!(this.numberOfUniqueHitboxes == this.hitboxes.size()))
                {
                    return; // no multihitboxes
                }
                this.code.remove(i);
                break; // there are multihitboxes
            }
        }
        // determine how many multihitboxes there are

        // TO-DO: calculate number of multihitboxes
    }

    public List<String> getCodeWithoutHitboxCommands()
    {
        return this.code;
    }
}
