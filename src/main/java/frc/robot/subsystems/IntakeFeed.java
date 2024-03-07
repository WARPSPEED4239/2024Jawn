package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeFeed extends SubsystemBase {

  private final TalonSRX mFeedMotor = new TalonSRX(Constants.INTAKE_MOTOR_FEED);
  
  public IntakeFeed() {
    mFeedMotor.setInverted(false);
    mFeedMotor.setNeutralMode(NeutralMode.Coast);
  }

  @Override
  public void periodic() {}

  public void setFeedMotorSpeed(double speed) {
    mFeedMotor.set(TalonSRXControlMode.PercentOutput, speed);
  }

  public void stopMotor() {
    mFeedMotor.set(TalonSRXControlMode.Disabled, 0);
  }
}