package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.subsystems.Shooter;

public class ShooterSetSpeed extends Command {

  private final CommandJoystick mJoystick;
  private static double joystickDirection;
  private static double intakeModifier;
  private static double mWheelSpeed;
  private final Shooter mShooter;
  
  public ShooterSetSpeed(Shooter shooter, CommandJoystick joystick, double speed) {
    mShooter = shooter;
    mJoystick = joystick;
    mWheelSpeed = speed;
    addRequirements(mShooter);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    joystickDirection = mJoystick.getY();
    intakeModifier = 0.1;

    if (joystickDirection < -0.2) {
      mShooter.setWheelSpeed(-mWheelSpeed * intakeModifier);
    } else if (joystickDirection > 0.2) {
      mShooter.setWheelSpeed(mWheelSpeed);
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
