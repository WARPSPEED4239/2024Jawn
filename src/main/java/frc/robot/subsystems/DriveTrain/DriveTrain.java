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

  double[][] calculateWheelSpeedAndAngle(double strafeRight, double rotateClockwise) {
    double A = strafeRight - rotateClockwise * (Constants.WHEEL_BASE_LENGTH / Constants.ROOT);
    double B = strafeRight + rotateClockwise * (Constants.WHEEL_BASE_LENGTH / Constants.ROOT);
    double C = strafeRight - rotateClockwise * (Constants.TRACK_WIDTH / Constants.ROOT);
    double D = strafeRight + rotateClockwise * (Constants.TRACK_WIDTH / Constants.ROOT);

    double wheelSpeedA = Math.sqrt(Math.pow(B, 2) + Math.pow(C, 2));
    double wheelSpeedB = Math.sqrt(Math.pow(B, 2) + Math.pow(D, 2));
    double wheelSpeedC = Math.sqrt(Math.pow(A, 2) + Math.pow(D, 2));
    double wheelSpeedD = Math.sqrt(Math.pow(A, 2) + Math.pow(C, 2));

    double wheelAngleA = Math.atan2(B,C) * 180 / Math.PI;
    double wheelAngleB = Math.atan2(B,D) * 180 / Math.PI;
    double wheelAngleC = Math.atan2(A,D) * 180 / Math.PI;
    double wheelAngleD = Math.atan2(A,C) * 180 / Math.PI;

    double max = wheelSpeedA;
    if (wheelSpeedB > max) {
      max = wheelSpeedB;
    }
    if (wheelSpeedC > max) {
      max = wheelSpeedC;
    }
    if (wheelSpeedD> max) {
      max = wheelSpeedD;
    }
    if (max > 1) {
      wheelSpeedA /= max;
      wheelSpeedB /= max;
      wheelSpeedC /= max;
      wheelSpeedD /= max;
    }
    double[][] wheelSettings = {{wheelSpeedA, wheelSpeedB, wheelSpeedC, wheelSpeedD},
                                {wheelAngleA, wheelAngleB, wheelAngleC, wheelAngleD}};
    return wheelSettings;
  }
}