package team.gif.commands.auto;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import lib.gif.PIDCalculator;
import team.gif.Globals;
import team.gif.Robot;

public class DriveStraightEnc extends Command {

	private double setpoint;
	private double angle;
	private double distError;
	private PIDCalculator distCalc;
	private PIDCalculator angleCalc;

	public DriveStraightEnc(double dist) {
		requires(Robot.drivetrain);
		setpoint = dist;
		distCalc = new PIDCalculator(Globals.DRIVETRAIN_P, Globals.DRIVETRAIN_I, Globals.DRIVETRAIN_D);
		angleCalc = new PIDCalculator(Globals.DRIVE_ANGLE_P, Globals.DRIVE_ANGLE_I, Globals.DRIVE_ANGLE_D);
		Robot.drivetrain.setMode(TalonControlMode.PercentVbus);
	}

	protected void initialize() {
		Robot.drivetrain.resetEncoders();
		angle = Robot.drivetrain.getAngle();
	}

	protected void execute() {
		distError = setpoint - Robot.drivetrain.getRightDist();
		double angleError = angle - Robot.drivetrain.getAngle();

		double distOutput = distCalc.getOutput(distError);
		double angleOutput = angleCalc.getOutput(angleError);

		Robot.drivetrain.drive(distOutput + angleOutput, distOutput - angleOutput);
	}

	protected boolean isFinished() {
		return Math.abs(distError) <= Globals.DRIVE_DIST_TOLERANCE;
	}

	protected void end() {
		Robot.drivetrain.drive(0, 0);
		Robot.drivetrain.resetEncoders();
	}

	protected void interrupted() {
		Robot.drivetrain.drive(0, 0);
	}
	
}
