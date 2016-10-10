package editor;
import java.util.regex.*;


public class Window
{
	protected String id = "0";
	protected String length = "window_length_" + id + "=";
	protected String hBoost = "window_h_boost_" + id + "=";
	protected String vBoost = "window_v_boost_" + id + "=";
	protected String hBoostConst = "window_h_boost_is_const_" + id + "=";
	protected String vBoostConst = "window_b_boost_is_const_" + id + "=";
	protected String hasSfx = "window_has_sfx_" + id + "=";
	protected String sfx = "window_sfx_" + id + "=";
	protected String sfxFrame = "window_sfx_frame_" + id + "=";
	protected String whiffFrames = "window_whiff_frames_" + id + "=";
	protected String invincibility = "invincibility_" + id + "=";
	
	protected float lengthValue = 0;
	protected float hBoostValue = 0;
	protected float vBoostValue = 0;
	protected float hBoostConstValue = 0;
	protected float vBoostConstValue = 0;
	protected float hasSfxValue = 0;
	protected float sfxValue = 0;
	protected float sfxFrameValue = 0;
	protected float whiffFramesValue = 0;
	protected float invincibilityValue = 0;
	
	public Window (String id, String length, String hBoost, String vBoost, String hBoostConst, String vBoostConst, String hasSfx, String sfx, String sfxFrames, String whiffFrames, String invincibility)
	{
		this.id = id;
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		Matcher m = null;
		
		m = p.matcher(length);
		m.find();
		this.lengthValue = Float.parseFloat(m.group(1));
		
		m = p.matcher(hBoost);
		m.find();
		this.hBoostValue = Float.parseFloat(m.group(1));
		
		m = p.matcher(vBoost);
		m.find();
		this.vBoostValue = Float.parseFloat(m.group(1));
		
		m = p.matcher(hBoostConst);
		m.find();
		this.hBoostConstValue = Float.parseFloat(m.group(1));
		
		m = p.matcher(vBoostConst);
		m.find();
		this.vBoostConstValue = Float.parseFloat(m.group(1));
		
		m = p.matcher(hasSfx);
		m.find();
		this.hasSfxValue = Float.parseFloat(m.group(1));
		
		m = p.matcher(sfx);
		m.find();
		this.sfxValue = Float.parseFloat(m.group(1));
		
		m = p.matcher(sfxFrames);
		m.find();
		this.sfxFrameValue = Float.parseFloat(m.group(1));
		
		m = p.matcher(whiffFrames);
		m.find();
		this.whiffFramesValue = Float.parseFloat(m.group(1));
		
		m = p.matcher(invincibility);
		m.find();
		this.invincibilityValue = Float.parseFloat(m.group(1));
	}

	public String getId()
	{
		return id;
	}

	public String getLength()
	{
		return length;
	}

	public String gethBoost()
	{
		return hBoost;
	}

	public String getvBoost()
	{
		return vBoost;
	}

	public String gethBoostConst()
	{
		return hBoostConst;
	}

	public String getvBoostConst()
	{
		return vBoostConst;
	}

	public String getHasSfx()
	{
		return hasSfx;
	}

	public String getSfx()
	{
		return sfx;
	}

	public String getSfxFrame()
	{
		return sfxFrame;
	}

	public String getWhiffFrames()
	{
		return whiffFrames;
	}

	public String getInvincibility()
	{
		return invincibility;
	}

	public float getLengthValue()
	{
		return lengthValue;
	}

	public float gethBoostValue()
	{
		return hBoostValue;
	}

	public float getvBoostValue()
	{
		return vBoostValue;
	}

	public float gethBoostConstValue()
	{
		return hBoostConstValue;
	}

	public float getvBoostConstValue()
	{
		return vBoostConstValue;
	}

	public float getHasSfxValue()
	{
		return hasSfxValue;
	}

	public float getSfxValue()
	{
		return sfxValue;
	}

	public float getSfxFrameValue()
	{
		return sfxFrameValue;
	}

	public float getWhiffFramesValue()
	{
		return whiffFramesValue;
	}

	public float getInvincibilityValue()
	{
		return invincibilityValue;
	}
}
