package generals;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.CommandStorage;
import utility.Utilities;

public class CharacterGeneral
{
    protected List<String> code = null;
    protected List<String> other = null;

    protected float knockbackAdjustment = 0;
    protected float hitstunGravityAccel = 0;
    protected float gravityAccel = 0;
    protected float fastFallSpeed = 0;
    protected float maxFallSpeed = 0;
    protected float groundFriction = 0;
    protected float airFriction = 0;
    protected float maxDblJumps = 0;
    protected float maxJumpHSpeed = 0;
    protected float dblJumpSpeed = 0;
    protected float shortHopSpeed = 0;
    protected float jumpSpeed = 0;
    protected float airAccel = 0;
    protected float maxAirSpeed = 0;
    protected float rollBackwardSpeed = 0;
    protected float rollBackwardRecoveryTime = 0;
    protected float rollBackwardActiveTime = 0;
    protected float rollBackwardStartupTime = 0;
    protected float rollForwardSpeed = 0;
    protected float rollForwardRecoveryTime = 0;
    protected float rollForwardActiveTime = 0;
    protected float rollForwardStartupTime = 0;
    protected float airDodgeSpeed = 0;
    protected float airDodgeRecoveryTime = 0;
    protected float airDodgeActiveTime = 0;
    protected float airDodgeStartupTime = 0;
    protected float techrollSpeed = 0;
    protected float techrollRecoveryTime = 0;
    protected float techrollActiveTime = 0;
    protected float techrollStartupTime = 0;
    protected float techRecoveryTime = 0;
    protected float techActiveTime = 0;
    protected float parryRecoveryTime = 0;
    protected float parryActiveTime = 0;
    protected float parryStartupTime = 0;
    protected float waveLandFriction = 0;
    protected float waveLandTime = 0;
    protected float jumpStartTime = 0;
    protected float pratFallAccel = 0;
    protected float pratLandTime = 0;
    protected float landTime = 0;
    protected float initialDashSpeed = 0;
    protected float initialDashAccel = 0;
    protected float initialDashTime = 0;
    protected float dashStopFriction = 0;
    protected float dashStopTime = 0;
    protected float walljumpVSpeed = 0;
    protected float walljumpHSpeed = 0;
    protected float dashTurnAccel = 0;
    protected float dashTurnTime = 0;
    protected float dashSpeed = 0;
    protected float walkTurnTime = 0;
    protected float walkAccel = 0;
    protected float walkSpeed = 0;

    /**
     * Placeholder constructor to avoid errors in all CharacterGeneral classes
     */
    public CharacterGeneral()
    {
        // TODO make this constructor do at least something
    }

    public CharacterGeneral(List<String> code)
    {
        this.code = code;
        this.other = code;

        this.initializeEverything();
    }

