package frc.robot.subsystems.drive;

import org.littletonrobotics.junction.AutoLog;

public interface SwerveModuleIO 
{
    @AutoLog
    public static class SwerveModuleIOInputs
    {
        public double potentiometerPostitionRad;
        public double rotateMotorPostitionRad;
        public double driveMotorPostionMeters;
        public double driveMotorVelocityMetersPerSec;
        public double rotateMotorVelocityRadPerSec;
    }
    public default void stop() {}
    public default void resetEncoders(SwerveModuleIOInputs inputs) {}
    public default void updateInputs(SwerveModuleIOInputs inputs) {}
    public default void setDriveVolts(double volts) {}
    public default void setRotateVolts(double volts) {}
}
