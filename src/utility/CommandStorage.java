package utility;

// Credit to u/yougblood for the command descriptions

public class CommandStorage
{
    // TODO add description and additional description to all fields

    // Window
    public static String windowLength = "window_length_";
    public static String windowLengthDescription = "The number of frames in a certain window";
    public static String windowHBoost = "window_h_boost_";
    public static String windowHBoostDescription = "The horizontal boost during that window";
    public static String windowVBoost = "window_v_boost_";
    public static String windowVBoostDescription = "The vertical boost during that window";
    public static String windowHBoostConst = "window_h_boost_is_const_";
    public static String windowHBoostConstDescription
                    = "Whether the window_h_boost is just a one-time burst or is a consistent boost during the whole window";
    public static String windowVBoostConst = "window_v_boost_is_const_";
    public static String windowVBoostConstDescription
                    = "Whether the window_v_boost is just a one-time burst or is a consistent boost during the whole window";
    public static String windowHasSfx = "window_has_sfx_";
    public static String windowHasSfxDescription = "Whether the window has a sound effect or not";
    public static String windowSfx = "window_sfx_";
    public static String windowSfxDescription = "The sound effect for the window.";
    public static String windowSfxAdditional_description
                    = "There is no list of sound effects, so if you want a specific sound, you'll need to copy the value from a move that already has the sound you want.";
    public static String windowSfxFrame = "window_sfx_frame_";
    public static String windowSfxFrameDescription
                    = "The frame of the window where the sound effect is played";
    public static String windowWhiffFrames = "window_whiff_frames_";
    public static String windowWhiffFramesDescription
                    = "The number of frames that the window will last if you haven't hit the opponent with the move yet";
    public static String windowInvincibility = "invincibility_";
    public static String windowInvincibilityDescription
                    = "Determines the invincibility properties of the move";
    public static String windowInvincibilityAdditionalDescription
                    = "0 - not invincible \n1 - fully invincible \n2 - invincible to projectiles only";

    public static String[] windowCommands =
    {"This is a placeholder string representing the id of the window and is here for convenience of conversion between this Array and tempWindow Arrays",
                    CommandStorage.windowLength, CommandStorage.windowHBoost,
                    CommandStorage.windowVBoost, CommandStorage.windowHBoostConst,
                    CommandStorage.windowVBoostConst, CommandStorage.windowHasSfx,
                    CommandStorage.windowSfx, CommandStorage.windowSfxFrame,
                    CommandStorage.windowWhiffFrames, CommandStorage.windowInvincibility};

    // Move
    public static String projectileHSpeed = "projectile_h_speed";
    public static String projectileVSpeed = "projectile_v_speed";
    public static String projectileGravity = "projectile_gravity";
    public static String projectileLifetime = "projectile_lifetime";

    // General
    public static String knockbackAdjustment = "knockback_adjustment";
    public static String hitstunGravityAccel = "hitstun_gravity_accel";
    public static String gravityAccel = "gravity_accel";
    public static String fastFallSpeed = "fast_fall_speed";
    public static String maxFallSpeed = "max_fall_speed";
    public static String groundFriction = "ground_friction";
    public static String airFriction = "air_friction";
    public static String maxDblJumps = "max_dbl_jumps";
    public static String maxJumpHSpeed = "max_jump_h_speed";
    public static String dblJumpSpeed = "dbl_jump_speed";
    public static String shortHopSpeed = "short_hop_speed";
    public static String jumpSpeed = "jump_speed";
    public static String airAccel = "air_accel";
    public static String maxAirSpeed = "max_air_speed";
    public static String rollBackwardSpeed = "roll_backward_speed";
    public static String rollBackwardRecoveryTime = "roll_backward_recovery_time";
    public static String rollBackwardActiveTime = "roll_backward_active_time";
    public static String rollBackwardStartupTime = "roll_backward_startup_time";
    public static String rollForwardSpeed = "roll_forward_speed";
    public static String rollForwardRecoveryTime = "roll_forward_recovery_time";
    public static String rollForwardActiveTime = "roll_forward_active_time";
    public static String rollForwardStartupTime = "roll_forward_startup_time";
    public static String airDodgeSpeed = "air_dodge_speed";
    public static String airDodgeRecoveryTime = "air_dodge_recovery_time";
    public static String airDodgeActiveTime = "air_dodge_active_time";
    public static String airDodgeStartupTime = "air_dodge_startup_time";
    public static String techrollSpeed = "techroll_speed";
    public static String techrollRecoveryTime = "techroll_recovery_time";
    public static String techrollActiveTime = "techroll_active_time";
    public static String techrollStartupTime = "techroll_startup_time";
    public static String techRecoveryTime = "tech_recovery_time";
    public static String techActiveTime = "tech_active_time";
    public static String parryRecoveryTime = "parry_recovery_time";
    public static String parryActiveTime = "parry_active_time";
    public static String parryStartupTime = "parry_startup_time";
    public static String waveLandFriction = "wave_land_friction";
    public static String waveLandTime = "wave_land_time";
    public static String jumpStartTime = "jump_start_time";
    public static String pratFallAccel = "prat_fall_accel";
    public static String pratLandTime = "prat_land_time";
    public static String landTime = "land_time";
    public static String initialDashSpeed = "initial_dash_speed";
    public static String initialDashAccel = "initial_dash_accel";
    public static String initialDashTime = "initial_dash_time";
    public static String dashStopFriction = "dash_stop_friction";
    public static String dashStopTime = "dash_stop_time";
    public static String walljumpVSpeed = "walljump_v_speed";
    public static String walljumpHSpeed = "walljump_h_speed";
    public static String dashTurnAccel = "dash_turn_accel";
    public static String dashTurnTime = "dash_turn_time";
    public static String dashSpeed = "dash_speed";
    public static String walkTurnTime = "walk_turn_time";
    public static String walkAccel = "walk_accel";
    public static String walkSpeed = "walk_speed";

    public static String[] generalCommands =
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

    //File names
    public static String customAbsa = "custom_Absa.ini";
    public static String customEtalus = "custom_Etalus.ini";
    public static String customForsburn = "custom_Forsburn.ini";
    public static String customKragg = "custom_Kragg.ini";
    public static String customMaypul = "custom_Maypul.ini";
    public static String customOrcane = "custom_Orcane.ini";
    public static String customWrastor = "custom_Wrastor.ini";
    public static String customZetterburn = "custom_Zetterburn.ini";
    public static String customGeneral = "custom_General.ini";
    
    
    // Other
    public static String[] duplicateCommands =
    {CommandStorage.windowHBoost, CommandStorage.windowHBoostConst, CommandStorage.windowVBoost,
                    CommandStorage.windowVBoostConst, CommandStorage.windowHasSfx,
                    CommandStorage.windowSfx, CommandStorage.windowSfxFrame};
}
