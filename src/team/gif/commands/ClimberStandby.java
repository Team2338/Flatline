package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *
 */
public class ClimberStandby extends Command {

    public ClimberStandby() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.climber.drive(0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
