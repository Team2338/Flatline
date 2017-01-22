package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.TankDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private static final CANTalon frontLeft = new CANTalon(0);
	private static final CANTalon frontRight = new CANTalon(1);
//	private static final CANTalon rearLeft = new CANTalon(2);
	private static final CANTalon rearRight = new CANTalon(3);
	
//	private static final Solenoid leftSol = new Solenoid(0);
//	private static final Solenoid rightSol = new Solenoid(1);
	
	public void drive(double leftOutput, double rightOutput){
		frontLeft.set(leftOutput);
		frontRight.set(rightOutput);
	}
	
//	public void releaseOmni() {
//		leftSol.set(true);
//		rightSol.set(true);
//	}
//	
//	public void retractOmni() {
//		leftSol.set(false);
//		rightSol.set(false);
//	}

    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
}

