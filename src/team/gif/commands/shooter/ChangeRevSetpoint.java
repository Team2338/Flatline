package team.gif.commands.shooter;

import lib.gif.commands.Command;
import team.gif.Robot;

public class ChangeRevSetpoint extends Command {

	private double setpoint;
	private double offset;

	public ChangeRevSetpoint(double setpoint, double offset) {
		requires(Robot.flywheel);
		requires(Robot.vision);
		this.setpoint = setpoint;
		this.offset = offset;
	}

	protected void initialize() {
		Robot.flywheel.setStandbySetpoint(setpoint);
		Robot.vision.setAngleOffset(offset);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
