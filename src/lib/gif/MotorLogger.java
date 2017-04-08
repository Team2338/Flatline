package lib.gif;

import com.ctre.CANTalon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author PatrickUbelhor
 * @version 04/04/2017
 */
public final class MotorLogger extends Thread {
	
	private static AtomicBoolean keepRunning = new AtomicBoolean(true);
	private static final int delayTime = 20; // Milliseconds. This may be too fast for proper time-clocking
	private static final String filepath = "MotorLogfile.csv"; // FIXME: Change to actual path
	private static final DecimalFormat df = new DecimalFormat("####0.000");
	private static final LinkedList<CANTalon> queue = new LinkedList<>();
	
	public static void addMotor(CANTalon motor) {
		queue.add(motor);
	}
	
	public void end() {
		keepRunning.set(false);
	}
	
	@Override
	public void run() {
		
		// TODO: can I speed this up by using the buffer feature of DecimalFormat?
		
		ListIterator<CANTalon> iterator = queue.listIterator();
		keepRunning.set(true); // In case this thread is killed and restarted
		
		
		/* Synchronizes the CAN update frequency with this thread's logging frequency
		*	NOTE: if you don't log from a certain status frame, DO NOT speed up its framerate
		*		in fact, you should even slow it down if it's unused to reduce CAN usage
		*
		*	Also, if one of these frames doesn't need to log as fast as the others, feel free to slow it down
		*
		*	Remember, the framerate should never be slower than what YOU need to control the robot (hence, the 'if')
		*/
		if (delayTime > 20) {
			while(iterator.hasNext()) {
				CANTalon motor = iterator.next();
				
				motor.setStatusFrameRateMs(CANTalon.StatusFrameRate.General, delayTime);
				motor.setStatusFrameRateMs(CANTalon.StatusFrameRate.AnalogTempVbat, delayTime);
				motor.setStatusFrameRateMs(CANTalon.StatusFrameRate.Feedback, delayTime);
	//			motor.setStatusFrameRateMs(CANTalon.StatusFrameRate.PulseWidth, delayTime);
	//			motor.setStatusFrameRateMs(CANTalon.StatusFrameRate.QuadEncoder, delayTime);
			}
		}
		
		
		while (keepRunning.get()) {
			
			iterator = queue.listIterator();
			
			while (iterator.hasNext()) {
				CANTalon motor = iterator.next();
				
				// Separating into individual files might take longer
				try (FileWriter fw = new FileWriter(new File(filepath + motor.getDescription()), true)) {
					
					// FIXME: Adjust what you want to log. You don't have a lot of file space.
					fw.append(Long.toString(System.nanoTime()));
					fw.append(","); // DO NOT MESS WITH THE COMMA LINES. Separately appending them is actually faster.
					fw.append(Integer.toString(motor.getDeviceID()));
					fw.append(",");
					fw.append(Integer.toString(motor.getControlMode().value));
					fw.append(",");
					fw.append(df.format(motor.getPosition()));
					fw.append(",");
					fw.append(df.format(motor.getSpeed()));
					fw.append(",");
					fw.append(df.format(motor.getBusVoltage()));
					fw.append(",");
					fw.append(df.format(motor.getOutputVoltage()));
					fw.append(",");
					fw.append(df.format(motor.getOutputCurrent()));
					fw.append(",");
					fw.append(df.format(motor.getSetpoint()));
					fw.append(",");
					fw.append(df.format(motor.getError()));
					fw.append(",");
					fw.append(df.format(motor.getTemperature()));
					fw.append(Long.toString(System.nanoTime()));
					fw.append('\n');
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			try {
				Thread.sleep(delayTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	} // :run():
	
}