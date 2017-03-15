package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.CollectorIn;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraFollow;
import team.gif.commands.shooter.ChangeRevSetpoint;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.RevFlywheel;

public class FarHopperShootBlue extends CommandGroup {

    public FarHopperShootBlue() {
    	addParallel(new ShifterLow(true));
    	addSequential(new ResetGyro());
    	addSequential(new ChangeRevSetpoint(Globals.FLYWHEEL_RPM_FH));
    	addSequential(new WaitCommand(0.4));
    	addSequential(new ResetTurret(false));
    	addParallel(new RevFlywheel());
    	addSequential(new DriveStraightEnc(130.625, 9));
    	addParallel(new CollectorIn(false));
    	addSequential(new GyroTurn(90));
    	addSequential(new DriveStraightEnc(29.25, 3));
    	addParallel(new CameraFollow());
    	addParallel(new FeederDrive(true));
    }
    
}