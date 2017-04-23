package team.gif.commands.drivetrain;

import lib.gif.commands.Command;
import team.gif.Robot;

/**
 *
 */
public class WiggleDrive extends Command {

	private boolean isAuto; // With the exception of far side gear auto, that is
							// why this is here
	private boolean autoFinish;
	private double i;

	public WiggleDrive(boolean isAuto, double timeout) {
		super(timeout);
		this.isAuto = isAuto;
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		i = 0;
		autoFinish = false;
	}

	protected void execute() {
		Robot.drivetrain.drive(0.15 + (0.3 * Math.sin(i)), 0.15 - (0.3 * Math.sin(i)));
		i += 3.14159 / 8;
		
		if (isAuto) {
			if (Robot.gearHanger.getFirstSense() || Robot.gearHanger.getSecondSense()) {
				autoFinish = true;
			}
		}
	}

	protected boolean isFinished() {
		return autoFinish || isTimedOut();
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
