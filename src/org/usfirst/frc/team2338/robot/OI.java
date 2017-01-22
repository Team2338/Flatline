package org.usfirst.frc.team2338.robot;

import org.usfirst.frc.team2338.robot.commands.ClimberDown;
import org.usfirst.frc.team2338.robot.commands.ClimberUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final Joystick leftJoy = new Joystick (0);
	public static final Joystick rightJoy = new Joystick(1);
	
	private static Button leftButton2;
	private static Button leftButton3;
	
	public OI() {
		leftButton2 = new JoystickButton(leftJoy, 2);
		leftButton3 = new JoystickButton(leftJoy, 3);
		
		leftButton2.whileHeld(new ClimberUp());
		leftButton3.whileHeld(new ClimberDown());
	}
}

