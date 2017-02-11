package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.RobotMap;
import team.gif.commands.drivetrain.TankDrive;

public class Drivetrain extends Subsystem {

	private static final CANTalon frontLeft = new CANTalon(RobotMap.FRONT_LEFT_DRIVE);
	private static final CANTalon frontRight = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
//	private static final CANTalon midLeft = new CANTalon(RobotMap.MID_LEFT_DRIVE);
//	private static final CANTalon midRight = new CANTalon(RobotMap.MID_RIGHT_DRIVE);
	private static final CANTalon rearLeft = new CANTalon(RobotMap.REAR_LEFT_DRIVE);
	private static final CANTalon rearRight = new CANTalon(RobotMap.REAR_RIGHT_DRIVE);
	private static final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	public Drivetrain() {
		super();
		
		frontLeft.enableBrakeMode(true);
		frontRight.enableBrakeMode(true);
		rearLeft.enableBrakeMode(true);
		rearRight.enableBrakeMode(true);
		
		frontLeft.changeControlMode(TalonControlMode.PercentVbus);
		frontRight.changeControlMode(TalonControlMode.PercentVbus);
		rearLeft.changeControlMode(TalonControlMode.Follower);
		rearRight.changeControlMode(TalonControlMode.Follower);
		
		frontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		frontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		resetEncoders();
		
		gyro.calibrate();
	}

	public void drive(double left, double right) {
		frontLeft.set(left);
		rearLeft.set(left);
		frontRight.set(right);
		rearRight.set(right);
	}
	
    public double getLeftDist() {
    	return frontLeft.getPosition();
    }
    
    public double getRightDist() {
    	return frontRight.getPosition();
    }
    
	public void resetEncoders() {
		frontLeft.setEncPosition(0);
		frontRight.setEncPosition(0);
		
	}
    
    public void resetGyro() {
    	gyro.reset();
    }
	
    public double getAngle() {
    	return gyro.getAngle();
    }
    
    public double getRate() {
		return gyro.getRate();
    }
    
    public void setMode(TalonControlMode mode) {
		frontLeft.changeControlMode(mode);
		frontRight.changeControlMode(mode);
//		midLeft.changeControlMode(mode);
//		midRight.changeControlMode(mode);
		rearLeft.changeControlMode(mode);
		rearRight.changeControlMode(mode);
		
	}
    
    public void update() {
    	SmartDashboard.putNumber("Left Encoder", getLeftDist());
    	SmartDashboard.putNumber("Right Encoder", getRightDist());
    	SmartDashboard.putNumber("Gyro Angle", getAngle());
    }
    
	public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }

}
