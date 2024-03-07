package frc.robot.commands.LED;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LEDController;

public class ChangeLEDColor extends Command {
  
  private final LEDController mLEDcontroller;
  private int mRed;
  private int mGreen;
  private int mBlue;

  public ChangeLEDColor(LEDController ledcontroller, int r, int g, int b) {
    mLEDcontroller = ledcontroller;
    mRed = r;
    mGreen = g;
    mBlue = b;
    addRequirements(mLEDcontroller);
  }

  @Override
  public void initialize() {
    mLEDcontroller.setLedColor(mRed, mGreen, mBlue);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
