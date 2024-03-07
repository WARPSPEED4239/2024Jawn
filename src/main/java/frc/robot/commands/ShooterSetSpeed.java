package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterSetSpeed extends Command {
  private final Shooter mShooter;
  private final double mTopSpeed;
  private final double mBottomSpeed;

  public ShooterSetSpeed(Shooter shooter, double topSpeed, double bottomSpeed) {
    mShooter = shooter;
    mTopSpeed = topSpeed;
    mBottomSpeed = bottomSpeed;
    addRequirements(mShooter);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mShooter.setWheelSpeed(mTopSpeed, mBottomSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    mShooter.setWheelSpeed(0, 0);
    mShooter.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}