package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {

  private final static TalonFX mLeftMotor = new TalonFX(Constants.LEFT_CLIMBER_MOTOR);
  private final static TalonFX mRightMotor = new TalonFX(Constants.RIGHT_CLIMBER_MOTOR);

  public Climber() {}

  @Override
  public void periodic() {}
  
  public void setLeftMotorSpeed(double speed) {
    mLeftMotor.set(speed);
  }

  public void setRightMotorSpeed(double speed) {
    mRightMotor.set(speed);
  }
}