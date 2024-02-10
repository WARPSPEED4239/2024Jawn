package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {

  private final static TalonFX mLeftMotor = new TalonFX(Constants.LEFT_CLIMBER_MOTOR, "rio");
  private final static TalonFX mRightMotor = new TalonFX(Constants.RIGHT_CLIMBER_MOTOR, "rio");

  public Climber() {
    mLeftMotor.setInverted(false);
    mLeftMotor.setNeutralMode(NeutralModeValue.Brake);
    mRightMotor.setInverted(false);
    mRightMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  public void periodic() {}
  
  public void setLeftMotorSpeed(double speed) {
    mLeftMotor.set(speed);
  }

  public void setRightMotorSpeed(double speed) {
    mRightMotor.set(speed);
  }
}