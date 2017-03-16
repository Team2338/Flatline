package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import lib.gif.commands.Command;
import team.gif.Robot;

/**
 *
 */
public class ResetTurret extends Command {

	private boolean blue;
	
	public ResetTurret(boolean blue) {
		this(blue, 0);
	}

	public ResetTurret(boolean blue, double timeout) {
		super(timeout);
		requires(Robot.turret);
		this.blue = blue;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.turret.setMode(TalonControlMode.PercentVbus);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (blue) {
			Robot.turret.setPosition(-0.3);
		} else {
			Robot.turret.setPosition(0.3);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (blue) {
			return Robot.turret.isReverseLimitClosed() || isTimedOut();
		} else {
			return Robot.turret.isForwardLimitClosed() || isTimedOut();
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.turret.setMode(TalonControlMode.Position);
		Robot.turret.resetEncoderPosition();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
