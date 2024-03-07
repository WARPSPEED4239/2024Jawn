package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakePivot;

public class IntakePivotSetSpeed extends Command {
  private final IntakePivot mPivot;
  private double mSpeed;

  public IntakePivotSetSpeed(IntakePivot intake, double speed) {
    mPivot = intake;
    mSpeed = speed;
    addRequirements(mPivot);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mPivot.setSpeed(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    mPivot.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
