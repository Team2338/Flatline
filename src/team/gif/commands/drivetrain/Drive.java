package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;


//enan was here

public class Drive extends Command {

	private double left;
	private double right;
//  public static double distance = Talon.getPosition();
	
    public Drive(double left, double right) {
        requires(Robot.drivetrain);
        this.left = left;
        this.right = right;
    }
    
    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.drive(left, right);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
