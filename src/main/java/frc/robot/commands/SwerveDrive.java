package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain.DriveTrain;

public class SwerveDrive extends CommandBase {

  private DriveTrain mDriveTrain;
  private CommandXboxController mXboxController;

  public SwerveDrive(DriveTrain driveTrain, CommandXboxController XBoxController) {
    
    mDriveTrain = driveTrain;
    mXboxController = XBoxController;

    addRequirements(mDriveTrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double y = -mXboxController.getLeftY();
    double x = mXboxController.getLeftX();
    double z = mXboxController.getRightX();
    double[][] calculations = mDriveTrain.calculateWheelSpeedAndAngle(y, x, z);

    mDriveTrain.drive(calculations);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}