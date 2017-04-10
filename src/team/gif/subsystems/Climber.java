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
//		climber1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		climber1.reverseOutput(false);
		climber1.reverseSensor(false);
		climber1.EnableCurrentLimit(false);
		climber1.setCurrentLimit(38);
	}

	public void drive(double speed) {
		climber1.set(speed);
	}
	
	public void setMode(TalonControlMode mode) {
		climber1.changeControlMode(mode);
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
