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

    protected void initialize() {
    }

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

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
