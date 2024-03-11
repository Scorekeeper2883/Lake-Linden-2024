// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class PrimitiveArmPivot extends Command {
	private DoubleSupplier speed1, speed2;

	/** Creates a new PrimitiveArmPivot. */
	public PrimitiveArmPivot(DoubleSupplier pSpeed1, DoubleSupplier pSpeed2) {
		speed1 = pSpeed1;
		speed2 = pSpeed2;

		addRequirements(Constants.arm);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		double speed = speed1.getAsDouble() - speed2.getAsDouble();

		if (Constants.arm.getAngle() > 140 && speed > 0) {
			speed = 0;
		} else if (Constants.arm.getAngle() < 80 && speed < 0) {
			speed = 0;
		}

		Constants.arm.PrimitiveArmPivot(speed);
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		Constants.arm.PrimitiveArmPivot(0);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
