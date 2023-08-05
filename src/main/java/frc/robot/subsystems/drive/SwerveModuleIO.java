package frc.robot.subsystems.drive;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.kinematics.SwerveModuleState;

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
    public default void setDesiredState(SwerveModuleState state) {}
}
