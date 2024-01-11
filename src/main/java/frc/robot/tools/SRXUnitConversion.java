package frc.robot.tools;

import frc.robot.Constants;

public class SRXUnitConversion {

    public static double positionInDegreesToSRXUnits(double positionInDegrees) {
        return positionInDegrees / Constants.SRX_UNITS_PER_ROTATION; //mult the SRX units by 360 if wheels dont spin
    }

    public static double speedToSRXUnits(double speed) {
        return speed * Constants.SRX_UNITS_PER_ROTATION * 6.75;
    }
}
