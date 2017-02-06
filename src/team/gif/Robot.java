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
	SendableChooser<Object> chooser;
	
	public void robotInit() {
		oi = new OI();
		chooser = new SendableChooser<Object>();

		grip = NetworkTable.getTable("GRIP");
		
		SmartDashboard.putNumber("Flywheel P", Globals.flywheelP);
		SmartDashboard.putNumber("Flywheel I", Globals.flywheelI);
		SmartDashboard.putNumber("Flywheel D", Globals.flywheelD);
		SmartDashboard.putNumber("Flywheel F", Globals.flywheelF);
		SmartDashboard.putNumber("Flywheel RPM", Globals.flywheelRPM);
	}
	public static int lor = 0;

	public void disabledInit() {}

	public void disabledPeriodic() {
		update();
	}

	public void autonomousInit() {
		autonomousCommand = new GearGrab();
				//(Command) chooser.getSelected();

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		update();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		new TankDrive().start(); //Does this have to be here?
		
//		turret.setPID(SmartDashboard.getNumber("Turret P", Globals.turretP), 
//				SmartDashboard.getNumber("Turret I", Globals.turretI), 
//				SmartDashboard.getNumber("Turret D", Globals.turretD));
//		
//		Globals.turretPosition = SmartDashboard.getNumber("Turret Position", Globals.turretPosition);
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
		Robot.flywheel.update();
		Robot.turret.update();
		Robot.vision.update();
	}
}
