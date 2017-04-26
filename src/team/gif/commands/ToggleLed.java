package team.gif.commands;

import lib.gif.commands.Command;
import team.gif.Robot;

public class ToggleLed extends Command {

	private boolean on;

	public ToggleLed(boolean on) {
		requires(Robot.gearHanger);
		this.on = on;
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.gearHanger.turnOnLed(on);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
