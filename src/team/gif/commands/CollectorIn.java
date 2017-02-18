package team.gif.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class CollectorIn extends Command {
	
	private boolean retract;
	private double initTime = Timer.getFPGATimestamp();
	
    public CollectorIn(boolean retract) {
    	requires(Robot.collector);
    	this.retract = retract;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (retract) {
    		Robot.collector.retract(retract);
    	} else if (!retract) {
    		Robot.collector.retractCollector(false);
    		if(Timer.getFPGATimestamp() - initTime > 2) {
    			Robot.collector.retractHood(true);
    		}
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
