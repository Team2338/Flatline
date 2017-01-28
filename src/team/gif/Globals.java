package team.gif;

public class Globals {
	// Shooter
	public static double flywheelP = 0.0048;     // PVC: 0.14 Turret: .0048
	public static double flywheelI = 0.0001;     // PVC:  0.0005 Turret: .0001
	public static double flywheelD = 0.000;	     // PVC: 0.001 Turret: 0.000
	public static double flywheelF = 0.0087;  	 // PVC: 0.028 Turret: 0.0087

	//	public static int flywheelIZone = 1200;  // PVC: 1200
	
	public static int flywheelIZoneAbove = 500;  // Turret: 500
	public static int flywheelIZoneBelow = 2000; // Turret: 2000
	public static double flywheelRPM = 90000; 	 // PVC: 22000 Turret: 90000 (16000 Mag Encoder Relative)

	// Turret
	public static double turretP = 0.1;
	public static double turretI = 0.00;
	public static double turretD = 0.00;
	public static int turretIZone = 0;
	public static double turretPosition = 635; // 635 Encoder Counts per Rev
	public static double turretAngleToTick = 16/9; // 127/172 possible
}
