package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakePivot;

public class IntakePivotSetPosition extends Command {

  private final IntakePivot mIntake;
  private double mTargetPosition;
  private double mPosition;
  private double mSpeed;
  private boolean mEnd;

  public IntakePivotSetPosition(IntakePivot intake, double position, double speed) {
    mIntake = intake;
    mTargetPosition = position;
    mSpeed = speed;
    addRequirements(mIntake);
  }

  @Override
  public void initialize() {
    mEnd = false;
  }

  @Override
  public void execute() {
    mPosition = mIntake.getPosition();

    if (mSpeed < 0.0 && mTargetPosition <= mPosition) {
      mIntake.setOutputWithLimitSensors(mSpeed);
    } else if (mSpeed > 0.0 && mTargetPosition >= mPosition) {
      mIntake.setOutputWithLimitSensors(mSpeed);
    } else {
      mIntake.setOutputWithLimitSensors(0.0);
      mEnd = true;
    }

    if (mIntake.getLimitIn()) {
      mIntake.setPositionIn();
    }

    if (mIntake.getLimitOut()) {
      mIntake.setPositionOut();
    }
  }

  @Override
  public void end(boolean interrupted) {
    mIntake.setOutputWithLimitSensors(0.0);
    mIntake.stopMotor();
  }

  @Override
  public boolean isFinished() {
    if(mEnd) {
      return true;
    }
    return false;
  }
}
