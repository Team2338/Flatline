package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.StatusFrameRate;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.shooter.ShooterStandby;
import team.gif.commands.shooter.TurretManual;

public class Turret extends Subsystem {

	private final CANTalon turret = new CANTalon(RobotMap.TURRET);

	public Turret() {
		super();
		
		turret.setStatusFrameRateMs(StatusFrameRate.Feedback, 10);
		
		turret.enableBrakeMode(true);
		turret.changeControlMode(TalonControlMode.Position);
		turret.setPID(Globals.TURRET_P, Globals.TURRET_I, Globals.TURRET_D);
		turret.setIZone(Globals.TURRET_I_ZONE);
		turret.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);

		turret.reverseOutput(true);
		turret.reverseSensor(false);

		turret.enableLimitSwitch(true, true);
		turret.enableForwardSoftLimit(false);
		turret.enableReverseSoftLimit(false);
		turret.setForwardSoftLimit(-0.05);
		turret.setReverseSoftLimit(-2.00);
		
		turret.setAllowableClosedLoopErr(0);
	}

	public void setPID(double p, double i, double d) {
		turret.setPID(p, i, d);
	}

	public void setMode(TalonControlMode mode) {
		turret.changeControlMode(mode);
	}

	public void setPosition(double position) {
		turret.set(position);
	}
	
	public void resetEncoderPosition() {
		turret.setPosition(0);
	}

	public double getMotorOutput() {
		return turret.getOutputVoltage() / turret.getBusVoltage();
	}

	public double getPGain() {
		return turret.getP() * turret.getError() / 1023;
	}

	public double getIGain() {
		return turret.GetIaccum() / 1023;
	}

	public double getDGain() {
		return turret.getD() * turret.getSpeed() * (turret.getError() / Math.abs(turret.getError())) / 1023;
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

	public boolean isForwardLimitClosed() {
		return turret.isFwdLimitSwitchClosed();
	}

	public boolean isReverseLimitClosed() {
		return turret.isRevLimitSwitchClosed();
	}

	public boolean isInTolerance() {
		return Math.abs(getError()) < Globals.TURRET_TOLERANCE;
	}

	public void update() {
		SmartDashboard.putNumber("Turret MotorOutput", getMotorOutput());
		SmartDashboard.putNumber("Turret CurrentPos", getPosition());
		SmartDashboard.putBoolean("Turret FwdClosed", isForwardLimitClosed());
		SmartDashboard.putBoolean("Turret RevClosed", isReverseLimitClosed());
		SmartDashboard.putNumber("Turret Error", getError());
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TurretManual());
	}
}
