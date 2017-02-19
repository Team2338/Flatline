package team.gif;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.JoystickAnalogButton;
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
	public static final Joystick leftStick = new Joystick(0);
	public static final Joystick rightStick = new Joystick(1);
	public static final Joystick auxController  = new Joystick(1);
//	public static final Joystick buttonBoard = new Joystick(2);
	
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
	
	private static Button a_2;
	private static Button a_3;
	private static Button a_4;
	private static Button a_5;
	private static Button a_6;
	private static Button a_7;
	private static Button a_8;
	private static Button a_9;
	private static Button a_10;
//	public static Button a_11 = new JoystickButton(buttonBoard, 11);
	private static Button a_12;
	private static Button a_14;
	private static Button a_15;
	
	private static Button l_2;
	private static Button r_2;
	
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
		
//		l_2 = new JoystickButton(leftStick, 2);
//		r_2 = new JoystickButton(rightStick, 2);
		
//		a_2 = new JoystickButton(buttonBoard, 2);
//		a_3 = new JoystickButton(buttonBoard, 3);
//		a_4 = new JoystickButton(buttonBoard, 4);
//		a_5 = new JoystickButton(buttonBoard, 5);
//		a_6 = new JoystickButton(buttonBoard, 6);
//		a_7 = new JoystickButton(buttonBoard, 7);
//		a_8 = new JoystickButton(buttonBoard, 8);
//		a_9 = new JoystickButton(buttonBoard, 9);
//		a_10 = new JoystickButton(buttonBoard, 10);
//		a_12 = new JoystickButton(buttonBoard, 12);
//		a_14 = new JoystickButton(buttonBoard, 14);
//		a_15 = new JoystickButton(buttonBoard, 15);
		
		a_A = new JoystickButton(auxController, 1);
		a_B = new JoystickButton(auxController, 2);
		a_X = new JoystickButton(auxController, 3);
		a_Y = new JoystickButton(auxController, 4);
		a_rightBumper = new JoystickButton(auxController, 6);
		a_select = new JoystickButton(auxController, 7);
		a_start = new JoystickButton(auxController, 8);
		
//		a_Y.whileHeld(new RevFlywheel());
//		a_Y.whenReleased(new ShooterStandby());
	
//		a_A.whenPressed(new Servo(0.5));
//		a_Y.whenPressed(new Servo(0.01));
//		a_X.whileHeld(new FeederDrive(false, 0));
//
//		a_A.whileHeld(new CameraFollow());
//		a_B.whenPressed(new TurretTurn(Globals.TURRET_POS));
//		a_X.whenPressed(new TurretTurn(0));
		
		// Driver controls
		d_A.whileHeld(new FeederDrive());
		d_Y.whileHeld(new RevFlywheel());
		d_Y.whenReleased(new ShooterStandby());

		// a_A = new JoystickButton(auxController, 1);
		// a_B = new JoystickButton(auxController, 2);
		// a_X = new JoystickButton(auxController, 3);
		// a_Y = new JoystickButton(auxController, 4);
		// a_rightBumper = new JoystickButton(auxController, 6);
		// a_select = new JoystickButton(auxController, 7);
		// a_start = new JoystickButton(auxController, 8);

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
		
//		l_2.whileHeld(new ShiftOmni(true));
//		l_2.whenReleased(new ShiftOmni(false));
//		r_2.whileHeld(new ShifterHigh(true));
//		r_2.whenReleased(new ShifterHigh(false));
		
		// Auxiliary controls
		new CameraFollowAndRev();
		new ManualShoot();
		new CameraShoot();
		
//		a_2.whileHeld(new ClimberDrive(1));
//		a_4.whileHeld(new FeederDrive());
//		a_5.whileHeld(new Eject());
//		a_6.whileHeld(new CollectorDrive());
//		a_7.whenPressed(new Cancel());
//		a_10.whileHeld(new GearRelease(false));
//		a_10.whenReleased(new GearRelease(true));
//		a_14.whileHeld(new ClimberDrive(-1));

		// Auxiliary controls
		if (isShifted) { // Shift to second set of commands
			// a_Y.whileHeld(new ClimberDrive(-1));
			a_rightBumper.whileHeld(new Eject());
			a_select.whenPressed(new CollectorHoodIn(false));
			a_start.whenPressed(new CollectorHoodIn(true));
//			a_8.whenPressed(new CollectorHoodIn(false));
//			a_9.whenPressed(new CollectorHoodIn(true));
//			a_15.whileHeld(new CameraFollowAndRev());
			a_rightTrigger.whileHeld(new ManualShoot());
		} else {
			a_A.whileHeld(new GearRelease(false));
			a_A.whenReleased(new GearRelease(true));
//			a_B.whileHeld(new FeederDrive());
			a_B.whenPressed(new Cancel());
//			a_Y.whileHeld(new RevFlywheel());
			a_Y.whenReleased(new ShooterStandby());
//			a_X.whileHeld(new ClimberDrive(1));
			a_Y.whileHeld(new ClimberUp());
			a_rightBumper.whileHeld(new CollectorDrive());
			a_select.whenPressed(new CollectorIn(true));
			a_start.whenPressed(new CollectorIn(false));
//			a_8.whenPressed(new CollectorIn(true));
//			a_9.whenPressed(new CollectorIn(false));
//			a_15.whileHeld(new RevFlywheel());
			a_rightTrigger.whileHeld(new FeederDrive(true));
			a_leftTrigger.whileHeld(new CameraFollowAndRev());
		}
	}
}