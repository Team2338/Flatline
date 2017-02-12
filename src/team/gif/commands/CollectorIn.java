package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;


public class CollectorIn extends Command {
	
	private boolean retract;

    public CollectorIn(boolean retract) {
    	requires(Robot.collector);
    	this.retract = retract;
    	setTimeout(2);
    }

    protected void initialize() {
    	Robot.collector.retract(retract);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }


    protected void interrupted() {
    }
}
