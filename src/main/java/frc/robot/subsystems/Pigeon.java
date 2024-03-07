package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class Pigeon {

  private final static Pigeon2 pigeon = new Pigeon2(Constants.PIGEON_IMU, "DriveTrain");

  
  public Pigeon() {}

  public static double getPitch() {
    return pigeon.getPitch().getValueAsDouble();
  }

  public static double getYaw() {
    return pigeon.getYaw().getValueAsDouble();
  }

  public static double getRoll() {
    return pigeon.getRoll().getValueAsDouble();
  }

  public static void setYaw(double angleDeg) {
    Pigeon.setYaw(angleDeg);
  }

  public static void outputGyroSensorsToDashboard() {
    SmartDashboard.putNumber("PITCH", getPitch());
    SmartDashboard.putNumber("ROLL", getRoll());
    SmartDashboard.putNumber("YAW", getYaw());
  }
}