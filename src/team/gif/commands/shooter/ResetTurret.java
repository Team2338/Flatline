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
		this(blue, 60);
	}

	public ResetTurret(boolean blue, double timeout) {
		super(timeout);
		requires(Robot.turret);
		this.blue = blue;
	}

	protected void initialize() {
		Robot.turret.setMode(TalonControlMode.PercentVbus);
	}

	protected void execute() {
		if (blue) {
			Robot.turret.setPosition(-0.3);
		} else {
			Robot.turret.setPosition(0.3);
		}
	}

	protected boolean isFinished() {
		if (blue) {
			return Robot.turret.isReverseLimitClosed() || isTimedOut();
		} else {
			return Robot.turret.isForwardLimitClosed() || isTimedOut();
		}
	}

	protected void end() {
		Robot.turret.setMode(TalonControlMode.Position);
		Robot.turret.resetEncoderPosition();
	}

	protected void interrupted() {
	}
}
