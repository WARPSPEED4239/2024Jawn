package frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private final DriveTrainModule ModuleA = new DriveTrainModule(Constants.DRIVEMOTOR_1, Constants.SWERVEMOTOR_1, Constants.CAMCODER_1);
  private final DriveTrainModule ModuleB = new DriveTrainModule(Constants.DRIVEMOTOR_2, Constants.SWERVEMOTOR_2, Constants.CAMCODER_2);
  private final DriveTrainModule ModuleC = new DriveTrainModule(Constants.DRIVEMOTOR_3, Constants.SWERVEMOTOR_3, Constants.CAMCODER_3);
  private final DriveTrainModule ModuleD = new DriveTrainModule(Constants.DRIVEMOTOR_4, Constants.SWERVEMOTOR_4, Constants.CAMCODER_4);
  
  public DriveTrain() {}

  @Override
  public void periodic() {}

  double calculateWheelSpeed(double strafeRight, double rotateClockwise, int wheel) {
    double A = strafeRight - rotateClockwise * (Constants.WHEEL_BASE_LENGTH / Constants.ROOT);
    double B = strafeRight + rotateClockwise * (Constants.WHEEL_BASE_LENGTH / Constants.ROOT);
    double C = strafeRight - rotateClockwise * (Constants.TRACK_WIDTH / Constants.ROOT);
    double D = strafeRight + rotateClockwise * (Constants.TRACK_WIDTH / Constants.ROOT);

    if (wheel == 1) {
        return Math.sqrt(Math.pow(B, 2) + Math.pow(C, 2));
    } else if (wheel == 2) {
        return Math.sqrt(Math.pow(B, 2) + Math.pow(D, 2));
    } else if (wheel == 3) {
        return Math.sqrt(Math.pow(A, 2) + Math.pow(D, 2));
    } else if (wheel == 4) {
        return Math.sqrt(Math.pow(A, 2) + Math.pow(C, 2));
    } else {
      return 0.0;
    }
  }

  double calculateWheelAngle(double strafeRight, double rotateClockwise, int wheel) {
    double A = strafeRight - rotateClockwise * (Constants.WHEEL_BASE_LENGTH / Constants.ROOT);
    double B = strafeRight + rotateClockwise * (Constants.WHEEL_BASE_LENGTH / Constants.ROOT);
    double C = strafeRight - rotateClockwise * (Constants.TRACK_WIDTH / Constants.ROOT);
    double D = strafeRight + rotateClockwise * (Constants.TRACK_WIDTH / Constants.ROOT);

    if (wheel == 1) {
      return Math.atan2(B,C) * 180 / Math.PI;
    } else if (wheel == 2) {
      return Math.atan2(B,D) * 180 / Math.PI;
    } else if (wheel == 3) {
      return Math.atan2(A,D) * 180 / Math.PI;
    } else if (wheel == 4) {
      return Math.atan2(A,C) * 180 / Math.PI;
    } else {
      return 0.0;
    }
  }
}