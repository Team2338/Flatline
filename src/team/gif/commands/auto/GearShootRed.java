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

public class GearShootRed extends CommandGroup {

	public GearShootRed() {
		addParallel(new ShifterLow(true));
		addParallel(new ShiftOmni(true));
		addSequential(new ResetGyro());
		addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_CP, Globals.CAMERA_OFFSET_CP_RED));
		addSequential(new WaitCommand(0.4, true));
		addParallel(new RevFlywheel());
		addSequential(new DriveStraightEnc(-74, 0.5, 6)); // Midwest: -84, 0.5, 4.5
		addParallel(new CollectorIn(false));
		addParallel(new GearRelease(true, false));
		addSequential(new WiggleDrive(true, 5));
		addSequential(new DriveStraightEnc(-7, 0.5, 1.5));
		addSequential(new DriveStraightEnc(18, 2));
		addParallel(new CameraTrack());
		addSequential(new WaitCommand(1.5));
		addParallel(new FeederDrive(false, true, true, 0.7, Globals.POLYWHISK_FRPM, 115));
	}
}