package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.CollectorIn;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraFollow;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class SideGearShootRed extends CommandGroup {

    public SideGearShootRed() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new WaitCommand(0.4));
    	addSequential(new ResetTurret(false));
    	addParallel(new RevFlywheel());
        addSequential(new DriveStraightEnc(-72.477, 7));
    	addParallel(new ResetTurret(true, 2.5));
        addSequential(new GyroTurn(60));
        addSequential(new DriveStraightEnc(-69, 7));
        addParallel(new CollectorIn(false));
    	addParallel(new GearRelease(false));
    	addSequential(new WaitCommand(1.2));
    	addSequential(new DriveStraightEnc(12, 7));
    	addParallel(new CameraFollow());
    	addParallel(new FeederDrive(true));
    }
    
}