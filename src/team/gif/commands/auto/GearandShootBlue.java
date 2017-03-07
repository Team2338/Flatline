package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ShifterHigh;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.RevFlywheel;

public class GearandShootBlue extends CommandGroup {

    public GearandShootBlue() {
    	addSequential(new ShifterHigh(false));
    	addSequential(new DriveStraightEnc(2849));
    	addSequential(new GearRelease(true));
    	addParallel(new RevFlywheel());
    	addSequential(new WaitCommand(1));
    	addSequential(new FeederDrive());
    }
    
}