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

/**
 *
 */
public class SideGearFarBlue extends CommandGroup {

    public SideGearFarBlue() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new WaitCommand(0.4));
        addSequential(new DriveStraightEnc(-91.5, 0.9, 7)); // Original: -99
    	addParallel(new CollectorIn(false));
        addSequential(new GyroTurn(59, 1.5));
        addParallel(new WiggleDrive(false, 8));
    	addParallel(new GearRelease(true, true, false));
    }
}
