package team.gif.commands.drivetrain;

import lib.gif.commands.Command;
import team.gif.Robot;

public class ShifterLow extends Command {

	private boolean isLow;

	public ShifterLow(boolean isLow) {
		requires(Robot.shifter);
		this.isLow = isLow;
	}

	protected void initialize() {
		Robot.shifter.shift(isLow);
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
