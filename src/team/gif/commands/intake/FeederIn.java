package team.gif.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *
 */
public class FeederIn extends Command {
	
	private boolean isAssisted;

    public FeederIn(boolean isAssisted) {
        requires(Robot.feeder);
        this.isAssisted = isAssisted;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isAssisted) {
    		if (Robot.turret.getInTolerance()) {
    			Robot.feeder.driveFeeder(1);
            	Robot.feeder.drivePolyWhisk(1);
    		}
    	} else {
        	Robot.feeder.driveFeeder(1);
        	Robot.feeder.drivePolyWhisk(1);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
        //return when no more balls
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
