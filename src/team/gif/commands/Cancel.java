package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import lib.gif.commands.Scheduler;
import team.gif.Robot;

/**
 *
 */
public class Cancel extends Command {

    public Cancel() {
    	requires(Robot.climber);
    	requires(Robot.collector);
    	requires(Robot.feeder);
    	requires(Robot.flywheel);
    	requires(Robot.gearHanger);
    	requires(Robot.turret);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.climber.drive(0);
    	Robot.collector.drive(0);
    	Robot.feeder.driveFeeder(0);
    	Robot.feeder.drivePolyWhisk(0);
    	Robot.flywheel.driveFlywheel(0);
    	Robot.gearHanger.release(false);
    	
    	// TODO: Figure out if this works
    	Scheduler.getInstance().removeAll();
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
