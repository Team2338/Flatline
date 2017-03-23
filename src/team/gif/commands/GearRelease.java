package team.gif.commands;

import lib.gif.commands.Command;
import team.gif.Robot;


public class GearRelease extends Command {
	
	private boolean release;

    public GearRelease(boolean release) {
    	requires(Robot.gearHanger);
    	this.release = release;
    }

    protected void initialize() {
//    	if (Robot.gearHanger.getSense()) {
//        	Robot.gearHanger.release(release);
//    	} else {
//    		Robot.gearHanger.release(true);
//    	}
    	
    	Robot.gearHanger.release(release);
    }

    protected void execute() {}

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	
    }
	
    protected void interrupted() {}
    
}
