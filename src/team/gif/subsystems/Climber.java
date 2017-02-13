package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.ClimberDrive;

public class Climber extends Subsystem {

	private static final CANTalon climber1 = new CANTalon(RobotMap.CLIMBER_1);
	private static final CANTalon climber2 = new CANTalon(RobotMap.CLIMBER_2);
	
	public Climber(){
		climber2.changeControlMode(TalonControlMode.Follower);
		climber2.set(RobotMap.CLIMBER_1);
	}

	public void drive(double speed){
		climber1.set(speed);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ClimberDrive(0));
    }
    
}
