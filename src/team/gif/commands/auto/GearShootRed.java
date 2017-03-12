package team.gif.commands.auto;

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

public class GearShootRed extends CommandGroup {

    public GearShootRed() {
    	// TODO: Never tested!
    	addParallel(new ShifterLow(true));
    	addSequential(new ResetGyro());
    	addSequential(new WaitCommand(0.4));
    	addSequential(new ResetTurret(false));
    	addParallel(new RevFlywheel());
    	addSequential(new DriveStraightEnc(-77.33));
    	addParallel(new CollectorIn(false));
    	addParallel(new GearRelease(true));
    	addSequential(new WaitCommand(1.5));
    	addSequential(new DriveStraightEnc(12));
    	addParallel(new CameraFollow());
    	addParallel(new FeederDrive(true));
    }
}
