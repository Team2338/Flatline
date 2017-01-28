package team.gif.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.CollectorStandby;
import com.ctre.CANTalon;

public class Collector extends Subsystem {
	private static final CANTalon collector = new CANTalon(5);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new CollectorStandby());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void drive(int i) {
		// TODO Auto-generated method stub
		
	}
}

