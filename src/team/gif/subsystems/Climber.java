package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.ClimberDrive;

public class Climber extends Subsystem {

	private static final CANTalon climber = new CANTalon(RobotMap.climber);

	public void drive(double speed){
		climber.set(speed);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ClimberDrive(0));
    }
}

