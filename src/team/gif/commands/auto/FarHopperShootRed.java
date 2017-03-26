package team.gif.commands.auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.CollectorHoodIn;
import team.gif.commands.CollectorIn;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraFollow;
import team.gif.commands.shooter.ChangeRevSetpoint;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class FarHopperShootRed extends CommandGroup {

    public FarHopperShootRed() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_FH, Globals.CAMERA_CENTER_X_FH));
    	addSequential(new WaitCommand(0.4));
    	addSequential(new ResetTurret(true));
    	addParallel(new RevFlywheel());
    	addParallel(new CollectorIn(false));
    	addSequential(new DriveStraightEnc(113.5, 0.85, 6));
    	addSequential(new GyroTurn(-88));
    	addParallel(new CollectorHoodIn(false));
    	addParallel(new CameraFollow());
    	addSequential(new DriveStraightEnc(30.75, 0.85, 3));
    	addParallel(new DriveStraightEnc(50, 0.1, 5));
    	addParallel(new FeederDrive(true));
    }
}