package frc.robot.subsystems.drive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.kinematics.SwerveModuleState;

public class SwerveModuleIOSparkMax implements SwerveModuleIO
{
    private final CANSparkMax _driveMotor;
    private final CANSparkMax _rotateMotor;

    private final RelativeEncoder _driveEncoder;
    private final RelativeEncoder _rotateEncoder;

    @Override
    public void stop() 
    {
        _driveMotor.setVoltage(0);
        _rotateMotor.setVoltage(0);
    }

    @Override
    public void resetEncoders(SwerveModuleIOInputs inputs) 
    {

    }

    @Override
    public void setDesiredState(SwerveModuleState state) 
    {
        
    }
}
