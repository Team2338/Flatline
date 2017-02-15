package team.gif;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.commands.*;
import team.gif.commands.drivetrain.*;
import team.gif.commands.intake.CollectorDrive;
import team.gif.commands.intake.Eject;
import team.gif.commands.shooter.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final Joystick driverController = new Joystick(0);
	public static final Joystick auxController  = new Joystick(1);
	
	private static Button d_leftBumper;
	private static Button d_rightBumper;
	private static Button d_leftStick;
	private static Button d_rightStick;
	
	private static Button a_A;
	private static Button a_B;
	private static Button a_X;
	private static Button a_Y;
	private static Button a_leftBumper;
	private static Button a_rightBumper;
	private static Button a_select;
	private static Button a_start;
	private static Button a_leftStick;
	private static Button a_rightStick;
	
	public OI() {
		d_leftBumper = new JoystickButton(driverController, 5);
		d_rightBumper = new JoystickButton(driverController, 6);
		
		a_A = new JoystickButton(auxController, 1);
		a_B = new JoystickButton(auxController, 2);
		a_X = new JoystickButton(auxController, 3);
		a_Y = new JoystickButton(auxController, 4);
		a_leftBumper = new JoystickButton(auxController, 5);
		a_rightBumper = new JoystickButton(auxController, 6);
		a_select = new JoystickButton(auxController, 7);
		a_start = new JoystickButton(auxController, 8);
		
//		y.whileHeld(new RevFlywheel());
//		y.whenReleased(new ShooterStandby());
//
//		a.whileHeld(new CameraFollow());
//		b.whenPressed(new TurretTurn(Globals.TURRET_POS));
//		x.whenPressed(new TurretTurn(0));
		
		// Real controls below
		d_leftBumper.whileHeld(new ShiftOmni(true));
		d_leftBumper.whenReleased(new ShiftOmni(false));
		d_rightBumper.whileHeld(new ShifterHigh(true));
		d_rightBumper.whenReleased(new ShifterHigh(false));
		
		a_A.whileHeld(new GearRelease(true));
		a_A.whenReleased(new GearRelease(false));
		a_B.whenPressed(new Cancel());
		a_Y.whileHeld(new ClimberUp());
		a_rightBumper.whileHeld(new CollectorDrive());
		a_select.whenPressed(new CollectorIn(true));
		
		if(a_leftBumper.get()) {
			a_Y.whileHeld(new ClimberDrive(-1));
			a_rightBumper.whileHeld(new Eject());
		}
		
	}
}