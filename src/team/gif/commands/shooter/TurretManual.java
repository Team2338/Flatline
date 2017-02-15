package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class TurretManual extends Command {

	private double speed;
	
    public TurretManual(double speed) {
    	requires(Robot.turret);
    	this.speed = speed;
    }

    protected void initialize() {
    	Robot.turret.setMode(TalonControlMode.PercentVbus);
    }

    protected void execute() {
		if (Math.abs(OI.auxController.getRawAxis(1)) > Globals.DEAD_ZONE) {
			Robot.turret.setPosition(OI.auxController.getRawAxis(1));
		} else {
			Robot.turret.setPosition(0);
		}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
