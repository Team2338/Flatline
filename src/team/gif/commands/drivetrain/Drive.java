package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *Inane was here
 */


public class Drive extends Command {

	private double left;
	private double right;
	double angle;
//                                                                                               n	public static double distance = Talon.getPosition();
	
    public Drive(double left, double right) {
        requires(Robot.drivetrain);
        this.left = left;
        this.right = right;
      
        
		

    }
    


    // Called just before this Command runs the first time
    protected void initialize() {
    	angle = Robot.drivetrain.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (angle - Robot.drivetrain.getAngle() < -1) {
    		Robot.drivetrain.drive(left - .1, right + .1);  
    		
    	} else if (angle - Robot.drivetrain.getAngle() < 0) {	
    		Robot.drivetrain.drive(left + .1, right - .1);
    		
    	} else {
    		Robot.drivetrain.drive(left, right); 
    	}	
}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
