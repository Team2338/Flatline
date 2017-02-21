package team.gif.commands.intake;

import edu.wpi.first.wpilibj.Timer;
import lib.gif.commands.Command;
import team.gif.Robot;

public class FeederDrive extends Command {

	private double speed;
	private boolean isAssisted;
	private double initTime = Timer.getFPGATimestamp();

	public FeederDrive() {
		this(false, 1);
	}

	public FeederDrive(boolean isAssisted) {
		this(isAssisted, 1);
	}

	public FeederDrive(boolean isAssisted, double speed) {
		requires(Robot.feeder);
		this.isAssisted = isAssisted;
		this.speed = speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		if (speed > 0) {
			if (Robot.feeder.getServoPosition() <= 0.01 && Timer.getFPGATimestamp() - initTime > 0.3) {
				Robot.feeder.setServoPosition(0.5);
				initTime = Timer.getFPGATimestamp();
			} else if (Robot.feeder.getServoPosition() >= 0.5 && Timer.getFPGATimestamp() - initTime > 0.3) {
				Robot.feeder.setServoPosition(0.01);
				initTime = Timer.getFPGATimestamp();
			}

			if (isAssisted) {
				if (Robot.flywheel.isInTolerance() && Robot.vision.isAligned()) {
					Robot.feeder.driveFeeder(0.6);
					Robot.feeder.drivePolyWhisk(speed);
				}
			} else {
				if (Robot.flywheel.isInTolerance()) {
					Robot.feeder.driveFeeder(0.6);
					Robot.feeder.drivePolyWhisk(speed);
				}
			}
		} else if (speed < 0) {
			Robot.feeder.driveFeeder(-0.15);
			Robot.feeder.drivePolyWhisk(speed);
		} else {
			Robot.feeder.driveFeeder(0);
			Robot.feeder.drivePolyWhisk(0);
			Robot.feeder.setServoPosition(0.01);
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
