package frc.robot;

import com.ctre.phoenix6.Utils;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.ClimberLeftSetSpeed;
import frc.robot.commands.ClimberRightSetSpeed;
import frc.robot.commands.CommandSwerveDrivetrain;
import frc.robot.commands.IntakePivotSetPosition;
import frc.robot.commands.IntakePivotSetSpeed;
import frc.robot.commands.IntakeSetFeedMotorSpeed;
import frc.robot.commands.JawnsonMotorSetPosition;
import frc.robot.commands.JawnsonMotorSetSpeed;
import frc.robot.commands.ShooterSetSpeed;
import frc.robot.commands.LED.ChangeLEDColor;
import frc.robot.subsystems.ClimberLeft;
import frc.robot.subsystems.ClimberRight;
import frc.robot.subsystems.IntakeFeed;
import frc.robot.subsystems.IntakePivot;
import frc.robot.subsystems.JawnsonFlap;
import frc.robot.subsystems.LEDController;
import frc.robot.subsystems.Shooter;
import frc.robot.tools.Telemetry;
import frc.robot.tools.generated.TunerConstants;
                                                                                                              // of the date 1/30/2024, Daniel Kale Pauff owes Samuel "Big Sam" Oswood 140 USD in two weeks time.
public class RobotContainer {
  private double MaxSpeed = 3.0;                                                                              // 6 meters/second
  private double MaxAngularRate = 1.5 * Math.PI;                                                             // .75 rotation/second

  private final CommandXboxController mXboxController = new CommandXboxController(Constants.XBOX_CONTROLLER);
  private final CommandJoystick mJoystick = new CommandJoystick(Constants.JOYSTICK);
  private final CommandSwerveDrivetrain drivetrain = TunerConstants.DriveTrain;

