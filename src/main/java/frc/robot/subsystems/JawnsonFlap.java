package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class JawnsonFlap extends SubsystemBase {

  private final TalonSRX mJawnson = new TalonSRX(Constants.JAWNSON_MOTOR);
  
  public JawnsonFlap() {
    mJawnson.setInverted(false);
    mJawnson.setNeutralMode(NeutralMode.Brake);
    mJawnson.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {}

  public void setSpeed(double speed) {
    mJawnson.set(TalonSRXControlMode.PercentOutput, speed);
  }

  public double getPosition() {
    return mJawnson.getSelectedSensorPosition();
  }

  public void setPositionZero() {
    mJawnson.setSelectedSensorPosition(0);
  }

  public void stopMotor() {
    mJawnson.set(TalonSRXControlMode.Disabled, 0);
  }
}