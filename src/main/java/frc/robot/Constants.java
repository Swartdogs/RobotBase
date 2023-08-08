// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants 
{
    public static final Mode currentMode = Mode.RUN;

    public static enum Mode 
    {
        /** Running a robot. */
        RUN,

        /** Replaying from a log file. */
        REPLAY
    }

    public static final class ModuleConstants
    {
        public static final double kDriveEncoderRot2Meter       = 0;
        public static final double kDriveEncoderRPM2MeterPerSec = 0;
        public static final double kRotateEncoderRot2Rad        = 0;
        public static final double kRotateEncoderRPM2RadPerSec  = 0;
    }
}
