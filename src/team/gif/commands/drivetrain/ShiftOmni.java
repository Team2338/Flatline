package team.gif.commands.drivetrain;
import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class ShiftOmni extends Command {

    public ShiftOmni() {
    	requires(Robot.versadrop);
    }

    protected void initialize() {
    	Robot.versadrop.drop(false);
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
