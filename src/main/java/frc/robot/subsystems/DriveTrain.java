// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import java.lang.Math;


public class DriveTrain extends SubsystemBase {


  /**
    * an abstract representation of a physical drive motor
    */
  private final MotorController leftMotor, rightMotor;
  /**
    * an abstract representation of a drive base
    */
  private final DifferentialDrive diffDrive;
  

  /**
    * subsystem base object for chassis
    */
  public DriveTrain() {
    leftMotor = new PWMSparkMax(Constants.PWM.leftDrive);
    rightMotor = new PWMSparkMax(Constants.PWM.rightDrive);
    diffDrive = new DifferentialDrive(leftMotor, rightMotor);
  }


  /**
   * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
   * to stop motors
   */
  public void stopMotor() {
    diffDrive.stopMotor();
  }


  /**
   * scales value ranging from -1 to 1 to 0 to 1
   * @param rawValue raw value from joystick; ranging from -1 to 1
   * @return scaled value; ranging from 0 to 1
   */
  public double adjustedSpeed(double rawValue){
    if (-rawValue <= 0){
      return 0.5-(Math.abs(-rawValue) / 2);
    } 
    return (-rawValue/2) + 0.5;
  }


  /**
   * calls arcadeDrive method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
   * to enable arcade drive with the joystick controller
   * @param position raw values of joystick used to control forward and backward movement
   * @param angle raw values of joystick used to control heading movement
   * @param speed raw values of slider used to control the speed of heading movement
   */
  public void arcadeDriveWithJoystick(double position, double angle, double speed) {
    diffDrive.arcadeDrive(-position, -angle * this.adjustedSpeed(speed));
  }


  /**
   * calls arcadeDrive method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
   * to enable arcade drive with the Xbox controller
   * @param position raw values of joystick used to control forward and backward movement
   * @param angle raw values of joystick used to control heading movement
   */
  public void arcadeDriveWithXbox(double position, double angle) {
    diffDrive.arcadeDrive(-position, -angle);
  }


  /**
   * calls diffDrive method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
   * to enable differential drive with the Xbox controller
   * @param leftJoystick raw values of the left joystick
   * @param rightJoystick raw values of the right joystick
   */
  public void diffDrive(double leftJoystick, double rightJoystick) {
    diffDrive.tankDrive(-leftJoystick, -rightJoystick);
  }


}