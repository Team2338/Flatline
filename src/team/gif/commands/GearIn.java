package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;


public class GearIn extends Command {

    public GearIn() {
    	requires(Robot.geardrop);
    }

    protected void initialize() {
    	Robot.geardrop.release(true);
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
