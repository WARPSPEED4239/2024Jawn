package frc.robot;

import com.ctre.phoenix6.Utils;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrain;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.CommandSwerveDrivetrain;
import frc.robot.tools.Telemetry;
import frc.robot.tools.generated.TunerConstants;

public class RobotContainer {
  private double MaxSpeed = 3.0;                                                                              // 6 meters/second
  private double MaxAngularRate = 1.5 * Math.PI;                                                              // .75 rotation/second

  private final CommandXboxController mXboxController = new CommandXboxController(Constants.XBOX_CONTROLLER);
  private final CommandJoystick mJoystick = new CommandJoystick(Constants.JOYSTICK);
  private final CommandSwerveDrivetrain drivetrain = TunerConstants.DriveTrain;

  private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
  private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();
  private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
      .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1)
      .withDriveRequestType(DriveRequestType.OpenLoopVoltage);
  private final Telemetry logger = new Telemetry(MaxSpeed);

  private final SendableChooser<Command> autoChooser;

  private void configureBindings() { 
    // use to get access to Pose2D
    System.out.println(drivetrain.getState().Pose);
    
    drivetrain.setDefaultCommand(
        drivetrain.applyRequest(() -> drive.withVelocityX(-mXboxController.getLeftY() * MaxSpeed)             // -y forward
                                           .withVelocityY(-mXboxController.getLeftX() * MaxSpeed)             // -x forward
                                           .withRotationalRate(-mXboxController.getRightX() * MaxAngularRate) // -x counterclockwise
                               ));                                                                            
    
    mXboxController.a().whileTrue(drivetrain.applyRequest(() -> brake));
    mXboxController.b().whileTrue(drivetrain
                       .applyRequest(() -> point.withModuleDirection(new Rotation2d(-mXboxController.getLeftY(), -mXboxController.getLeftX()))));

    mXboxController.leftBumper().onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldRelative()));

    if (Utils.isSimulation()) {
      drivetrain.seedFieldRelative(new Pose2d(new Translation2d(), Rotation2d.fromDegrees(90)));
    }

    drivetrain.registerTelemetry(logger::telemeterize);
  }

  public RobotContainer() {
    configureBindings();
    autoChooser = AutoBuilder.buildAutoChooser();

    SmartDashboard.putData("Test Auto", autoChooser);
    SmartDashboard.putData("Spin hee hee hee haw", autoChooser);
  }

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}