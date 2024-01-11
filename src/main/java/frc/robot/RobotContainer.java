package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.SwerveDrive;
import frc.robot.subsystems.DriveTrain.DriveTrain;

public class RobotContainer {

  private final CommandXboxController mController = new CommandXboxController(Constants.XBOX_CONTROLLER);
  
  private final DriveTrain mDriveTrain = new DriveTrain();

  public RobotContainer() {
    mDriveTrain.setDefaultCommand(new SwerveDrive(mDriveTrain, mController));
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}