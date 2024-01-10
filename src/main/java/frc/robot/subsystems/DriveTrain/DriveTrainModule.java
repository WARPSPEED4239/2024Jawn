package frc.robot.subsystems.DriveTrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenixpro.hardware.CANcoder;

import frc.robot.Constants;

public class DriveTrainModule{

  private final WPI_TalonFX DriveMotor;
  private final WPI_TalonFX SpinMotor;
  private final CANcoder Sensor;

  private double kP_speed = 0.0;
  private double kI_speed = 0.0;
  private double kD_speed = 0.0;
  private double kF_speed = 0.0;

  private double kP_angle = 0.0;
  private double kI_angle = 0.0;
  private double kD_angle = 0.0;
  private double kF_angle = 0.0;
  

  public DriveTrainModule(int driveMotor, int strafeMotor, int sensor) {
    DriveMotor = new WPI_TalonFX(driveMotor);
    SpinMotor = new WPI_TalonFX(strafeMotor);
    Sensor = new CANcoder(sensor);
    configMotorSettings();
  }

  void configMotorSettings() {
    DriveMotor.config_kP(0, kP_speed, Constants.TIMEOUT_MS);
    DriveMotor.config_kI(0, kI_speed, Constants.TIMEOUT_MS);
    DriveMotor.config_kD(0, kD_speed, Constants.TIMEOUT_MS);
    DriveMotor.config_kF(0, kF_speed, Constants.TIMEOUT_MS);

    SpinMotor.config_kP(0, kP_angle, Constants.TIMEOUT_MS);
    SpinMotor.config_kI(0, kI_angle, Constants.TIMEOUT_MS);
    SpinMotor.config_kD(0, kD_angle, Constants.TIMEOUT_MS);
    SpinMotor.config_kF(0, kF_angle, Constants.TIMEOUT_MS);
  }

  public void setMotorSpeedAndAngle(double speed, double angle) {
    //pid stuff here 
    //motion magic for setting angle
    DriveMotor.set(ControlMode.Velocity, 0/*velocity to SRX Units */);
    SpinMotor.set(ControlMode.MotionMagic, 0/*degrees to SRX Units */);
  }
}