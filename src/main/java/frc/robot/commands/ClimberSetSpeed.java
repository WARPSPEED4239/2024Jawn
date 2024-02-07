package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.subsystems.Climber;

public class ClimberSetSpeed extends Command {

  private final Climber mClimber;
  private final CommandJoystick mJoystick;
  
  public ClimberSetSpeed(Climber climber, CommandJoystick joystick) {
    mClimber = climber;
    mJoystick = joystick;
    addRequirements(mClimber);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mClimber.setMotorSpeeds(mJoystick.getY());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
