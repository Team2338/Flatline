package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraFollow;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class GearShootRed extends CommandGroup {

    public GearShootRed() {
    	addSequential(new ResetTurret());
    	addParallel(new ShifterLow(false));
    	addParallel(new RevFlywheel());
    	addSequential(new DriveStraightEnc(-14100));
    	addParallel(new GearRelease(true));
    	// TODO: Add a command to turn the turret to a position where it can see the boiler
    	addParallel(new CameraFollow());
    	addParallel(new FeederDrive(true));
    	addSequential(new GearRelease(true));

    }
}
