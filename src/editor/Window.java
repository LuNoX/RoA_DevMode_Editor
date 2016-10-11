package editor;

import java.util.regex.*;

public class Window
{
	protected String id = "0";

	protected float length = 0;
	protected float hBoost = 0;
	protected float vBoost = 0;
	protected float hBoostConst = 0;
	protected float vBoostConst = 0;
	protected float hasSfx = 0;
	protected float sfx = 0;
	protected float sfxFrame = 0;
	protected float whiffFrames = 0;
	protected float invincibility = 0;

	public Window(String id, String length, String hBoost, String vBoost, String hBoostConst, String vBoostConst, String hasSfx, String sfx, String sfxFrames, String whiffFrames, String invincibility)
	{
		this.id = id;
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		Matcher m = null;

		m = p.matcher(length);
		m.find();
		this.length = Float.parseFloat(m.group(1));

		m = p.matcher(hBoost);
		m.find();
		this.hBoost = Float.parseFloat(m.group(1));

		m = p.matcher(vBoost);
		m.find();
		this.vBoost = Float.parseFloat(m.group(1));

		m = p.matcher(hBoostConst);
		m.find();
		this.hBoostConst = Float.parseFloat(m.group(1));

		m = p.matcher(vBoostConst);
		m.find();
		this.vBoostConst = Float.parseFloat(m.group(1));

		m = p.matcher(hasSfx);
		m.find();
		this.hasSfx = Float.parseFloat(m.group(1));

		m = p.matcher(sfx);
		m.find();
		this.sfx = Float.parseFloat(m.group(1));

		m = p.matcher(sfxFrames);
		m.find();
		this.sfxFrame = Float.parseFloat(m.group(1));

		m = p.matcher(whiffFrames);
		m.find();
		this.whiffFrames = Float.parseFloat(m.group(1));

		m = p.matcher(invincibility);
		m.find();
		this.invincibility = Float.parseFloat(m.group(1));
	}

	public String getId()
	{
		return id;
	}

	public float getLength()
	{
		return length;
	}

	public float gethBoost()
	{
		return hBoost;
	}

	public float getvBoost()
	{
		return vBoost;
	}

	public float gethBoostConst()
	{
		return hBoostConst;
	}

	public float getvBoostConst()
	{
		return vBoostConst;
	}

	public float getHasSfx()
	{
		return hasSfx;
	}

	public float getSfx()
	{
		return sfx;
	}

	public float getSfxFrame()
	{
		return sfxFrame;
	}

	public float getWhiffFrames()
	{
		return whiffFrames;
	}

	public float getInvincibility()
	{
		return invincibility;
	}
}
