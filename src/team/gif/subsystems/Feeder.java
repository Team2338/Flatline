package team.gif.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.intake.FeederDrive;

import com.ctre.CANTalon;

public class Feeder extends Subsystem {

	private static final CANTalon feeder = new CANTalon(RobotMap.FEEDER);
	private static final CANTalon polyWhisk = new CANTalon(RobotMap.POLY_WHISK);
	private static final Servo flappy = new Servo(RobotMap.FLAPPY);

	public Feeder() {
		super();
		
		// FIXME: Possibly doesn't reset?
//		if (getServoPosition() != 0.01) {
//			flappy.setPosition(0.01);
//		}
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
		setDefaultCommand(new FeederDrive(false, 0));
	}

	public void update() {
		SmartDashboard.putNumber("Servo CurrPos", getServoPosition());
		SmartDashboard.putNumber("Servo Angle", getServoAngle());
	}

}
