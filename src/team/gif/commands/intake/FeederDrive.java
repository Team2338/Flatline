package team.gif.commands.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
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
		super(0.03);
		requires(Robot.feeder);
		this.isAssisted = isAssisted;
		this.speed = speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		if (speed != 0) {
			if (Robot.feeder.getServoPosition() <= 0.01 && Timer.getFPGATimestamp() - initTime > 0.3) {
				Robot.feeder.setServoPosition(0.5);
				initTime = Timer.getFPGATimestamp();
			} else if (Robot.feeder.getServoPosition() >= 0.5 && Timer.getFPGATimestamp() - initTime > 0.3) {
				Robot.feeder.setServoPosition(0.01);
				initTime = Timer.getFPGATimestamp();
			}

			if (isAssisted) {
				if (Robot.flywheel.isInTolerance() && Robot.vision.isAligned()) {
					Robot.feeder.driveFeeder(speed);
					Robot.feeder.drivePolyWhisk(speed);
//				} else {
//					Robot.feeder.driveFeeder(0);
//					Robot.feeder.drivePolyWhisk(0);
				}
			} else {
				if (Robot.flywheel.isInTolerance()) {
					Robot.feeder.driveFeeder(speed);
					Robot.feeder.drivePolyWhisk(speed);
//				} else {
//					Robot.feeder.driveFeeder(0);
//					Robot.feeder.drivePolyWhisk(0);
				}
			}
		} else {
			Robot.feeder.driveFeeder(0);
			Robot.feeder.drivePolyWhisk(0);
			Robot.feeder.setServoPosition(0.01);
		}

		// Robot.feeder.driveFeeder(speed);
		// Robot.feeder.drivePolyWhisk(speed);
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
