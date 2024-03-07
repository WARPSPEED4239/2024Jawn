package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeFeed;

public class IntakeSetFeedMotorSpeed extends Command {
  private final IntakeFeed mIntakeFeed;
  private double mSpeed;

  public IntakeSetFeedMotorSpeed(IntakeFeed intake, double speed) {
    mIntakeFeed = intake;
    mSpeed = speed;
    addRequirements(mIntakeFeed);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mIntakeFeed.setFeedMotorSpeed(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    mIntakeFeed.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}