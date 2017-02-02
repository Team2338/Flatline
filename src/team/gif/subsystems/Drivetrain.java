package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.drivetrain.TankDrive;

public class Drivetrain extends Subsystem {

	private static final CANTalon frontLeft = new CANTalon(RobotMap.frontLeftDrive);
	private static final CANTalon frontRight = new CANTalon(RobotMap.frontRightDrive);
	private static final CANTalon rearLeft = new CANTalon(RobotMap.rearLeftDrive);
	private static final CANTalon rearRight = new CANTalon(RobotMap.rearRightDrive);
	
	public Drivetrain() {
		super();
		frontLeft.changeControlMode(TalonControlMode.Position);
	}

	public void drive(double left, double right) {
		frontLeft.set(left);
		rearLeft.set(left);
		frontRight.set(right);
		rearRight.set(right);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
}

