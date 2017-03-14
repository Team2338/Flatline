package team.gif.commands.intake;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot;

public class FeederDrive extends Command {

	private double feederSpeed;
	private double polyWhiskSpeed;
	private boolean isAssisted;
	private boolean isAuto;
	private double flappyTime = Timer.getFPGATimestamp();
	private double autoTime = Timer.getFPGATimestamp();

	public FeederDrive() {
		this(false, false, 1.0, Globals.POLYWHISK_FRPM);
	}

	public FeederDrive(boolean isAssisted) {
		this(false, isAssisted, 1.0, Globals.POLYWHISK_FRPM);
	}

	public FeederDrive(double feederSpeed, double polyWhiskSpeed) {
		this(false, false, feederSpeed, polyWhiskSpeed);
	}

	public FeederDrive(boolean isAuto, boolean isAssisted, double feederSpeed, double polyWhiskSpeed) {
		requires(Robot.feeder);
		this.isAuto = isAuto;
		this.isAssisted = isAssisted;
		this.feederSpeed = feederSpeed;
		this.polyWhiskSpeed = polyWhiskSpeed;
	}

	protected void initialize() {
		Robot.feeder.setMode(TalonControlMode.Speed);
		Robot.feeder.setPolyWhiskPID(SmartDashboard.getNumber("PolyWhisk P", Globals.POLYWHISK_P),
				SmartDashboard.getNumber("PolyWhisk I", Globals.POLYWHISK_I),
				SmartDashboard.getNumber("PolyWhisk D", Globals.POLYWHISK_D),
				SmartDashboard.getNumber("PolyWhisk F", Globals.POLYWHISK_F));
	}

	protected void execute() {
		if (isAuto) {
			flapFlappy();
			if (Timer.getFPGATimestamp() - autoTime > 0.5) {
				if (Robot.flywheel.isInTolerance() && Robot.vision.isAligned()) {
					Robot.feeder.driveFeeder(feederSpeed); // 0.5
					Robot.feeder.drivePolyWhisk(polyWhiskSpeed); // speed
				}
				autoTime = Timer.getFPGATimestamp();
			} else {
				Robot.feeder.driveFeeder(0); // 0.5
				Robot.feeder.drivePolyWhisk(0); // speed
			}
		} else {
			if (feederSpeed > 0) {
				// FIXME: Make servo no longer scream for mercy
				flapFlappy();

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
				Robot.feeder.setMode(TalonControlMode.PercentVbus);
				Robot.feeder.driveFeeder(0);
				Robot.feeder.drivePolyWhisk(0);
				Robot.feeder.setServoPosition(0.01);
			}
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.feeder.setMode(TalonControlMode.PercentVbus);
		Robot.feeder.driveFeeder(0);
		Robot.feeder.drivePolyWhisk(0);
	}

	protected void interrupted() {
		end();
	}

	private void flapFlappy() {
		if (Robot.feeder.getServoPosition() <= 0.08 && Timer.getFPGATimestamp() - flappyTime > 0.45) {
			Robot.feeder.setServoPosition(0.5);
			flappyTime = Timer.getFPGATimestamp();
		} else if (Robot.feeder.getServoPosition() >= 0.49 && Timer.getFPGATimestamp() - flappyTime > 0.45) {
			Robot.feeder.setServoPosition(0.07);
			flappyTime = Timer.getFPGATimestamp();
		}
	}

}
