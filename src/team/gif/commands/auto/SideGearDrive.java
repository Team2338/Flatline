package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.shooter.ResetTurret;

/**
 *
 */

// This command group runs if the gear releases at the far side
public class SideGearDrive extends CommandGroup {
    public SideGearDrive() {
    	addParallel(new GearRelease(false, false));
    	addParallel(new DriveStraightEnc(0, 0.9, 0.75));
    	addSequential(new WaitCommand(.25));
    	addSequential(new DriveStraightEnc(28, 0.9, 3));
    	addSequential(new ResetGyro());
    	addSequential(new GyroTurn(70, 1.5)); // Make sure to change this to correspond to alliance color! R: 70 | B: -70
    	addParallel(new ShifterLow(false));
    	addSequential(new WaitCommand(0.4));
    	addSequential(new DriveStraightEnc(-125, 0.8, 10));
    }
}
