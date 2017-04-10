package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.StatusFrameRate;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.MotorLogger;
import lib.gif.commands.Subsystem;
import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.shooter.ShooterStandby;

public class Flywheel extends Subsystem {
	
	private final CANTalon flywheel = new CANTalon(RobotMap.FLYWHEEL_1);
	private final CANTalon flywheel2 = new CANTalon(RobotMap.FLYWHEEL_2);
	private static final Compressor compressor = new Compressor();
	private static double setpoint;
	
	public Flywheel(){
		super();
		
		flywheel.setStatusFrameRateMs(StatusFrameRate.Feedback, 10);
		
		flywheel.enableBrakeMode(false);
		flywheel2.enableBrakeMode(false);
		flywheel.changeControlMode(TalonControlMode.Speed);
		flywheel.setPID(Globals.FLYWHEEL_P_CP, Globals.FLYWHEEL_I_CP, Globals.FLYWHEEL_D_CP);
		flywheel.setF(Globals.FLYWHEEL_F_CP);
		flywheel.setIZone(Globals.FLYWHEEL_I_BELOW);
		flywheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		flywheel.configNominalOutputVoltage(0, -0);
		flywheel.configPeakOutputVoltage(12, -12);
		flywheel.setPosition(0);
		
		flywheel.reverseOutput(true);
		flywheel.reverseSensor(true);
		
		flywheel2.changeControlMode(TalonControlMode.Follower);
		flywheel2.set(RobotMap.FLYWHEEL_1);
		setpoint = Globals.FLYWHEEL_RPM_CP;
		
		MotorLogger.addMotor(flywheel);
	}
	
	public void setPID(double p, double i, double d, double f) {
		flywheel.setPID(p, i, d);
		flywheel.setF(f);
	}
	
	public void setIZone(int iZone) {
		flywheel.setIZone(iZone);
	}
	
	public void setMode(TalonControlMode mode) {
		flywheel.changeControlMode(mode);
	}
	
	public void enableCompressor(boolean isOn) {
		if (isOn) {
			compressor.start();
		} else {
			compressor.stop();
		}
	}
	
	public void driveFlywheel(double speed) {
		flywheel.set(speed);
	}
	
	public void setStandbySetpoint(double setpoint) {
		this.setpoint = setpoint;
	}
	
	public double getStandbySetpoint() {
		return setpoint;
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
	
	public double getIZone() {
		return flywheel.getIZone();
	}
	
	public double getMotorOutput() {
		return flywheel.getOutputVoltage() / flywheel.getBusVoltage();
	}
	
	public double getMotorOutput2() {
		return flywheel2.getOutputVoltage() / flywheel2.getBusVoltage();
	}
	
	public void resetIAccum() {
		flywheel.clearIAccum();
	}
	
	public boolean isInTolerance() {
		return Math.abs(getError()) < Globals.SHOOTER_TOLERANCE;
	}
	
	public void update() {
		SmartDashboard.putNumber("Shooter CurrPos" , getPosition());
		SmartDashboard.putNumber("ShooterVelocity", getVelocity());
		SmartDashboard.putNumber("ShooterError", getError());
		SmartDashboard.putNumber("P Gain", getPGain());
    	SmartDashboard.putNumber("I Gain", getIGain());
    	SmartDashboard.putNumber("D Gain", getDGain());
    	SmartDashboard.putNumber("F Gain", getFGain());
    	SmartDashboard.putNumber("IZone", getIZone());
    	SmartDashboard.putNumber("Rev Standby Setpoint", getStandbySetpoint());
    	SmartDashboard.putNumber("Shooter Motor Output", getMotorOutput());
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterStandby());
    }
    
}

