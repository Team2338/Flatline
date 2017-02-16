package team.gif.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class FeederDrive extends Command {

	private double speed;
	private boolean isAssisted;

	public FeederDrive() {
		this(false, 1);
	}

	public FeederDrive(boolean isAssisted) {
		this(isAssisted, 1);
	}

	public FeederDrive(boolean isAssisted, double speed) {
		super(0.03);
		requires(Robot.feeder);
		this.isAssisted = isAssisted;
		this.speed = speed;
	}

	protected void initialize() {}

	protected void execute() {
		if (isAssisted) {
			if (Robot.flywheel.isInTolerance() && Robot.vision.isAligned()) {
				Robot.feeder.driveFeeder(speed);
				Robot.feeder.drivePolyWhisk(speed);
				Robot.feeder.servoOscillate();
			}
		} else {
			if (Robot.flywheel.isInTolerance()) {
				Robot.feeder.driveFeeder(speed);
				Robot.feeder.drivePolyWhisk(speed);
				Robot.feeder.servoOscillate();
			}
		}
		
		Robot.feeder.driveFeeder(speed);
		Robot.feeder.drivePolyWhisk(speed);
		Robot.feeder.servoOscillate();
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {}

	protected void interrupted() {}
	
}
