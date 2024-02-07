package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class SetPivotState extends Command {

  private final Intake mIntake;
  private static double mSpeed;
  private static boolean mTargetState;
  
  public SetPivotState(Intake intake, double speed) {
    mIntake = intake;
    mSpeed = speed;
    addRequirements(mIntake);
  }

  @Override
  public void initialize() {
    if (mIntake.getLimitDown()){
      mTargetState = true;
      mSpeed *= -1;
    } else if (mIntake.getLimitUp()) {
      mTargetState = false;
    }
  }

  @Override
  public void execute() {
    if (mTargetState) {
      if (!mIntake.getLimitUp()) {
        mIntake.setPivotSpeed(mSpeed);
      } else {
        mIntake.setPivotSpeed(0.0);
      }
    } else {
      if (!mIntake.getLimitDown()) {
        mIntake.setPivotSpeed(mSpeed);
      }  else {
        mIntake.setPivotSpeed(0.0);
      }
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}