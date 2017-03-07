package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ShifterHigh;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraFollow;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class AutoTest extends CommandGroup {

    public AutoTest() {
    	addSequential(new ResetTurret());
    	addParallel(new RevFlywheel());
//    	addParallel(new ShifterHigh(false));
    	addSequential(new DriveStraightEnc(-14100));
    	addParallel(new CameraFollow());
    	addParallel(new FeederDrive(true));
    }
    
}