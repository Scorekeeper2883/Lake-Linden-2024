package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class AngleReset extends Command{
	private boolean done;

	public AngleReset() {
		addRequirements(Constants.arm);
	}

	@Override
	public void initialize() {
		done = false;
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		Constants.arm.setCurrentAngle(140);
		done = true;
	}

	@Override
	public boolean isFinished() {
		return done;
	}
}
