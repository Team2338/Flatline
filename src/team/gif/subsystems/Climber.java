package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.ClimberDrive;

public class Climber extends Subsystem {

	private static final CANTalon climber1 = new CANTalon(RobotMap.climber1);
	private static final CANTalon climber2 = new CANTalon(RobotMap.climber2);
	
	public Climber(){
		climber2.set(RobotMap.climber1);
	}

	public void drive(double speed){
		climber1.set(speed);
		climber2.set(speed);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ClimberDrive(0));
    }
}

