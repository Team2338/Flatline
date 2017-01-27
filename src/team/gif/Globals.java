package team.gif;

public class Globals {
	// Shooter
	public static double flywheelP = 0.0045; // PVC: 0.14 Turret: ?
	public static double flywheelI = 0.0005; // PVC:  0.0005 Turret: ?
	public static double flywheelD = 0.001; // PVC: 0.001 Turret: 0.001
	public static double flywheelF = 0.009; // PVC: 0.028 Turret: 0.009
//	public static int flywheelIZone = 1200; // PVC: 1200
	public static int flywheelIZoneAbove = 500; // Turret: 500
	public static int flywheelIZoneBelow = 2000; // Turret: 2000
	public static double flywheelRPM = 90000; // PVC: 22000 Turret: 90000 (16000 Mag Encoder Relative)

}
