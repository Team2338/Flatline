package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraFollow;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class GearShootBlue extends CommandGroup {

    public GearShootBlue() {
    	addSequential(new ResetTurret());
    	addParallel(new ShifterLow(false));
    	addParallel(new RevFlywheel());
    	addSequential(new DriveStraightEnc(-14100));
    	addParallel(new GearRelease(true));
    	addParallel(new CameraFollow());
    	addParallel(new FeederDrive(true));
    	addSequential(new GearRelease(true));
    }
    
}