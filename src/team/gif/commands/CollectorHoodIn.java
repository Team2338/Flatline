package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class CollectorHoodIn extends Command {
	
	private boolean retract;
	
    public CollectorHoodIn(boolean retract) {
    	requires(Robot.collector);
    	this.retract = retract;
    }

    protected void initialize() {
    	Robot.collector.retractHood(retract);
    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
