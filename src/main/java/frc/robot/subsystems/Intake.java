package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  public final static TalonFX mFeedMotor = new TalonFX(Constants.INTAKE_MOTOR_FEED);
  public final static TalonFX mPivotMotor = new TalonFX(Constants.INTAKE_MOTOR_PIVOT);
  public final static DigitalInput mLimitDown = new DigitalInput(Constants.LIMIT_SWITCH_DOWN);
  public final static DigitalInput mLimitUp = new DigitalInput(Constants.LIMIT_SWITCH_UP);

  public Intake() {}

  @Override
  public void periodic() {}

  public void setFeedSpeed(double speed){
    mFeedMotor.set(speed);
  }

  public void setPivotSpeed(double speed){
    mPivotMotor.set(speed);
  }

  public boolean getLimitDown() {
    return mLimitDown.get();
  }

  public boolean getLimitUp() {
    return mLimitUp.get();
  }
}