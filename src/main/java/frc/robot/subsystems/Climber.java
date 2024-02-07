package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {

  private final static TalonFX mMotor1 = new TalonFX(Constants.MOTOR1);
  private final static TalonFX mMotor2 = new TalonFX(Constants.MOTOR2);

  public Climber() {}

  @Override
  public void periodic() {}
  
  public void setMotorSpeeds(double speed) {
    mMotor1.set(speed);
    mMotor2.set(speed);
  }
}