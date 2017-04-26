package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.CollectorHoodIn;
import team.gif.commands.CollectorIn;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.CollectorDrive;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraTrack;
import team.gif.commands.shooter.ChangeRevSetpoint;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class FarHopperShootBlue extends CommandGroup {

    public FarHopperShootBlue() {
    	addParallel(new ShifterLow(false));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_FH, Globals.CAMERA_OFFSET_FH));
    	addSequential(new WaitCommand(0.4, true));
//    	addSequential(new ResetTurret(false));
    	addParallel(new RevFlywheel());
    	addParallel(new CollectorIn(false));
    	addSequential(new DriveStraightEnc(101.5, 0.85, 6));
    	addParallel(new ShifterLow(true));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new GyroTurn(90, 2));
    	addParallel(new CollectorHoodIn(false));
       	addSequential(new DriveStraightEnc(30.75, 0.85, 3));
    	addParallel(new CameraTrack());
    	addParallel(new DriveStraightEnc(50, 0.1, 5));
    	addParallel(new FeederDrive(false, false, 1.0, Globals.POLYWHISK_FHRPM, 115));
    	addSequential(new WaitCommand(5));
    	addParallel(new CollectorDrive());
    	addSequential(new CollectorIn(true));
    	addSequential(new WaitCommand(0.75));
    	addSequential(new CollectorIn(false));
    }
}