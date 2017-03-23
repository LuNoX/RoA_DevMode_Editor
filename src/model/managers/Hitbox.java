package model.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.moves.CustomCommand;

public class Hitbox
{
    protected String id = null;

    protected boolean hasCustomId = false;

    protected double parentHitbox = 0;
    protected double hitboxWindow = 0;
    protected double hitboxWindowCreationFrame = 0;
    protected double hitboxLifetime = 0;
    protected double baseKnockback = 0;
    protected double knockbackScaling = 0;
    protected double knockbackAngle = 0;
    protected double angleFlipper = 0;
    protected double damage = 0;
    protected double hitboxSizeX = 0;
    protected double hitboxSizeY = 0;
    protected double hitboxPositionX = 0;
    protected double hitboxPositionY = 0;
    protected double hitEffect = 0;
    protected double asdiModifier = 0;
    protected double hitstunModifier = 0;
    protected double untechable = 0;
    protected double priority = 0;
    protected double baseHitpause = 0;
    protected double hitpauseScaling = 0;
    protected double visualEffect = 0;
    protected double visualEffectXOffset = 0;
    protected double visualEffectYOffset = 0;
    protected double hitSoundEffect = 0;
    protected double extraCameraShake = 0;
    protected double canKillProjectiles = 0;
    protected double hitLockoutTime = 0;
    protected double causesExtendedParryStun = 0;
    protected double forceFlinch = 0;
    protected double hitboxShape = 0;

    protected boolean isProjectile = false;
    protected double useSpriteCollision = 0;
    protected double projectileHSpeed = 0;
    protected double projectileVSpeed = 0;
    protected double projectileGravity = 0;
    protected double projectileLifetime = 0;

    public Hitbox(String id, double parentHitbox, double hitboxWindow,
                    double hitboxWindowCreationFrame, double hitboxLifetime, double baseKnockback,
                    double knockbackScaling, double knockbackAngle, double angleFlipper,
                    double damage, double hitboxSizeX, double hitboxSizeY, double hitboxPositionX,
                    double hitboxPositionY, double hitEffect, double asdiModifier,
                    double hitstunModifier, double untechable, double priority, double baseHitpause,
                    double hitpauseScaling, double visualEffect, double visualEffectXOffset,
                    double visualEffectYOffset, double hitSoundEffect, double extraCameraShake,
                    double canKillProjectiles, double hitLockoutTime,
                    double causesExtendedParryStun, double forceFlinch, double hitboxShape,
                    double useSpriteCollision, double projectileHSpeed, double projectileVSpeed,
                    double projectileGravity, double projectileLifetime)
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
        this.useSpriteCollision = useSpriteCollision;
        this.projectileHSpeed = projectileHSpeed;
        this.projectileVSpeed = projectileLifetime;
        this.projectileGravity = projectileGravity;
        this.projectileLifetime = projectileLifetime;

