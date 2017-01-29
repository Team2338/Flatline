package team.gif;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import team.gif.commands.CameraFollow;
import team.gif.commands.ClimberDown;
import team.gif.commands.ClimberUp;
import team.gif.commands.GearIn;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShiftTank;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.shooter.RevFlywheel;
import team.gif.commands.shooter.ShooterStandby;
import team.gif.commands.shooter.TurretTurn;
import team.gif.commands.drivetrain.ShifterHigh;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final Joystick xboxController = new Joystick(2);
	
	private static Button a;
	private static Button b;
	private static Button x;
	private static Button y;
	private static Button leftBumper;
	private static Button rightBumper;
	private static Button select;
	private static Button start;
	private static Button leftStick;
	private static Button rightStick;
	
	public OI() {
		
		a = new JoystickButton(xboxController, 1);
		b = new JoystickButton(xboxController, 2);
		x = new JoystickButton(xboxController, 3);
		y = new JoystickButton(xboxController, 4);
		leftBumper = new JoystickButton(xboxController, 5);
		rightBumper = new JoystickButton(xboxController, 6);
		select = new JoystickButton(xboxController, 7);
		start = new JoystickButton(xboxController, 8);
		leftStick = new JoystickButton(xboxController, 9);
		rightStick = new JoystickButton(xboxController, 10);
		
//		b.whileHeld(new RevFlywheel(Robot.prefs.getDouble("FlywheelRPM", Globals.flywheelRPM)));
//		b.whenReleased(new ShooterStandby());
		
		a.whileHeld(new CameraFollow());
		y.whenPressed(new TurretTurn(Globals.turretPosition));
		x.whenPressed(new TurretTurn(0));
		
		leftBumper.whileHeld(new ShiftOmni());
		leftBumper.whenReleased(new ShiftTank());
		rightBumper.whileHeld(new ShifterHigh());
		rightBumper.whenReleased(new ShifterLow());
	}
}

