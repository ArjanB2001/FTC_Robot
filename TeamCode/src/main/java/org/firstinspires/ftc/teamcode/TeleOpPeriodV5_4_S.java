package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import static org.opencv.ml.SVM.C;


@TeleOp(name = "TeleOpPeriodV5_4_S ", group = "Linear Opmode")//
public class TeleOpPeriodV5_4_S extends LinearOpMode {

    //<editor-fold default="folded", desc="Local booleans, objects and strings">
    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();
    boolean lowActive = true;
    boolean highActive = true;;
    boolean servoActive = true;
    String speed;
    String location;
    //</editor-fold>

    public void setSpeedLow() {

        double o = -Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        o = Range.clip(o, -0.3, 0.3);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = Range.clip(gamepad1.right_stick_x, -0.6, 0.6);
        r.LFpower = o * Math.cos(robotAngle) + rightX;
        r.LBpower = o * Math.sin(robotAngle) + rightX;
        r.RFpower = o * Math.sin(robotAngle) - rightX;
        r.RBpower = o * Math.cos(robotAngle) - rightX;

        r.LFmotor.setPower(r.LFpower);
        r.LBmotor.setPower(r.LBpower);
        r.RFmotor.setPower(r.RFpower);
        r.RBmotor.setPower(r.RBpower);

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
//            Press button "LB" (the left bumper) to decrease velocity and turning speed
            if((gamepad1.left_bumper==true || lowActive) && !gamepad1.right_bumper==true){
                lowActive = true;
                setSpeedLow();
                speed = "low speed";
            }else{
                lowActive = false;
            }
//            Press button "RB" (the right bumper) to use maximum volicity and turning speed
            if ((gamepad1.right_bumper==true || highActive) && !gamepad1.left_bumper==true){
                highActive = true;
                setSpeedHigh();
                speed = "high speed";
            }else{
                highActive = false;
            }
            //</editor-fold>

            //<editor-fold default="folded", desc="servo control">
//            Press button "a" to open the arms that hold the glyph and press again to release
            if(gamepad1.a==true && servoActive==true){
                servoActive = false;
                location = "open";
                r.grijp.setPosition(r.open);
                sleep(500);
            }else if(gamepad1.a==true && servoActive==false){
                servoActive = true;
                location = "closed";
                r.grijp.setPosition(r.close);
                sleep(500);
            }
            //</editor-fold>

            //<editor-fold default="folded" , desc="crane control">
//            Push (the right trigger) to move the crane up, push (the left trigger) to move the crane down
            r.Cpower = gamepad1.right_trigger-gamepad1.left_trigger;
            r.Cmotor.setPower(r.Cpower);
            //</editor-fold>

            telemetry.addData("Velocity mode", speed);
            telemetry.addData("Servo location", location);
            telemetry.addLine();
            telemetry.addData("", "--------------: Instructies :--------------:");
            telemetry.addData("Rechter stick", "link- en rechtsom draaien");
            telemetry.addData("Linker stick", "voor- en achteruit en opzij");
            telemetry.addData("LB (low speed)", "langzaam rijden");
            telemetry.addData("RB (high speed)", "snel rijden");
            telemetry.update();
        }
    }
}



