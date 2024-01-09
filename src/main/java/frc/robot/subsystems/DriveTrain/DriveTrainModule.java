package frc.robot.subsystems.DriveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenixpro.hardware.CANcoder;

public class DriveTrainModule{

  private final WPI_TalonFX DriveMotor;
  private final WPI_TalonFX StrafeMotor;
  private final CANcoder Sensor;

  public DriveTrainModule(int driveMotor, int strafeMotor, int sensor) {
    DriveMotor = new WPI_TalonFX(driveMotor);
    StrafeMotor =  new WPI_TalonFX(strafeMotor);
    Sensor = new CANcoder(sensor);
  }
  
}