package team.gif.commands.drivetrain;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import lib.gif.PIDCalculator;
import team.gif.Globals;
import team.gif.Robot;

/**
 *
 */
public class GyroTurn extends Command {

	private double angle;
	private double angleError;
	private PIDCalculator angleCalc;
    
	public GyroTurn() {
		this(Robot.drivetrain.getAngle());
	}
	
	public GyroTurn(double angle) {
        requires(Robot.drivetrain);
        this.angle = angle;
        angleCalc = new PIDCalculator(Globals.DRIVE_ANGLE_P, 
        		Globals.DRIVE_ANGLE_I, Globals.DRIVE_ANGLE_D);
        Robot.drivetrain.setMode(TalonControlMode.PercentVbus);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angleError = angle - Robot.drivetrain.getAngle();
    	double angleOutput = angleCalc.getOutput(angleError);
    	
    	Robot.drivetrain.drive(angleOutput, -angleOutput);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(angleError) <= Globals.DRIVE_ANGLE_TOLERANCE;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
