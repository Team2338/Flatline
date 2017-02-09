package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.drivetrain.TankDrive;

public class Drivetrain extends Subsystem {

	private static final CANTalon frontLeft = new CANTalon(RobotMap.frontLeftDrive);
	private static final CANTalon frontRight = new CANTalon(RobotMap.frontRightDrive);
	private static final CANTalon rearLeft = new CANTalon(RobotMap.rearLeftDrive);
	private static final CANTalon rearRight = new CANTalon(RobotMap.rearRightDrive);
	public static final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	private static final Encoder leftEncoder = new Encoder(RobotMap.leftDriveEncoderA, RobotMap.leftDriveEncoderB);
	private static final Encoder rightEncoder = new Encoder(RobotMap.rightDriveEncoderA, RobotMap.rightDriveEncoderB);
	
	public Drivetrain() {
		super();
		frontLeft.changeControlMode(TalonControlMode.Position);
		gyro.calibrate();
	}

	public void drive(double left, double right) {
		frontLeft.set(left);
		rearLeft.set(left);
		frontRight.set(right);
		rearRight.set(right);
	}
    
    public double getAngle() {
    	return gyro.getAngle();
    }
    
    public double getRate() {
		return gyro.getRate();
	}
    
    public double getLeftEncPosition() {
    	return frontLeft.getEncPosition();
    }
    
    public double getRightEncPosition() {
    	return frontRight.getEncPosition();
    }
 
    public void resetGyro() {
    	gyro.reset();
    }
    
	public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
}