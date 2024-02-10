package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Climber;

public class ClimberSetSpeed extends Command {

  private final Climber mClimber;
  private final CommandXboxController mController;
  private static double mSpeed;
  
  public ClimberSetSpeed(Climber climber, CommandXboxController controller, double speed) {
    mClimber = climber;
    mController = controller;
    mSpeed = speed;
    addRequirements(mClimber);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (mController.leftBumper().getAsBoolean()) {
      mClimber.setLeftMotorSpeed(mSpeed);
    } else if (mController.leftTrigger().getAsBoolean()) {
      mClimber.setLeftMotorSpeed(-mSpeed);
    }

    if (mController.rightBumper().getAsBoolean()) {
      mClimber.setRightMotorSpeed(mSpeed);
    } else if (mController.rightTrigger().getAsBoolean()) {
      mClimber.setRightMotorSpeed(-mSpeed);
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}