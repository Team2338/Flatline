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
    	addSequential(new DriveStraightEnc(10, 0.9, 3));
    	addSequential(new GyroTurn(60, 1.5)); // Make sure to change this to correspond to alliance color! R: 60 | B: -60
    	addSequential(new DriveStraightEnc(100, 0.9, 10));
    }
}
