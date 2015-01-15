package org.usfirst.frc2974.PiyushOMatic.autonomous;

import org.usfirst.frc2974.PiyushOMatic.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnForDegrees extends Command implements AutoCommand{

	double degreesToTurn;
    public TurnForDegrees(double degreesToTurn) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.degreesToTurn = degreesToTurn;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(degreesToTurn < 0) {
    		Robot.driveTrain.set(-1,1);
    	}else {
    		Robot.driveTrain.set(1, -1);
    	}
    }

    long time = -1;
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	/*
        double d = Robot.driveTrain.getDistanceTravelledLeft() - Robot.driveTrain.getDistanceTravelledRight();
        d = Math.abs(d);
        //Robot has a radius of 14" ish TODO check this
        double circumference = 2*Math.PI*14;
        return d > (circumference / 360)*degreesToTurn;
        */
    	if(time == -1) {
    		time = System.currentTimeMillis();
    	}
    	return System.currentTimeMillis() - time > degreesToTurn/.34;
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
