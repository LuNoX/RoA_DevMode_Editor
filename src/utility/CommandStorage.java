package utility;

// Credit to u/yougblood for the command descriptions

public class CommandStorage
{
    public static String windowLength = "window_length_";
    public static String windowLengthDescription = "The number of frames in a certain window";
    public static String windowHBoost = "window_h_boost_";
    public static String windowHBoostDescription = "The horizontal boost during that window";
    public static String windowVBoost = "window_v_boost_";
    public static String windowVBoostDescription = "The vertical boost during that window";
    public static String windowHBoostConst = "window_h_boost_is_const_";
    public static String windowHBoostConstDescription = "Whether the window_h_boost is just a one-time burst or is a consistent boost during the whole window";
    public static String windowVBoostConst = "window_v_boost_is_const_";
    public static String windowVBoostConstDescription = "Whether the window_v_boost is just a one-time burst or is a consistent boost during the whole window";
    public static String windowHasSfx = "window_has_sfx_";
    public static String windowHasSfxDescription = "Whether the window has a sound effect or not";
    public static String windowSfx = "window_sfx_";
    public static String windowSfxDescription = "The sound effect for the window.";
    public static String windowSfxAdditional_description = "There is no list of sound effects, so if you want a specific sound, you'll need to copy the value from a move that already has the sound you want.";
    public static String windowSfxFrame = "window_sfx_frame_";
    public static String windowSfxFrameDescription = "The frame of the window where the sound effect is played";
    public static String windowWhiffFrames = "window_whiff_frames_";
    public static String windowWhiffFramesDescription = "The number of frames that the window will last if you haven't hit the opponent with the move yet";
    public static String windowInvincibility = "invincibility_";
    public static String windowInvincibilityDescription = "Determines the invincibility properties of the move";
    public static String windowInvincibilityAdditionalDescription = "0 - not invincible \n1 - fully invincible \n2 - invincible to projectiles only";
    public static String projectileLifetime = "projectile_lifetime";
    public static String preChargeWindowFrames = "pre_charge_window_frames";
    public static String postChargeWindowFrames = "post_charge_window_frames";
    
    
    public static String[] duplicateCommands =
    {CommandStorage.windowHBoost, CommandStorage.windowHBoostConst, CommandStorage.windowVBoost,
            CommandStorage.windowVBoostConst, CommandStorage.windowHasSfx, CommandStorage.windowSfx, CommandStorage.windowSfxFrame};

    public static boolean isSpecificCommand(String toBeChecked, String command)
    {
        if (!toBeChecked.contains(command))
        {

            return false;
        }
        for (int i = 0; i < CommandStorage.duplicateCommands.length; i++)
        {
            if (!CommandStorage.duplicateCommands[i].equals(command) && toBeChecked.contains(CommandStorage.duplicateCommands[i]))
            {
                return false;
            }
        }
        return true;
    }
}
