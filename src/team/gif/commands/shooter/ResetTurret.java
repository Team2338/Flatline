package team.gif.commands.shooter;

import lib.gif.commands.Command;
import team.gif.Robot;

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
	}

	protected void execute() {
		if (blue) {
			Robot.turret.set(-0.3);
		} else {
			Robot.turret.set(0.3);
		}
	}

	protected boolean isFinished() {
		if (Robot.turret.isForwardLimitClosed()) {
			return true;
		}
		
		if (blue) {
			return Robot.turret.isReverseLimitClosed() || isTimedOut();
		} else {
			return Robot.turret.isForwardLimitClosed() || isTimedOut();
		}
	}

	protected void end() {
		Robot.turret.resetEncoder();
	}

	protected void interrupted() {
	}
}
