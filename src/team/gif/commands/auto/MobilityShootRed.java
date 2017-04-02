package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.CollectorIn;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraAim;
import team.gif.commands.shooter.ChangeRevSetpoint;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class MobilityShootRed extends CommandGroup {

    public MobilityShootRed() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_FH, Globals.CAMERA_CENTER_X_MS));
    	addSequential(new WaitCommand(0.4, true));
//    	addSequential(new ResetTurret(false));
    	addParallel(new RevFlywheel());
    	addSequential(new DriveStraightEnc(-75, 0.75, 7.5));
    	addParallel(new CollectorIn(false));
    	addParallel(new CameraAim());
    	addSequential(new WaitCommand(2.5));
    	addParallel(new FeederDrive(true));
    }
    
}