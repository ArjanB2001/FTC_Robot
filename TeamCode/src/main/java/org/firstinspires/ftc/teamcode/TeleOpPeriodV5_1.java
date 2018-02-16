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
    String position;

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

            //<editor-fold deafault="folded", desc="speed control">
            if((gamepad1.left_bumper==true || lowActive) && !gamepad1.right_bumper==true){
                lowActive = true;
                low();
                speed = "low speed";
            }else{
                lowActive = false;
            }

            if ((gamepad1.right_bumper==true || highActive) && !gamepad1.left_bumper==true){
                highActive = true;
                high();
                speed = "high speed";
            }else{
                highActive = false;
            }
            //</editor-fold>

            //<editor-fold default="open", desc="Servo's a b y">
            if(gamepad1.a) {
                r.grijp.setPosition(0.75);
                telemetry.addData("Servo:", "0.75");
            }
            if(gamepad1.b) {
                r.grijp.setPosition(1);
                telemetry.addData("Servo:", "1");
            }
            if(gamepad1.y) {
                r.grijp.setPosition(0.6);
                telemetry.addData("Servo:", "0.6");
            }
            //</editor-fold>

            if(gamepad1.a && servoActive==true){
                servoActive = false;
                low();
                position = "open";
            }else if(gamepad1.a && servoActive==false){
                servoActive = true;
            }

            telemetry.addData("ServoPos", r.grijp.getPosition());
            telemetry.addData("running", speed);
            telemetry.addData("Located", position);
            telemetry.update();

        }
    }
}



