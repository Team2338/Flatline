package team.gif.commands.auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.CommandGroup;
import team.gif.commands.CollectorIn;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraFollow;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class SidePegShoot extends CommandGroup {

    public SidePegShoot() {
    	boolean blue = SmartDashboard.getBoolean("BlueAlliance", true);
    	addParallel(new ShifterLow(true));
    	addSequential(new ResetGyro());
    	addSequential(new WaitCommand(0.4));
    	addSequential(new ResetTurret(blue));
    	addParallel(new RevFlywheel());
        addSequential(new DriveStraightEnc(-72.477));
        addSequential(new GyroTurn(blue ? 60 : -60));
        addSequential(new DriveStraightEnc(-69));
        addParallel(new CollectorIn(false));
    	addParallel(new GearRelease(false));
    	addSequential(new WaitCommand(1.2));
    	addSequential(new DriveStraightEnc(12));
    	addParallel(new CameraFollow());
    	addParallel(new FeederDrive(true));
    }
}
