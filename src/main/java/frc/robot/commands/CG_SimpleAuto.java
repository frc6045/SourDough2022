// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.Tunnle;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class CG_SimpleAuto extends SequentialCommandGroup {
  /** Creates a new CG_SimpleAuto. */
  public CG_SimpleAuto(Tunnle m_tunnle, FlyWheel m_flywheel, IntakeArm m_intakeArm, DriveTrain m_driveTrain) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
			//Dump Cargo for 5 seconds
			new ParallelDeadlineGroup(new WaitCommand(5),
																new CG_DumpCargo(m_tunnle, m_flywheel, m_intakeArm)
																),
			//Lower The Intake Arm
			new ParallelDeadlineGroup(new WaitCommand(3), 
																new IntakeLower(m_intakeArm)
																),
			//Drive Forward for 5 seconds and intake
			new ParallelDeadlineGroup(new WaitCommand(5),
																//Drive at 50% power
																new DriveWithJoy(() -> 0.5, () -> 0.0, m_driveTrain),
																new IntakeCargo(m_intakeArm, m_tunnle)
																)
								);
  }
}
