package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberRight extends SubsystemBase {
  private final TalonFX mRightClimber = new TalonFX(Constants.RIGHT_CLIMBER_MOTOR);

  public ClimberRight() {
    mRightClimber.setInverted(false);
    mRightClimber.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  public void periodic() {}

  public void SetRightClimberSpeed(double speed) {
    mRightClimber.set(speed);
  }

  public void stopMotor() {
    mRightClimber.stopMotor();
  }
}