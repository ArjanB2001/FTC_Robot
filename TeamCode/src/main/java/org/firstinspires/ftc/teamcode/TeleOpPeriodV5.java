package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeleOpPeriodV5 ", group = "Linear Opmode")//
public class TeleOpPeriodV5 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();
    double degree;
    double drive;

    public void runOpMode(){
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();
 
        while(opModeIsActive()){
            double o = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
            double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x;
            final double v1 = o * Math.cos(robotAngle) + rightX;
            final double v2 = o * Math.sin(robotAngle) - rightX;
            final double v3 = o * Math.sin(robotAngle) + rightX;
            final double v4 = o * Math.cos(robotAngle) - rightX;

            r.LFmotor.setPower(v1);
            r.RFmotor.setPower(v2);
            r.LBmotor.setPower(v3);
            r.RBmotor.setPower(v4);

            if(gamepad1.a) {
                r.servo1.setPosition(0.75);
                telemetry.addData("Servo:", "0.75");
            }

            if(gamepad1.y) {
                r.servo1.setPosition(0);
                telemetry.addData("Servo:", "0");
            }

            if(gamepad1.b) {
                r.servo1.setPosition(1);
                telemetry.addData("Servo:", "1");
            }

            if(gamepad1.x) {
                r.servo1.setPosition(0.7);
                telemetry.addData("Servo:", "0.7");
            }

            degree = gamepad1.right_trigger;
            if (degree > 0) {
                r.servo1.setPosition(degree);
                telemetry.addData("Servo", r.servo1.getPosition());
            }


            telemetry.addData("rotation LFmotor", r.LFmotor.getPower());
            telemetry.addData("rotation LBmotor", r.LBmotor.getPower());
            telemetry.addData("rotation RFmotor", r.RFmotor.getPower());
            telemetry.addData("rotation RBmotor", r.RBmotor.getPower());
            telemetry.addData("Degree", degree);
            telemetry.addData("ServoPos", r.servo1.getPosition());
            telemetry.update();


        }
    }
}
