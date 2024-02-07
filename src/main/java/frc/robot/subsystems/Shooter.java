package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  private final static TalonFX Shooter1 = new TalonFX(Constants.SHOOTER_MOTOR_1);
  private final static TalonFX Shooter2 = new TalonFX(Constants.SHOOTER_MOTOR_2);
  
  public Shooter() {}

  @Override
  public void periodic() {
    
  }

  public void Shoot(double _Shoot_) {
    Shooter1.set(_Shoot_);
    Shooter2.set(_Shoot_);
  }
}
