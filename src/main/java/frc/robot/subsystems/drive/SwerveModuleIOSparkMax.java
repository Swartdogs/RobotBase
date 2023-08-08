package frc.robot.subsystems.drive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.Constants;
import frc.robot.Constants.ModuleConstants;

public class SwerveModuleIOSparkMax implements SwerveModuleIO
{
    private final CANSparkMax _driveMotor ;
    private final CANSparkMax _rotateMotor;

    private final RelativeEncoder _driveEncoder;
    private final RelativeEncoder _rotateEncoder;

    private final AnalogInput _potentiometer;
    private final boolean     _potentiometerReversed;
    private final double      _potentiometerOffset;

    public SwerveModuleIOSparkMax(int driveMotorId, int rotateMotorId, boolean driveMotorReversed, boolean rotateMotorReversed, int potentiometerId, double potentiometerOffset, boolean potentiometerReversed)
    {
        _potentiometer         = new AnalogInput(potentiometerId);
        _potentiometerReversed = potentiometerReversed;
        _potentiometerOffset   = potentiometerOffset;

        _driveMotor  = new CANSparkMax(driveMotorId,  MotorType.kBrushless);
        _rotateMotor = new CANSparkMax(rotateMotorId, MotorType.kBrushless);
        
        _driveMotor.setInverted(driveMotorReversed);
        _rotateMotor.setInverted(rotateMotorReversed);

        _driveEncoder  = _driveMotor.getEncoder();
        _rotateEncoder = _rotateMotor.getEncoder();

        _driveEncoder.setPositionConversionFactor(ModuleConstants.kDriveEncoderRot2Meter);
        _driveEncoder.setVelocityConversionFactor(ModuleConstants.kDriveEncoderRPM2MeterPerSec);
        _rotateEncoder.setPositionConversionFactor(ModuleConstants.kRotateEncoderRot2Rad);
        _rotateEncoder.setVelocityConversionFactor(ModuleConstants.kRotateEncoderRPM2RadPerSec);
    }

    @Override
    public void stop() 
    {
        _driveMotor.setVoltage(0);
        _rotateMotor.setVoltage(0);
    }

    @Override
    public void resetEncoders(SwerveModuleIOInputs inputs) 
    {
        _driveEncoder.setPosition(0);
        _rotateEncoder.setPosition(inputs.potentiometerPostitionRad);
    }

    @Override
    public void updateInputs(SwerveModuleIOInputs inputs)
    {
        inputs.potentiometerPostitionRad      = _rotateEncoder.getPosition();
        inputs.rotateMotorPostitionRad        = _rotateEncoder.getPosition();
        inputs.driveMotorPostionMeters        = _driveEncoder.getPosition();
        inputs.driveMotorVelocityMetersPerSec = _driveEncoder.getVelocity();
        inputs.rotateMotorVelocityRadPerSec   = _rotateEncoder.getVelocity();
    }

    @Override
    public void setDriveVolts(double volts) 
    {
        _driveMotor.setVoltage(volts);
    }

    @Override
    public void setRotateVolts(double volts)
    {
        _rotateMotor.setVoltage(volts);
    }
}
