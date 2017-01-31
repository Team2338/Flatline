package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *enan was here
 */
public class Drive extends Command {

    public Drive(double right, double left) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	    	
		Robot.drivetrain.drive(right, left);
    }
    
   

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
