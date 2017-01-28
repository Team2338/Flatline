package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class ShooterStandby extends Command {

    public ShooterStandby() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    	Robot.shooter.setMode(TalonControlMode.PercentVbus);
    	Robot.shooter.driveFlywheel(0);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
