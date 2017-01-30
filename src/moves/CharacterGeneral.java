package moves;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.CommandStorage;
import utility.Utilities;

// TODO delete all specific character generals and add custom commands to this one instead
public class CharacterGeneral
{
    protected List<String> code = new ArrayList<String>();
    protected List<String> other = new ArrayList<String>();

    protected List<CustomCommand> characterSpecificCommands = new ArrayList<CustomCommand>();

    protected double knockbackAdjustment = 0;
    protected double hitstunGravityAccel = 0;
    protected double gravityAccel = 0;
    protected double fastFallSpeed = 0;
    protected double maxFallSpeed = 0;
    protected double groundFriction = 0;
    protected double airFriction = 0;
    protected double maxDblJumps = 0;
    protected double maxJumpHSpeed = 0;
    protected double dblJumpSpeed = 0;
    protected double shortHopSpeed = 0;
    protected double jumpSpeed = 0;
    protected double airAccel = 0;
    protected double maxAirSpeed = 0;
    protected double rollBackwardSpeed = 0;
    protected double rollBackwardRecoveryTime = 0;
    protected double rollBackwardActiveTime = 0;
    protected double rollBackwardStartupTime = 0;
    protected double rollForwardSpeed = 0;
    protected double rollForwardRecoveryTime = 0;
    protected double rollForwardActiveTime = 0;
    protected double rollForwardStartupTime = 0;
    protected double airDodgeSpeed = 0;
    protected double airDodgeRecoveryTime = 0;
    protected double airDodgeActiveTime = 0;
    protected double airDodgeStartupTime = 0;
    protected double techrollSpeed = 0;
    protected double techrollRecoveryTime = 0;
    protected double techrollActiveTime = 0;
    protected double techrollStartupTime = 0;
    protected double techRecoveryTime = 0;
    protected double techActiveTime = 0;
    protected double parryRecoveryTime = 0;
    protected double parryActiveTime = 0;
    protected double parryStartupTime = 0;
    protected double waveLandFriction = 0;
    protected double waveLandTime = 0;
    protected double jumpStartTime = 0;
    protected double pratFallAccel = 0;
    protected double pratLandTime = 0;
    protected double landTime = 0;
    protected double initialDashSpeed = 0;
    protected double initialDashAccel = 0;
    protected double initialDashTime = 0;
    protected double dashStopFriction = 0;
    protected double dashStopTime = 0;
    protected double walljumpVSpeed = 0;
    protected double walljumpHSpeed = 0;
    protected double dashTurnAccel = 0;
    protected double dashTurnTime = 0;
    protected double dashSpeed = 0;
    protected double walkTurnTime = 0;
    protected double walkAccel = 0;
    protected double walkSpeed = 0;

    public CharacterGeneral()
    {
    }

    public CharacterGeneral(List<String> code)
    {
        this.code = code;
        this.other = code;
        this.initializeEverything();
    }

    public void initializeEverything()
    {
        this.initializeValues();
        this.initializeCustomCommands();
    }

