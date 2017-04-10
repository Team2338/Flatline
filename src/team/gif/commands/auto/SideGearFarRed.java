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
public class SideGearFarRed extends CommandGroup {

    public SideGearFarRed() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new WaitCommand(0.4));
//    	addSequential(new ResetTurret(false));
        addSequential(new DriveStraightEnc(-96, 0.75, 7));
        addSequential(new GyroTurn(-60, 1.5));
        addSequential(new WaitCommand(0.1));
        addSequential(new DriveStraightEnc(-10, 0.75, 7));
//    	addParallel(new GearRelease(true, false));
    	addSequential(new WaitCommand(1.2));
//    	addSequential(new DriveStraightEnc(12, 0.75, 7));
    }
}
