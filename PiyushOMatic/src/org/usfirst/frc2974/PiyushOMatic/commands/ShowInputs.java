package org.usfirst.frc2974.PiyushOMatic.commands;

import org.usfirst.frc2974.PiyushOMatic.Robot;

import edu.wpi.first.wpilibj.command.Command;
//import org.usfirst.frc2974.PiyushOMatic.subsystems.*;

/**
 *
 */
public class ShowInputs extends Command {

    public ShowInputs() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    requires(Robot.inputs);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.inputs.updateSmartDashboard();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.inputs.updateSmartDashboard();
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
}
