package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class ArmAngle extends Command {
	private final double angle;
	private boolean done;

	public ArmAngle(double pAngle) {
		angle = pAngle;

		addRequirements(Constants.arm);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		done = false;
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		double tolerance = 5;

		if (angle + tolerance < Constants.arm.getAngle()) {
			Constants.arm.PrimitiveArmPivot(-0.3);
		} else if (Constants.arm.getAngle() < angle - tolerance) {
			Constants.arm.PrimitiveArmPivot(0.3);
		} else {
			done = true;
		}
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		Constants.arm.PrimitiveArmPivot(0);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return done;
	}
}
