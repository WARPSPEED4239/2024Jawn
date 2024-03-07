package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberLeft;

public class ClimberLeftSetSpeed extends Command {
  private final ClimberLeft mClimberLeft;
  private final double mSpeed;
  
  public ClimberLeftSetSpeed(ClimberLeft climberleft, double speed) {
    mClimberLeft = climberleft;
    mSpeed = speed;
    addRequirements(mClimberLeft);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mClimberLeft.SetLeftClimberSpeed(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    mClimberLeft.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
