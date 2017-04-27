package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.ctre.PigeonImu;
import com.ctre.PigeonImu.CalibrationMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.drivetrain.TankDrive;

public class Drivetrain extends Subsystem {

	public static final CANTalon frontLeft = new CANTalon(RobotMap.FRONT_LEFT_DRIVE);
	public static final CANTalon frontRight = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
	private static final CANTalon midLeft = new CANTalon(RobotMap.MID_LEFT_DRIVE);
	private static final CANTalon midRight = new CANTalon(RobotMap.MID_RIGHT_DRIVE);
	private static final CANTalon rearLeft = new CANTalon(RobotMap.REAR_LEFT_DRIVE);
	private static final CANTalon rearRight = new CANTalon(RobotMap.REAR_RIGHT_DRIVE);
	
	private static final PigeonImu pidgey = new PigeonImu(Climber.getTalon());

	public Drivetrain() {
		super();

		frontLeft.enableBrakeMode(true);
		frontRight.enableBrakeMode(true);
		midLeft.enableBrakeMode(true);
		midRight.enableBrakeMode(true);
		rearLeft.enableBrakeMode(true);
		rearRight.enableBrakeMode(true);

		frontLeft.changeControlMode(TalonControlMode.PercentVbus);
		frontRight.changeControlMode(TalonControlMode.PercentVbus);
		midLeft.changeControlMode(TalonControlMode.Follower);
		midRight.changeControlMode(TalonControlMode.Follower);
		rearLeft.changeControlMode(TalonControlMode.Follower);
		rearRight.changeControlMode(TalonControlMode.Follower);

		midLeft.set(RobotMap.FRONT_LEFT_DRIVE);
		midRight.set(RobotMap.FRONT_RIGHT_DRIVE);
		rearLeft.set(RobotMap.FRONT_LEFT_DRIVE);
		rearRight.set(RobotMap.FRONT_RIGHT_DRIVE);

		frontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		frontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		resetEncoders();
		
		pidgey.SetFusedHeading(0);
		pidgey.EnterCalibrationMode(CalibrationMode.BootTareGyroAccel);
		
	}

	public void drive(double leftSpeed, double rightSpeed) {
		frontLeft.set(leftSpeed);
		frontRight.set(-rightSpeed);
		// midRight.set(-rightSpeed);
		// rearLeft.set(leftSpeed);
		// midLeft.set(leftSpeed);
		// rearRight.set(-rightSpeed);
	}
	
	public void setPID(double p, double i, double d) {
		frontLeft.setPID(p, i, d);
		frontRight.setPID(p, i, d);
	}

	public double getLeftDist() {
		return frontLeft.getPosition(); // P: -frontLeft C: frontLeft
	}

	public double getRightDist() {
		return -frontRight.getPosition(); // TODO: Check on comp. bot dir.
	}
	
	public double getLeftError() {
		return frontLeft.getSetpoint() - frontLeft.getPosition();
	}
	
	public double getRightError() {
		return frontRight.getError() - frontRight.getPosition();
	}

	public void resetEncoders() {
		frontLeft.setPosition(0);
		frontRight.setPosition(0);
	}

	public void resetGyro() {
		pidgey.SetFusedHeading(0);
	}

	public double getAngle() {
		PigeonImu.FusionStatus fusionStatus = new PigeonImu.FusionStatus();
		return pidgey.GetFusedHeading(fusionStatus);
	}
	
	public void setMode(TalonControlMode mode) {
		frontLeft.changeControlMode(mode);
		frontRight.changeControlMode(mode);
	}

	public void update() {
		SmartDashboard.putNumber("Left Encoder", getLeftDist());
		SmartDashboard.putNumber("Right Encoder", getRightDist());
		SmartDashboard.putNumber("Gyro Angle", getAngle());
		SmartDashboard.putNumber("Drivetrain Left Error", getLeftError());
		SmartDashboard.putNumber("Drivetrain Right Error", getRightError());
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive(0.4));
	}

}
