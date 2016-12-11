package utility;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Credit to u/yougblood for the command descriptions

public class CommandStorage
{
    // TODO add description and additional description to all fields
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

    public static String projectileHSpeed = "projectile_h_speed";
    public static String projectileVSpeed = "projectile_v_speed";
    public static String projectileGravity = "projectile_gravity";
    public static String projectileLifetime = "projectile_lifetime";

    public static String[] windowCommands =
    {"id", CommandStorage.windowLength, CommandStorage.windowHBoost, CommandStorage.windowVBoost, //Id is ALWAYS at index 0
            CommandStorage.windowHBoostConst, CommandStorage.windowVBoostConst,
            CommandStorage.windowHasSfx, CommandStorage.windowSfx, CommandStorage.windowSfxFrame,
            CommandStorage.windowWhiffFrames, CommandStorage.windowInvincibility};

    public static String[] duplicateCommands =
    {CommandStorage.windowHBoost, CommandStorage.windowHBoostConst, CommandStorage.windowVBoost,
            CommandStorage.windowVBoostConst, CommandStorage.windowHasSfx, CommandStorage.windowSfx,
            CommandStorage.windowSfxFrame};

    public static boolean isSpecificCommand(String toBeChecked, String command)
    {
        if (!toBeChecked.contains(command))
        {

            return false;
        }
        for (int i = 0; i < CommandStorage.duplicateCommands.length; i++)
        {
            if (!CommandStorage.duplicateCommands[i].equals(command) && toBeChecked.contains(
                    CommandStorage.duplicateCommands[i]))
            {
                return false;
            }
        }
        return true;
    }
    
    public static List<float[]> addTempWindowCommand(List<float[]> listToBeAddedTo,
            String commandToBeAdded, int commandPosition)
    {
        List<float[]> result = listToBeAddedTo;
        String[] windowCommands = CommandStorage.windowCommands;

        int tmp = commandToBeAdded.indexOf(windowCommands[commandPosition])
                + windowCommands[commandPosition].length();
        int id = Integer.parseInt(commandToBeAdded.substring(tmp, tmp + 1));

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(commandToBeAdded);
        m.find();
        Float value = Float.parseFloat(m.group(1));

        boolean belongsToExistingWindow = false;
        for (float[] window : result)
        {
            if (id == window[0])
            {
                window[commandPosition] = value;
                belongsToExistingWindow = true;
            }
        }
        if (!belongsToExistingWindow)
        {
            float[] window = new float[windowCommands.length];
            window[0] = id;
            for (int i = 1; i < window.length; i++)
            {
                if (i == commandPosition)
                {
                    window[i] = value;
                }
                else
                {
                    window[i] = 0;
                }
            }
            result.add(window);
        }

        return result;
    }
}
