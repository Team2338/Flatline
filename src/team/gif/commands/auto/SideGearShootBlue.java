package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.CollectorIn;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraAim;
import team.gif.commands.shooter.ChangeRevSetpoint;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class SideGearShootBlue extends CommandGroup {

    public SideGearShootBlue() {
    	// Not tuned, DO NOT TUNE FOR MIDWEST!
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_SP, Globals.CAMERA_CENTER_X_SP));
    	addSequential(new WaitCommand(0.4));
    	addSequential(new ResetTurret(true));
    	addParallel(new RevFlywheel());
        addSequential(new DriveStraightEnc(-60.477, 0.75, 7));
        addParallel(new CollectorIn(false));
    	addParallel(new ResetTurret(false, 2));
        addSequential(new GyroTurn(-60, 1.5));
        addSequential(new DriveStraightEnc(-82, 7));
    	addParallel(new GearRelease(true, false));
    	addSequential(new WaitCommand(1.2));
    	addSequential(new DriveStraightEnc(12, 3));
    	addParallel(new CameraAim());
    	addParallel(new FeederDrive(true));
    }
    
}