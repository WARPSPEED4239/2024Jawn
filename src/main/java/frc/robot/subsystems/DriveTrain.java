package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private final WPI_TalonFX DriveMotor = new WPI_TalonFX(Contants.FILLER);
  double FWD;
  double STR;
  double RCW;

  public DriveTrain() {}

  @Override
  public void periodic() {}
}