package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import lib.gif.commands.Command;
import team.gif.Robot;

public class ShooterStandby extends Command {

	public ShooterStandby() {
		requires(Robot.flywheel);
	}

	protected void initialize() {
		Robot.flywheel.setMode(TalonControlMode.PercentVbus);
		Robot.flywheel.driveFlywheel(0);
	}

	protected void execute() {}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {}

	protected void interrupted() {}
	
}
