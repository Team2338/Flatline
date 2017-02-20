package team.gif.commands.intake;

import lib.gif.commands.Command;
import team.gif.Robot;

public class CollectorDrive extends Command {
	
	private double speed;
	
	public CollectorDrive() {
		this(1);
	}

	public CollectorDrive(double speed) {
		requires(Robot.collector);
		this.speed = speed;
	}

	protected void initialize() {}

	protected void execute() {
		Robot.collector.drive(speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {}

	protected void interrupted() {}

}
