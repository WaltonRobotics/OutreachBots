package org.usfirst.frc2974.PiyushOMatic.subsystems;

import org.usfirst.frc2974.PiyushOMatic.RobotMap;
import org.usfirst.frc2974.PiyushOMatic.commands.ShowInputs;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Inputs extends Subsystem {


    
    
    DigitalInput digital0 = RobotMap.digital0;
    DigitalInput digital1 = RobotMap.driveTrainRightEncoderA;
    DigitalInput digital2 = RobotMap.driveTrainRightEncoderB;
    DigitalInput digital3 = RobotMap.driveTrainLeftEncoderA;
    DigitalInput digital4 = RobotMap.driveTrainLeftEncoderB;
    DigitalInput digital5 = RobotMap.digital5;
    DigitalInput digital6 = RobotMap.digital6;
    DigitalInput digital7 = RobotMap.digital7;
    DigitalInput digital8 = RobotMap.digital8;
    DigitalInput digital9 = RobotMap.digital9;
    

    AnalogInput analog0 = RobotMap.analog0;
    AnalogInput analog1 = RobotMap.analog1;
    AnalogInput analog2 = RobotMap.analog2;
    AnalogInput analog3 = RobotMap.pneumaticsPressureTransducer;
    

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ShowInputs());
		// TODO Auto-generated method stub
		
	}
	public void updateSmartDashboard()
	{
		SmartDashboard.putData("Digital In 0", digital0);
		SmartDashboard.putData("Digital In 1", digital1);
		SmartDashboard.putData("Digital In 2", digital2);
		SmartDashboard.putData("Digital In 3", digital3);
		SmartDashboard.putData("Digital In 4", digital4);
		SmartDashboard.putData("Digital In 5", digital5);
		SmartDashboard.putData("Digital In 6", digital6);
		SmartDashboard.putData("Digital In 7", digital7);
		SmartDashboard.putData("Digital In 8", digital8);
		SmartDashboard.putData("Digital In 9", digital9);

		SmartDashboard.putData("Analog In 0", analog0);
		SmartDashboard.putData("Analog In 1", analog1);
		SmartDashboard.putData("Analog In 2", analog2);
		SmartDashboard.putData("Analog In 3", analog3);
		
	}
}
