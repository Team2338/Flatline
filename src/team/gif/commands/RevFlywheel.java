package team.gif.commands;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 *
 */
public class RevFlywheel extends Command {
	
	public final double setpoint;

    public RevFlywheel(double setpoint) {
    	requires(Robot.shooter);
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.setMode(TalonControlMode.Speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.shooter.getIZone() >= 0) {
    		Robot.shooter.flywheel.setIZone(Globals.flywheelIZoneBelow);
    	} else if (Robot.shooter.getIZone() < 0) {
    		Robot.shooter.flywheel.setIZone(Globals.flywheelIZoneAbove);
    	}
    	
    	Robot.shooter.driveFlywheel(setpoint);
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
