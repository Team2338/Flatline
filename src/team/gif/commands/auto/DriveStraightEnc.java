package team.gif.commands.auto;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.PIDCalculator;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot;

public class DriveStraightEnc extends Command {

	private double setpoint;
	private double angle;
	private double distLeftError;
	private double distRightError;
	private double distError;
	private final double speedCap;
	private PIDCalculator distCalc;
	private PIDCalculator angleCalc;

	public DriveStraightEnc(double dist) {
		this(dist, 0.7);
	}
	
	public DriveStraightEnc(double dist, double speedCap) {
		requires(Robot.drivetrain);
		setpoint = dist;
		this.speedCap = Math.abs(speedCap);
		
		distCalc = new PIDCalculator(Globals.DRIVETRAIN_P, Globals.DRIVETRAIN_I, Globals.DRIVETRAIN_D);
		angleCalc = new PIDCalculator(Globals.DRIVE_ANGLE_P, Globals.DRIVE_ANGLE_I, Globals.DRIVE_ANGLE_D);
		Robot.drivetrain.setMode(TalonControlMode.PercentVbus);
	}

	protected void initialize() {
		Robot.drivetrain.resetEncoders();
		angle = Robot.drivetrain.getAngle();
	}

	protected void execute() {
		distLeftError = setpoint - Robot.drivetrain.getLeftDist();
		distRightError = setpoint - Robot.drivetrain.getRightDist();
//		distError = setpoint - Robot.drivetrain.getRightDist();
		double angleError = angle - Robot.drivetrain.getAngle();

		double distLeftOutput = distCalc.getOutput(distLeftError);
		double distRightOutput = distCalc.getOutput(distRightError);
//		double distOutput = distCalc.getOutput(distError);
		double angleOutput = angleCalc.getOutput(angleError);

//    	if (distOutput > speedCap) {
//    		Robot.drivetrain.drive(-(speedCap + angleOutput), -(speedCap - angleOutput));
//    	} else if (distOutput < -speedCap) {
//    		Robot.drivetrain.drive(-(-speedCap + distOutput), -(-speedCap - distOutput));
//    	} else {
//    		Robot.drivetrain.drive(-distOutput + angleOutput), (-distOutput - angleOutput));
//    	}
		
		SmartDashboard.putNumber("Angle Error", angleError);

		Robot.drivetrain.drive(-distLeftOutput + angleOutput, -distRightOutput - angleOutput);
	}

	protected boolean isFinished() {
		return (Math.abs(distLeftError) <= Globals.DRIVE_DIST_TOLERANCE) && Math.abs(distRightError) <= Globals.DRIVE_DIST_TOLERANCE;
//		return (Math.abs(distError) <= Globals.DRIVE_DIST_TOLERANCE);
	}

	protected void end() {
		Robot.drivetrain.drive(0, 0);
//		Robot.drivetrain.resetEncoders();
	}

	protected void interrupted() {
		Robot.drivetrain.drive(0, 0);
	}
	
}
