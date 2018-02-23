package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import static android.R.attr.mode;


@TeleOp(name = "TeleOpPeriodV5_3 ", group = "Linear Opmode")//
public class TeleOpPeriodV5_3 extends LinearOpMode {

    //<editor-fold default="folded", desc="Booleans, Objects, Strings">
    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();
    boolean startActive = false;
    boolean stickActive = true;
    boolean servoActive = true;
    String speed;
    String location;
    String mode;
    //</editor-fold>

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

            if(gamepad1.left_stick_button==true && gamepad1.right_stick_button==true && stickActive == false){
                stickActive = true;
                sleep(200);
            }

            if(gamepad1.left_stick_button==true && gamepad1.right_stick_button==true && stickActive == true){
                stickActive = false;
                sleep(200);
            }

            if(stickActive=true){
                //<editor-fold default="folded", desc="speed control (start)">
                if(gamepad1.start==true && startActive==true){
                    startActive = false;
                    setSpeedHigh();
                    speed = "high speed";
                    sleep(200);
                }else if(gamepad1.start==true && startActive==false){
                    startActive = true;
                    setSpeedLow();
                    speed = "low speed";
                    sleep(200);
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
                    r.grijp.setPosition(0.7);
                    sleep(300);
                    if(r.grijp.getPosition()!=0.7){
                        r.grijp.setPosition(r.grijp.getPosition()+0.01);
                        location = "custom";
                    }
                }

                //</editor-fold>
                mode = "ride";
            }

            if(stickActive=false) {
                mode = "music";
//                r.wobblyControl();

            }

            telemetry.addData("Mode", mode);
            telemetry.addData("Speed", speed);
            telemetry.addData("Playing", r.sound);
            telemetry.addData("Servo location", location);
            telemetry.update();

        }
    }
}



