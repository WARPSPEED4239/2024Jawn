package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Shooter;

public class ShooterShoot extends Command {

  private final Shooter mShooter;
  private final CommandJoystick mJoystick;

  public ShooterShoot(Shooter shooter, CommandJoystick joystick) {
    mShooter = shooter;
    mJoystick = joystick;
    addRequirements(mShooter);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mShooter.Shoot(mJoystick.getX());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
