package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *
 */
public class ClimberUp extends Command {

    public ClimberUp() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
       	Robot.climber.drive(1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
