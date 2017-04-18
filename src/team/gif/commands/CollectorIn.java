package team.gif.commands;

import edu.wpi.first.wpilibj.Timer;
import lib.gif.commands.Command;
import team.gif.Robot;

public class CollectorIn extends Command {
	
	private boolean retract;
	private double initTime;
	private boolean isFullyRetracted;
	
    public CollectorIn(boolean retract) {
    	requires(Robot.collector);
    	this.retract = retract;
    }

    protected void initialize() {
    	initTime = Timer.getFPGATimestamp();
    	isFullyRetracted = false;
    	if (retract) {
    		Robot.collector.retractCollector(!retract);
    		Robot.collector.retractHood(!retract);
    	} else {
        	Robot.collector.retractCollector(!retract); // P: !retract // C: !retract
    	}
    }

    protected void execute() {
    	double finalTime = Timer.getFPGATimestamp();
    	
    	if(finalTime - initTime > 2) {
    		isFullyRetracted = true;
    	}
    }

    protected boolean isFinished() {
        return isFullyRetracted;
    }

    protected void end() {
    	if (!retract) {
        	Robot.collector.retractHood(!retract);
    	}
    }

    protected void interrupted() {}
    
}
