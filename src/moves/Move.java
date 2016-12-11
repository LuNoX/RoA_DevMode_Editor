package moves;

import java.util.List;

import managers.HitboxManager;
import managers.WindowManager;

public class Move
{
    protected String name = null;

    protected List<String> code = null; //TODO think about the consequences of removing this.other, is there a reason to have the copy?

    protected HitboxManager hm = null;
    protected WindowManager wm = null;

    protected boolean isProjectile = false;

    protected List<String> other = null;

    /**
     * Placeholder constructor to avoid errors in all Character classes
     */
    public Move()
    {
        // TODO make this constructor do at least something
    }

    public Move(String name, List<String> code)
    {
        this.code = code;
        this.other = code;
        this.initializeWindows();
        this.initializeHitboxes();
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

    public String getName()
    {
        return name;
    }

    public List<String> getCode()
    {
        return code;
    }

    public List<String> getOther()
    {
        return other;
    }

    public HitboxManager getHm()
    {
        return hm;
    }

    public WindowManager getWm()
    {
        return wm;
    }
}
