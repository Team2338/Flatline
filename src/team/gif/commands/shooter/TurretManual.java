package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class TurretManual extends Command {
	
	private boolean isFinished = false;

	public TurretManual() {
		requires(Robot.turret);
	}

	protected void initialize() {
		Robot.turret.setMode(TalonControlMode.PercentVbus);
	}

	protected void execute() {
		if (Math.abs(OI.auxController.getRawAxis(0)) > Globals.DEAD_ZONE) {
			Robot.turret.setPosition(0.3 * -OI.auxController.getRawAxis(0));
		} else {
			Robot.turret.setPosition(0);
		}
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void end() {
	}

	protected void interrupted() {
		isFinished = true;
	}

}
