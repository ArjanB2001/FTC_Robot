package org.firstinspires.ftc.teamcode;

import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import static com.sun.tools.javac.util.LayoutCharacters.LF;

@TeleOp(name = "TeleOpPeriodV5_1 ", group = "Linear Opmode")//
public class TeleOpPeriodV5_1 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();
    boolean servoActive;
    boolean lowActive;
    boolean highActive;
    String speed;
    String location;

    public void setSpeedLow() {

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

    public void setSpeedHigh() {

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

            //<editor-fold deafault="folded", desc="speed control (bumpers)">
            if((gamepad1.left_bumper==true || lowActive) && !gamepad1.right_bumper==true){
                lowActive = true;
                setSpeedLow();
                speed = "low speed";
                sleep(200);
            }else{
                lowActive = false;
            }

            if ((gamepad1.right_bumper==true || highActive) && !gamepad1.left_bumper==true){
                highActive = true;
                setSpeedHigh();
                speed = "high speed";
                sleep(200);
            }else{
                highActive = false;
            }
            //</editor-fold>

            //<editor-fold default="folded", desc="servo control">
            if(gamepad1.a==true && servoActive==true){
                servoActive = false;
                location = "open";
                r.grijp.setPosition(r.open);
                sleep(200);
            }else if(gamepad1.a==true && servoActive==false){
                servoActive = true;
                location = "closed";
                r.grijp.setPosition(r.close);
                sleep(200);
            }
            //</editor-fold>

            telemetry.addData("Speed", speed);
            telemetry.addData("ServoLoc", location);
            telemetry.addData("ServoPos", r.grijp.getPosition());
            telemetry.update();
        }
    }
}



