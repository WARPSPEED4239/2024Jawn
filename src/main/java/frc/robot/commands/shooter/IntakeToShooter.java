package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class IntakeToShooter extends Command {

  private final Intake mIntake;
  private final Shooter mShooter;
  private static double mIntakeSpeed;
  private static double mShooterSpeed;
  
  public IntakeToShooter(Intake intake, Shooter shooter, double intakeSpeed, double shooterSpeed) {
    mIntake = intake;
    mShooter = shooter;
    mIntakeSpeed = intakeSpeed;
    mShooterSpeed = shooterSpeed;
    addRequirements(mShooter, mIntake);
    }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (!mIntake.getLimitUp()) {
      mIntake.setPivotSpeed(mIntakeSpeed);
    } else {
      mShooter.setWheelSpeed(mShooterSpeed);
      mIntake.setFeedSpeed(mIntakeSpeed);
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}