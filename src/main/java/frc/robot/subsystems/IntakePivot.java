package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakePivot extends SubsystemBase {
  
  private final TalonFX mPivotMotor = new TalonFX(Constants.INTAKE_MOTOR_PIVOT);
  private final DigitalInput mLimitIn = new DigitalInput(Constants.LIMIT_SWITCH_IN);
  private final DigitalInput mLimitOut = new DigitalInput(Constants.LIMIT_SWITCH_OUT);
  private final DutyCycleOut mDutyCycle = new DutyCycleOut(0.0);
  
  public IntakePivot() {
    mPivotMotor.setInverted(false);
    mPivotMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  public void periodic() {}

  public double getPosition() {
    return mPivotMotor.getPosition().getValueAsDouble();

  }

  public void setSpeed(double speed) {
    mPivotMotor.set(speed);
  }

  public void setOutputWithLimitSensors(double speed) {
    mPivotMotor.setControl(mDutyCycle.withOutput(speed).withLimitForwardMotion(mLimitIn.get()).withLimitReverseMotion(mLimitOut.get()));
  }

  public void setPositionIn() {
    mPivotMotor.setPosition(0.0);
  }

  public void setPositionOut() {
    mPivotMotor.setPosition(-44);
  }

  public boolean getLimitIn() {
    return mLimitIn.get();
  }

  public boolean getLimitOut() {
    return mLimitOut.get();
  }

  public void stopMotor() {
    mPivotMotor.stopMotor();
  }
}
