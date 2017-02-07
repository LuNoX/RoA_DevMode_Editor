package model.managers;

import java.util.regex.*;

public class Window
{
    protected String id = "0";

    protected double length = 0;
    protected boolean isCancelable = false;
    protected double windowCancelFrame = 0;
    protected double hBoost = 0;
    protected double vBoost = 0;
    protected double hBoostConst = 0;
    protected double vBoostConst = 0;
    protected double hasSfx = 0;
    protected double sfx = 0;
    protected double sfxFrame = 0;
    protected double whiffFrames = 0;
    protected double invincibility = 0;

    public Window(String id, double length, double windowCancelFrame, double hBoost, double vBoost, double hBoostConst,
                    double vBoostConst, double hasSfx, double sfx, double sfxFrame, double whiffFrames,
                    double invincibility)
    {
        this.id = id;
        this.length = length;
        this.windowCancelFrame = windowCancelFrame;
        this.hBoost = hBoost;
        this.vBoost = vBoost;
        this.hBoostConst = hBoostConst;
        this.vBoostConst = vBoostConst;
        this.hasSfx = hasSfx;
        this.sfx = sfx;
        this.sfxFrame = sfxFrame;
        this.whiffFrames = whiffFrames;
        this.invincibility = invincibility;
        
        if(this.windowCancelFrame > 0)
        {
            this.isCancelable = true;
        }
    }

    public Window(String id, String length, String windowCancelFrame, String hBoost, String vBoost, String hBoostConst,
                    String vBoostConst, String hasSfx, String sfx, String sfxFrames,
                    String whiffFrames, String invincibility)
    {
        this.id = id;
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        m = p.matcher(length);
        m.find();
        this.length = Double.parseDouble(m.group(1));
        
        m = p.matcher(windowCancelFrame);
        m.find();
        this.length = Double.parseDouble(m.group(1));

        m = p.matcher(hBoost);
        m.find();
        this.hBoost = Double.parseDouble(m.group(1));

        m = p.matcher(vBoost);
        m.find();
        this.vBoost = Double.parseDouble(m.group(1));

        m = p.matcher(hBoostConst);
        m.find();
        this.hBoostConst = Double.parseDouble(m.group(1));

        m = p.matcher(vBoostConst);
        m.find();
        this.vBoostConst = Double.parseDouble(m.group(1));

        m = p.matcher(hasSfx);
        m.find();
        this.hasSfx = Double.parseDouble(m.group(1));

        m = p.matcher(sfx);
        m.find();
        this.sfx = Double.parseDouble(m.group(1));

        m = p.matcher(sfxFrames);
        m.find();
        this.sfxFrame = Double.parseDouble(m.group(1));

        m = p.matcher(whiffFrames);
        m.find();
        this.whiffFrames = Double.parseDouble(m.group(1));

        m = p.matcher(invincibility);
        m.find();
        this.invincibility = Double.parseDouble(m.group(1));
        
        if(this.windowCancelFrame > 0)
        {
            this.isCancelable = true;
        }
    }

    public String getId()
    {
        return id;
    }

    public double getLength()
    {
        return length;
    }

    public double gethBoost()
    {
        return hBoost;
    }

    public double getvBoost()
    {
        return vBoost;
    }

    public double gethBoostConst()
    {
        return hBoostConst;
    }

    public double getvBoostConst()
    {
        return vBoostConst;
    }

    public double getHasSfx()
    {
        return hasSfx;
    }

    public double getSfx()
    {
        return sfx;
    }

    public double getSfxFrame()
    {
        return sfxFrame;
    }

    public double getWhiffFrames()
    {
        return whiffFrames;
    }

    public double getInvincibility()
    {
        return invincibility;
    }
}
