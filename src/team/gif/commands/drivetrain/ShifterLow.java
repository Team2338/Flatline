package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.Timer;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class ShifterLow extends Command {

	private boolean isLow;
	private boolean isShifted;
	private double left;
	private double right;
	private double initTime;

	public ShifterLow(boolean isLow) {
//		requires(Robot.drivetrain);
		requires(Robot.shifter);
		this.isLow = isLow;
	}

	protected void initialize() {
//		initTime = Timer.getFPGATimestamp();
//		isShifted = false;
		
		Robot.shifter.shift(!isLow);
	}

	protected void execute() {
//		if (Math.abs(OI.driverController.getRawAxis(1)) > Globals.DEAD_ZONE) {
//			left = 0.25 * OI.driverController.getRawAxis(1);
//		} else {
//			left = 0;
//		}
//
//		if (Math.abs(OI.driverController.getRawAxis(5)) > Globals.DEAD_ZONE) {
//			right = 0.25 * OI.driverController.getRawAxis(5);
//		} else {
//			right = 0;
//		}
//		
//		Robot.drivetrain.drive(left, right);
//		
//		if (Timer.getFPGATimestamp() - initTime > 0.3) {
//			Robot.shifter.shift(!isHigh); // P: isHigh C: !isHigh
//			isShifted = true;
//		}
	}

	protected boolean isFinished() {
//		return isShifted;
		return false;
	}

	protected void end() {
//		new TankDrive().start();
	}

	protected void interrupted() {
	}

}
