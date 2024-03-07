package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdle.LEDStripType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class LEDController extends SubsystemBase {

  private final CANdle candle = new CANdle(Constants.CANDLE);

  public LEDController() {
    candle.configFactoryDefault();
    candle.configLEDType(LEDStripType.RGB);
  }

  @Override
  public void periodic() {
    
  }

  public void setLedColor(int red, int green, int blue) {
    candle.setLEDs(red, green, blue);
  }
}
