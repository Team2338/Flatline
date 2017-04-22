package team.gif.commands.shooter;

import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class TurretManual extends Command {
	
	public TurretManual() {
		requires(Robot.turret);
	}

	protected void initialize() {
	}

	protected void execute() {
		if (Math.abs(OI.auxController.getRawAxis(0)) > Globals.DEAD_ZONE) {
			Robot.turret.set(0.27 * -OI.auxController.getRawAxis(0));
		} else {
			Robot.turret.set(0);
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.turret.set(0);
	}

	protected void interrupted() {
	}

}
