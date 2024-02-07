package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class SetFeedSpeed extends Command {

  private final Intake mIntake;
  private final double mSpeed;
  
  public SetFeedSpeed (Intake intake, double speed) {
    mIntake = intake;
    mSpeed = speed;
    addRequirements(mIntake);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mIntake.setFeedSpeed(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}