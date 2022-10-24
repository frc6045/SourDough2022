// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive_Distance_Inch extends CommandBase {
	private final DriveTrain m_driveTrain;
  private double m_distance;
  private double m_speed;
  /** Creates a new Drive_Distance_Inch. */
  public Drive_Distance_Inch(double distance, double speed, DriveTrain subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
		m_distance = distance; 
		m_speed = speed;
		m_driveTrain = subsystem;
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
		m_driveTrain.my_reset_Right_Encoder();
	}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
		m_driveTrain.my_Drive_Archade(m_speed, 0.0);
	}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
		m_driveTrain.my_Drive_Archade(0.0, 0.0);
	}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(m_driveTrain.my_getRight_Encoder_Distance_Inch()) > m_distance;
  }
}