  private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
  private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();
  private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
      .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1)
      .withDriveRequestType(DriveRequestType.OpenLoopVoltage);
  private final Telemetry logger = new Telemetry(MaxSpeed);

  private final Shooter mShooter = new Shooter();
  private final IntakeFeed mIntakeFeed = new IntakeFeed();
  private final ClimberLeft mClimberLeft = new ClimberLeft();
  private final ClimberRight mClimberRight = new ClimberRight();
  private final JawnsonFlap mJawnsonFlap = new JawnsonFlap();
  private final LEDController mLEDController = new LEDController();
  private final IntakePivot mIntakePivot = new IntakePivot();

  private final SendableChooser<Command> autoChooser;

  public RobotContainer() {
    NamedCommands.registerCommand("Shoot", new ParallelCommandGroup(new IntakeSetFeedMotorSpeed(mIntakeFeed, -1.0), 
                                                                         new ShooterSetSpeed(mShooter, 0.85, 0.85)));

    NamedCommands.registerCommand("ShootStop", new ParallelCommandGroup(new IntakeSetFeedMotorSpeed(mIntakeFeed, 0.0), 
                                                                             new ShooterSetSpeed(mShooter, 0.0, 0.0)));                                                       
                                                                           
    NamedCommands.registerCommand("Intake", new IntakeSetFeedMotorSpeed(mIntakeFeed, 0.7));

    NamedCommands.registerCommand("Inta$keStops", new IntakeSetFeedMotorSpeed(mIntakeFeed, 0.0));

    NamedCommands.registerCommand("PivotIn", new IntakePivotSetPosition(mIntakePivot, -1.0, 0.3));

    NamedCommands.registerCommand("PivotOut", new IntakePivotSetPosition(mIntakePivot, -42.0, -0.4));

    mShooter.setDefaultCommand(new ShooterSetSpeed(mShooter, 0.0, 0.0));
    mIntakeFeed.setDefaultCommand(new IntakeSetFeedMotorSpeed(mIntakeFeed, 0.0));
    mClimberLeft.setDefaultCommand(new ClimberLeftSetSpeed(mClimberLeft, 0.0));
    mClimberRight.setDefaultCommand(new ClimberRightSetSpeed(mClimberRight, 0.0));
    mJawnsonFlap.setDefaultCommand(new JawnsonMotorSetPosition(mJawnsonFlap, 5, .25));
    mLEDController.setDefaultCommand(new ChangeLEDColor(mLEDController, 0, 255, 0));
    mIntakePivot.setDefaultCommand(new IntakePivotSetSpeed(mIntakePivot, 0.0));

    autoChooser = AutoBuilder.buildAutoChooser();

    UsbCamera mainCamera = CameraServer.startAutomaticCapture();
    mainCamera.setResolution(320, 240);
    mainCamera.setFPS(10);

    configureBindings();
  }

  private void configureBindings() {
    SmartDashboard.putData("Auto Chooser", autoChooser);

    mJoystick.button(1).whileTrue(new ParallelCommandGroup(new ShooterSetSpeed(mShooter, 0.85, 0.85), 
                                                                  new IntakeSetFeedMotorSpeed(mIntakeFeed, -1.0)));

    mJoystick.button(2).whileTrue(new ParallelCommandGroup(new SequentialCommandGroup(new WaitCommand(0.5),
                                                                                             new IntakeSetFeedMotorSpeed(mIntakeFeed, -0.45)),
                                                                  new ShooterSetSpeed(mShooter, 0.125, 0.125))); 

    mJoystick.button(2).onFalse(new JawnsonMotorSetPosition(mJawnsonFlap, 60.0, 0.15));
    mJoystick.button(3).whileTrue(new IntakePivotSetPosition(mIntakePivot, -38.0, -0.4));
    mJoystick.button(4).whileTrue(new IntakePivotSetPosition(mIntakePivot, -1.0, 0.3));
    mJoystick.button(5).whileTrue(new IntakeSetFeedMotorSpeed(mIntakeFeed, -1.0));
    mJoystick.button(6).whileTrue(new IntakeSetFeedMotorSpeed(mIntakeFeed, 1.0));
    mJoystick.button(8).whileTrue(new JawnsonMotorSetPosition(mJawnsonFlap, 85, -0.25));
    mJoystick.button(10).whileTrue(new JawnsonMotorSetPosition(mJawnsonFlap, 85, -0.25));
    mJoystick.button(12).whileTrue(new JawnsonMotorSetPosition(mJawnsonFlap, 85, -0.25));
    mJoystick.button(7).whileTrue(new JawnsonMotorSetSpeed(mJawnsonFlap, 0.25));
    mJoystick.button(9).whileTrue(new JawnsonMotorSetSpeed(mJawnsonFlap, 0.25));
    mJoystick.button(11).whileTrue(new JawnsonMotorSetSpeed(mJawnsonFlap, 0.25));
    mJoystick.povCenter().whileTrue(new JawnsonMotorSetPosition(mJawnsonFlap, 5, .25));

    mJoystick.button(4).and(mJoystick.button(0));

    mJoystick.button(7).whileTrue(new IntakePivotSetSpeed(mIntakePivot, -0.03));

    mXboxController.leftTrigger().whileTrue(new ClimberLeftSetSpeed(mClimberLeft, 0.5));
    mXboxController.rightTrigger().whileTrue(new ClimberRightSetSpeed(mClimberRight, 0.5));
    mXboxController.leftBumper().whileTrue(new ClimberLeftSetSpeed(mClimberLeft, -0.5));
    mXboxController.rightBumper().whileTrue(new ClimberRightSetSpeed(mClimberRight, -0.5));

    mXboxController.povLeft().onTrue(new ChangeLEDColor(mLEDController, 150, 150, 0));
    mXboxController.povRight().onTrue(new ChangeLEDColor(mLEDController, 0, 0, 25));
    mXboxController.povUp().onTrue(new ChangeLEDColor(mLEDController, 0, 255, 0));
    mXboxController.povDown().onTrue(new ChangeLEDColor(mLEDController, 100, 0, 100));

    drivetrain.setDefaultCommand(
        drivetrain.applyRequest(() -> drive.withVelocityX(-mXboxController.getLeftY() * MaxSpeed)             // -y forward
                                           .withVelocityY(-mXboxController.getLeftX() * MaxSpeed)             // -x forward
                                           .withRotationalRate(-mXboxController.getRightX() * MaxAngularRate) // -x counterclockwise
                               ));              
    
    mXboxController.a().whileTrue(drivetrain.applyRequest(() -> brake));
    mXboxController.b().whileTrue(drivetrain
                       .applyRequest(() -> point.withModuleDirection(new Rotation2d(-mXboxController.getLeftY(), -mXboxController.getLeftX()))));

    mXboxController.start().onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldRelative()));

    if (Utils.isSimulation()) {
      drivetrain.seedFieldRelative(new Pose2d(new Translation2d(), Rotation2d.fromDegrees(90)));
    }

    drivetrain.registerTelemetry(logger::telemeterize);
  }

  public Command getAutonomousCommand() {
    System.out.print(autoChooser.getSelected());
    return autoChooser.getSelected();
  }
}