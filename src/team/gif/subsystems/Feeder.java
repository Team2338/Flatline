package team.gif.subsystems;

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
		feeder.changeControlMode(TalonControlMode.Speed);
		polyWhisk.changeControlMode(TalonControlMode.Speed);
		feeder.setPID(Globals.FEEDER_P, Globals.FEEDER_I, Globals.FEEDER_D);
		feeder.setF(Globals.FEEDER_F);
		polyWhisk.setPID(Globals.POLYWHISK_P, Globals.POLYWHISK_I, Globals.POLYWHISK_D);
		polyWhisk.setF(Globals.POLYWHISK_F);
		feeder.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		polyWhisk.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		
		feeder.setPosition(0);
		polyWhisk.setPosition(0);
		
		feeder.reverseOutput(false);
		feeder.reverseSensor(false);
		polyWhisk.reverseSensor(false);
		polyWhisk.reverseSensor(false);
		
		// FIXME: Competition bot has different servo angles
	}
	
	public void setMode(TalonControlMode mode) {
		feeder.changeControlMode(mode);
		polyWhisk.changeControlMode(mode);
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

	public void initDefaultCommand() {
		setDefaultCommand(new FeederDrive(false, 0, 0));
	}

	public void update() {
		SmartDashboard.putNumber("Servo CurrPos", getServoPosition());
		SmartDashboard.putNumber("Servo Angle", getServoAngle());
	}

}
