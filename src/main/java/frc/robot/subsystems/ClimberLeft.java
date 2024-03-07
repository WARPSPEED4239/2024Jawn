package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberLeft extends SubsystemBase {
  private final TalonFX mLeftClimber = new TalonFX(Constants.LEFT_CLIMBER_MOTOR);

  public ClimberLeft() {
    mLeftClimber.setInverted(false);
    mLeftClimber.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  public void periodic() {}

  public void SetLeftClimberSpeed(double speed) {
    mLeftClimber.set(speed);
  }

  public void stopMotor() {
    mLeftClimber.stopMotor();
  }
}
