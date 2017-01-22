package moves;

import java.util.List;

import managers.Hitbox;
import managers.HitboxManager;
import managers.WindowManager;

public class AbsaCloudBurst extends CharacterSpecificMove
{

    public AbsaCloudBurst(List<String> code)
    {
        super("CLOUD_BURST", code);
        this.initializeEverything();
    }

    public AbsaCloudBurst()
    {
    }
    
    public void initializeWindows()
    {
        this.windowManager = new WindowManager();
    }
    
    public void initializeHitboxes()
    {
        this.hitboxManager = new HitboxManager();
        this.hitboxManager.setCode(this.other);
        this.hitboxManager.determineNumberOfHitboxes();
        this.hitboxManager.determineNumberOfMultihitboxes();
        String[] specificIds =
        {"charged", "uncharged"};
        this.hitboxManager.createHitboxes(specificIds);

        for (int i = 0; i < specificIds.length; i++)
        {
            for (Hitbox hitbox : this.hitboxManager.getHitboxes())
            {
                int j = i+1;
                String tmp = "" + j;
                if (hitbox.getId().equals(tmp))
                {
                    hitbox.setId(specificIds[i]);
                    hitbox.setHasCustomId(true);
                }
            }
        }
        this.other = hitboxManager.getCodeWithoutHitboxCommands();
    }
}
