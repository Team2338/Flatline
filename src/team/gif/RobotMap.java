package team.gif;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// CAN Addresses
	public static final int frontRightDrive		= 9;
	public static final int rearRightDrive		= 4;
	public static final int frontLeftDrive		= 7;
	public static final int rearLeftDrive		= 8;
	public static final int climber             = 15;
	public static final int collectorFront		= 16;
	public static final int shooterFlywheel		= 17;
	public static final int shooterFlywheel2	= 18;
	public static final int shooterTurret		= 5;
	
	// DIO Ports
	
	// Relay Ports
	public static final int geardrop			= 5;
	public static final int versadrop			= 6;
	public static final int shifter				= 7;
}
