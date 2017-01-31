package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class ShifterLow extends Command {

    public ShifterLow() {
    	requires(Robot.shifter);
    }

    protected void initialize() {
    	Robot.shifter.shift(true);
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
