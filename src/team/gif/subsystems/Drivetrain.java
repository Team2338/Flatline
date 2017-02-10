package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
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
<<<<<<< HEAD
	
   
	public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
=======
>>>>>>> origin/master
    
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
<<<<<<< HEAD

    public final CANTalon frontRightDrive= new CANTalon(RobotMap.frontRightDrive);
    public final CANTalon frontLeftDrive= new CANTalon(RobotMap.frontLeftDrive);

    {
	    frontLeftDrive.changeControlMode(TalonControlMode.Position);
		frontRightDrive.changeControlMode(TalonControlMode.Position);
		frontLeftDrive.setPID(Globals.frontLeftDriveP, Globals.frontLeftDriveI, Globals.frontLeftDriveD);
		frontRightDrive.setPID(Globals.frontRightDriveP, Globals.frontRightDriveI, Globals.frontRightDriveD);
		
		frontLeftDrive.reverseOutput(true);
		frontLeftDrive.reverseSensor(false);
		frontLeftDrive.setAllowableClosedLoopErr(0);
		frontRightDrive.reverseOutput(true);
		frontRightDrive.reverseSensor(false);
		frontRightDrive.setAllowableClosedLoopErr(0);
    }

	public void setPID(double p, double i, double d) {
		frontLeftDrive.setPID(p, i, d);
		frontRightDrive.setPID(p, i, d);
	}
	
	public void setMode(TalonControlMode mode) {
		frontRightDrive.changeControlMode(mode);
		frontLeftDrive.changeControlMode(mode);
	}
	
	public void setPosition(double position){
		frontRightDrive.set(position);
		frontLeftDrive.set(position);
	}
	
	public double getPGainRight() {
		return frontRightDrive.getP() * frontRightDrive.getError() / 1;
	}
	public double getPGainLeft() {
		return frontLeftDrive.getP() * frontLeftDrive.getError() / 1;
	}
	
	public double getIGainRight() {
		return frontRightDrive.GetIaccum() / 1;
	}
	public double getIGainLeft() {
		return frontLeftDrive.GetIaccum() / 1;
	}
	
	public double getDGainRight() {
		return frontRightDrive.getD() * frontRightDrive.getSpeed() * (frontRightDrive.getError() / 
				Math.abs(frontRightDrive.getError())) / 1;
	}
	public double getDGainLeft() {
		return frontLeftDrive.getD() * frontLeftDrive.getSpeed() * (frontLeftDrive.getError() / 
				Math.abs(frontLeftDrive.getError())) / 1;
	}
	
	public double getFGainRight() {
		return frontRightDrive.getF() * frontRightDrive.getSetpoint() / 1;
	}
	public double getFGainLeft() {
		return frontLeftDrive.getF() * frontLeftDrive.getSetpoint() / 1;
	}
	
	public double getErrorRight() {
		return frontRightDrive.getError();
	}
	public double getErrorLeft() {
		return frontLeftDrive.getError();
	}
	
	public double getPositionRight() {
		return frontRightDrive.getPosition();
	}
	public double getPositionLeft() {
		return frontLeftDrive.getPosition();
	}
	
	public double getSetpointRight() {
		return frontRightDrive.getSetpoint();
	}
	public double getSetpointLeft() {
		return frontLeftDrive.getSetpoint();
	}
	
	public double getIZoneRight() {
		return frontRightDrive.getIZone();
	}
	public double getIZoneLeft() {
		return frontLeftDrive.getIZone();
	}
	
	public void resetIAccum() {
		frontRightDrive.clearIAccum();
		frontLeftDrive.clearIAccum();
	}
	
	public void update() {
		SmartDashboard.putNumber("frontRightDrive CurrentPos", getPositionRight());
		SmartDashboard.putNumber("frontRightDrive PGain", getPGainRight());
		SmartDashboard.putNumber("frontRightDrive Error", getErrorRight());
		SmartDashboard.putNumber("frontLeftDrive CurrentPos", getPositionLeft());
		SmartDashboard.putNumber("frontLeftDrive PGain", getPGainLeft());
		SmartDashboard.putNumber("frontLeftDrive Error", getErrorLeft());
		}
	}
=======
    
	public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
}
>>>>>>> origin/master
