// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX; import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonFX talonFXEnhanced1;
private WPI_TalonFX talonFXEnhanced2;
private MotorControllerGroup leftMotorGroup;
private WPI_TalonFX talonFXEnhanced3;
private WPI_TalonFX talonFXEnhanced4;
private MotorControllerGroup rightMotorGroup;
private DifferentialDrive differentialDrive1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

		final int kUnitsPerRevolution = 2048; /* this is constant for Talon FX */
    final double kGear_Ratio = 12.875;
    final double kWheelDiameter = 6.00;
    
    /**
    *
    */
    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
talonFXEnhanced1 = new WPI_TalonFX(2);
 
    /* Factory default hardware to prevent unexpected behavior */
talonFXEnhanced1.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
talonFXEnhanced1.setInverted(true);
talonFXEnhanced1.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
talonFXEnhanced1.configNominalOutputForward(0, 30);
talonFXEnhanced1.configNominalOutputReverse(0, 30);
talonFXEnhanced1.configPeakOutputForward(1, 30);
talonFXEnhanced1.configPeakOutputReverse(-1, 30);
        


talonFXEnhanced2 = new WPI_TalonFX(3);
 
    /* Factory default hardware to prevent unexpected behavior */
talonFXEnhanced2.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
talonFXEnhanced2.setInverted(true);
talonFXEnhanced2.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
talonFXEnhanced2.configNominalOutputForward(0, 30);
talonFXEnhanced2.configNominalOutputReverse(0, 30);
talonFXEnhanced2.configPeakOutputForward(1, 30);
talonFXEnhanced2.configPeakOutputReverse(-1, 30);
        


leftMotorGroup = new MotorControllerGroup(talonFXEnhanced1, talonFXEnhanced2  );
 addChild("Left Motor Group",leftMotorGroup);
 

talonFXEnhanced3 = new WPI_TalonFX(1);
 
    /* Factory default hardware to prevent unexpected behavior */
talonFXEnhanced3.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
talonFXEnhanced3.setInverted(true);
talonFXEnhanced3.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
talonFXEnhanced3.configNominalOutputForward(0, 30);
talonFXEnhanced3.configNominalOutputReverse(0, 30);
talonFXEnhanced3.configPeakOutputForward(1, 30);
talonFXEnhanced3.configPeakOutputReverse(-1, 30);
        


talonFXEnhanced4 = new WPI_TalonFX(15);
 
    /* Factory default hardware to prevent unexpected behavior */
talonFXEnhanced4.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
talonFXEnhanced4.setInverted(true);
talonFXEnhanced4.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
talonFXEnhanced4.configNominalOutputForward(0, 30);
talonFXEnhanced4.configNominalOutputReverse(0, 30);
talonFXEnhanced4.configPeakOutputForward(1, 30);
talonFXEnhanced4.configPeakOutputReverse(-1, 30);
        


rightMotorGroup = new MotorControllerGroup(talonFXEnhanced3, talonFXEnhanced4  );
 addChild("Right Motor Group",rightMotorGroup);
 

differentialDrive1 = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
 addChild("Differential Drive 1",differentialDrive1);
 differentialDrive1.setSafetyEnabled(true);
differentialDrive1.setExpiration(0.1);
differentialDrive1.setMaxOutput(1.0);



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Right Master Rotations", my_getRight_Encoder_Rotations());
        SmartDashboard.putNumber("Right Side Inch", my_getRight_Encoder_Distance_Inch());
        differentialDrive1.feed();

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void my_Drive_Archade(double xSpeed, double zRotation){
        
        differentialDrive1.arcadeDrive(xSpeed, zRotation);
    }

		public void my_reset_Right_Encoder() {
			talonFXEnhanced1.setSelectedSensorPosition(0);
	}

	private double my_getRight_Encoder_Rotations() {
			return talonFXEnhanced1.getSelectedSensorPosition(0) / kUnitsPerRevolution; /* position units */
	}

	public double my_getRight_Encoder_Distance_Inch() {
			return (my_getRight_Encoder_Rotations() / kGear_Ratio) * (kWheelDiameter * Math.PI);
		
	}
}

