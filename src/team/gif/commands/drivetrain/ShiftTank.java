package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;


public class ShiftTank extends Command {

    public ShiftTank() {
    	requires(Robot.versadrop);
    }

    protected void initialize() {
    	Robot.versadrop.drop(true);
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
