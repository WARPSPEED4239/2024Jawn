package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class LimitCheck extends Command {

  private final Intake mIntake;
  
  public LimitCheck(Intake intake) {
    mIntake = intake;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (mIntake.getLimitDown()) {
      System.out.println("Limit Down On");
    }

    // if (mLimitUp.getLimitUp()) {
    //   System.out.println("Limit Up On");
    // }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
