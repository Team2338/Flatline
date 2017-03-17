package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.CollectorIn;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraFollow;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class AutoTest extends CommandGroup {

    public AutoTest() {
    	// This class is ONLY used for TESTING autonomous code, not for competition use.
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new ResetTurret(true));
//    	addParallel(new RevFlywheel());
    	addSequential(new DriveStraightEnc(-48, 5));
//    	addSequential(new GyroTurn(90));
//    	addParallel(new CollectorIn(false));
//    	addParallel(new GearRelease(false));
//    	addSequential(new WaitCommand(1.2));
//    	addSequential(new DriveStraightEnc(2157));
//    	addParallel(new CameraFollow());
//    	addParallel(new FeederDrive(true));
    }
    
}