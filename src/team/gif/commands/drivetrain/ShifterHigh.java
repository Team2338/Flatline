package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;


public class ShifterHigh extends Command {

    public ShifterHigh() {
    	requires(Robot.shifter);
    }

    protected void initialize() {
    	Robot.shifter.shift(false);
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
