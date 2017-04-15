package team.gif.commands.drivetrain;

import lib.gif.commands.Command;
import team.gif.Robot;

/**
 *
 */
public class WiggleDrive extends Command {
	
	double i;

    public WiggleDrive() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	i = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(0.15 + (0.3 * Math.sin(i)), 0.15 - (0.3 * Math.sin(i)));
    	i += 3.14159 / 8;
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
