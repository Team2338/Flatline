package team.gif;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;
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
	// public static final Climber climber = new Climber();
	public static final Shooter shooter = new Shooter();
	public static final ShooterTurret turret = new ShooterTurret();
	public static final Geardrop geardrop = new Geardrop();
	public static final Shifter shifter = new Shifter();
	public static final Versadrop versadrop = new Versadrop();
	public static final Intake collector = new Intake();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser chooser;
	// public static Preferences prefs;

	// Vision - test
	public static NetworkTable grip;
	private VisionThread visionThread;
	// GripPipeline grip = new GripPipeline();
	// private final Object imgLock = new Object();

	private double centerX = 0.0;
	private double centerY = 0.0;
	private double area = 0.0;
	private double solidity = 0.0;
	private boolean isProcessing = false;

	public void robotInit() {
		oi = new OI();
		chooser = new SendableChooser();

		grip = NetworkTable.getTable("GRIP");

	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		update();
	}

	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		update();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		new TankDrive().start();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		update();
	}

	public void testPeriodic() {
		LiveWindow.run();
		update();
	}

	public void update() {
		Robot.shooter.update();
		Robot.turret.update();
		SmartDashboard.putNumber("Center X: ", centerX);
		SmartDashboard.putNumber("Center Y: ", centerY);
		SmartDashboard.putNumber("Area: ", area);
		SmartDashboard.putBoolean("Is Processing: ", isProcessing);
		
	}
}
