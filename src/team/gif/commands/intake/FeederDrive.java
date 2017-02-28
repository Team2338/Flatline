package team.gif.commands.intake;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Timer;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot;

public class FeederDrive extends Command {

	private double feederSpeed;
	private double polyWhiskSpeed;
	private boolean isAssisted;
	private double initTime = Timer.getFPGATimestamp();

	public FeederDrive() {
		this(false, Globals.FEEDER_FRPM, Globals.POLYWHISK_FRPM);
	}

	public FeederDrive(boolean isAssisted) {
		this(isAssisted, Globals.FEEDER_FRPM, Globals.POLYWHISK_FRPM);
	}
	
	public FeederDrive(double feederSpeed, double polyWhiskSpeed) {
		this(false, feederSpeed, polyWhiskSpeed);
	}

	public FeederDrive(boolean isAssisted, double feederSpeed, double polyWhiskSpeed) {
		requires(Robot.feeder);
		this.isAssisted = isAssisted;
		this.feederSpeed = feederSpeed;
		this.polyWhiskSpeed = polyWhiskSpeed;
	}

	protected void initialize() {
		Robot.feeder.setMode(TalonControlMode.Speed);
	}

	protected void execute() {
		if (feederSpeed > 0) {
			if (Robot.feeder.getServoPosition() <= 0.02 && Timer.getFPGATimestamp() - initTime > 0.3) {
				Robot.feeder.setServoPosition(0.5);
				initTime = Timer.getFPGATimestamp();
			} else if (Robot.feeder.getServoPosition() >= 0.49 && Timer.getFPGATimestamp() - initTime > 0.3) {
				Robot.feeder.setServoPosition(0.01);
				initTime = Timer.getFPGATimestamp();
			}

			if (isAssisted) {
				if (Robot.flywheel.isInTolerance() && Robot.vision.isAligned()) {
					Robot.feeder.driveFeeder(feederSpeed); // 0.5
					Robot.feeder.drivePolyWhisk(polyWhiskSpeed); // speed
				}
			} else {
				if (Robot.flywheel.isInTolerance()) {
					Robot.feeder.driveFeeder(feederSpeed); // 0.5
					Robot.feeder.drivePolyWhisk(polyWhiskSpeed); // speed
				}
			}
		} else if (feederSpeed < 0) {
			Robot.feeder.driveFeeder(feederSpeed); // -0.15
			Robot.feeder.drivePolyWhisk(polyWhiskSpeed); // speed 
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
