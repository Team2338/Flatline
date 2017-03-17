package team.gif.commands.drivetrain;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class TankDrive extends Command {

	private double left;
	private double right;
	private double leftLast;
	private double rightLast;
	private double leftStick;
	private double rightStick;
	private double maxAccel;
	private boolean squaredInputs;

	public TankDrive(double maxAccel) {
		requires(Robot.drivetrain);
		this.maxAccel = maxAccel;
	}

	protected void initialize() {
		Robot.drivetrain.setMode(TalonControlMode.PercentVbus);
		this.squaredInputs = SmartDashboard.getBoolean("Squared Inputs", false);
	}

	protected void execute() {
		leftStick = OI.driverController.getRawAxis(1);
		rightStick = OI.driverController.getRawAxis(5);

		left = -(Math.abs(leftStick) > Globals.DEAD_ZONE ? leftStick : 0);

		right = -(Math.abs(rightStick) > Globals.DEAD_ZONE ? rightStick : 0);
		
		if (squaredInputs) {
			left = left * Math.abs(left);
			right = right * Math.abs(right);
		}

		if (!Robot.shifter.isHigh()) {
			if (left > 0 && leftLast < 0 || left < 0 && leftLast > 0) {
				left = 0;
			} else if (left > 0) { //Forward Left
				if (left - leftLast > maxAccel)
					left = leftLast + maxAccel;
			} else if (left < 0){ //Reverse Left
				if (left - leftLast < -maxAccel)
					left = leftLast - maxAccel;
			}
			
			if (right > 0 && rightLast < 0 || right < 0 && rightLast > 0) {
				right = 0;
			} else if (right > 0) { //Forward Right
				if (right - rightLast > maxAccel)
					right = rightLast + maxAccel;
			} else if (right < 0 ){ //Reverse Right
				if (right - rightLast < -maxAccel)
					right = rightLast - maxAccel;
			}
		}

		// TODO: Use velocity in place of left - leftLast
		
		Robot.drivetrain.drive(-left, -right);

		leftLast = left;
		rightLast = right;
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivetrain.drive(0, 0);
	}

	protected void interrupted() {
		end();
	}

}
