package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
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
    	Robot.turret.setPosition(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
