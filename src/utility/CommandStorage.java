package utility;

// Credit to u/yougblood for the command descriptions

public class CommandStorage
{
    public static String window_length = "window_length_";
    public static String window_length_description = "The number of frames in a certain window";
    public static String window_hBoost = "window_h_boost_";
    public static String window_hBoost_description = "The horizontal boost during that window";
    public static String window_vBoost = "window_v_boost_";
    public static String window_vBoost_description = "The vertical boost during that window";
    public static String window_hBoostConst = "window_h_boost_is_const_";
    public static String window_hBoostConst_description = "Whether the window_h_boost is just a one-time burst or is a consistent boost during the whole window";
    public static String window_vBoostConst = "window_v_boost_is_const_";
    public static String window_vBoostConst_description = "Whether the window_v_boost is just a one-time burst or is a consistent boost during the whole window";
    public static String window_hasSfx = "window_has_sfx_";
    public static String window_hasSfx_description = "Whether the window has a sound effect or not";
    public static String window_sfx = "window_sfx_";
    public static String window_sfx_description = "The sound effect for the window.";
    public static String window_sfx_additional_description = "There is no list of sound effects, so if you want a specific sound, you'll need to copy the value from a move that already has the sound you want.";
    public static String window_sfxFrame = "window_sfx_frame_";
    public static String window_sfxFrame_description = "The frame of the window where the sound effect is played";
    public static String window_whiffFrames = "window_whiff_frames_";
    public static String window_whiffFrames_description = "The number of frames that the window will last if you haven't hit the opponent with the move yet";
    public static String window_invincibility = "invincibility_";
    public static String window_invincibility_description = "Determines the invincibility properties of the move";
    public static String window_invincibility_additional_description = "0 - not invincible \n1 - fully invincible \n2 - invincible to projectiles only";

    public static String[] duplicateCommands =
    {CommandStorage.window_hBoost, CommandStorage.window_hBoostConst, CommandStorage.window_vBoost,
            CommandStorage.window_vBoostConst, CommandStorage.window_hasSfx, CommandStorage.window_sfx, CommandStorage.window_sfxFrame};

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
