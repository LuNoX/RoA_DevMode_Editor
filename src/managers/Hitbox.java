package managers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hitbox
{
    protected String id = null;
    protected String name = null;
    
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

    public Hitbox(String id, String name, float parentHitbox, float hitboxWindow,
                    float hitboxWindowCreationFrame, float hitboxLifetime, float baseKnockback,
                    float knockbackScaling, float knockbackAngle, float angleFlipper, float damage,
                    float hitboxSizeX, float hitboxSizeY, float hitboxPositionX,
                    float hitboxPositionY, float hitEffect, float asdiModifier,
                    float hitstunModifier, float untechable, float priority, float baseHitpause,
                    float hitpauseScaling, float visualEffect, float visualEffectXOffset,
                    float visualEffectYOffset, float hitSoundEffect, float extraCameraShake,
                    float canKillProjectiles, float hitLockoutTime, float causesExtendedParryStun,
                    float forceFlinch, float hitboxShape)
    {
        this.id = id;
        this.name = name;
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

    public Hitbox(String id, String name, String parentHitbox, String hitboxWindow,
                    String hitboxWindowCreationFrame, String hitboxLifetime, String baseKnockback,
                    String knockbackScaling, String knockbackAngle, String angleFlipper,
                    String damage, String hitboxSizeX, String hitboxSizeY, String hitboxPositionX,
                    String hitboxPositionY, String hitEffect, String asdiModifier,
                    String hitstunModifier, String untechable, String priority, String baseHitpause,
                    String hitpauseScaling, String visualEffect, String visualEffectXOffset,
                    String visualEffectYOffset, String hitSoundEffect, String extraCameraShake,
                    String canKillProjectiles, String hitLockoutTime,
                    String causesExtendedParryStun, String forceFlinch, String hitboxShape)
    {
        this.id = id;
        this.name = name;
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        m = p.matcher(parentHitbox);
        m.find();
        this.parentHitbox = Float.parseFloat(m.group(1));

        m = p.matcher(hitboxWindow);
        m.find();
        this.hitboxWindow = Float.parseFloat(m.group(1));

        m = p.matcher(hitboxWindowCreationFrame);
        m.find();
        this.hitboxWindowCreationFrame = Float.parseFloat(m.group(1));

        m = p.matcher(hitboxLifetime);
        m.find();
        this.hitboxLifetime = Float.parseFloat(m.group(1));

        m = p.matcher(baseKnockback);
        m.find();
        this.baseKnockback = Float.parseFloat(m.group(1));

        m = p.matcher(knockbackScaling);
        m.find();
        this.knockbackScaling = Float.parseFloat(m.group(1));

        m = p.matcher(knockbackAngle);
        m.find();
        this.knockbackAngle = Float.parseFloat(m.group(1));

        m = p.matcher(angleFlipper);
        m.find();
        this.angleFlipper = Float.parseFloat(m.group(1));

        m = p.matcher(damage);
        m.find();
        this.damage = Float.parseFloat(m.group(1));

        m = p.matcher(hitboxSizeX);
        m.find();
        this.hitboxSizeX = Float.parseFloat(m.group(1));

        m = p.matcher(hitboxSizeY);
        m.find();
        this.hitboxSizeY = Float.parseFloat(m.group(1));

        m = p.matcher(hitboxPositionX);
        m.find();
        this.hitboxPositionX = Float.parseFloat(m.group(1));

        m = p.matcher(hitboxPositionY);
        m.find();
        this.hitboxPositionY = Float.parseFloat(m.group(1));

        m = p.matcher(hitEffect);
        m.find();
        this.hitEffect = Float.parseFloat(m.group(1));

        m = p.matcher(asdiModifier);
        m.find();
        this.asdiModifier = Float.parseFloat(m.group(1));

        m = p.matcher(hitstunModifier);
        m.find();
        this.hitstunModifier = Float.parseFloat(m.group(1));

        m = p.matcher(untechable);
        m.find();
        this.untechable = Float.parseFloat(m.group(1));

        m = p.matcher(priority);
        m.find();
        this.priority = Float.parseFloat(m.group(1));

        m = p.matcher(baseHitpause);
        m.find();
        this.baseHitpause = Float.parseFloat(m.group(1));

        m = p.matcher(hitpauseScaling);
        m.find();
        this.hitpauseScaling = Float.parseFloat(m.group(1));

        m = p.matcher(visualEffect);
        m.find();
        this.visualEffect = Float.parseFloat(m.group(1));

        m = p.matcher(visualEffectXOffset);
        m.find();
        this.visualEffectXOffset = Float.parseFloat(m.group(1));

        m = p.matcher(visualEffectYOffset);
        m.find();
        this.visualEffectYOffset = Float.parseFloat(m.group(1));

        m = p.matcher(hitSoundEffect);
        m.find();
        this.hitSoundEffect = Float.parseFloat(m.group(1));

        m = p.matcher(extraCameraShake);
        m.find();
        this.extraCameraShake = Float.parseFloat(m.group(1));

        m = p.matcher(canKillProjectiles);
        m.find();
        this.canKillProjectiles = Float.parseFloat(m.group(1));

        m = p.matcher(hitLockoutTime);
        m.find();
        this.hitLockoutTime = Float.parseFloat(m.group(1));

        m = p.matcher(causesExtendedParryStun);
        m.find();
        this.causesExtendedParryStun = Float.parseFloat(m.group(1));

        m = p.matcher(forceFlinch);
        m.find();
        this.forceFlinch = Float.parseFloat(m.group(1));

        m = p.matcher(hitboxShape);
        m.find();
        this.hitboxShape = Float.parseFloat(m.group(1));
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
