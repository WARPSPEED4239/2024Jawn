package frc.robot;

import java.lang.Math;

public class Constants {
    public static final int 
        XBOX_CONTROLLER = 0,
        JOYSTICK = 1,

        TIMEOUT_MS = 100,
        
        DRIVEMOTOR_1 = 101,
        SWERVEMOTOR_1 = 102,
        CANCODER_1 = 103,
        DRIVEMOTOR_2 = 104,
        SWERVEMOTOR_2 = 105,
        CANCODER_2 = 106,
        DRIVEMOTOR_3 = 107,
        SWERVEMOTOR_3 = 108,
        CANCODER_3 = 109,
        DRIVEMOTOR_4 = 110,
        SWERVEMOTOR_4 = 111,
        CANCODER_4 = 112,

        PIGEON_IMU = 200,

        SRX_UNITS_PER_ROTATION = 4096,

        FILLER = 5318008;

    public static final double
        WHEEL_DIAMETER_INCHES = 4,
        GEAR_RATIO = 6.75,

        WHEEL_BASE_LENGTH = 27.5,
        TRACK_WIDTH = 20.5,
        ROOT = Math.sqrt(WHEEL_BASE_LENGTH * 2 + TRACK_WIDTH * 2);
}
