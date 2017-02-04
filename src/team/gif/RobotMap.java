package team.gif;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// CAN Addresses
	public static final int frontRightDrive	= 3; //9
	public static final int rearRightDrive = 0; //4
	public static final int frontLeftDrive = 1; //7
	public static final int rearLeftDrive = 2; //8
	public static final int intake = 50;
	public static final int flywheel1 = 5;
	public static final int flywheel2 = 6;
	public static final int turret = 51;
	public static final int climber = 15;
	
	// Relay Ports
	public static final int gearHanger = 5;
	public static final int versadrop = 6;
	public static final int shifter = 7;

}