    public void initializeEverything()
    {
        String[] generalCommands = CommandStorage.generalCommands;
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.code.size()];

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.code.size(); i++)
        {
            String command = this.code.get(i);
            for (int j = 0; j < generalCommands.length; j++)
            {
                if (Utilities.isSpecificCommand(command, generalCommands[j]))
                {
                    m = p.matcher(command);
                    m.find();
                    float value = Float.parseFloat(m.group(1));
                    Field declaredField = null;
                    try
                    {
                        String fieldName = Utilities.convertLowerCaseUnderscoresToCamelCase(
                                        generalCommands[j]);
                        declaredField = CharacterGeneral.class.getDeclaredField(fieldName);
                        boolean accessible = declaredField.isAccessible();

                        declaredField.setAccessible(true);
                        declaredField.set(this, value);
                        declaredField.setAccessible(accessible);

                    }
                    catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                                    | IllegalAccessException e)
                    {
                        System.out.println(e.getLocalizedMessage());
                        e.printStackTrace();
                    }
                    numberOfCommands++;
                    commandPositions[numberOfCommands - 1] = i;
                    break;
                }
            }
        }
        // remove all commands from code
        Arrays.sort(commandPositions); // sort the indices and then go through the list backwards to
                                       // avoid index errors
        for (int i = numberOfCommands - 1; i >= 0; i--) // dont use commandPositions.length because
                                                        // the Array is far longer than needed
        {
            this.other.remove(commandPositions[i]);
        }
    }

    public List<String> getCode()
    {
        return code;
    }

    public List<String> getOther()
    {
        return other;
    }

    public float getKnockbackAdjustment()
    {
        return knockbackAdjustment;
    }

    public float getHitstunGravityAccel()
    {
        return hitstunGravityAccel;
    }

    public float getGravityAccel()
    {
        return gravityAccel;
    }

    public float getFastFallSpeed()
    {
        return fastFallSpeed;
    }

    public float getMaxFallSpeed()
    {
        return maxFallSpeed;
    }

    public float getGroundFriction()
    {
        return groundFriction;
    }

    public float getAirFriction()
    {
        return airFriction;
    }

    public float getMaxDblJumps()
    {
        return maxDblJumps;
    }

    public float getMaxJumpHSpeed()
    {
        return maxJumpHSpeed;
    }

    public float getDblJumpSpeed()
    {
        return dblJumpSpeed;
    }

    public float getShortHopSpeed()
    {
        return shortHopSpeed;
    }

    public float getJumpSpeed()
    {
        return jumpSpeed;
    }

    public float getAirAccel()
    {
        return airAccel;
    }

    public float getMaxAirSpeed()
    {
        return maxAirSpeed;
    }

    public float getRollBackwardSpeed()
    {
        return rollBackwardSpeed;
    }

    public float getRollBackwardRecoveryTime()
    {
        return rollBackwardRecoveryTime;
    }

    public float getRollBackwardActiveTime()
    {
        return rollBackwardActiveTime;
    }

    public float getRollBackwardStartupTime()
    {
        return rollBackwardStartupTime;
    }

    public float getRollForwardSpeed()
    {
        return rollForwardSpeed;
    }

    public float getRollForwardRecoveryTime()
    {
        return rollForwardRecoveryTime;
    }

    public float getRollForwardActiveTime()
    {
        return rollForwardActiveTime;
    }

    public float getRollForwardStartupTime()
    {
        return rollForwardStartupTime;
    }

    public float getAirDodgeSpeed()
    {
        return airDodgeSpeed;
    }

    public float getAirDodgeRecoveryTime()
    {
        return airDodgeRecoveryTime;
    }

    public float getAirDodgeActiveTime()
    {
        return airDodgeActiveTime;
    }

    public float getAirDodgeStartupTime()
    {
        return airDodgeStartupTime;
    }

    public float getTechrollSpeed()
    {
        return techrollSpeed;
    }

    public float getTechrollRecoveryTime()
    {
        return techrollRecoveryTime;
    }

    public float getTechrollActiveTime()
    {
        return techrollActiveTime;
    }

    public float getTechrollStartupTime()
    {
        return techrollStartupTime;
    }

    public float getTechRecoveryTime()
    {
        return techRecoveryTime;
    }

    public float getTechActiveTime()
    {
        return techActiveTime;
    }

    public float getParryRecoveryTime()
    {
        return parryRecoveryTime;
    }

    public float getParryActiveTime()
    {
        return parryActiveTime;
    }

    public float getParryStartupTime()
    {
        return parryStartupTime;
    }

    public float getWaveLandFriction()
    {
        return waveLandFriction;
    }

    public float getWaveLandTime()
    {
        return waveLandTime;
    }

    public float getJumpStartTime()
    {
        return jumpStartTime;
    }

    public float getPratFallAccel()
    {
        return pratFallAccel;
    }

    public float getPratLandTime()
    {
        return pratLandTime;
    }

    public float getLandTime()
    {
        return landTime;
    }

    public float getInitialDashSpeed()
    {
        return initialDashSpeed;
    }

    public float getInitialDashAccel()
    {
        return initialDashAccel;
    }

    public float getInitialDashTime()
    {
        return initialDashTime;
    }

    public float getDashStopFriction()
    {
        return dashStopFriction;
    }

    public float getDashStopTime()
    {
        return dashStopTime;
    }

    public float getWalljumpVSpeed()
    {
        return walljumpVSpeed;
    }

    public float getWalljumpHSpeed()
    {
        return walljumpHSpeed;
    }

    public float getDashTurnAccel()
    {
        return dashTurnAccel;
    }

    public float getDashTurnTime()
    {
        return dashTurnTime;
    }

    public float getDashSpeed()
    {
        return dashSpeed;
    }

    public float getWalkTurnTime()
    {
        return walkTurnTime;
    }

    public float getWalkAccel()
    {
        return walkAccel;
    }

    public float getWalkSpeed()
    {
        return walkSpeed;
    }
}
