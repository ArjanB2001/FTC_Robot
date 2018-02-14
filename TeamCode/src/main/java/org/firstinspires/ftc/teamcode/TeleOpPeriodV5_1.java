package org.firstinspires.ftc.teamcode;

import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeleOpPeriodV5 ", group = "Linear Opmode")//
public class TeleOpPeriodV5_1 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();
    double degree;
    double drive;
    public Boolean playing = false;

    public void runOpMode(){
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();

        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();
 
        while(opModeIsActive()){
            double o = -Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
                   o = Range.clip(o, -0.3, 0.3);
            double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
            double rightX = Range.clip(gamepad1.right_stick_x, -0.7, 0.7);
            final double LF = o * Math.cos(robotAngle) + rightX;
            final double LB = o * Math.sin(robotAngle) + rightX;
            final double RF = o * Math.sin(robotAngle) - rightX;
            final double RB = o * Math.cos(robotAngle) - rightX;

            r.LFmotor.setPower(LF);
            r.LBmotor.setPower(LB);
            r.RFmotor.setPower(RF);
            r.RBmotor.setPower(RB);


        }
    }
}
