package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.RevFlywheel;

public class GearandShootRed extends CommandGroup {

    public GearandShootRed() {
    	addSequential(new DriveStraightEnc(2849));
    	addSequential(new GearRelease(true));
    	addParallel(new RevFlywheel());
    	addSequential(new WaitCommand(1));
    	addSequential(new FeederDrive());

    }
}
