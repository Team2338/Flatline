package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.CollectorIn;
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

public class SideGearCloseRed extends CommandGroup {

    public SideGearCloseRed() {
    	// Not fully tuned
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_SP, Globals.CAMERA_OFFSET_SP));
    	addSequential(new WaitCommand(0.4));
    	addSequential(new ResetTurret(false));
    	addParallel(new RevFlywheel());
        addSequential(new DriveStraightEnc(-97, 0.9, 7));
        addParallel(new CollectorIn(false));
    	addParallel(new ResetTurret(true, 2));
        addSequential(new GyroTurn(62, 1.5));
        addSequential(new DriveStraightEnc(-9, 0.75, 7));
    	addParallel(new GearRelease(true, false));
    	addSequential(new WaitCommand(0.75));
    	addSequential(new DriveStraightEnc(12, 7));
    	addParallel(new CameraTrack());
    	addParallel(new FeederDrive(true)); 
    }
    
}