package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.drivetrain.WiggleDrive;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraTrack;
import team.gif.commands.shooter.ChangeRevSetpoint;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

/**
 *
 */
public class SideGearFarRed extends CommandGroup {

    public SideGearFarRed() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_FSP, Globals.CAMERA_OFFSET_SP));
    	addParallel(new RevFlywheel()); // TODO: Maybe put a timeout for auto?
    	addParallel(new CameraTrack()); // TODO: Maybe put a timeout for auto?
    	addSequential(new FeederDrive(false, false, 1.00, Globals.POLYWHISK_FRPM, 5));
        addSequential(new DriveStraightEnc(-98, 0.9, 7));
        addSequential(new GyroTurn(-62, 1.5));
        addSequential(new WiggleDrive());
//    	addParallel(new GearRelease(true, true, false));
    }
    
}
