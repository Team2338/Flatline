package team.gif.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

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
