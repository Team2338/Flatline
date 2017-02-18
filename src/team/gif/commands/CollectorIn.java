package team.gif.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class CollectorIn extends Command {
	
	private boolean retract;
	private double initTime = Timer.getFPGATimestamp();
	private boolean isFullyRetracted = false;
	
    public CollectorIn(boolean retract) {
    	requires(Robot.collector);
    	this.retract = retract;
    }

    protected void initialize() {
    	if (retract) {
    		Robot.collector.retract(retract);
    		isFullyRetracted = true;
    	} else if (!retract) {
    		Robot.collector.retractCollector(false);
    		if(Timer.getFPGATimestamp() - initTime > 2) {
    			Robot.collector.retractHood(true);
    			isFullyRetracted = true;
    		}
    	}
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return isFullyRetracted;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
