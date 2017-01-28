package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class TurretTurn extends Command {
	
	public final double setpoint;

    public TurretTurn(double setpoint) {
    	requires(Robot.turret);
    	this.setpoint = setpoint;
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.turret.setPosition(setpoint);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
