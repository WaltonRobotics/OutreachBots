// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2974.PiyushOMatic.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2974.PiyushOMatic.Robot;

/**
 *
 */
public class Drive extends Command {

	public Drive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.driveTrain);
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SmartDashboard.putNumber("Left Speed", 0);
		SmartDashboard.putNumber("Right Speed", 0);
		SmartDashboard.putNumber("Left Encoder", 0);
		SmartDashboard.putNumber("Right Encoder", 0);
		SmartDashboard.putNumber("X Acceleration", 0);
		SmartDashboard.putNumber("Y Acceleration", 0);
		SmartDashboard.putNumber("Z Acceleration", 0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		cheesyDrive();
		checkShifting();

		updateEncoderDistance();
		updateSpeed();
		updateAccelerometer();
	}

	private void cheesyDrive() {
		double joyLY = -Robot.oi.left.getY();
		double joyRY = -Robot.oi.right.getY();
		double joyRX = -Robot.oi.right.getX();

		/*
		 * left joystick controls throttle right joystick y helps right motor
		 * speed right joystick x hurts right motor speed
		 * 
		 * right joystick y helps left motor speed right joystick x helps left
		 * motor speed
		 * 
		 * throttle+=1; throttle/=2.0;
		 */
		double throttle = (joyLY + 1) / 2;
		double RM = joyRY - joyRX;
		double LM = joyRY + joyRX;

		RM *= throttle;
		LM *= throttle;

		Robot.driveTrain.set(LM, RM);

	}

	private void checkShifting() {
		if (Robot.oi.left.getRawButton(3))
			Robot.driveTrain.shiftUp();

		if (Robot.oi.left.getRawButton(2))
			Robot.driveTrain.shiftDown();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	private void updateSpeed() {
		SmartDashboard.putNumber("Left Speed", Robot.driveTrain.getLeftSpeed());
		SmartDashboard.putNumber("Right Speed",
				Robot.driveTrain.getRightSpeed());
	}

	private void updateEncoderDistance() {
		SmartDashboard.putNumber("Left Encoder",
				Robot.driveTrain.getDistanceTravelledLeft());
		SmartDashboard.putNumber("Right Encoder",
				Robot.driveTrain.getDistanceTravelledRight());
	}

	private void updateAccelerometer() {
		SmartDashboard
				.putNumber("X Acceleration", Robot.driveTrain.getXAccel());
		SmartDashboard
				.putNumber("Y Acceleration", Robot.driveTrain.getYAccel());
		SmartDashboard
				.putNumber("Z Acceleration", Robot.driveTrain.getZAccel());
	}

}