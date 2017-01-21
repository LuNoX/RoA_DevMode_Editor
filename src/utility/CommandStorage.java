package utility;

// Credit to u/yougblood for the command descriptions

// TODO sort this MESS
// TODO rename specific stuff to exclusive or something to avoid confusion with isSpecificCommand()
// alternatively just rename that method to isDistinctCommand() or something like that

public class CommandStorage
{
    // TODO add description and additional description to all fields

    // Window
    public static final String windowLength = "window_length_";
    public static final String windowLengthDescription = "The number of frames in a certain window";
    public static final String windowCancelFrame = "window_cancel_frame_";
    public static final String windowHBoost = "window_h_boost_";
    public static final String windowHBoostDescription = "The horizontal boost during that window";
    public static final String windowVBoost = "window_v_boost_";
    public static final String windowVBoostDescription = "The vertical boost during that window";
    public static final String windowHBoostConst = "window_h_boost_is_const_";
    public static final String windowHBoostConstDescription
                    = "Whether the window_h_boost is just a one-time burst or is a consistent boost during the whole window";
    public static final String windowVBoostConst = "window_v_boost_is_const_";
    public static final String windowVBoostConstDescription
                    = "Whether the window_v_boost is just a one-time burst or is a consistent boost during the whole window";
    public static final String windowHasSfx = "window_has_sfx_";
    public static final String windowHasSfxDescription
                    = "Whether the window has a sound effect or not";
    public static final String windowSfx = "window_sfx_";
    public static final String windowSfxDescription = "The sound effect for the window.";
    public static final String windowSfxAdditionalDescription
                    = "There is no list of sound effects, so if you want a specific sound, you'll need to copy the value from a move that already has the sound you want.";
    public static final String windowSfxFrame = "window_sfx_frame_";
    public static final String windowSfxFrameDescription
                    = "The frame of the window where the sound effect is played";
    public static final String windowWhiffFrames = "window_whiff_frames_";
    public static final String windowWhiffFramesDescription
                    = "The number of frames that the window will last if you haven't hit the opponent with the move yet";
    public static final String windowInvincibility = "invincibility_";
    public static final String windowInvincibilityDescription
                    = "Determines the invincibility properties of the move";
    public static final String windowInvincibilityAdditionalDescription
                    = "0 - not invincible \n1 - fully invincible \n2 - invincible to projectiles only";

    public static final String[] windowCommands =
    {"This is a placeholder string representing the id of the window and is here for convenience of conversion between this Array and tempWindow Arrays",
                    CommandStorage.windowLength, CommandStorage.windowCancelFrame,
                    CommandStorage.windowHBoost, CommandStorage.windowVBoost,
                    CommandStorage.windowHBoostConst, CommandStorage.windowVBoostConst,
                    CommandStorage.windowHasSfx, CommandStorage.windowSfx,
                    CommandStorage.windowSfxFrame, CommandStorage.windowWhiffFrames,
                    CommandStorage.windowInvincibility};

    // Hitbox
    public static final String numHitboxes = "num_hitboxes";
    public static final String numUniqueHitboxes = "num_unique_hitboxes";
    public static final String numFinalHitboxes = "num_final_hitboxes";
    public static final String parentHitbox = "parent_hitbox";
    public static final String hitboxWindow = "hitbox_window";
    public static final String hitboxWindowCreationFrame = "hitbox_window_creation_frame";
    public static final String hitboxLifetime = "hitbox_lifetime";
    public static final String baseKnockback = "base_knockback";
    public static final String knockbackScaling = "knockback_scaling";
    public static final String knockbackAngle = "knockback_angle";
    public static final String angleFlipper = "angle_flipper";
    public static final String damage = "damage";
    public static final String hitboxSizeX = "hitbox_size_x";
    public static final String hitboxSizeY = "hitbox_size_y";
    public static final String hitboxPositionX = "hitbox_position_x";
    public static final String hitboxPositionY = "hitbox_position_y";
    public static final String hitEffect = "hit_effect";
    public static final String asdiModifier = "asdi_modifier";
    public static final String hitstunModifier = "hitstun_modifier";
    public static final String untechable = "untechable";
    public static final String priority = "priority";
    public static final String baseHitpause = "base_hitpause";
    public static final String hitpauseScaling = "hitpause_scaling";
    public static final String visualEffect = "visual_effect";
    public static final String visualEffectXOffset = "visual_effect_x_offset";
    public static final String visualEffectYOffset = "visual_effect_y_offset";
    public static final String hitSoundEffect = "hit_sound_effect";
    public static final String extraCameraShake = "extra_camera_shake";
    public static final String canKillProjectiles = "can_kill_projectiles";
    public static final String hitLockoutTime = "hit_lockout_time";
    public static final String causesExtendedParryStun = "causes_extended_parry_stun";
    public static final String forceFlinch = "force_flinch";
    public static final String hitboxShape = "hitbox_shape";