        if (this.projectileLifetime > 0)
        {
            this.isProjectile = true;
        }
    }

    public Hitbox(String id, String parentHitbox, String hitboxWindow,
                    String hitboxWindowCreationFrame, String hitboxLifetime, String baseKnockback,
                    String knockbackScaling, String knockbackAngle, String angleFlipper,
                    String damage, String hitboxSizeX, String hitboxSizeY, String hitboxPositionX,
                    String hitboxPositionY, String hitEffect, String asdiModifier,
                    String hitstunModifier, String untechable, String priority, String baseHitpause,
                    String hitpauseScaling, String visualEffect, String visualEffectXOffset,
                    String visualEffectYOffset, String hitSoundEffect, String extraCameraShake,
                    String canKillProjectiles, String hitLockoutTime,
                    String causesExtendedParryStun, String forceFlinch, String hitboxShape,
                    String useSpriteCollision, String projectileHSpeed, String projectileVSpeed,
                    String projectileGravity, String projectileLifetime)
    {
        this.id = id;
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        m = p.matcher(parentHitbox);
        m.find();
        this.parentHitbox = Double.parseDouble(m.group(1));

        m = p.matcher(hitboxWindow);
        m.find();
        this.hitboxWindow = Double.parseDouble(m.group(1));

        m = p.matcher(hitboxWindowCreationFrame);
        m.find();
        this.hitboxWindowCreationFrame = Double.parseDouble(m.group(1));

        m = p.matcher(hitboxLifetime);
        m.find();
        this.hitboxLifetime = Double.parseDouble(m.group(1));

        m = p.matcher(baseKnockback);
        m.find();
        this.baseKnockback = Double.parseDouble(m.group(1));

        m = p.matcher(knockbackScaling);
        m.find();
        this.knockbackScaling = Double.parseDouble(m.group(1));

        m = p.matcher(knockbackAngle);
        m.find();
        this.knockbackAngle = Double.parseDouble(m.group(1));

        m = p.matcher(angleFlipper);
        m.find();
        this.angleFlipper = Double.parseDouble(m.group(1));

        m = p.matcher(damage);
        m.find();
        this.damage = Double.parseDouble(m.group(1));

        m = p.matcher(hitboxSizeX);
        m.find();
        this.hitboxSizeX = Double.parseDouble(m.group(1));

        m = p.matcher(hitboxSizeY);
        m.find();
        this.hitboxSizeY = Double.parseDouble(m.group(1));

        m = p.matcher(hitboxPositionX);
        m.find();
        this.hitboxPositionX = Double.parseDouble(m.group(1));

        m = p.matcher(hitboxPositionY);
        m.find();
        this.hitboxPositionY = Double.parseDouble(m.group(1));

        m = p.matcher(hitEffect);
        m.find();
        this.hitEffect = Double.parseDouble(m.group(1));

        m = p.matcher(asdiModifier);
        m.find();
        this.asdiModifier = Double.parseDouble(m.group(1));

        m = p.matcher(hitstunModifier);
        m.find();
        this.hitstunModifier = Double.parseDouble(m.group(1));

        m = p.matcher(untechable);
        m.find();
        this.untechable = Double.parseDouble(m.group(1));

        m = p.matcher(priority);
        m.find();
        this.priority = Double.parseDouble(m.group(1));

        m = p.matcher(baseHitpause);
        m.find();
        this.baseHitpause = Double.parseDouble(m.group(1));

        m = p.matcher(hitpauseScaling);
        m.find();
        this.hitpauseScaling = Double.parseDouble(m.group(1));

        m = p.matcher(visualEffect);
        m.find();
        this.visualEffect = Double.parseDouble(m.group(1));

        m = p.matcher(visualEffectXOffset);
        m.find();
        this.visualEffectXOffset = Double.parseDouble(m.group(1));

        m = p.matcher(visualEffectYOffset);
        m.find();
        this.visualEffectYOffset = Double.parseDouble(m.group(1));

        m = p.matcher(hitSoundEffect);
        m.find();
        this.hitSoundEffect = Double.parseDouble(m.group(1));

        m = p.matcher(extraCameraShake);
        m.find();
        this.extraCameraShake = Double.parseDouble(m.group(1));

        m = p.matcher(canKillProjectiles);
        m.find();
        this.canKillProjectiles = Double.parseDouble(m.group(1));

        m = p.matcher(hitLockoutTime);
        m.find();
        this.hitLockoutTime = Double.parseDouble(m.group(1));

        m = p.matcher(causesExtendedParryStun);
        m.find();
        this.causesExtendedParryStun = Double.parseDouble(m.group(1));

        m = p.matcher(forceFlinch);
        m.find();
        this.forceFlinch = Double.parseDouble(m.group(1));

        m = p.matcher(hitboxShape);
        m.find();
        this.hitboxShape = Double.parseDouble(m.group(1));

        m = p.matcher(useSpriteCollision);
        m.find();
        this.useSpriteCollision = Double.parseDouble(m.group(1));

        m = p.matcher(projectileHSpeed);
        m.find();
        this.projectileHSpeed = Double.parseDouble(m.group(1));

        m = p.matcher(projectileVSpeed);
        m.find();
        this.projectileVSpeed = Double.parseDouble(m.group(1));

        m = p.matcher(projectileGravity);
        m.find();
        this.projectileGravity = Double.parseDouble(m.group(1));

        m = p.matcher(projectileLifetime);
        m.find();
        this.projectileLifetime = Double.parseDouble(m.group(1));

        if (this.projectileLifetime > 0)
        {
            this.isProjectile = true;
        }
    }

    public Hitbox(String[] tempHitbox)
    {
        this(tempHitbox[0], tempHitbox[1], tempHitbox[2], tempHitbox[3], tempHitbox[4],
                        tempHitbox[5], tempHitbox[6], tempHitbox[7], tempHitbox[8], tempHitbox[9],
                        tempHitbox[10], tempHitbox[11], tempHitbox[12], tempHitbox[13],
                        tempHitbox[14], tempHitbox[15], tempHitbox[16], tempHitbox[17],
                        tempHitbox[18], tempHitbox[19], tempHitbox[20], tempHitbox[21],
                        tempHitbox[22], tempHitbox[23], tempHitbox[24], tempHitbox[25],
                        tempHitbox[26], tempHitbox[27], tempHitbox[28], tempHitbox[29],
                        tempHitbox[30], tempHitbox[31], tempHitbox[32], tempHitbox[33],
                        tempHitbox[34], tempHitbox[35]);
    }

    public CustomCommand[] getHitboxCommands()
    {
        CustomCommand parentHitbox = new CustomCommand("parentHitbox", this.parentHitbox);
        CustomCommand hitboxWindow = new CustomCommand("hitboxWindow", this.hitboxWindow);
        CustomCommand hitboxWindowCreationFrame = new CustomCommand("hitboxWindowCreationFrame",
                        this.hitboxWindowCreationFrame);
        CustomCommand hitboxLifetime = new CustomCommand("hitboxLifetime", this.hitboxLifetime);
        CustomCommand baseKnockback = new CustomCommand("baseKnockback", this.baseKnockback);
        CustomCommand knockbackScaling = new CustomCommand("knockbackScaling",
                        this.knockbackScaling);
        CustomCommand knockbackAngle = new CustomCommand("knockbackAngle", this.knockbackAngle);
        CustomCommand angleFlipper = new CustomCommand("angleFlipper", this.angleFlipper);
        CustomCommand damage = new CustomCommand("damage", this.damage);
        CustomCommand hitboxSizeX = new CustomCommand("hitboxSizeX", this.hitboxSizeX);
        CustomCommand hitboxSizeY = new CustomCommand("hitboxSizeY", this.hitboxSizeY);
        CustomCommand hitboxPositionX = new CustomCommand("hitboxPositionX", this.hitboxPositionX);
        CustomCommand hitboxPositionY = new CustomCommand("hitboxPositionY", this.hitboxPositionY);
        CustomCommand hitEffect = new CustomCommand("hitEffect", this.hitEffect);
        CustomCommand asdiModifier = new CustomCommand("asdiModifier", this.asdiModifier);
        CustomCommand hitstunModifier = new CustomCommand("hitstunModifier", this.hitstunModifier);
        CustomCommand untechable = new CustomCommand("untechable", this.untechable);
        CustomCommand priority = new CustomCommand("priority", this.priority);
        CustomCommand baseHitpause = new CustomCommand("baseHitpause", this.baseHitpause);
        CustomCommand hitpauseScaling = new CustomCommand("hitpauseScaling", this.hitpauseScaling);
        CustomCommand visualEffect = new CustomCommand("visualEffect", this.visualEffect);
        CustomCommand visualEffectXOffset = new CustomCommand("visualEffectXOffset",
                        this.visualEffectXOffset);
        CustomCommand visualEffectYOffset = new CustomCommand("visualEffectYOffset",
                        this.visualEffectYOffset);
        CustomCommand hitSoundEffect = new CustomCommand("hitSoundEffect", this.hitSoundEffect);
        CustomCommand extraCameraShake = new CustomCommand("extraCameraShake",
                        this.extraCameraShake);
        CustomCommand canKillProjectiles = new CustomCommand("canKillProjectiles",
                        this.canKillProjectiles);
        CustomCommand hitLockoutTime = new CustomCommand("hitLockoutTime", this.hitLockoutTime);
        CustomCommand causesExtendedParryStun = new CustomCommand("causesExtendedParryStun",
                        this.causesExtendedParryStun);
        CustomCommand forceFlinch = new CustomCommand("forceFlinch", this.forceFlinch);
        CustomCommand hitboxShape = new CustomCommand("hitboxShape", this.hitboxShape);

        CustomCommand[] result =
        {parentHitbox, hitboxWindow, hitboxWindowCreationFrame, hitboxLifetime, baseKnockback, knockbackScaling,
                        knockbackAngle, angleFlipper, damage, hitboxSizeX, hitboxSizeY,
                        hitboxPositionX, hitboxPositionY, hitEffect, asdiModifier, hitstunModifier,
                        untechable, priority, baseHitpause, hitpauseScaling, visualEffect,
                        visualEffectXOffset, visualEffectYOffset, hitSoundEffect, extraCameraShake,
                        canKillProjectiles, hitLockoutTime, causesExtendedParryStun, forceFlinch,
                        hitboxShape};
        return result;
    }

    public CustomCommand[] getProjectileCommands()
    {
        CustomCommand useSpriteCollision = new CustomCommand("useSpriteCollision",
                        this.useSpriteCollision);
        CustomCommand projectileHSpeed = new CustomCommand("projectileHSpeed",
                        this.projectileHSpeed);
        CustomCommand projectileVSpeed = new CustomCommand("projectileVSpeed",
                        this.projectileVSpeed);
        CustomCommand projectileGravity = new CustomCommand("projectileGravity",
                        this.projectileGravity);
        CustomCommand projectileLifetime = new CustomCommand("projectileLifetime",
                        this.projectileLifetime);

        CustomCommand[] result =
        {useSpriteCollision, projectileHSpeed, projectileVSpeed, projectileGravity,
                        projectileLifetime};
        return result;
    }

    public String getId()
    {
        return id;
    }

    public double getParentHitbox()
    {
        return parentHitbox;
    }

    public double getHitboxWindow()
    {
        return hitboxWindow;
    }

    public double getHitboxWindowCreationFrame()
    {
        return hitboxWindowCreationFrame;
    }

    public double getHitboxLifetime()
    {
        return hitboxLifetime;
    }

    public double getBaseKnockback()
    {
        return baseKnockback;
    }

    public double getKnockbackScaling()
    {
        return knockbackScaling;
    }

    public double getKnockbackAngle()
    {
        return knockbackAngle;
    }

    public double getAngleFlipper()
    {
        return angleFlipper;
    }

    public double getDamage()
    {
        return damage;
    }

    public double getHitboxSizeX()
    {
        return hitboxSizeX;
    }

    public double getHitboxSizeY()
    {
        return hitboxSizeY;
    }

    public double getHitboxPositionX()
    {
        return hitboxPositionX;
    }

    public double getHitboxPositionY()
    {
        return hitboxPositionY;
    }

    public double getHitEffect()
    {
        return hitEffect;
    }

    public double getAsdiModifier()
    {
        return asdiModifier;
    }

    public double getHitstunModifier()
    {
        return hitstunModifier;
    }

    public double getUntechable()
    {
        return untechable;
    }

    public double getPriority()
    {
        return priority;
    }

    public double getBaseHitpause()
    {
        return baseHitpause;
    }

    public double getHitpauseScaling()
    {
        return hitpauseScaling;
    }

    public double getVisualEffect()
    {
        return visualEffect;
    }

    public double getVisualEffectXOffset()
    {
        return visualEffectXOffset;
    }

    public double getVisualEffectYOffset()
    {
        return visualEffectYOffset;
    }

    public double getHitSoundEffect()
    {
        return hitSoundEffect;
    }

    public double getExtraCameraShake()
    {
        return extraCameraShake;
    }

    public double getCanKillProjectiles()
    {
        return canKillProjectiles;
    }

    public double getHitLockoutTime()
    {
        return hitLockoutTime;
    }

    public double getCausesExtendedParryStun()
    {
        return causesExtendedParryStun;
    }

    public double getForceFlinch()
    {
        return forceFlinch;
    }

    public double getHitboxShape()
    {
        return hitboxShape;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setHasCustomId(boolean hasCustomId)
    {
        this.hasCustomId = hasCustomId;
    }

    public void setParentHitbox(double parentHitbox)
    {
        this.parentHitbox = parentHitbox;
    }

    public void setHitboxWindow(double hitboxWindow)
    {
        this.hitboxWindow = hitboxWindow;
    }

    public void setHitboxWindowCreationFrame(double hitboxWindowCreationFrame)
    {
        this.hitboxWindowCreationFrame = hitboxWindowCreationFrame;
    }

    public void setHitboxLifetime(double hitboxLifetime)
    {
        this.hitboxLifetime = hitboxLifetime;
    }

    public void setBaseKnockback(double baseKnockback)
    {
        this.baseKnockback = baseKnockback;
    }

    public void setKnockbackScaling(double knockbackScaling)
    {
        this.knockbackScaling = knockbackScaling;
    }

    public void setKnockbackAngle(double knockbackAngle)
    {
        this.knockbackAngle = knockbackAngle;
    }

    public void setAngleFlipper(double angleFlipper)
    {
        this.angleFlipper = angleFlipper;
    }

    public void setDamage(double damage)
    {
        this.damage = damage;
    }

    public void setHitboxSizeX(double hitboxSizeX)
    {
        this.hitboxSizeX = hitboxSizeX;
    }

    public void setHitboxSizeY(double hitboxSizeY)
    {
        this.hitboxSizeY = hitboxSizeY;
    }

    public void setHitboxPositionX(double hitboxPositionX)
    {
        this.hitboxPositionX = hitboxPositionX;
    }

    public void setHitboxPositionY(double hitboxPositionY)
    {
        this.hitboxPositionY = hitboxPositionY;
    }

    public void setHitEffect(double hitEffect)
    {
        this.hitEffect = hitEffect;
    }

    public void setAsdiModifier(double asdiModifier)
    {
        this.asdiModifier = asdiModifier;
    }

    public void setHitstunModifier(double hitstunModifier)
    {
        this.hitstunModifier = hitstunModifier;
    }

    public void setUntechable(double untechable)
    {
        this.untechable = untechable;
    }

    public void setPriority(double priority)
    {
        this.priority = priority;
    }

    public void setBaseHitpause(double baseHitpause)
    {
        this.baseHitpause = baseHitpause;
    }

    public void setHitpauseScaling(double hitpauseScaling)
    {
        this.hitpauseScaling = hitpauseScaling;
    }

    public void setVisualEffect(double visualEffect)
    {
        this.visualEffect = visualEffect;
    }

    public void setVisualEffectXOffset(double visualEffectXOffset)
    {
        this.visualEffectXOffset = visualEffectXOffset;
    }

    public void setVisualEffectYOffset(double visualEffectYOffset)
    {
        this.visualEffectYOffset = visualEffectYOffset;
    }

    public void setHitSoundEffect(double hitSoundEffect)
    {
        this.hitSoundEffect = hitSoundEffect;
    }

    public void setExtraCameraShake(double extraCameraShake)
    {
        this.extraCameraShake = extraCameraShake;
    }

    public void setCanKillProjectiles(double canKillProjectiles)
    {
        this.canKillProjectiles = canKillProjectiles;
    }

    public void setHitLockoutTime(double hitLockoutTime)
    {
        this.hitLockoutTime = hitLockoutTime;
    }

    public void setCausesExtendedParryStun(double causesExtendedParryStun)
    {
        this.causesExtendedParryStun = causesExtendedParryStun;
    }

    public void setForceFlinch(double forceFlinch)
    {
        this.forceFlinch = forceFlinch;
    }

    public void setHitboxShape(double hitboxShape)
    {
        this.hitboxShape = hitboxShape;
    }

    public void setProjectile(boolean isProjectile)
    {
        this.isProjectile = isProjectile;
    }

    public void setUseSpriteCollision(double useSpriteCollision)
    {
        this.useSpriteCollision = useSpriteCollision;
    }

    public void setProjectileHSpeed(double projectileHSpeed)
    {
        this.projectileHSpeed = projectileHSpeed;
    }

    public void setProjectileVSpeed(double projectileVSpeed)
    {
        this.projectileVSpeed = projectileVSpeed;
    }

    public void setProjectileGravity(double projectileGravity)
    {
        this.projectileGravity = projectileGravity;
    }

    public void setProjectileLifetime(double projectileLifetime)
    {
        this.projectileLifetime = projectileLifetime;
    }

}
