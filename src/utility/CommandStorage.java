package utility;

// Credit to u/yougblood for the command descriptions

public class CommandStorage
{
    // TODO add description and additional description to all fields

    // Window
    public static final String windowLength = "window_length_";
    public static final String windowLengthDescription = "The number of frames in a certain window";
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
    public static final String windowSfxAdditional_description
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
                    CommandStorage.windowLength, CommandStorage.windowHBoost,
                    CommandStorage.windowVBoost, CommandStorage.windowHBoostConst,
                    CommandStorage.windowVBoostConst, CommandStorage.windowHasSfx,
                    CommandStorage.windowSfx, CommandStorage.windowSfxFrame,
                    CommandStorage.windowWhiffFrames, CommandStorage.windowInvincibility};

    // Hitbox
    public static final String numHitboxes = "num_hitboxes";
    public static final String numUniqueHitboxes = "num_unique_hitboxes";
    public static final String numFinalHitboxes = "num_final_hitboxes";
    public static final String parentHitbox = "parent_hitbox_";
    public static final String hitboxWindow = "hitbox_window_";
    public static final String hitboxWindowCreationFrame = "hitbox_window_creation_frame_";
    public static final String hitboxLifetime = "hitbox_lifetime_";
    public static final String baseKnockback = "base_knockback_";
    public static final String knockbackScaling = "knockback_scaling_";
    public static final String knockbackAngle = "knockback_angle_";
    public static final String angleFlipper = "angle_flipper_";
    public static final String damage = "damage_";
    public static final String hitboxSizeX = "hitbox_size_x_";
    public static final String hitboxSizeY = "hitbox_size_y_";
    public static final String hitboxPositionX = "hitbox_position_x_1";
    public static final String hitboxPositionY = "hitbox_position_y_1";
    public static final String hitEffect = "hit_effect_";
    public static final String asdiModifier = "asdi_modifier_";
    public static final String hitstunModifier = "hitstun_modifier_";
    public static final String untechable = "untechable_";
    public static final String priority = "priority_";
    public static final String baseHitpause = "base_hitpause_";
    public static final String hitpauseScaling = "hitpause_scaling_";
    public static final String visualEffect = "visual_effect_";
    public static final String visualEffectXOffset = "visual_effect_x_offset_";
    public static final String visualEffectYOffset = "visual_effect_y_offset_";
    public static final String hitSoundEffect = "hit_sound_effect_";
    public static final String extraCameraShake = "extra_camera_shake_";
    public static final String canKillProjectiles = "can_kill_projectiles_";
    public static final String hitLockoutTime = "hit_lockout_time_";
    public static final String causesExtendedParryStun = "causes_extended_parry_stun_";
    public static final String forceFlinch = "force_flinch_";
    public static final String hitboxShape = "hitbox_shape_";

    public static final String[] hitboxCommands =
    {CommandStorage.numHitboxes, CommandStorage.numUniqueHitboxes, CommandStorage.numFinalHitboxes,
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
                    CommandStorage.hitboxShape};

    // Move
    public static final String projectileHSpeed = "projectile_h_speed";
    public static final String projectileVSpeed = "projectile_v_speed";
    public static final String projectileGravity = "projectile_gravity";
    public static final String projectileLifetime = "projectile_lifetime";

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
    public static final String customAbsa = "custom_Absa.ini";
    public static final String customEtalus = "custom_Etalus.ini";
    public static final String customForsburn = "custom_Forsburn.ini";
    public static final String customKragg = "custom_Kragg.ini";
    public static final String customMaypul = "custom_Maypul.ini";
    public static final String customOrcane = "custom_Orcane.ini";
    public static final String customWrastor = "custom_Wrastor.ini";
    public static final String customZetterburn = "custom_Zetterburn.ini";
    public static final String customGeneral = "custom_General.ini";

    // Other
    public static final String[] duplicateCommands =
    {CommandStorage.windowHBoost, CommandStorage.windowHBoostConst, CommandStorage.windowVBoost,
                    CommandStorage.windowVBoostConst, CommandStorage.windowHasSfx,
                    CommandStorage.windowSfx, CommandStorage.windowSfxFrame};
}