    // //Projectile
    public static final String useSpriteCollison = "use_sprite_collision";
    public static final String projectileHSpeed = "projectile_h_speed";
    public static final String projectileVSpeed = "projectile_v_speed";
    public static final String projectileGravity = "projectile_gravity";
    public static final String projectileLifetime = "projectile_lifetime";

    public static final String[] hitboxCommands =
    {"This is a placeholder string representing the id of the hitbox and is here for convenience of conversion between this Array and tempHitbox Arrays",
                    CommandStorage.parentHitbox, CommandStorage.hitboxWindow,
                    CommandStorage.hitboxWindowCreationFrame, CommandStorage.hitboxLifetime,
                    CommandStorage.baseKnockback, CommandStorage.knockbackScaling,
                    CommandStorage.knockbackAngle, CommandStorage.angleFlipper,
                    CommandStorage.damage, CommandStorage.hitboxSizeX, CommandStorage.hitboxSizeY,
                    CommandStorage.hitboxPositionX, CommandStorage.hitboxPositionY,
                    CommandStorage.hitEffect, CommandStorage.asdiModifier,
                    CommandStorage.hitstunModifier, CommandStorage.untechable,
                    CommandStorage.priority, CommandStorage.baseHitpause,
                    CommandStorage.hitpauseScaling, CommandStorage.visualEffect,
                    CommandStorage.visualEffectXOffset, CommandStorage.visualEffectYOffset,
                    CommandStorage.hitSoundEffect, CommandStorage.extraCameraShake,
                    CommandStorage.canKillProjectiles, CommandStorage.hitLockoutTime,
                    CommandStorage.causesExtendedParryStun, CommandStorage.forceFlinch,
                    CommandStorage.hitboxShape, CommandStorage.useSpriteCollison,
                    CommandStorage.projectileHSpeed, CommandStorage.projectileVSpeed,
                    CommandStorage.projectileGravity, CommandStorage.projectileLifetime};

    public static final boolean[] isMultihitOrFinalCommand =
    {false, // id
                    false, // parentHitbox
                    false, // hitboxWindow
                    false, // hitboxWindowCreationFrame
                    false, // hitboxLifetime
                    true, // baseKnockback
                    true, // knockbackScaling
                    true, // knockbackAngle
                    true, // angleFlipper
                    true, // damage
                    true, // hitboxSizeX
                    true, // hitboxSizeY
                    false, // hitboxPositionX
                    false, // hitboxPositionY
                    true, // hitEffect
                    true, // asdiModifier
                    true, // hitstunModifier
                    true, // untechable
                    true, // priority
                    true, // baseHitpause
                    true, // hitpauseScaling
                    true, // visualEffect
                    true, // visualEffectXOffset
                    true, // visualEffectYOffset
                    true, // hitSoundEffect
                    true, // extraCameraShake
                    true, // canKillProjectiles
                    true, // hitLockoutTime
                    true, // causesExtendedParryStun
                    true, // forceFlinch
                    true, // hitboxShape
                    false, // useSpriteCollison
                    false, // projectileHSpeed
                    false, // projectileVSpeed
                    false, // projectileGravity
                    false// projectileLifetime
    };

    // Move
    public static final String hasCooldown = "has_cooldown";
    public static final String cooldown = "cooldown";
    public static final String hasWhiffLanding = "has_whiff_landing";
    public static final String autocancelFrame = "autocancel_frame";
    public static final String landingLag = "landing_lag";

    public static final String[] moveCommands =
    {CommandStorage.hasCooldown, CommandStorage.cooldown, CommandStorage.autocancelFrame,
                    CommandStorage.landingLag};

