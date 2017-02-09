package team.gif.commands.auto;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.Robot;
import team.gif.RobotMap;

/**
 *
 */
public class Driveup extends Command {
	
	
	public final CANTalon frontRightDrive= new CANTalon(RobotMap.frontRightDrive);
	public final CANTalon frontLeftDrive= new CANTalon(RobotMap.frontLeftDrive);


    public Driveup() {
    	frontLeftDrive.changeControlMode(TalonControlMode.Position);
    	frontRightDrive.changeControlMode(TalonControlMode.Position);
    	frontLeftDrive.setPID(Globals.frontLeftDriveP, Globals.frontLeftDriveI, Globals.frontLeftDriveD);
    	frontRightDrive.setPID(Globals.frontRightDriveP, Globals.frontRightDriveI, Globals.frontRightDriveD);
    	
    	frontLeftDrive.reverseOutput(true);
    	frontLeftDrive.reverseSensor(false);
    	frontLeftDrive.setAllowableClosedLoopErr(0);
    	frontRightDrive.reverseOutput(true);
    	frontRightDrive.reverseSensor(false);
    	frontRightDrive.setAllowableClosedLoopErr(0);
    }
	
	public void setPID(double p, double i, double d) {
		frontLeftDrive.setPID(p, i, d);
		frontRightDrive.setPID(p, i, d);
	}

	public void setMode(TalonControlMode mode) {
		frontRightDrive.changeControlMode(mode);
		frontLeftDrive.changeControlMode(mode);
	}
	
	public void setPosition(double position){
		frontRightDrive.set(position);
		frontLeftDrive.set(position);
	}
	
	public double getPGainRight() {
		return frontRightDrive.getP() * frontRightDrive.getError() / 1;
	}
	public double getPGainLeft() {
		return frontLeftDrive.getP() * frontLeftDrive.getError() / 1;
	}
	
	public double getIGainRight() {
		return frontRightDrive.GetIaccum() / 1;
	}
	public double getIGainLeft() {
		return frontLeftDrive.GetIaccum() / 1;
	}
	
	public double getDGainRight() {
		return frontRightDrive.getD() * frontRightDrive.getSpeed() * (frontRightDrive.getError() / 
				Math.abs(frontRightDrive.getError())) / 1;
	}
	public double getDGainLeft() {
		return frontLeftDrive.getD() * frontLeftDrive.getSpeed() * (frontLeftDrive.getError() / 
				Math.abs(frontLeftDrive.getError())) / 1;
	}
	
	public double getFGainRight() {
		return frontRightDrive.getF() * frontRightDrive.getSetpoint() / 1;
	}
	public double getFGainLeft() {
		return frontLeftDrive.getF() * frontLeftDrive.getSetpoint() / 1;
	}
	
	public double getErrorRight() {
		return frontRightDrive.getError();
	}
	public double getErrorLeft() {
		return frontLeftDrive.getError();
	}
	
	public double getPositionRight() {
		return frontRightDrive.getPosition();
	}
	public double getPositionLeft() {
		return frontLeftDrive.getPosition();
	}
	
	public double getSetpointRight() {
		return frontRightDrive.getSetpoint();
	}
	public double getSetpointLeft() {
		return frontLeftDrive.getSetpoint();
	}
	
	public double getIZoneRight() {
		return frontRightDrive.getIZone();
	}
	public double getIZoneLeft() {
		return frontLeftDrive.getIZone();
	}
	
	public void resetIAccum() {
		frontRightDrive.clearIAccum();
		frontLeftDrive.clearIAccum();
	}
	
	public void update() {
		SmartDashboard.putNumber("frontRightDrive CurrentPos", getPositionRight());
		SmartDashboard.putNumber("frontRightDrive PGain", getPGainRight());
		SmartDashboard.putNumber("frontRightDrive Error", getErrorRight());
		SmartDashboard.putNumber("frontLeftDrive CurrentPos", getPositionLeft());
		SmartDashboard.putNumber("frontLeftDrive PGain", getPGainLeft());
		SmartDashboard.putNumber("frontLeftDrive Error", getErrorLeft());
	}

    public void initDefaultCommand() {

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(0.5, 0.5);
    	
    	
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