package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name = "TeleOpPeriodV5_2 ", group = "Linear Opmode")//
public class TeleOpPeriodV5_2 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();
    boolean startActive;
    String method;


    public void low() {

        double o = -Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        o = Range.clip(o, -0.3, 0.3);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = Range.clip(gamepad1.right_stick_x, -0.6, 0.6);
        final double LF = o * Math.cos(robotAngle) + rightX;
        final double LB = o * Math.sin(robotAngle) + rightX;
        final double RF = o * Math.sin(robotAngle) - rightX;
        final double RB = o * Math.cos(robotAngle) - rightX;

        r.LFmotor.setPower(LF);
        r.LBmotor.setPower(LB);
        r.RFmotor.setPower(RF);
        r.RBmotor.setPower(RB);

    }

    public void high() {

        double o = -Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = gamepad1.right_stick_x;
        final double LF = o * Math.cos(robotAngle) + rightX;
        final double LB = o * Math.sin(robotAngle) + rightX;
        final double RF = o * Math.sin(robotAngle) - rightX;
        final double RB = o * Math.cos(robotAngle) - rightX;

        r.LFmotor.setPower(LF);
        r.LBmotor.setPower(LB);
        r.RFmotor.setPower(RF);
        r.RBmotor.setPower(RB);

    }

    public void runOpMode() {

        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();

        while (opModeIsActive()){

            if(gamepad1.start==true && startActive==true){
                startActive = false;
                high();
                method = "high";
            }else if(gamepad1.start==true && startActive==false){
                startActive = true;
                low();
                method = "low";
            }

            telemetry.addData("running", method);
            telemetry.update();

        }
    }
}



