package team.gif.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Robot;
import team.gif.RobotMap;
import team.gif.commands.intake.FeederDrive;

import com.ctre.CANTalon;

public class Feeder extends Subsystem {

	private static final CANTalon feeder = new CANTalon(RobotMap.FEEDER);
	private static final CANTalon polyWhisk = new CANTalon(RobotMap.POLY_WHISK);
	private static final Servo flappy = new Servo(RobotMap.FLAPPY_SERVO);
	
	public void driveFeeder(double speed) {
		feeder.set(-speed);
	}
	
	public void drivePolyWhisk(double speed) {
		polyWhisk.set(speed);
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

