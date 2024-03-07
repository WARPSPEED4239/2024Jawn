package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private final TalonFX mTopMotor = new TalonFX(Constants.SHOOTER_TOP_MOTOR);
  private final TalonFX mBottomMotor = new TalonFX(Constants.SHOOTER_BOTTOM_MOTOR);

  public Shooter() {
    mTopMotor.setInverted(false);
    mBottomMotor.setInverted(false);
    mTopMotor.setNeutralMode(NeutralModeValue.Coast);
    mBottomMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {}

  public void setWheelSpeed(double topSpeed, double bottomSpeed) {
    mTopMotor.set(topSpeed);
    mBottomMotor.set(bottomSpeed);
  }

  public void stopMotor() {
    mTopMotor.stopMotor();
    mBottomMotor.stopMotor();
  }
}