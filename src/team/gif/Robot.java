package team.gif;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.commands.auto.GearGrab;
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
	Command autonomousCommand;
	SendableChooser chooser;

	public void robotInit() {
		oi = new OI();
		chooser = new SendableChooser<Object>();

		grip = NetworkTable.getTable("GRIP");
		SmartDashboard.putNumber("Flywheel P", Globals.FLYWHEEL_P);
		SmartDashboard.putNumber("Flywheel I", Globals.FLYWHEEL_I);
		SmartDashboard.putNumber("Flywheel D", Globals.FLYWHEEL_D);
		SmartDashboard.putNumber("Flywheel F", Globals.FLYWHEEL_F);
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		update();
	}

	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		update();
	}

	public void teleopInit() {
		if (autonomousCommand != null) autonomousCommand.cancel();
		new TankDrive().start(); // Does this have to be here?
	}

	public void teleopPeriodic() {
		update();
	}

	public void testPeriodic() {
		LiveWindow.run();
		update();
	}

	public void update() {
		Scheduler.getInstance().run();
		Robot.drivetrain.update();
		Robot.flywheel.update();
		Robot.turret.update();
		Robot.vision.update();
	}
}
