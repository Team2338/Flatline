package team.gif.commands.intake;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot;

public class FeederDrive extends Command {

	private double feederSpeed;
	private double polyWhiskSpeed;
	private boolean isAssisted;
//	private boolean hitTolerance;
	private double initTime = Timer.getFPGATimestamp();

	public FeederDrive() {
		this(false, 0.9, Globals.POLYWHISK_FRPM);
	}

	public FeederDrive(boolean isAssisted) {
		this(isAssisted, 0.9, SmartDashboard.getNumber("PolyWhisk RPM", Globals.POLYWHISK_FRPM));
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
		Robot.feeder.setPolyWhiskPID(SmartDashboard.getNumber("PolyWhisk P", Globals.POLYWHISK_P),
				SmartDashboard.getNumber("PolyWhisk I", Globals.POLYWHISK_I),
				SmartDashboard.getNumber("PolyWhisk D", Globals.POLYWHISK_D),
				SmartDashboard.getNumber("PolyWhisk F", Globals.POLYWHISK_F));
	}

	protected void execute() {
		if (feederSpeed > 0) {
			if (Robot.feeder.getServoPosition() <= 0.02 && Timer.getFPGATimestamp() - initTime > 0.45) {
				Robot.feeder.setServoPosition(0.5);
				initTime = Timer.getFPGATimestamp();
			} else if (Robot.feeder.getServoPosition() >= 0.49 && Timer.getFPGATimestamp() - initTime > 0.45) {
				Robot.feeder.setServoPosition(0.01);
				initTime = Timer.getFPGATimestamp();
			}

			if (isAssisted) {
				if (Robot.flywheel.isInTolerance() && Robot.vision.isAligned()) {
//					hitTolerance = true;
					Robot.feeder.driveFeeder(feederSpeed); // 0.5
					Robot.feeder.drivePolyWhisk(polyWhiskSpeed); // speed
				}
			} else {
				if (Robot.flywheel.isInTolerance()) {
//					hitTolerance = true;
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

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.feeder.setMode(TalonControlMode.PercentVbus);
		Robot.feeder.driveFeeder(0);
		Robot.feeder.drivePolyWhisk(0);
//		hitTolerance = false;
	}

	protected void interrupted() {
		end();
	}

}
