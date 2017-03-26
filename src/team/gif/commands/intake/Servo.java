package team.gif.commands.intake;

import lib.gif.commands.Command;
import team.gif.Robot;

//Note that this command is not being called/used anywhere.
public class Servo extends Command {
	
	private double position;

	public Servo(double position) {
		requires(Robot.feeder);
		this.position = position;
	}

	protected void initialize() {
		Robot.feeder.setServoPosition(position);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {}

	protected void interrupted() {}

}
