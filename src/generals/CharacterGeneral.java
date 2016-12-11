package generals;

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
        int numberOfCommands = 0;
        int[] commandPositions = new int[this.code.size()];

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = null;

        for (int i = 0; i < this.code.size(); i++)
        {
            String command = this.code.get(i);

            if (Utilities.isSpecificCommand(command, CommandStorage.knockbackAdjustment))
            {
                m = p.matcher(command);
                m.find();
                this.knockbackAdjustment = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.hitstunGravityAccel))
            {
                m = p.matcher(command);
                m.find();
                this.hitstunGravityAccel = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.gravityAccel))
            {
                m = p.matcher(command);
                m.find();
                this.gravityAccel = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.fastFallSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.fastFallSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.maxFallSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.maxFallSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.groundFriction))
            {
                m = p.matcher(command);
                m.find();
                this.groundFriction = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.airFriction))
            {
                m = p.matcher(command);
                m.find();
                this.airFriction = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.maxDblJumps))
            {
                m = p.matcher(command);
                m.find();
                this.maxDblJumps = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.maxJumpHSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.maxJumpHSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.dblJumpSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.dblJumpSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.shortHopSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.shortHopSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.jumpSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.jumpSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.airAccel))
            {
                m = p.matcher(command);
                m.find();
                this.airAccel = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.maxAirSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.maxAirSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.rollBackwardSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.rollBackwardSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.rollBackwardRecoveryTime))
            {
                m = p.matcher(command);
                m.find();
                this.rollBackwardRecoveryTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.rollBackwardActiveTime))
            {
                m = p.matcher(command);
                m.find();
                this.rollBackwardActiveTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.rollBackwardStartupTime))
            {
                m = p.matcher(command);
                m.find();
                this.rollBackwardStartupTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.rollForwardSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.rollForwardSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.rollForwardRecoveryTime))
            {
                m = p.matcher(command);
                m.find();
                this.rollForwardRecoveryTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.rollForwardActiveTime))
            {
                m = p.matcher(command);
                m.find();
                this.rollForwardActiveTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.rollForwardStartupTime))
            {
                m = p.matcher(command);
                m.find();
                this.rollForwardStartupTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.airDodgeSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.airDodgeSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.airDodgeRecoveryTime))
            {
                m = p.matcher(command);
                m.find();
                this.airDodgeRecoveryTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.airDodgeActiveTime))
            {
                m = p.matcher(command);
                m.find();
                this.airDodgeActiveTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.airDodgeStartupTime))
            {
                m = p.matcher(command);
                m.find();
                this.airDodgeStartupTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.techrollSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.techrollSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.techrollRecoveryTime))
            {
                m = p.matcher(command);
                m.find();
                this.techrollRecoveryTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.techrollActiveTime))
            {
                m = p.matcher(command);
                m.find();
                this.techrollActiveTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.techrollStartupTime))
            {
                m = p.matcher(command);
                m.find();
                this.techrollStartupTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.techRecoveryTime))
            {
                m = p.matcher(command);
                m.find();
                this.techRecoveryTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.techActiveTime))
            {
                m = p.matcher(command);
                m.find();
                this.techActiveTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.parryRecoveryTime))
            {
                m = p.matcher(command);
                m.find();
                this.parryRecoveryTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.parryActiveTime))
            {
                m = p.matcher(command);
                m.find();
                this.parryActiveTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.parryStartupTime))
            {
                m = p.matcher(command);
                m.find();
                this.parryStartupTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.waveLandFriction))
            {
                m = p.matcher(command);
                m.find();
                this.waveLandFriction = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.waveLandTime))
            {
                m = p.matcher(command);
                m.find();
                this.waveLandTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.jumpStartTime))
            {
                m = p.matcher(command);
                m.find();
                this.jumpStartTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.pratFallAccel))
            {
                m = p.matcher(command);
                m.find();
                this.pratFallAccel = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.pratLandTime))
            {
                m = p.matcher(command);
                m.find();
                this.pratLandTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.landTime))
            {
                m = p.matcher(command);
                m.find();
                this.landTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.initialDashSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.initialDashSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.initialDashAccel))
            {
                m = p.matcher(command);
                m.find();
                this.initialDashAccel = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.initialDashTime))
            {
                m = p.matcher(command);
                m.find();
                this.initialDashTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.dashStopFriction))
            {
                m = p.matcher(command);
                m.find();
                this.dashStopFriction = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.dashStopTime))
            {
                m = p.matcher(command);
                m.find();
                this.dashStopTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.walljumpVSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.walljumpVSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.walljumpHSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.walljumpHSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.dashTurnAccel))
            {
                m = p.matcher(command);
                m.find();
                this.dashTurnAccel = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.dashTurnTime))
            {
                m = p.matcher(command);
                m.find();
                this.dashTurnTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.dashSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.dashSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.walkTurnTime))
            {
                m = p.matcher(command);
                m.find();
                this.walkTurnTime = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.walkAccel))
            {
                m = p.matcher(command);
                m.find();
                this.walkAccel = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
            else if (Utilities.isSpecificCommand(command, CommandStorage.walkSpeed))
            {
                m = p.matcher(command);
                m.find();
                this.walkSpeed = Float.parseFloat(m.group(1));
                numberOfCommands++;
                commandPositions[numberOfCommands - 1] = i;
            }
        }
        //remove all commands from code
        Arrays.sort(commandPositions); //sort the indices and then go through the list backwards to avoid index errors
        for (int i = numberOfCommands-1; i >= 0; i--) //dont use commandPositions.length because the Array is far longer than needed
        {
            this.other.remove(commandPositions[i]);
        }
    }

    public CharacterGeneral(List<String> code, List<String> other, float knockbackAdjustment,
                    float hitstunGravityAccel, float gravityAccel, float fastFallSpeed,
                    float maxFallSpeed, float groundFriction, float airFriction, float maxDblJumps,
                    float maxJumpHSpeed, float dblJumpSpeed, float shortHopSpeed, float jumpSpeed,
                    float airAccel, float maxAirSpeed, float rollBackwardSpeed,
                    float rollBackwardRecoveryTime, float rollBackwardActiveTime,
                    float rollBackwardStartupTime, float rollForwardSpeed,
                    float rollForwardRecoveryTime, float rollForwardActiveTime,
                    float rollForwardStartupTime, float airDodgeSpeed, float airDodgeRecoveryTime,
                    float airDodgeActiveTime, float airDodgeStartupTime, float techrollSpeed,
                    float techrollRecoveryTime, float techrollActiveTime, float techrollStartupTime,
                    float techRecoveryTime, float techActiveTime, float parryRecoveryTime,
                    float parryActiveTime, float parryStartupTime, float waveLandFriction,
                    float waveLandTime, float jumpStartTime, float pratFallAccel,
                    float pratLandTime, float landTime, float initialDashSpeed,
                    float initialDashAccel, float initialDashTime, float dashStopFriction,
                    float dashStopTime, float walljumpVSpeed, float walljumpHSpeed,
                    float dashTurnAccel, float dashTurnTime, float dashSpeed, float walkTurnTime,
                    float walkAccel, float walkSpeed)
    {
        this.code = code;
        this.other = other;

    }

}
