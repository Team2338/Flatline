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
        addSequential(new DriveStraightEnc(-95, 0.9, 7));
        addSequential(new GyroTurn(-61, 1.5));
        addSequential(new DriveStraightEnc(-4, 0.75, 7));
//    	addParallel(new GearRelease(true, true, false));
//    	addParallel(new DriveStraightEnc(-10, 0.2));
//    	addSequential(new GyroTurn(20, 0.2));
//    	addSequential(new GyroTurn(-20, 0.2));
    }
}
