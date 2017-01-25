package team.gif;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import team.gif.commands.ClimberDown;
import team.gif.commands.ClimberUp;
import team.gif.commands.RevFlywheel;
import team.gif.commands.ShooterStandby;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShiftTank;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.drivetrain.ShifterHigh;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final Joystick leftJoy = new Joystick (0);
	public static final Joystick rightJoy = new Joystick(1);
	
//	public static final Joystick xboxController = new Joystick(0);
	
//	private static Button leftButton0;
	private static Button leftButton2;
	private static Button leftButton3;
	private static Button leftButton5;
	private static Button leftButton6;
	private static Button rightButton2;
	private static Button rightButton3;
	
	public OI() {
//		leftButton0 = new JoystickButton(leftJoy, 0);
		rightButton2 = new JoystickButton(rightJoy, 2);
		
//		leftButton0 = new JoystickButton(xboxController, 0);
//		leftButton5 = new JoystickButton(xboxController, 5);
//		leftButton6 = new JoystickButton(xboxController, 6);
		
//		leftButton2.whileHeld(new ClimberUp());
//		leftButton3.whileHeld(new ClimberDown());
		
		rightButton2.whileHeld(new RevFlywheel(Globals.flywheelRPM));
		rightButton2.whenReleased(new ShooterStandby());
		
//		leftButton5.whileHeld(new ShiftOmni());
//		leftButton5.whenReleased(new ShiftTank());
//		leftButton6.whileHeld(new ShifterUp());
//		leftButton6.whenReleased(new ShifterDown());
	}
}

