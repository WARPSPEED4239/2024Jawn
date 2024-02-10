package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  public final static TalonFX mFeedMotor = new TalonFX(Constants.INTAKE_MOTOR_FEED, "rio");
  public final static TalonFX mPivotMotor = new TalonFX(Constants.INTAKE_MOTOR_PIVOT, "rio");
  public final static DigitalInput mLimitDown = new DigitalInput(Constants.LIMIT_SWITCH_DOWN);
  public final static DigitalInput mLimitUp = new DigitalInput(Constants.LIMIT_SWITCH_UP);

  public Intake() {
    mFeedMotor.setInverted(false);
    mFeedMotor.setNeutralMode(NeutralModeValue.Brake);
    mPivotMotor.setInverted(false);
    mPivotMotor.setNeutralMode(NeutralModeValue.Brake);
  }

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