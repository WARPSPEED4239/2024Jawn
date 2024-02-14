package frc.robot;

import com.ctre.phoenix6.Utils;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;
import com.pathplanner.lib.auto.AutoBuilder;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.ClimberSetSpeed;
import frc.robot.commands.CommandSwerveDrivetrain;
import frc.robot.commands.LimitCheck;
import frc.robot.commands.intake.SetFeedSpeed;
import frc.robot.commands.intake.SetPivotState;
import frc.robot.commands.shooter.IntakeToShooter;
import frc.robot.commands.shooter.ShooterSetSpeed;
import frc.robot.commands.shooter.ShooterSetSpeedCool;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LimitUp;
import frc.robot.subsystems.Shooter;
import frc.robot.tools.Telemetry;
import frc.robot.tools.generated.TunerConstants;
                                                                                                              // of the date 1/30/2024, Daniel Kale Pauff owes Samuel "Big Sam" Oswood 140 USD in two weeks time.
public class RobotContainer {
  private double MaxSpeed = 3.0;                                                                              // 6 meters/second
  private double MaxAngularRate = 1.5 * Math.PI;                                                              // .75 rotation/second

  private final CommandXboxController mXboxController = new CommandXboxController(Constants.XBOX_CONTROLLER);
  private final CommandJoystick mJoystick = new CommandJoystick(Constants.JOYSTICK);
  private final CommandSwerveDrivetrain drivetrain = TunerConstants.DriveTrain;
  private final LimitUp mLimitUp = new LimitUp();
  private final Climber mClimber = new Climber(); 
  private final Shooter mShooter = new Shooter();
  private final Intake mIntake = new Intake();

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
                               
    mClimber.setDefaultCommand(new ClimberSetSpeed(mClimber, mXboxController, 0.05));
    //mIntake.setDefaultCommand(new LimitCheck(mIntake));
    
    mXboxController.a().whileTrue(drivetrain.applyRequest(() -> brake));
    mXboxController.b().whileTrue(drivetrain
                       .applyRequest(() -> point.withModuleDirection(new Rotation2d(-mXboxController.getLeftY(), -mXboxController.getLeftX()))));

    mXboxController.leftStick().onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldRelative()));
    //mXboxController.leftStick().onFalse()

    mJoystick.button(3).whileTrue(new SetFeedSpeed(mIntake, 0.15));
    //mJoystick.button(4).whileTrue(new SetFeedSpeed(mIntake, -0.15));
    //mJoystick.button(11).whileTrue(new IntakeToShooter(mIntake, mShooter, 0.05, 0.05));
    mJoystick.button(2).whileTrue(new ShooterSetSpeed(mShooter, 0.20));
    mJoystick.trigger().whileTrue(new ShooterSetSpeedCool(mShooter, 0.45));
    mJoystick.button(5).whileTrue(new SetPivotState(mIntake, mLimitUp, 0.05));
    //mJoystick.button(6).whileTrue(new SetPivotState(mIntake, -0.025));

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

  public final Intake getIntake() {
    return mIntake;
  }

  public final LimitUp getLimitUp() {
    return mLimitUp;
  }
}