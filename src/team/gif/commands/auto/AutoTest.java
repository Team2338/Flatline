package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.CollectorHoodIn;
import team.gif.commands.CollectorIn;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.drivetrain.WiggleDrive;
import team.gif.commands.shooter.CameraTrack;
import team.gif.commands.shooter.ChangeRevSetpoint;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

// This class is ONLY used for TESTING autonomous code, not for competition use.

public class AutoTest extends CommandGroup {

    public AutoTest() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
//    	addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_FSP, Globals.CAMERA_OFFSET_FSP));
    	addParallel(new RevFlywheel()); // TODO: Maybe put a timeout for auto?
    	addParallel(new CameraTrack()); // TODO: Maybe put a timeout for auto?
        addSequential(new DriveStraightEnc(-99, 0.9, 7)); // Original: -99
    	addParallel(new CollectorIn(false));
//    	addParallel(new CollectorIn(false));
//    	addParallel(new GearRelease(false));
//    	addSequential(new WaitCommand(1.2));
//    	addSequential(new DriveStraightEnc(2157));
//    	addParallel(new CameraFollow());
//    	addParallel(new FeederDrive(true));
    }
    
}