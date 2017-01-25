package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.commands.ShooterStandby;

/**
 *
 */
public class Shooter extends Subsystem {
	
	private static final CANTalon flywheel = new CANTalon(2);
	private static final CANTalon flywheel2 = new CANTalon(6);
	
	public Shooter(){
		flywheel.enableBrakeMode(false);
		flywheel2.enableBrakeMode(false);
		flywheel.changeControlMode(TalonControlMode.Speed);
		flywheel.setPID(Globals.flywheelP, Globals.flywheelI, Globals.flywheelD);
		flywheel.setF(Globals.flywheelF);
		flywheel.setIZone(Globals.flywheelIZone);
		flywheel.setFeedbackDevice(FeedbackDevice.QuadEncoder); // TODO: figure out unit conversion (CtreAbsoluteMag_Relative is proper)
		flywheel.setPosition(0);
//		flywheel.configEncoderCodesPerRev(4096*3); // 4096 * 3 (CPR * gear ratio)
		
		flywheel.reverseOutput(false);
		flywheel.reverseSensor(true);
		
		flywheel2.changeControlMode(TalonControlMode.Follower);
		flywheel2.set(2);
		
	}
	
	public void setMode(TalonControlMode mode) {
		flywheel.changeControlMode(mode);
	}
	
	public double getVelocity() {
		return flywheel.getSpeed();
	}
	
	public double getError() {
		return flywheel.getError();
	}
	
	public double getPosition() {
		return flywheel.getPosition();
	}
	
	public void driveFlywheel(double speed) {
		flywheel.set(speed);
	}
	
	public double getPGain() {
		return flywheel.getP() * flywheel.getError() / 1023;
	}
	
	public double getIGain() {
		return flywheel.GetIaccum() / 1023;
	}
	
	public double getDGain() {
		return flywheel.getD() * flywheel.getSpeed() * (flywheel.getError() / 
				Math.abs(flywheel.getError())) / 1023;
	}
	
	public double getFGain() {
		return flywheel.getF() * flywheel.getSetpoint() / 1023;
	}
	
	public double getSetpoint() {
		return flywheel.getSetpoint();
	}
	
	public void resetIAccum() {
		flywheel.clearIAccum();
	}
	
	public void update() {
		SmartDashboard.putNumber("Current Position" , getPosition());
		SmartDashboard.putNumber("ShooterVelocity", getVelocity());
		SmartDashboard.putNumber("ShooterError", getError());
		SmartDashboard.putNumber("P Gain", getPGain());
    	SmartDashboard.putNumber("I Gain", getIGain());
    	SmartDashboard.putNumber("D Gain", getDGain());
    	SmartDashboard.putNumber("F Gain", getFGain());
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterStandby());
    }
}
