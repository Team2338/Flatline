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

public class GearShootRed extends CommandGroup {

    public GearShootRed() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_CP, Globals.CAMERA_CENTER_X_CP));
    	addSequential(new WaitCommand(0.4, true));
    	addSequential(new ResetTurret(false));
    	addParallel(new RevFlywheel());
    	addSequential(new DriveStraightEnc(-84, 0.4, 4.5));
    	addParallel(new CollectorIn(false));
    	addParallel(new GearRelease(true, false));
    	addSequential(new WaitCommand(.75));
    	addSequential(new DriveStraightEnc(18, 2));
    	addParallel(new CameraAim());
    	addSequential(new WaitCommand(3));
    	addParallel(new FeederDrive(true));
    }
}