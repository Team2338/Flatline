package team.gif.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;


public class GearRelease extends Command {
	
	private boolean release;

    public GearRelease(boolean release) {
    	requires(Robot.gearHanger);
    	this.release = release;
    	setTimeout(1);
    }

    protected void initialize() {
    	Robot.gearHanger.release(release);
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
