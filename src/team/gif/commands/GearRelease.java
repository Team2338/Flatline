package team.gif.commands;

import lib.gif.commands.Command;
import team.gif.Robot;
import team.gif.commands.auto.SideGearDrive;


public class GearRelease extends Command {
	
	private boolean release;
	private boolean isAuto;
	private boolean isFarSideAuto;
	private boolean autoFinish = false;
	
	public GearRelease(boolean release){
		this(false, false, release);
	}
	
	public GearRelease(boolean isAuto, boolean release) {
		this(isAuto, false, release);
	}

    public GearRelease(boolean isAuto, boolean isFarSideAuto, boolean release) {
    	requires(Robot.gearHanger);
    	this.release = release;
    	this.isAuto = isAuto;
    	this.isFarSideAuto = isFarSideAuto;
    }

    protected void initialize() {
    	if (isAuto) {
    		if (Robot.gearHanger.getFirstSense() || Robot.gearHanger.getSecondSense()) {
    			Robot.gearHanger.release(release);
				if (isFarSideAuto) {
    				autoFinish = true;
    			}
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
    		if (Robot.gearHanger.getFirstSense() || Robot.gearHanger.getSecondSense()) {
    			Robot.gearHanger.release(release);
				if (isFarSideAuto) {
    				autoFinish = true;
    			}
    		}
    	}
    }

    protected boolean isFinished() {
        return autoFinish;
    }

    protected void end() {
    	if (isFarSideAuto) {
        	new SideGearDrive().start();	
    	}
    }
	
    protected void interrupted() {}
    
}
