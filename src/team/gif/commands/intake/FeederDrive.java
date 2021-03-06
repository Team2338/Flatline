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
	private boolean isSpew;
	private boolean isAuto; // with the exception of hopper auto
	private double flappyTime = Timer.getFPGATimestamp();

	public FeederDrive() {
		this(false, false, false, 0.7, Globals.POLYWHISK_FRPM, 115);
	}

	public FeederDrive(boolean isAssisted) {
		this(false, isAssisted, false, 0.7, Globals.POLYWHISK_FRPM, 115);
	}

	public FeederDrive(double feederSpeed, double polyWhiskSpeed) {
		this(false, false, false, feederSpeed, polyWhiskSpeed, 115);
	}

	public FeederDrive(boolean isSpew, boolean isAssisted, boolean isAuto, double feederSpeed, 
			double polyWhiskSpeed, double timeout) {
		super(timeout);
		requires(Robot.feeder);
		this.isSpew = isSpew;
		this.isAssisted = isAssisted;
		this.isAuto = isAuto;
		this.feederSpeed = feederSpeed;
		this.polyWhiskSpeed = polyWhiskSpeed;
	}

	protected void initialize() {
		Robot.feeder.setMode(TalonControlMode.Speed);
		if (polyWhiskSpeed == Globals.POLYWHISK_FHRPM) {
			Robot.feeder.setPolyWhiskPID(Globals.POLYWHISK_P, Globals.POLYWHISK_I, Globals.POLYWHISK_D, Globals.POLYWHISK_F_FH);
		} else {
			Robot.feeder.setPolyWhiskPID(Globals.POLYWHISK_P, Globals.POLYWHISK_I, Globals.POLYWHISK_D, Globals.POLYWHISK_F);
		}
	}

	protected void execute() {
		if (isSpew) {
			flapFlappy();
			Robot.feeder.driveFeeder(feederSpeed);
			Robot.feeder.drivePolyWhisk(polyWhiskSpeed);
		} else {
			if (feederSpeed > 0) {
				if(isAuto) {
					Robot.feeder.setServoPosition(0.2);
				} else {
					flapFlappy();
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
				Robot.feeder.setMode(TalonControlMode.PercentVbus);
				Robot.feeder.driveFeeder(0);
				Robot.feeder.drivePolyWhisk(0);
				Robot.feeder.setServoPosition(0.01);
			}
		}
	}

	protected boolean isFinished() {
		return isTimedOut();
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
		// FIXME: Make servo no longer scream for mercy
			if (Robot.feeder.getServoPosition() <= 0.08 && Timer.getFPGATimestamp() - flappyTime > 0.45) {
				Robot.feeder.setServoPosition(0.4);
				flappyTime = Timer.getFPGATimestamp();
			} else if (Robot.feeder.getServoPosition() >= 0.39 && Timer.getFPGATimestamp() - flappyTime > 0.45) {
				Robot.feeder.setServoPosition(0.07);
				flappyTime = Timer.getFPGATimestamp();
			}
		}
}
