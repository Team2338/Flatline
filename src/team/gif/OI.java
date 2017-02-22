package team.gif;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.JoystickAnalogButton;
import lib.gif.buttons.Button;
import lib.gif.buttons.JoystickButton;
import lib.gif.commands.Scheduler;
import team.gif.commands.ClimberDrive;
import team.gif.commands.CollectorHoodIn;
import team.gif.commands.CollectorIn;
import team.gif.commands.GearRelease;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterHigh;
import team.gif.commands.intake.CollectorDrive;
import team.gif.commands.intake.Eject;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.CameraFollow;
import team.gif.commands.shooter.CameraFollowAndRev;
import team.gif.commands.shooter.ManualShoot;
import team.gif.commands.shooter.TurretTurn;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

@SuppressWarnings("unused")
public class OI {
	public static final Joystick driverController = new Joystick(0);
	public static final Joystick auxController = new Joystick(1);

	public static Button d_A;
	private static Button d_B;
	private static Button d_X;
	private static Button d_Y;
	private static Button d_leftTrigger;
	private static Button d_rightTrigger;
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

	public OI(boolean isShifted) {
		d_A = new JoystickButton(driverController, 1);
		d_B = new JoystickButton(driverController, 2);
		d_X = new JoystickButton(driverController, 3);
		d_Y = new JoystickButton(driverController, 4);
		d_leftTrigger = new JoystickAnalogButton(driverController, 2, 0.5);
		d_rightTrigger = new JoystickAnalogButton(driverController, 3, 0.5);

		a_A = new JoystickButton(auxController, 1);
		a_B = new JoystickButton(auxController, 2);
		a_X = new JoystickButton(auxController, 3);
		a_Y = new JoystickButton(auxController, 4);
		a_rightBumper = new JoystickButton(auxController, 6);
		a_select = new JoystickButton(auxController, 7);
		a_start = new JoystickButton(auxController, 8);
		a_leftTrigger = new JoystickAnalogButton(auxController, 2, 0.5);
		a_rightTrigger = new JoystickAnalogButton(auxController, 3, 0.5);

		Scheduler.getInstance().removeAll();
		Scheduler.getInstance().removeAllButtons();
		
		d_leftTrigger.whileHeld(new ShiftOmni(true));
		d_leftTrigger.whenReleased(new ShiftOmni(false));
		d_rightTrigger.whileHeld(new ShifterHigh(true));
		d_rightTrigger.whenReleased(new ShifterHigh(false));
		
		if (isShifted) { // Shift to second set of commands
		// // a_Y.whileHeld(new ClimberDrive(-1));
		 a_rightBumper.whileHeld(new Eject());
		 a_select.whenPressed(new CollectorHoodIn(false));
		 a_start.whenPressed(new CollectorHoodIn(true));
		 a_rightTrigger.whileHeld(new ManualShoot());
		} else {
			a_A.whileHeld(new GearRelease(false));
			a_A.whenReleased(new GearRelease(true));
//			a_B.whenPressed(new TurretTurn(Globals.TURRET_BLUEPOS));
			// a_B.whileHeld(new FeederDrive());
//			a_B.whenPressed(new Cancel());
			a_X.whileHeld(new CameraFollow());
			a_Y.whileHeld(new ClimberDrive(1));
			// a_Y.whileHeld(new ClimberUp());
			a_rightBumper.whileHeld(new CollectorDrive());
			a_select.whenPressed(new CollectorIn(true));
			a_start.whenPressed(new CollectorIn(false));
			a_leftTrigger.whileHeld(new CameraFollowAndRev());
			a_rightTrigger.whileHeld(new FeederDrive(true));
			// a_8.whenPressed(new CollectorIn(true));
			// a_9.whenPressed(new CollectorIn(false));
			// a_15.whileHeld(new RevFlywheel());
		}
	}
}