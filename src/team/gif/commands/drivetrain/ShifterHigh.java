package team.gif.commands.drivetrain;

import lib.gif.commands.Command;
import team.gif.Robot;

public class ShifterHigh extends Command {

	private boolean isHigh;

	public ShifterHigh(boolean isHigh) {
		requires(Robot.shifter);
		this.isHigh = isHigh;
	}

	protected void initialize() {
		Robot.shifter.shift(isHigh);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
