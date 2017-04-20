package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.drivetrain.WiggleDrive;
import team.gif.commands.shooter.ResetTurret;

// This class is ONLY used for TESTING autonomous code, not for competition use.

public class AutoTest extends CommandGroup {

    public AutoTest() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
        addParallel(new WiggleDrive());
    	addParallel(new GearRelease(true, true, false));
//    	addSequential(new GyroTurn(90));
//    	addParallel(new CollectorIn(false));
//    	addParallel(new GearRelease(false));
//    	addSequential(new WaitCommand(1.2));
//    	addSequential(new DriveStraightEnc(2157));
//    	addParallel(new CameraFollow());
//    	addParallel(new FeederDrive(true));
    }
    
}