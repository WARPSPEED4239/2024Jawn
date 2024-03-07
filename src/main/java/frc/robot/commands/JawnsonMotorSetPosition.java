package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.JawnsonFlap;

public class JawnsonMotorSetPosition extends Command {
  private final JawnsonFlap mJawnsonFlap;
  private double mTargetPosition;
  private double mPosition;
  private double mSpeed;

  public JawnsonMotorSetPosition(JawnsonFlap jawnsonFlap, double targetposition, double speed) {
    mJawnsonFlap = jawnsonFlap;
    mTargetPosition = targetposition;
    mSpeed = speed;
    addRequirements(mJawnsonFlap);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mPosition = mJawnsonFlap.getPosition();
    if (mSpeed < 0.0 && mTargetPosition >= mPosition) {
      mJawnsonFlap.setSpeed(mSpeed);
    } else if (mSpeed > 0.0 && mTargetPosition <= mPosition) {
      mJawnsonFlap.setSpeed(mSpeed);
    } else {
      mJawnsonFlap.setSpeed(0.0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    mJawnsonFlap.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
