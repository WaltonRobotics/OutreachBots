package org.usfirst.frc2974.PiyushOMatic.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MasterScheduler {
	private final static Runnable[] order = {
		() -> instance = new Init(),
		() -> instance = new ForwardForFeet(5),
		() -> instance = new Wait(500),
		() -> instance = new TurnForDegrees(90),
		() -> instance = new Wait(500),
		() -> instance = new ForwardForFeet(5),
		() -> instance = null
	};
	private static int currentIndex;
	private static AutoCommand instance;
	static {
		reset();
	}
	public static Command getInstance() {
		check();
		return (Command)instance;
	}
	private static void check() {
		if(instance != null && instance.isDead()) {
			currentIndex++;
			order[currentIndex].run();
		}
		SmartDashboard.putNumber("auto index", currentIndex);
		if(instance!=null)
			SmartDashboard.putString("MasterScheduler current Command", instance.getClass().getName());
	}
	public static void reset() {
		currentIndex=0;
		order[currentIndex].run();
	}
}