    // Character specific moves
    public static final String[] characterSpecificMoveNames =
    {"Orcane.BUBBLES", "Absa.CLOUD_BURST", "Wrastor.NSPECIAL", "Kragg.FSPECIAL", "Kragg.NSPECIAL"};

    // //Absa
    public static final String[] absaSpecificMoveNames =
    {"CLOUD_BURST"};

    // // //Ftilt
    public static final String maxRange = "max_range";

    // // //Fspecial
    public static final String initialSpeed = "initial_speed";
    public static final String acceleration = "acceleration";

    // // //Lightning Bolt
    public static final String boltWidth = "bolt_width";

    // //Etalus

    // // //Dattack
    public static final String minSlideSpeed = "min_slide_speed";
    public static final String slidingBoost = "sliding_boost";

    // // //Fair
    public static final String armorValue = "armor_value";
    public static final String minArmorFrames = "min_armor_frames";

    // // //Uspecial
    public static final String minActionableSpeed = "min_actionable_speed";
    public static final String maxBoost = "max_boost";
    public static final String minBoost = "min_boost";
    public static final String maxChargeTime = "max_charge_time";
    public static final String minChargeTime = "min_charge_time";

    // // //Nspecial
    // // // //public static final String maxFallSpeed = "max_fall_speed";
    public static final String gravityChange = "gravity_change";

    // //Forsburn

    // // //Fspecial
    public static final String cloneCreationFrame = "clone_creation_frame";

    // // //Uspecial
    public static final String teleportDistance = "teleport_distance";
    public static final String teleportFrame = "teleport_frame";
    public static final String upwardLeniency = "upward_leniency";
    public static final String postTeleportSmokeCancelFrames = "post_teleport_smoke_cancel_frames";

    // // //Dspecial
    public static final String inhaleFrame = "inhale_frame";
    public static final String inhaleFinishFrame = "inhale_finish_frame";

    // //Kragg
    public static final String[] kraggSpecificMoveNames =
    {"NSPECIAL", "FSPECIAL"};
    
    // //Maypul

    // // //Fspecial
    public static final String boostSpeedGround = "boost_speed_ground";
    public static final String boostSpeedAir = "boost_speed_air";

    // // //Uspecial Marked
    public static final String baseSlingTime = "base_sling_time";
    public static final String slingDistanceDivider = "sling_distance_divisor";

    // // //Dspecial
    public static final String plantLifespan = "plant_lifespan";
    public static final String upwardSeedSpeed = "upward_seed_speed";
    public static final String plantStartupFrames = "plant_startup_frames";
    public static final String plantBaseWrapFrames = "plant_base_wrap_frames";
    public static final String plantWrapScaling = "plant_wrap_scaling";

    // //Orcane
    public static final String[] orcaneSpecificMoveNames =
    {"BUBBLES"};

    // // //Bubbles
    public static final String hitstun = "hitstun";
    public static final String hitstop = "hitstop";
    public static final String lockoutTime = "lockout_time";
    public static final String fairVKnockback = "fair_v_knockback";
    public static final String fairHKnockback = "fair_h_knockback";
    public static final String dspecialVKnockback = "dspecial_v_knockback";
    public static final String dspecialHKnockback = "dspecial_h_knockback";
    // // // //damage = "damage";
    public static final String fairInputDrift = "fair_input_drift";
    public static final String fairVSpeedRange = "fair_v_speed_range";
    public static final String fairHSpeedMin = "fair_h_speed_min";
    public static final String fairHSpeedMax = "fair_h_speed_max";
    public static final String bubblesPerFrameFair = "bubbles_per_frame_fair";
    public static final String dspecialInputDrift = "dspecial_input_drift";
    public static final String dspecialVSpeedMin = "dspecial_v_speed_min";
    public static final String dspecialVSpeedMax = "dspecial_v_speed_max";
    public static final String dspecialHSpeedRange = "dspecial_h_speed_range";
    public static final String bubblesPerFrameDspecial = "bubbles_per_frame_dspecial";

    public static final String[] orcaneBubblesCommands =
    {CommandStorage.hitstun, CommandStorage.hitstop, CommandStorage.lockoutTime,
                    CommandStorage.fairVKnockback, CommandStorage.fairHKnockback,
                    CommandStorage.dspecialVKnockback, CommandStorage.dspecialHKnockback,
                    CommandStorage.damage, CommandStorage.fairInputDrift,
                    CommandStorage.fairVSpeedRange, CommandStorage.fairHSpeedMin,
                    CommandStorage.fairHSpeedMax, CommandStorage.bubblesPerFrameFair,
                    CommandStorage.dspecialInputDrift, CommandStorage.dspecialVSpeedMin,
                    CommandStorage.dspecialVSpeedMax, CommandStorage.dspecialHSpeedRange,
                    CommandStorage.bubblesPerFrameDspecial};
    
