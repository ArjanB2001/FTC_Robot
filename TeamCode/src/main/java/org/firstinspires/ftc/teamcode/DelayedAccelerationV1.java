package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Delayed Acceleration V1", group = "Linear Opmode")
public class DelayedAccelerationV1 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();

    public void runOpMode() {
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();

        //full power
        while (opModeIsActive()) {

            //<editor-fold default="closed" desc="Motor kracht 0.1">

            r.LFpower = Range.clip(gamepad1.left_stick_y, -0.1, 0.1);
            r.LBpower = Range.clip(gamepad1.left_stick_y, -0.1, 0.1);
            r.RFpower = Range.clip(gamepad1.left_stick_y, -0.1, 0.1);
            r.RBpower = Range.clip(gamepad1.left_stick_y, -0.1, 0.1);

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

            sleep(100);

            //<editor-fold default="folded" desc="Motor kracht 0.2">

            r.LFpower = Range.clip(gamepad1.left_stick_y, -0.2, 0.2);
            r.LBpower = Range.clip(gamepad1.left_stick_y, -0.2, 0.2);
            r.RFpower = Range.clip(gamepad1.left_stick_y, -0.2, 0.2);
            r.RBpower = Range.clip(gamepad1.left_stick_y, -0.2, 0.2);

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

            sleep(100);

            //<editor-fold default="folded" desc="Motor kracht 0.3">

            r.LFpower = Range.clip(gamepad1.left_stick_y, -0.3, 0.3);
            r.LBpower = Range.clip(gamepad1.left_stick_y, -0.3, 0.3);
            r.RFpower = Range.clip(gamepad1.left_stick_y, -0.3, 0.3);
            r.RBpower = Range.clip(gamepad1.left_stick_y, -0.3, 0.3);

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

            sleep(100);

            //<editor-fold default="folded" desc="Motor kracht 0.4">

            r.LFpower = Range.clip(gamepad1.left_stick_y, -0.4, 0.4);
            r.LBpower = Range.clip(gamepad1.left_stick_y, -0.4, 0.4);
            r.RFpower = Range.clip(gamepad1.left_stick_y, -0.4, 0.4);
            r.RBpower = Range.clip(gamepad1.left_stick_y, -0.4, 0.4);

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

            sleep(100);

            //<editor-fold default="folded" desc="Motor kracht 0.5">

            r.LFpower = Range.clip(gamepad1.left_stick_y, -0.5, 0.5);
            r.LBpower = Range.clip(gamepad1.left_stick_y, -0.5, 0.5);
            r.RFpower = Range.clip(gamepad1.left_stick_y, -0.5, 0.5);
            r.RBpower = Range.clip(gamepad1.left_stick_y, -0.5, 0.5);

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

            sleep(100);

            //<editor-fold default="folded" desc="Motor kracht 0.6">

            r.LFpower = Range.clip(gamepad1.left_stick_y, -0.6, 0.6);
            r.LBpower = Range.clip(gamepad1.left_stick_y, -0.6, 0.6);
            r.RFpower = Range.clip(gamepad1.left_stick_y, -0.6, 0.6);
            r.RBpower = Range.clip(gamepad1.left_stick_y, -0.6, 0.6);

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

            sleep(100);

            //<editor-fold default="folded" desc="Motor kracht 0.7">

            r.LFpower = Range.clip(gamepad1.left_stick_y, -0.7, 0.7);
            r.LBpower = Range.clip(gamepad1.left_stick_y, -0.7, 0.7);
            r.RFpower = Range.clip(gamepad1.left_stick_y, -0.7, 0.7);
            r.RBpower = Range.clip(gamepad1.left_stick_y, -0.7, 0.7);

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

            sleep(100);

            //<editor-fold default="folded" desc="Motor kracht 0.8">

            r.LFpower = Range.clip(gamepad1.left_stick_y, -0.8, 0.8);
            r.LBpower = Range.clip(gamepad1.left_stick_y, -0.8, 0.8);
            r.RFpower = Range.clip(gamepad1.left_stick_y, -0.8, 0.8);
            r.RBpower = Range.clip(gamepad1.left_stick_y, -0.8, 0.8);

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

            sleep(100);

            //<editor-fold default="folded" desc="Motor kracht 0.9">

            r.LFpower = Range.clip(gamepad1.left_stick_y, -0.9, 0.9);
            r.LBpower = Range.clip(gamepad1.left_stick_y, -0.9, 0.9);
            r.RFpower = Range.clip(gamepad1.left_stick_y, -0.9, 0.9);
            r.RBpower = Range.clip(gamepad1.left_stick_y, -0.9, 0.9);

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

            sleep(100);


        }
    }
}