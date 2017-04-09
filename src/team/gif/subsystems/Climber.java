package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.ClimberDrive;

public class Climber extends Subsystem {

	private static final CANTalon climber1 = new CANTalon(RobotMap.CLIMBER_1);

	public Climber() {
		climber1.reverseOutput(false);
		climber1.reverseSensor(false);
	}

	public void drive(double speed) {
		climber1.set(speed);
	}
	
	public void setMode(TalonControlMode mode) {
		climber1.changeControlMode(mode);
	}
	
	public double getCurrent() {
		return climber1.getOutputCurrent();
	}
	
	public static CANTalon getTalon() {
		return climber1;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ClimberDrive());
	}

}
