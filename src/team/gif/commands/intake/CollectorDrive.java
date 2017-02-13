package team.gif.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class CollectorDrive extends Command {
	
	private double speed;

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
