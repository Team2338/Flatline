package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;


public class RevFlywheel extends Command {
	
	public final double setpoint;

    public RevFlywheel(double setpoint) {
    	requires(Robot.shooter);
    	this.setpoint = setpoint;
    }

    protected void initialize() {
    	Robot.shooter.setMode(TalonControlMode.Speed);
    }

    protected void execute() {
    	if(Robot.shooter.getError() >= 0) {
    		Robot.shooter.flywheel.setIZone(Globals.flywheelIZoneBelow);
    	} else if (Robot.shooter.getError() < 0) {
    		Robot.shooter.flywheel.setIZone(Globals.flywheelIZoneAbove);
    	}
    	
    	Robot.shooter.driveFlywheel(setpoint);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }


    protected void interrupted() {
    }
}
