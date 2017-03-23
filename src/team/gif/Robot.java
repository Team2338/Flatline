package team.gif;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import lib.gif.commands.Scheduler;
import team.gif.commands.auto.AntiAuto;
import team.gif.commands.auto.AutoTest;
import team.gif.commands.auto.FarHopperShootBlue;
import team.gif.commands.auto.FarHopperShootRed;
import team.gif.commands.auto.GearShootBlue;
import team.gif.commands.auto.GearShootRed;
import team.gif.commands.auto.Mobility;
import team.gif.commands.auto.MobilityShootBlue;
import team.gif.commands.auto.MobilityShootRed;
import team.gif.commands.auto.SideGearShootBlue;
import team.gif.commands.auto.SideGearShootRed;
import team.gif.commands.drivetrain.TankDrive;
import team.gif.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Flywheel flywheel = new Flywheel();
	public static final Collector collector = new Collector();
	public static final Feeder feeder = new Feeder();
	public static final Turret turret = new Turret();
	public static final Climber climber = new Climber();
	public static final GearHanger gearHanger = new GearHanger();
	public static final Shifter shifter = new Shifter();
	public static final Versadrop versadrop = new Versadrop();
	public static final Vision vision = new Vision();
	public static OI oi;

	public static NetworkTable grip;
	public static SendableChooser<Double> turretPosChooser;
	private SendableChooser<Command> autoChooser;
    private SendableChooser<Double> delayChooser;
	private Command autonomousCommand;
	private boolean isShifted;

	public void robotInit() {
		SmartDashboard.putNumber("Turret P", Globals.TURRET_P);
		SmartDashboard.putNumber("Turret I", Globals.TURRET_I);
		SmartDashboard.putNumber("Turret D", Globals.TURRET_D);
		SmartDashboard.putBoolean("Squared Inputs", false);
		
		isShifted = OI.a_leftBumper.get();
		oi = new OI(isShifted);
		
		autoChooser = new SendableChooser<Command>();
        autoChooser.addDefault("AntiAuto", new AntiAuto());
        autoChooser.addObject("AutoTest", new AutoTest());
        autoChooser.addObject("Mobility", new Mobility());
        autoChooser.addObject("MobilityShootRed", new MobilityShootRed());
        autoChooser.addObject("MobilityShootBlue", new MobilityShootBlue());
        autoChooser.addObject("GearShootBlue", new GearShootBlue());
        autoChooser.addObject("GearShootRed", new GearShootRed());
        autoChooser.addObject("FarHopperShootBlue", new FarHopperShootBlue());
        autoChooser.addObject("FarHopperShootRed", new FarHopperShootRed());
        autoChooser.addObject("SideGearShootBlue", new SideGearShootBlue());
        autoChooser.addObject("SideGearShootRed", new SideGearShootRed());
		SmartDashboard.putData("AutoChooser", autoChooser);
		
		delayChooser = new SendableChooser<Double>();
        delayChooser.addDefault("No delay", new Double(0));
        delayChooser.addObject("5 sec", new Double(5));
        SmartDashboard.putData("Delay chooser", delayChooser);

		grip = NetworkTable.getTable("GRIP/myContoursReport");

//		SmartDashboard.putNumber("PolyWhisk P", Globals.POLYWHISK_P);
//		SmartDashboard.putNumber("PolyWhisk I", Globals.POLYWHISK_I);
//		SmartDashboard.putNumber("PolyWhisk D", Globals.POLYWHISK_D);
//		SmartDashboard.putNumber("PolyWhisk F", Globals.POLYWHISK_F);
//		SmartDashboard.putNumber("PolyWhisk RPM", Globals.POLYWHISK_FRPM);
		SmartDashboard.putNumber("Flywheel P", Globals.FLYWHEEL_P_CP);
		SmartDashboard.putNumber("Flywheel I", Globals.FLYWHEEL_I_CP);
		SmartDashboard.putNumber("Flywheel D", Globals.FLYWHEEL_D_CP);
		SmartDashboard.putNumber("Flywheel F", Globals.FLYWHEEL_F_CP);
		SmartDashboard.putNumber("Flywheel RPM", Globals.FLYWHEEL_RPM_CP);
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		update();
	}

	public void autonomousInit() {
		autonomousCommand = (Command) autoChooser.getSelected();

    	if (delayChooser.getSelected() != null) {
    		Timer.delay((Double) delayChooser.getSelected());
    	}
    	
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	public void autonomousPeriodic() {
		update();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		new TankDrive(0.05).start(); // Does this have to be here?
	}

	public void teleopPeriodic() {
//		if (OI.auxController.getPOV() == 0 || OI.auxController.getPOV() == 45 || OI.auxController.getPOV() == 315) {
//			new TurretTurn((Double) turretPosChooser.getSelected()).start();
//		} else {
//			new TurretManual().start();
//		}
		
//		if (OI.auxController.getPOV() == 225 || OI.auxController.getPOV() == 270 || OI.auxController.getPOV() == 315) {
//			new TurretTurn(Globals.TURRET_BLUEPOS).start();
//		} else if (OI.auxController.getPOV() == 45 || OI.auxController.getPOV() == 90 || OI.auxController.getPOV() == 135) {
//			new TurretTurn(Globals.TURRET_REDPOS).start();
//		} else {
//			new TurretManual().start();
//		}
		
		update();
	}

	public void testPeriodic() {
		LiveWindow.run();
		update();
	}

	private void update() {
		Scheduler.getInstance().run();
		Robot.drivetrain.update();
		Robot.flywheel.update();
		Robot.turret.update();
		Robot.feeder.update();
		Robot.gearHanger.update();
		Robot.vision.update();

    	if (OI.a_leftBumper.get() != isShifted) {
    		isShifted = !isShifted;
    		oi = new OI(isShifted);
    	}
	}
}
