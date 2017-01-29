package team.gif;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// CAN Addresses
	public static final int frontRightDrive	= 9;
	public static final int rearRightDrive = 4;
	public static final int frontLeftDrive = 7;
	public static final int rearLeftDrive = 8;
	public static final int intake = 5;
	public static final int flywheel1 = 40;
	public static final int flywheel2 = 41;
	public static final int turret = 5;
	public static final int climber = 15;
	
	// Relay Ports
	public static final int geardrop = 5;
	public static final int versadrop = 6;
	public static final int shifter = 7;

}
