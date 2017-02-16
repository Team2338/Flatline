package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import team.gif.Globals;
import team.gif.commands.GearRelease;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.RevFlywheel;

public class GearAndShoot extends CommandGroup {

    public GearAndShoot() {
    	addSequential(new DriveStraightEnc(Globals.DRIVE_DIST));
    	addSequential(new GearRelease(true));
    	addSequential(new DriveStraightEnc(-4960));
    	addSequential(new GyroTurn(230));
    	addSequential(new DriveStraightEnc(8000));
    	addParallel(new RevFlywheel());
    	addSequential(new WaitCommand(1));
    	addSequential(new FeederDrive());
    }
    
}
