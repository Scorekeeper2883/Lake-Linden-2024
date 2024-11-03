// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
	private static final CANSparkMax leftArmMotor = new CANSparkMax(Constants.leftArm, MotorType.kBrushless);
	private static final CANSparkMax rightArmMotor = new CANSparkMax(Constants.rightArm, MotorType.kBrushless);
	private static final RelativeEncoder encodeArm = leftArmMotor.getEncoder();
	// private final double lowerLimit = -5;
	// private final double upperLimit = 100;
	private final double gearRatio = 248/1;

	public Arm() {
		leftArmMotor.setInverted(false);
		rightArmMotor.setInverted(true);

		leftArmMotor.setIdleMode(IdleMode.kBrake);
		rightArmMotor.setIdleMode(IdleMode.kBrake);

		encodeArm.setPositionConversionFactor(360/encodeArm.getCountsPerRevolution()/gearRatio);
		encodeArm.setPosition(0);	// Make sure the arm starts straight up!
	}

	public void primitiveArmPivot(double pSpeed) {
			leftArmMotor.set(pSpeed);
			rightArmMotor.set(pSpeed);
	}

	public double getAngle() {
		return encodeArm.getPosition();
	}

	public void setCurrentAngle(double pAngle) {
		encodeArm.setPosition(pAngle);
	}

	public void goToAngle(double pAngle) {
	}
}
