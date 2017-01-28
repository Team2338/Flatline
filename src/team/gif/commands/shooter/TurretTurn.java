package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

public class TurretTurn extends Command {
	
	public final double setpoint;

    public TurretTurn(double setpoint) {
    	requires(Robot.turret);
    	this.setpoint = setpoint;
    }

    protected void initialize() {
    	Robot.turret.setMode(TalonControlMode.Position);
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
