package org.usfirst.frc2974.PiyushOMatic.autonomous;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command implements AutoCommand{

	private long delay;
    public Wait(long delay) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.delay=delay;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    long time = -1;
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(time == -1) {
    		time = System.currentTimeMillis();
    	}
        return System.currentTimeMillis() - time > delay;
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
