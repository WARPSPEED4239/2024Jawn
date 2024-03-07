package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberRight;

public class ClimberRightSetSpeed extends Command {
  private final ClimberRight mClimberRight;
  private final double mSpeed;
  
  public ClimberRightSetSpeed(ClimberRight climberright, double speed) {
    mClimberRight = climberright;
    mSpeed = speed;
    addRequirements(mClimberRight);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mClimberRight.SetRightClimberSpeed(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    mClimberRight.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
