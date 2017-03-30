package team.gif.commands;

import com.ctre.CANTalon.TalonControlMode;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class ClimberDrive extends Command {

	public ClimberDrive() {
		requires(Robot.climber);
	}

	protected void initialize() {
		Robot.climber.setMode(TalonControlMode.PercentVbus);
	}

	protected void execute() {
		// FIXME: Make going down on joystick NOT work
		if (Math.abs(OI.auxController.getRawAxis(5)) > Globals.DEAD_ZONE) {
			Robot.climber.drive(-OI.auxController.getRawAxis(5));
		} else {
			Robot.climber.drive(0);
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.climber.drive(0);
	}

	protected void interrupted() {
	}

}
