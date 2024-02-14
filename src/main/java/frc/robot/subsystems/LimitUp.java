// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LimitUp extends SubsystemBase {

  public final static DigitalInput mLimitUp = new DigitalInput(Constants.LIMIT_SWITCH_UP);
  public LimitUp() {}

  @Override
  public void periodic() {}
  
  public boolean getLimitUp() {
    return mLimitUp.get();
  }
}
