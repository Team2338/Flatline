package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import lib.gif.commands.Command;
import team.gif.Robot;

/**
 *
 */
public class ResetTurret extends Command {

    public ResetTurret() {
        requires(Robot.turret);
        setTimeout(3);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.turret.setMode(TalonControlMode.PercentVbus);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.turret.setPosition(0.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.turret.isForwardLimitClosed() || Robot.turret.isReverseLimitClosed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.turret.setPosition(0);
    	Robot.turret.setMode(TalonControlMode.Position);
    	Robot.turret.resetEncoderPosition();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
