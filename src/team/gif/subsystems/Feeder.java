package team.gif.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.intake.FeederDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

public class Feeder extends Subsystem {

	private static final CANTalon feeder = new CANTalon(RobotMap.FEEDER);
	private static final CANTalon polyWhisk = new CANTalon(RobotMap.POLY_WHISK);
	private static final Servo flappy = new Servo(RobotMap.FLAPPY);

	public Feeder() {
		super();
		
		feeder.enableBrakeMode(false);
		polyWhisk.enableBrakeMode(false);
		feeder.changeControlMode(TalonControlMode.PercentVbus);
		polyWhisk.changeControlMode(TalonControlMode.Speed);
		polyWhisk.setPID(Globals.POLYWHISK_P, Globals.POLYWHISK_I, Globals.POLYWHISK_D);
		polyWhisk.setF(Globals.POLYWHISK_F);
		polyWhisk.setIZone(Globals.POLYWHISK_IZONE);
		polyWhisk.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		
		polyWhisk.setPosition(0);
		
		polyWhisk.reverseOutput(false);
		polyWhisk.reverseSensor(true);
	}
	
	public void setMode(TalonControlMode mode) {
		polyWhisk.changeControlMode(mode);
	}
	
	public void setFeederPID(double p, double i, double d, double f) {
		feeder.setPID(p, i, d);
		feeder.setF(f);
	}
	
	public void setPolyWhiskPID(double p, double i, double d, double f) {
		polyWhisk.setPID(p, i, d);
		polyWhisk.setF(f);
	}

	public void driveFeeder(double speed) {
		feeder.set(speed); // P: -speed
	}

	public void drivePolyWhisk(double speed) {
		polyWhisk.set(-speed); // P: speed
	}

	public void setServoPosition(double position) {
		flappy.setPosition(position);
	}

	public double getServoPosition() {
		return flappy.getPosition();
	}

	public double getServoAngle() {
		return flappy.getAngle();
	}
	
	public double getFeederMotorOutput() {
		return feeder.getOutputVoltage() / feeder.getBusVoltage();
	}
	
	public double getPolyWhiskVelocity() {
		return polyWhisk.getSpeed();
	}
	
	public double getPolyWhiskError() {
		return -polyWhisk.getSetpoint() - polyWhisk.getSpeed();
	}
	
	public double getPolyWhiskPosition() {
		return polyWhisk.getPosition();
	}
	
	public double getPolyWhiskSetpoint() {
		return polyWhisk.getSetpoint();
	}
	
	public double getPolyWhiskMotorOutput() {
		return polyWhisk.getOutputVoltage() / polyWhisk.getBusVoltage();
	}

	public void initDefaultCommand() {
//		setDefaultCommand(new FeederDrive(false, false, 0, 0));
	}

	public void update() {
		SmartDashboard.putNumber("Servo CurrPos", getServoPosition());
		SmartDashboard.putNumber("Servo Angle", getServoAngle());
		SmartDashboard.putNumber("PolyWhisk CurrPos" , getPolyWhiskPosition());
		SmartDashboard.putNumber("PolyWhiskVelocity", getPolyWhiskVelocity());
		SmartDashboard.putNumber("PolyWhiskError", getPolyWhiskError());
		SmartDashboard.putNumber("PolyWhiskSetpoint", getPolyWhiskSetpoint());
	}

}
