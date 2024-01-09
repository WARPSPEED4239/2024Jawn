package frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private final DriveTrainModule Module1 = new DriveTrainModule(Constants.DRIVEMOTOR_1, Constants.SWERVEMOTOR_1, Constants.CAMCODER_1);
  
  public DriveTrain() {}

  @Override
  public void periodic() {}
}