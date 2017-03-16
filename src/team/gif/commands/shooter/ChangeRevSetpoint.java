package team.gif.commands.shooter;

import lib.gif.commands.Command;
import team.gif.Robot;

public class ChangeRevSetpoint extends Command {

	private double setpoint;
	private double centerX;

	public ChangeRevSetpoint(double setpoint, double centerX) {
		requires(Robot.flywheel);
		requires(Robot.vision);
		this.setpoint = setpoint;
		this.centerX = centerX;
	}

	protected void initialize() {
		Robot.flywheel.setStandbySetpoint(setpoint);
		Robot.vision.setCenterX(centerX);
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
