package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.JawnsonFlap;

public class JawnsonMotorSetSpeed extends Command {
  private final JawnsonFlap mJawnsonFlap;
  private double mSpeed;

  public JawnsonMotorSetSpeed(JawnsonFlap jawnsonFlap, double speed) {
    mJawnsonFlap = jawnsonFlap;
    mSpeed = speed;
    addRequirements(mJawnsonFlap);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mJawnsonFlap.setSpeed(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    mJawnsonFlap.setPositionZero();
    mJawnsonFlap.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}