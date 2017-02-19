package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import team.gif.commands.GearRelease;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.RevFlywheel;

public class GearandShootRed extends CommandGroup {

    public GearandShootRed() {
    	addSequential(new DriveStraightEnc(19840));
    	addSequential(new GearRelease(true));
    	addSequential(new DriveStraightEnc(-7440));
    	addSequential(new GyroTurn(110));
    	addSequential(new DriveStraightEnc(8000));
    	addParallel(new RevFlywheel());
    	addSequential(new WaitCommand(1));
    	addSequential(new FeederDrive());

    }
}