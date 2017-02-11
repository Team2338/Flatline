package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.RobotMap;

public class Turret extends Subsystem {
	 
	public final CANTalon turret = new CANTalon(RobotMap.TURRET);

	public Turret() {
		turret.enableBrakeMode(true);
		turret.changeControlMode(TalonControlMode.Position);
		turret.setPID(Globals.TURRET_P, Globals.TURRET_I, Globals.TURRET_D);
		turret.setIZone(Globals.TURRET_I_ZONE);
		turret.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		
		turret.reverseOutput(true);
		turret.reverseSensor(false);
		turret.setAllowableClosedLoopErr(0);
	}
	
	public void setPID(double p, double i, double d) {
		turret.setPID(p, i, d);
	}
	
	public void setMode(TalonControlMode mode) {
		turret.changeControlMode(mode);
	}
	
	public void setPosition(double position){
		turret.set(position);
	}
	
	public double getPGain() {
		return turret.getP() * turret.getError() / 1023;
	}
	
	public double getIGain() {
		return turret.GetIaccum() / 1023;
	}
	
	public double getDGain() {
		return turret.getD() * turret.getSpeed() * (turret.getError() / 
				Math.abs(turret.getError())) / 1023;
	}
	
	public double getFGain() {
		return turret.getF() * turret.getSetpoint() / 1023;
	}
	
	public double getError() {
		return turret.getError();
	}
	
	public double getPosition() {
		return turret.getPosition();
	}
	
	public double getSetpoint() {
		return turret.getSetpoint();
	}
	
	public double getIZone() {
		return turret.getIZone();
	}
	
	public void resetIAccum() {
		turret.clearIAccum();
	}
	
	public boolean isInTolerance() {
		if (Math.abs(getError()) < Globals.TURRET_TOLERANCE) {
			return true;
		} else {
			return false;
		}
	}
	
	public void update() {
		SmartDashboard.putNumber("Turret CurrentPos", getPosition());
		SmartDashboard.putNumber("Turret PGain", getPGain());
		SmartDashboard.putNumber("Turret Error", getError());
	}

    public void initDefaultCommand() {

    }
}

