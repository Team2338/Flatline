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
	private static final CANTalon climber2 = new CANTalon(RobotMap.CLIMBER_2);

	public Climber() {
//		climber1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		climber1.reverseOutput(false);
		climber1.reverseSensor(false);
		
		climber2.changeControlMode(TalonControlMode.Follower);
		climber2.set(RobotMap.CLIMBER_1);
	}

	public void drive(double speed) {
		if (speed > 0) {
			climber1.set(speed);
		} else {
			climber1.set(0);
		}
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
	
	public void update() {
		SmartDashboard.putNumber("Climber Current", climber1.getOutputCurrent());
//		SmartDashboard.putNumber("Climber Speed", climber1.getSpeed());
	}

}