    // //Wrastor
    public static final String[] wrastorSpecificMoveNames =
    {"NSPECIAL"};
    
    // // //Dstrong
    public static final String minTravelDistance = "min_travel_distance";

    public static final String[] moveSpecificCommands =
    {CommandStorage.maxRange, CommandStorage.initialSpeed, CommandStorage.acceleration,
                    CommandStorage.boltWidth, CommandStorage.minSlideSpeed,
                    CommandStorage.slidingBoost, CommandStorage.armorValue,
                    CommandStorage.minArmorFrames, CommandStorage.minActionableSpeed,
                    CommandStorage.maxBoost, CommandStorage.minBoost, CommandStorage.maxChargeTime,
                    CommandStorage.minChargeTime, CommandStorage.maxFallSpeed,
                    CommandStorage.gravityChange, CommandStorage.cloneCreationFrame,
                    CommandStorage.teleportDistance, CommandStorage.teleportFrame,
                    CommandStorage.upwardLeniency, CommandStorage.postTeleportSmokeCancelFrames,
                    CommandStorage.inhaleFrame, CommandStorage.inhaleFinishFrame,
                    CommandStorage.boostSpeedGround, CommandStorage.boostSpeedAir,
                    CommandStorage.baseSlingTime, CommandStorage.slingDistanceDivider,
                    CommandStorage.plantLifespan, CommandStorage.upwardSeedSpeed,
                    CommandStorage.plantStartupFrames, CommandStorage.plantBaseWrapFrames,
                    CommandStorage.plantWrapScaling, CommandStorage.minTravelDistance};

    // General
    public static final String knockbackAdjustment = "knockback_adjustment";
    public static final String hitstunGravityAccel = "hitstun_gravity_accel";
    public static final String gravityAccel = "gravity_accel";
    public static final String fastFallSpeed = "fast_fall_speed";
    public static final String maxFallSpeed = "max_fall_speed";
    public static final String groundFriction = "ground_friction";
    public static final String airFriction = "air_friction";
    public static final String maxDblJumps = "max_dbl_jumps";
    public static final String maxJumpHSpeed = "max_jump_h_speed";
    public static final String dblJumpSpeed = "dbl_jump_speed";
    public static final String shortHopSpeed = "short_hop_speed";
    public static final String jumpSpeed = "jump_speed";
    public static final String airAccel = "air_accel";
    public static final String maxAirSpeed = "max_air_speed";
    public static final String rollBackwardSpeed = "roll_backward_speed";
    public static final String rollBackwardRecoveryTime = "roll_backward_recovery_time";
    public static final String rollBackwardActiveTime = "roll_backward_active_time";
    public static final String rollBackwardStartupTime = "roll_backward_startup_time";
    public static final String rollForwardSpeed = "roll_forward_speed";
    public static final String rollForwardRecoveryTime = "roll_forward_recovery_time";
    public static final String rollForwardActiveTime = "roll_forward_active_time";
    public static final String rollForwardStartupTime = "roll_forward_startup_time";
    public static final String airDodgeSpeed = "air_dodge_speed";
    public static final String airDodgeRecoveryTime = "air_dodge_recovery_time";
    public static final String airDodgeActiveTime = "air_dodge_active_time";
    public static final String airDodgeStartupTime = "air_dodge_startup_time";
    public static final String techrollSpeed = "techroll_speed";
    public static final String techrollRecoveryTime = "techroll_recovery_time";
    public static final String techrollActiveTime = "techroll_active_time";
    public static final String techrollStartupTime = "techroll_startup_time";
    public static final String techRecoveryTime = "tech_recovery_time";
    public static final String techActiveTime = "tech_active_time";
    public static final String parryRecoveryTime = "parry_recovery_time";
    public static final String parryActiveTime = "parry_active_time";
    public static final String parryStartupTime = "parry_startup_time";
    public static final String waveLandFriction = "wave_land_friction";
    public static final String waveLandTime = "wave_land_time";
    public static final String jumpStartTime = "jump_start_time";
    public static final String pratFallAccel = "prat_fall_accel";
    public static final String pratLandTime = "prat_land_time";
    public static final String landTime = "land_time";
    public static final String initialDashSpeed = "initial_dash_speed";
    public static final String initialDashAccel = "initial_dash_accel";
    public static final String initialDashTime = "initial_dash_time";
    public static final String dashStopFriction = "dash_stop_friction";
    public static final String dashStopTime = "dash_stop_time";
    public static final String walljumpVSpeed = "walljump_v_speed";
    public static final String walljumpHSpeed = "walljump_h_speed";
    public static final String dashTurnAccel = "dash_turn_accel";
    public static final String dashTurnTime = "dash_turn_time";
    public static final String dashSpeed = "dash_speed";
    public static final String walkTurnTime = "walk_turn_time";
    public static final String walkAccel = "walk_accel";
    public static final String walkSpeed = "walk_speed";

