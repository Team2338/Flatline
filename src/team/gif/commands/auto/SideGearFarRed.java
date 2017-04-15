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
//    	addSequential(new WaitCommand(0.4));
////    	addSequential(new ResetTurret(false));
//        addSequential(new DriveStraightEnc(-97, 0.9, 7)); // Close: -97 Far: -98
//        addSequential(new GyroTurn(62, 1.5));
//        addSequential(new DriveStraightEnc(-18, 0.75, 7)); // Close: -18 Far: -11
//        addParallel(new ShiftOmni(false));
//    	addParallel(new GearRelease(true, true, false));
    	addParallel(new DriveStraightEnc(-30, 0.4, 6));
    	addSequential(new GyroTurn(10, 0.4));
    	addSequential(new GyroTurn(-10, 0.4));
    	addSequential(new GyroTurn(10, 0.4));
    	addSequential(new GyroTurn(-10, 0.4));
    }
    
}
