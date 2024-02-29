// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class takeIn extends Command {
	private double speed, angle;

	public takeIn(double pSpeed) {
		speed = pSpeed;
		angle = Constants.arm.getAngle();

		addRequirements(Constants.intake, Constants.arm);
	}

	public takeIn(double pSpeed, double pAngle) {
		speed = pSpeed;
		angle = pAngle;

		addRequirements(Constants.intake, Constants.arm);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		Constants.arm.setAngle(angle);
		Constants.intake.In(speed);
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		Constants.intake.In(0);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