    public void initializeValues()
    {
        String[] generalCommands = CommandStorage.generalCommands;
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.other.size()];

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.other.size(); i++)
        {
            String command = this.other.get(i);
            for (int j = 0; j < generalCommands.length; j++)
            {
                if (Utilities.isSpecificCommand(command, generalCommands[j]))
                {
                    m = p.matcher(command);
                    m.find();
                    double value = Double.parseDouble(m.group(1));
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
        for (int i = 1; i <= numberOfCommands; i++) // dont use commandPositions.length because
        // the Array is far longer than needed
        {
            this.other.remove(commandPositions[commandPositions.length - i]);
        }
    }

    public void initializeCustomCommands()
    {
        String[] characterSpecificGeneralCommands = CommandStorage.characterSpecificGeneralCommands;
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.other.size()];

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.other.size(); i++)
        {
            String command = this.other.get(i);
            for (int j = 0; j < characterSpecificGeneralCommands.length; j++)
            {
                if (Utilities.isSpecificCommand(command, characterSpecificGeneralCommands[j]))
                {
                    m = p.matcher(command);
                    m.find();
                    double value = Double.parseDouble(m.group(1));
                    String name = Utilities.convertLowerCaseUnderscoresToCamelCase(
                                    characterSpecificGeneralCommands[j]);
                    CustomCommand characterSpecificGeneralCommand = new CustomCommand(name, value);
                    this.characterSpecificCommands.add(characterSpecificGeneralCommand);

                    numberOfCommands++;
                    commandPositions[numberOfCommands - 1] = i;
                    break;
                }
            }
        }

        // remove all commands from code
        Arrays.sort(commandPositions); // sort the indices and then go through the list backwards to
                                       // avoid index errors
        for (int i = 1; i <= numberOfCommands; i++) // dont use commandPositions.length because
        // the Array is far longer than needed
        {
            this.other.remove(commandPositions[commandPositions.length - i]);
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

    public double getKnockbackAdjustment()
    {
        return knockbackAdjustment;
    }

    public double getHitstunGravityAccel()
    {
        return hitstunGravityAccel;
    }

    public double getGravityAccel()
    {
        return gravityAccel;
    }

    public double getFastFallSpeed()
    {
        return fastFallSpeed;
    }

    public double getMaxFallSpeed()
    {
        return maxFallSpeed;
    }

    public double getGroundFriction()
    {
        return groundFriction;
    }

    public double getAirFriction()
    {
        return airFriction;
    }

    public double getMaxDblJumps()
    {
        return maxDblJumps;
    }

    public double getMaxJumpHSpeed()
    {
        return maxJumpHSpeed;
    }

    public double getDblJumpSpeed()
    {
        return dblJumpSpeed;
    }

    public double getShortHopSpeed()
    {
        return shortHopSpeed;
    }

    public double getJumpSpeed()
    {
        return jumpSpeed;
    }

    public double getAirAccel()
    {
        return airAccel;
    }

    public double getMaxAirSpeed()
    {
        return maxAirSpeed;
    }

    public double getRollBackwardSpeed()
    {
        return rollBackwardSpeed;
    }

    public double getRollBackwardRecoveryTime()
    {
        return rollBackwardRecoveryTime;
    }

    public double getRollBackwardActiveTime()
    {
        return rollBackwardActiveTime;
    }

    public double getRollBackwardStartupTime()
    {
        return rollBackwardStartupTime;
    }

    public double getRollForwardSpeed()
    {
        return rollForwardSpeed;
    }

    public double getRollForwardRecoveryTime()
    {
        return rollForwardRecoveryTime;
    }

    public double getRollForwardActiveTime()
    {
        return rollForwardActiveTime;
    }

    public double getRollForwardStartupTime()
    {
        return rollForwardStartupTime;
    }

    public double getAirDodgeSpeed()
    {
        return airDodgeSpeed;
    }

    public double getAirDodgeRecoveryTime()
    {
        return airDodgeRecoveryTime;
    }

    public double getAirDodgeActiveTime()
    {
        return airDodgeActiveTime;
    }

    public double getAirDodgeStartupTime()
    {
        return airDodgeStartupTime;
    }

    public double getTechrollSpeed()
    {
        return techrollSpeed;
    }

    public double getTechrollRecoveryTime()
    {
        return techrollRecoveryTime;
    }

    public double getTechrollActiveTime()
    {
        return techrollActiveTime;
    }

    public double getTechrollStartupTime()
    {
        return techrollStartupTime;
    }

    public double getTechRecoveryTime()
    {
        return techRecoveryTime;
    }

    public double getTechActiveTime()
    {
        return techActiveTime;
    }

    public double getParryRecoveryTime()
    {
        return parryRecoveryTime;
    }

    public double getParryActiveTime()
    {
        return parryActiveTime;
    }

    public double getParryStartupTime()
    {
        return parryStartupTime;
    }

    public double getWaveLandFriction()
    {
        return waveLandFriction;
    }

    public double getWaveLandTime()
    {
        return waveLandTime;
    }

    public double getJumpStartTime()
    {
        return jumpStartTime;
    }

    public double getPratFallAccel()
    {
        return pratFallAccel;
    }

    public double getPratLandTime()
    {
        return pratLandTime;
    }

    public double getLandTime()
    {
        return landTime;
    }

    public double getInitialDashSpeed()
    {
        return initialDashSpeed;
    }

    public double getInitialDashAccel()
    {
        return initialDashAccel;
    }

    public double getInitialDashTime()
    {
        return initialDashTime;
    }

    public double getDashStopFriction()
    {
        return dashStopFriction;
    }

    public double getDashStopTime()
    {
        return dashStopTime;
    }

    public double getWalljumpVSpeed()
    {
        return walljumpVSpeed;
    }

    public double getWalljumpHSpeed()
    {
        return walljumpHSpeed;
    }

    public double getDashTurnAccel()
    {
        return dashTurnAccel;
    }

    public double getDashTurnTime()
    {
        return dashTurnTime;
    }

    public double getDashSpeed()
    {
        return dashSpeed;
    }

    public double getWalkTurnTime()
    {
        return walkTurnTime;
    }

    public double getWalkAccel()
    {
        return walkAccel;
    }

    public double getWalkSpeed()
    {
        return walkSpeed;
    }

    public List<CustomCommand> getCharacterSpecificCommands()
    {
        return characterSpecificCommands;
    }
}
