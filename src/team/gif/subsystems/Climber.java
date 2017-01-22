package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.ClimberStandby;

/**
 *
 */
public class Climber extends Subsystem {

//	private static final CANTalon climber = new CANTalon(5);

	public void drive(double output){
//		climber.set(output);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ClimberStandby());
    }
}