    public static final String[] generalCommands =
    {CommandStorage.knockbackAdjustment, CommandStorage.hitstunGravityAccel,
                    CommandStorage.gravityAccel, CommandStorage.fastFallSpeed,
                    CommandStorage.maxFallSpeed, CommandStorage.groundFriction,
                    CommandStorage.airFriction, CommandStorage.maxDblJumps,
                    CommandStorage.maxJumpHSpeed, CommandStorage.dblJumpSpeed,
                    CommandStorage.shortHopSpeed, CommandStorage.jumpSpeed, CommandStorage.airAccel,
                    CommandStorage.maxAirSpeed, CommandStorage.rollBackwardSpeed,
                    CommandStorage.rollBackwardRecoveryTime, CommandStorage.rollBackwardActiveTime,
                    CommandStorage.rollBackwardStartupTime, CommandStorage.rollForwardSpeed,
                    CommandStorage.rollForwardRecoveryTime, CommandStorage.rollForwardActiveTime,
                    CommandStorage.rollForwardStartupTime, CommandStorage.airDodgeSpeed,
                    CommandStorage.airDodgeRecoveryTime, CommandStorage.airDodgeActiveTime,
                    CommandStorage.airDodgeStartupTime, CommandStorage.techrollSpeed,
                    CommandStorage.techrollRecoveryTime, CommandStorage.techrollActiveTime,
                    CommandStorage.techrollStartupTime, CommandStorage.techRecoveryTime,
                    CommandStorage.techActiveTime, CommandStorage.parryRecoveryTime,
                    CommandStorage.parryActiveTime, CommandStorage.parryStartupTime,
                    CommandStorage.waveLandFriction, CommandStorage.waveLandTime,
                    CommandStorage.jumpStartTime, CommandStorage.pratFallAccel,
                    CommandStorage.pratLandTime, CommandStorage.landTime,
                    CommandStorage.initialDashSpeed, CommandStorage.initialDashAccel,
                    CommandStorage.initialDashTime, CommandStorage.dashStopFriction,
                    CommandStorage.dashStopTime, CommandStorage.walljumpVSpeed,
                    CommandStorage.walljumpHSpeed, CommandStorage.dashTurnAccel,
                    CommandStorage.dashTurnTime, CommandStorage.dashSpeed,
                    CommandStorage.walkTurnTime, CommandStorage.walkAccel,
                    CommandStorage.walkSpeed};

    // File names
    public static final String customAbsa = "custom_absa.ini";
    public static final String customEtalus = "custom_etalus.ini";
    public static final String customForsburn = "custom_forsburn.ini";
    public static final String customKragg = "custom_kragg.ini";
    public static final String customMaypul = "custom_maypul.ini";
    public static final String customOrcane = "custom_orcane.ini";
    public static final String customWrastor = "custom_wrastor.ini";
    public static final String customZetterburn = "custom_zetterburn.ini";
    public static final String customGeneral = "custom_general.ini";

    // Other
    public static final String[] duplicateCommands =
    {CommandStorage.windowHBoostConst, CommandStorage.windowVBoostConst,
                    CommandStorage.windowHasSfx, CommandStorage.windowSfxFrame,
                    CommandStorage.hitboxWindowCreationFrame, CommandStorage.visualEffectXOffset,
                    CommandStorage.visualEffectYOffset};
}
