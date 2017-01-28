package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 *
 */
public class TurretTurn extends Command {
	
	public final double setpoint;

    public TurretTurn(double setpoint) {
    	requires(Robot.turret);
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.turret.setMode(TalonControlMode.Position);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.turret.setPosition(setpoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
