package team.gif;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import lib.gif.commands.Scheduler;
import team.gif.commands.auto.GearGrab;
import team.gif.commands.drivetrain.TankDrive;
import team.gif.commands.intake.CollectorDrive;
import team.gif.commands.shooter.TurretManual;
import team.gif.commands.shooter.TurretTurn;
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
	public static SendableChooser turretPosChooser;
	private SendableChooser autoChooser;
	private Command autonomousCommand;
	private boolean isShifted;

	public void robotInit() {
		isShifted = OI.a_leftBumper.get();
		oi = new OI(isShifted);

		autoChooser = new SendableChooser();

		turretPosChooser = new SendableChooser();
		turretPosChooser.addDefault("Blue", new Double(Globals.TURRET_BLUEPOS));
		turretPosChooser.addObject("Red", new Double(Globals.TURRET_REDPOS));
		SmartDashboard.putData("Turret position chooser", turretPosChooser);

		grip = NetworkTable.getTable("GRIP/myContoursReport");

		SmartDashboard.putNumber("Flywheel P", Globals.FLYWHEEL_P);
		SmartDashboard.putNumber("Flywheel I", Globals.FLYWHEEL_I);
		SmartDashboard.putNumber("Flywheel D", Globals.FLYWHEEL_D);
		SmartDashboard.putNumber("Flywheel F", Globals.FLYWHEEL_F);
		SmartDashboard.putNumber("Flywheel RPM", Globals.FLYWHEEL_RPM);
		
		SmartDashboard.putNumber("Turret P", Globals.TURRET_P);
		SmartDashboard.putNumber("Turret I", Globals.TURRET_I);
		SmartDashboard.putNumber("Turret D", Globals.TURRET_D);
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		update();
	}

	public void autonomousInit() {
		autonomousCommand = (Command) autoChooser.getSelected();

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
		new TankDrive().start(); // Does this have to be here?
	}

	public void teleopPeriodic() {
//		if (OI.auxController.getPOV() == 0 || OI.auxController.getPOV() == 45 || OI.auxController.getPOV() == 315) {
//			new TurretTurn((Double) turretPosChooser.getSelected()).start();
//		} else { }
		
		if (OI.auxController.getPOV() == 0 || OI.auxController.getPOV() == 45 || OI.auxController.getPOV() == 315) {
			new TurretTurn((Double) turretPosChooser.getSelected()).start();
		} else {
			new TurretManual().start();
		}
		
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
		Robot.vision.update();

    	if (OI.a_leftBumper.get() != isShifted) {
    		isShifted = !isShifted;
    		oi = new OI(isShifted);
    	}
	}
}
