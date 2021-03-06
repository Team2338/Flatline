package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.CollectorIn;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraTrack;
import team.gif.commands.shooter.ChangeRevSetpoint;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class MobilityShootBlue extends CommandGroup {

    public MobilityShootBlue() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_FH, Globals.CAMERA_OFFSET_MS));
    	addSequential(new WaitCommand(0.4, true));
//    	addSequential(new ResetTurret(true));
    	addParallel(new RevFlywheel());
    	addSequential(new DriveStraightEnc(-75, 0.75, 7.5));
    	addParallel(new CollectorIn(false));
    	addParallel(new CameraTrack());
    	addSequential(new WaitCommand(2.5));
    	addParallel(new FeederDrive(true));
    }
    
}