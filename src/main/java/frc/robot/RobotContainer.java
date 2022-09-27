// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final Climb m_climb = new Climb();
    public final Tunnle m_tunnle = new Tunnle();
    public final IntakeArm m_intakeArm = new IntakeArm();
    public final DriveTrain m_driveTrain = new DriveTrain();

// Joysticks
private final Joystick operatorJoy = new Joystick(1);
private final Joystick driver_Joy = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_climb);
    SmartDashboard.putData(m_tunnle);
    SmartDashboard.putData(m_intakeArm);
    SmartDashboard.putData(m_driveTrain);


    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("IntakeRaise", new IntakeRaise( m_intakeArm ));
    SmartDashboard.putData("IntakeLower", new IntakeLower( m_intakeArm ));
    SmartDashboard.putData("IntakeCargo_Run: Intake_Value", new IntakeCargo_Run(0.5, m_intakeArm));
    SmartDashboard.putData("IntakeCargo_Run: Eject_Value", new IntakeCargo_Run(-.5, m_intakeArm));
    SmartDashboard.putData("Conveyor_Run: Raise", new Conveyor_Run(.5, m_tunnle));
    SmartDashboard.putData("Conveyor_Run: Lower", new Conveyor_Run(-.5, m_tunnle));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    SmartDashboard.putData("Intake Cargo", new IntakeCargo( m_intakeArm, m_tunnle ));
    SmartDashboard.putData("EjectCargo", new EjectCargo( m_intakeArm, m_tunnle ));
    configureButtonBindings();

    // Configure default commands
    
        // _BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_driveTrain.setDefaultCommand(new DriveWithJoy(() -> -driver_Joy.getX(), () -> driver_Joy.getY(), m_driveTrain) );

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton joystickButton3 = new JoystickButton(driver_Joy, 3);        
    joystickButton3.whileHeld(new EjectCargo( m_intakeArm, m_tunnle ) ,true);
        
    final JoystickButton joystickButton5 = new JoystickButton(driver_Joy, 5);        
    joystickButton5.whileHeld(new IntakeCargo( m_intakeArm, m_tunnle ) ,true);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final JoystickButton joystickButton6 = new JoystickButton(driver_Joy, 6);        
joystickButton6.whileHeld(new IntakeRaise( m_intakeArm ) ,true);
    SmartDashboard.putData("Joystick Button 6",new IntakeRaise( m_intakeArm ) );

final JoystickButton joystickButton4 = new JoystickButton(driver_Joy, 4);        
joystickButton4.whileHeld(new IntakeLower( m_intakeArm ) ,true);
    SmartDashboard.putData("Joystick Button 4",new IntakeLower( m_intakeArm ) );



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getDriver_Joy() {
        return driver_Joy;
    }

public Joystick getOperatorJoy() {
        return operatorJoy;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

