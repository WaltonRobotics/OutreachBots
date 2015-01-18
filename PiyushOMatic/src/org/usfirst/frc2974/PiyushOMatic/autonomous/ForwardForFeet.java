package org.usfirst.frc2974.PiyushOMatic.autonomous;

import org.usfirst.frc2974.PiyushOMatic.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ForwardForFeet extends Command implements AutoCommand{

	private double feetToTravel;

	public ForwardForFeet(double feetToTravel) {
		requires(Robot.driveTrain);
		this.feetToTravel = feetToTravel;
	}

	protected void initialize() {
		Robot.driveTrain.initEncoders();
		Robot.driveTrain.resetEncoders();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//makes the robot end up parallel to it's start position
		if(!isFinishedLeft())
		{
			if(!isFinishedRight())
				Robot.driveTrain.set(1, 1);
			else
				Robot.driveTrain.set(1,0);
		}
		else if(!isFinishedRight())
			Robot.driveTrain.set(0, 1);
			
	}



	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isFinishedLeft() && isFinishedRight();
	}
	protected boolean isFinishedLeft()
	{
		return Robot.driveTrain.getDistanceTravelledLeft()>=feetToTravel*12;
	}
	
	protected boolean isFinishedRight()
	{
		return Robot.driveTrain.getDistanceTravelledRight()>=feetToTravel*12;
	}

	boolean isDead=false;
	// Called once after isFinished returns true
	protected void end() {
		isDead=true;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		isDead=true;
	}
	
	public boolean isDead() {
		return isDead;
	}
}
