package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.OI;
import team.gif.Robot;

public class GearOut extends Command {

    public GearOut() {
    	requires(Robot.gearHanger);
    }

    protected void initialize() {
    	Robot.gearHanger.release(false);
    }

    protected void execute() {
    	if (OI.xboxController.getRawAxis(3) > 0) {
    		Robot.gearHanger.release(true);
    	} else {
    		Robot.gearHanger.release(false);
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }


    protected void interrupted() {
    }
}
