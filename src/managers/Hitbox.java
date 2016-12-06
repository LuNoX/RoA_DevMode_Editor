package managers;

public class Hitbox
{
	protected String id = null;
	
	protected float parentHitbox = 0;
	protected float hitboxWindow = 0;
	protected float hitboxWindowCreationFrame = 0;
	protected float hitboxLifetime = 0;
	protected float baseKnockback = 0;
	protected float knockbackScaling = 0;
	protected float knockbackAngle = 0;
	protected float angleFlipper = 0;
	protected float damage = 0;
	protected float hitboxSizeX = 0;
	protected float hitboxSizeY = 0;
	protected float hitboxPositionX = 0;
	protected float hitboxPositionY = 0;
	protected float hitEffect = 0;
	protected float asdiModifier = 0;
	protected float hitstunModifier = 0;
	protected float untechable = 0;
	protected float priority = 0;
	protected float baseHitpause = 0;
	protected float hitpauseScaling = 0;
	protected float visualEffect = 0;
	protected float visualEffectXOffset = 0;
	protected float visualEffectYOffset = 0;
	protected float hitSoundEffect = 0;
	protected float extraCameraShake = 0;
	protected float canKillProjectiles = 0;
	protected float hitLockoutTime = 0;
	protected float causesExtendedParryStun = 0;
	protected float forceFlinch = 0;
	protected float hitboxShape = 0;
	
	public Hitbox(String id, float parentHitbox, float hitboxWindow, float hitboxWindowCreationFrame, float hitboxLifetime, float baseKnockback, float knockbackScaling, float knockbackAngle, float angleFlipper, float damage, float hitboxSizeX, float hitboxSizeY, float hitboxPositionX, float hitboxPositionY, float hitEffect, float asdiModifier, float hitstunModifier, float untechable, float priority, float baseHitpause, float hitpauseScaling, float visualEffect, float visualEffectXOffset, float visualEffectYOffset, float hitSoundEffect, float extraCameraShake, float canKillProjectiles, float hitLockoutTime, float causesExtendedParryStun, float forceFlinch, float hitboxShape)
	{
		this.id = id;
		this.parentHitbox = parentHitbox;
		this.hitboxWindow = hitboxWindow;
		this.hitboxWindowCreationFrame = hitboxWindowCreationFrame;
		this.hitboxLifetime = hitboxLifetime;
		this.baseKnockback = baseKnockback;
		this.knockbackScaling = knockbackScaling;
		this.knockbackAngle = knockbackAngle;
		this.angleFlipper = angleFlipper;
		this.damage = damage;
		this.hitboxSizeX = hitboxSizeX;
		this.hitboxSizeY = hitboxSizeY;
		this.hitboxPositionX = hitboxPositionX;
		this.hitboxPositionY = hitboxPositionY;
		this.hitEffect = hitEffect;
		this.asdiModifier = asdiModifier;
		this.hitstunModifier = hitstunModifier;
		this.untechable = untechable;
		this.priority = priority;
		this.baseHitpause = baseHitpause;
		this.hitpauseScaling = hitpauseScaling;
		this.visualEffect = visualEffect;
		this.visualEffectXOffset = visualEffectXOffset;
		this.visualEffectYOffset = visualEffectYOffset;
		this.hitSoundEffect = hitSoundEffect;
		this.extraCameraShake = extraCameraShake;
		this.canKillProjectiles = canKillProjectiles;
		this.hitLockoutTime = hitLockoutTime;
		this.causesExtendedParryStun = causesExtendedParryStun;
		this.forceFlinch = forceFlinch;
		this.hitboxShape = hitboxShape;
	}

	public String getId()
	{
		return id;
	}

	public float getParentHitbox()
	{
		return parentHitbox;
	}

	public float getHitboxWindow()
	{
		return hitboxWindow;
	}

	public float getHitboxWindowCreationFrame()
	{
		return hitboxWindowCreationFrame;
	}

	public float getHitboxLifetime()
	{
		return hitboxLifetime;
	}

	public float getBaseKnockback()
	{
		return baseKnockback;
	}

	public float getKnockbackScaling()
	{
		return knockbackScaling;
	}

	public float getKnockbackAngle()
	{
		return knockbackAngle;
	}

	public float getAngleFlipper()
	{
		return angleFlipper;
	}

	public float getDamage()
	{
		return damage;
	}

	public float getHitboxSizeX()
	{
		return hitboxSizeX;
	}

	public float getHitboxSizeY()
	{
		return hitboxSizeY;
	}

	public float getHitboxPositionX()
	{
		return hitboxPositionX;
	}

	public float getHitboxPositionY()
	{
		return hitboxPositionY;
	}

	public float getHitEffect()
	{
		return hitEffect;
	}

	public float getAsdiModifier()
	{
		return asdiModifier;
	}

	public float getHitstunModifier()
	{
		return hitstunModifier;
	}

	public float getUntechable()
	{
		return untechable;
	}

	public float getPriority()
	{
		return priority;
	}

	public float getBaseHitpause()
	{
		return baseHitpause;
	}

	public float getHitpauseScaling()
	{
		return hitpauseScaling;
	}

	public float getVisualEffect()
	{
		return visualEffect;
	}

	public float getVisualEffectXOffset()
	{
		return visualEffectXOffset;
	}

	public float getVisualEffectYOffset()
	{
		return visualEffectYOffset;
	}

	public float getHitSoundEffect()
	{
		return hitSoundEffect;
	}

	public float getExtraCameraShake()
	{
		return extraCameraShake;
	}

	public float getCanKillProjectiles()
	{
		return canKillProjectiles;
	}

	public float getHitLockoutTime()
	{
		return hitLockoutTime;
	}

	public float getCausesExtendedParryStun()
	{
		return causesExtendedParryStun;
	}

	public float getForceFlinch()
	{
		return forceFlinch;
	}

	public float getHitboxShape()
	{
		return hitboxShape;
	}
	
	
}
