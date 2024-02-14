package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LimitUp;

public class SetPivotState extends Command {

  private final Intake mIntake;
  private final LimitUp mLimitUp;
  private static double mSpeed;
  private static boolean mTargetState;
  
  public SetPivotState(Intake intake, LimitUp limitup, double speed) {
    mIntake = intake;
    mLimitUp = limitup;
    mSpeed = speed;
    addRequirements(mIntake);
  }

  @Override
  public void initialize() {
    if (mIntake.getLimitDown()){
      mTargetState = true;
    } else if (mLimitUp.getLimitUp()) {
      mTargetState = false;
      mSpeed *= -1;
    }
  }

  @Override
  public void execute() {
    System.out.println(mIntake.getLimitDown());
    if (mTargetState) {
      if (!mLimitUp.getLimitUp()) {
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
  public void end(boolean interrupted) {
    mIntake.stopPivotMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}