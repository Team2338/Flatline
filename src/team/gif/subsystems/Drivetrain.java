package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.drivetrain.TankDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private static final CANTalon frontLeft = new CANTalon(RobotMap.frontLeftDrive);
	private static final CANTalon frontRight = new CANTalon(RobotMap.frontRightDrive);
	private static final CANTalon rearLeft = new CANTalon(RobotMap.rearLeftDrive);
	private static final CANTalon rearRight = new CANTalon(RobotMap.rearRightDrive);
	
	public Drivetrain() {
		super();
	}
	
	public void drive(double leftOutput, double rightOutput){
		frontLeft.set(leftOutput);
		frontRight.set(rightOutput);
		rearLeft.set(leftOutput);
		rearRight.set(rightOutput);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
}

