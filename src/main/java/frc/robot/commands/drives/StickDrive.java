// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drives;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

/**
 * DriveCommand runs the chassis through
 *  the DriveTrain subsystem.
 */
public class StickDrive extends Command {
  private DoubleSupplier speed, rotation;

  /**
   * Creates a new DriveCommand. 
   * @param pSpeed    - See DriveTrain.Drive() pSpeed.
   * @param pRotation - See DriveTrain.Drive() pRotation.
   */
  public StickDrive(DoubleSupplier pSpeed, DoubleSupplier pRotation) {
    speed = pSpeed;
    rotation = pRotation;

    addRequirements(Constants.driveTrain);    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Constants.driveTrain.Drive(speed.getAsDouble(), rotation.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Constants.driveTrain.Drive(0.0, 0.0);
  }
}
