package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterSetSpeedCool extends Command {

  private static double mWheelSpeed;
  private final Shooter mShooter;
  
  public ShooterSetSpeedCool(Shooter shooter, double speed) {
    System.out.println("Cconstructer");
    mShooter = shooter;
    mWheelSpeed = speed;
    addRequirements(mShooter);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    System.out.println(mWheelSpeed);
    mShooter.setWheelSpeed(mWheelSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("Command Ended");
    mShooter.stopWheels();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}