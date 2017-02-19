package team.gif;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.JoystickAnalogButton;
import lib.gif.commands.Scheduler;
import team.gif.commands.*;
import team.gif.commands.drivetrain.*;
import team.gif.commands.intake.CollectorDrive;
import team.gif.commands.intake.Eject;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final Joystick driverController = new Joystick(0);
	public static final Joystick auxController = new Joystick(1);
	// public static final Joystick buttonBoard = new Joystick(1);

	private static Button d_A;
	private static Button d_B;
	private static Button d_X;
	private static Button d_Y;
	private static Button d_leftBumper;
	private static Button d_rightBumper;
	private static Button d_leftStick;
	private static Button d_rightStick;

	private static Button a_A;
	private static Button a_B;
	private static Button a_X;
	private static Button a_Y;
	public static Button a_leftBumper = new JoystickButton(auxController, 5);
	private static Button a_rightBumper;
	private static Button a_select;
	private static Button a_start;
	private static Button a_leftStick;
	private static Button a_rightStick;
	private static Button a_rightTrigger;
	private static Button a_leftTrigger;

	// private static Button a_1;
	// private static Button a_2;
	// private static Button a_3;
	// private static Button a_4;
	// private static Button a_5;
	// private static Button a_6;
	// private static Button a_7;
	// private static Button a_8;
	// private static Button a_9;
	// private static Button a_10;
	// private static Button a_11 = new JoystickButton(buttonBoard, 11);
	// private static Button a_12;
	// private static Button a_13;

	public OI(boolean isShifted) {
		a_rightTrigger = new JoystickAnalogButton(auxController, 3, 0.5);
		a_leftTrigger = new JoystickAnalogButton(auxController, 2, 0.5);
		d_A = new JoystickButton(driverController, 1);
		d_B = new JoystickButton(driverController, 2);
		d_X = new JoystickButton(driverController, 3);
		d_Y = new JoystickButton(driverController, 4);
		d_leftBumper = new JoystickButton(driverController, 5);
		d_rightBumper = new JoystickButton(driverController, 6);

		a_A = new JoystickButton(auxController, 1);
		a_B = new JoystickButton(auxController, 2);
		a_X = new JoystickButton(auxController, 3);
		a_Y = new JoystickButton(auxController, 4);
		a_rightBumper = new JoystickButton(auxController, 6);
		a_select = new JoystickButton(auxController, 7);
		a_start = new JoystickButton(auxController, 8);
		
		Scheduler.getInstance().removeAll();
		Scheduler.getInstance().removeAllButtons();

		// Debug controls (can be deleted later)
		// a_Y.whileHeld(new RevFlywheel());
		// a_Y.whenReleased(new ShooterStandby());

		// a_A.whenPressed(new Servo(0.5));
		// a_Y.whenPressed(new Servo(0.01));
		// a_X.whileHeld(new FeederDrive(false, 0));
		//
		// a_A.whileHeld(new CameraFollow());
		// a_B.whenPressed(new TurretTurn(Globals.TURRET_POS));
		// a_X.whenPressed(new TurretTurn(0));

		// Driver controls
		// d_A.whileHeld(new FeederDrive());
		// d_Y.whileHeld(new RevFlywheel());
		// d_Y.whenReleased(new ShooterStandby());
		d_leftBumper.whileHeld(new ShiftOmni(true));
		d_leftBumper.whenReleased(new ShiftOmni(false));
		d_rightBumper.whileHeld(new ShifterHigh(true));
		d_rightBumper.whenReleased(new ShifterHigh(false));
		

		// Auxiliary controls
		if (isShifted) { // Shift to second set of commands
			// a_Y.whileHeld(new ClimberDrive(-1));
			a_rightBumper.whileHeld(new Eject());
			a_select.whenPressed(new CollectorHoodIn(false));
			a_start.whenPressed(new CollectorHoodIn(true));
			a_rightTrigger.whileHeld(new ManualShoot());
		} else {
			a_A.whileHeld(new GearRelease(false));
			a_A.whenReleased(new GearRelease(true));
			// a_B.whileHeld(new FeederDrive());
			a_B.whenPressed(new Cancel());
			a_X.whileHeld(new CameraFollow());
			// a_Y.whileHeld(new ClimberUp());
			a_rightBumper.whileHeld(new CollectorDrive());
			a_select.whenPressed(new CollectorIn(true));
			a_start.whenPressed(new CollectorIn(false));
			// a_rightTrigger.whileHeld(new FeederDrive(true));
//			a_rightTrigger.whileHeld(new ManualShoot());
			a_leftTrigger.whileHeld(new CameraFollowAndRev());
		}
	}
}