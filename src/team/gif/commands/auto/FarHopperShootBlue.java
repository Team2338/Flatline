package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.CollectorIn;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraFollow;
import team.gif.commands.shooter.ChangeRevSetpoint;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class FarHopperShootBlue extends CommandGroup {

    public FarHopperShootBlue() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_FH, Globals.CAMERA_CENTER_X_FH));
    	addSequential(new WaitCommand(0.4));
    	addSequential(new ResetTurret(false));
    	addParallel(new RevFlywheel());
    	addParallel(new CollectorIn(false));
    	addSequential(new DriveStraightEnc2(118.5, 0.65, 6));
    	addSequential(new GyroTurn(88));
    	addSequential(new DriveStraightEnc2(40.75, 0.35, 3));
    	addParallel(new DriveStraightEnc2(50, 0.1, 5));
    	addParallel(new CameraFollow());
    	addParallel(new FeederDrive(true));
    }
    
}