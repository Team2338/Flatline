package team.gif.commands.drivetrain;

import team.gif.Robot;

public class ResetGyro extends lib.gif.commands.Command {

    public ResetGyro() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Robot.drivetrain.resetGyro();
    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}
    protected void interrupted() {}
    
}
