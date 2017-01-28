package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class GearOut extends Command {

    public GearOut() {
    	requires(Robot.geardrop);
    }

    protected void initialize() {
    	Robot.geardrop.release(false);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }


    protected void interrupted() {
    }
}
