package team.gif.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.StatusFrameRate;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.Globals;
import team.gif.Robot;
import team.gif.RobotMap;
import team.gif.commands.shooter.TurretManual;

public class Turret extends Subsystem {

	private final CANTalon turret = new CANTalon(RobotMap.TURRET);

	public Turret() {
		super();
		turret.setStatusFrameRateMs(StatusFrameRate.Feedback, 5);
		turret.enableBrakeMode(true);
		turret.changeControlMode(TalonControlMode.PercentVbus);
		turret.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		turret.reverseOutput(true);
		turret.reverseSensor(false);
		turret.enableLimitSwitch(true, true);
	}

	public void set(double speed) {
		turret.set(speed);
	}
	
	public void resetEncoder() {
		turret.setPosition(0);
	}
	
	public double getSpeed() {
		return turret.getSpeed();
	}

	public double getPosition() {
		return turret.getPosition();
	}
	
	public double getIGain() {
		return turret.GetIaccum() / 1023;
	}

	public boolean isForwardLimitClosed() {
		return turret.isFwdLimitSwitchClosed();
	}

	public boolean isReverseLimitClosed() {
		return turret.isRevLimitSwitchClosed();
	}
	
	public void update() {
		SmartDashboard.putNumber("Turret CurrentPos", getPosition());
		SmartDashboard.putNumber("Turret Speed", getSpeed());
		SmartDashboard.putNumber("Turret IGain", getIGain());
		SmartDashboard.putNumber("Turret Angle", getPosition() / Globals.TURRET_ANGLE_TO_TICK);
		SmartDashboard.putBoolean("Turret FwdClosed", isForwardLimitClosed());
		SmartDashboard.putBoolean("Turret RevClosed", isReverseLimitClosed());
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TurretManual());
	}

}
