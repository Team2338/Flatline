package team.gif.commands;

import lib.gif.commands.Command;
import team.gif.Robot;


public class GearRelease extends Command {
	
	private boolean release;
	private boolean isAuto;
	
	public GearRelease(boolean release){
		this(false, release);
	}

    public GearRelease(boolean isAuto, boolean release) {
    	requires(Robot.gearHanger);
    	this.release = release;
    	this.isAuto = isAuto;
    }

    protected void initialize() {
    	if (isAuto) {
    		if (Robot.gearHanger.getSense()) {
    			Robot.gearHanger.release(release);
    		} else {
    			Robot.gearHanger.release(true);
    		}
    	} else {
    		Robot.gearHanger.release(release);
    	}
    }

    protected void execute() {
    	Robot.gearHanger.toggleLight();
    	
    	if (isAuto) {
    		if (Robot.gearHanger.getSense()) {
    			Robot.gearHanger.release(release);
    		}
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	
    }
	
    protected void interrupted() {}
    
}
