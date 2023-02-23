package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ClawServo extends SubsystemBase {


    private Servo clawServo;

    
    public ClawServo() {
        this.clawServo = new Servo(Constants.Subsystems.ClawServo.kPORT);
 
        System.out.println("Subsystem Log: Claw is configured to CAN port");
    }


    public void up() {
        this.clawServo.setAngle(90);
        //this.clawServo.set(-Constants.Subsystems.ClawServo.kUpPos);
        System.out.println("Command Log: Opened claw");
    }


    public void down() {
        this.clawServo.setAngle(0);
        //this.clawServo.set(Constants.Subsystems.ClawServo.kDownPos);
        System.out.println("Command Log: Closed claw");
    }

    public void stop() {
        this.clawServo.setDisabled();
        System.out.println(this.clawServo.getAngle());
    }


}