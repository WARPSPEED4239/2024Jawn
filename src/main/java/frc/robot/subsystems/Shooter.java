package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  private final static TalonFX mTopWheel = new TalonFX(Constants.SHOOTER_MOTOR_1);
  private final static TalonFX mBottomWheel = new TalonFX(Constants.SHOOTER_MOTOR_2);
  
  public Shooter() {}

  @Override
  public void periodic() {
    
  }

  public void setWheelSpeed(double speed) {
    mTopWheel.set(speed);
    mBottomWheel.set(speed);
  }
}
