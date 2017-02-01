package team.gif.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.IntakeStandby;
import com.ctre.CANTalon;

public class Intake extends Subsystem {

	private static final CANTalon collector = new CANTalon(RobotMap.intake);
    
	public void drive(double speed) {
		collector.set(speed);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeStandby());
    }
}

