package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Delayed Acceleration V4", group = "Linear Opmode")
public class DelayedAccelerationV4 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();

    public void runOpMode() {
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();

        //laag gaat hij achteruit, hoog gaat hij kort achteruit en switch dan naar voren.
        //full power
        while (opModeIsActive()) {

            while (gamepad1.left_stick_y>=0.7){

                //<editor-fold, default="folded", desc="Build Up">

                r.LFmotor.setPower(0.1);
                r.LBmotor.setPower(0.1);
                r.RFmotor.setPower(0.1);
                r.RBmotor.setPower(0.1);

                sleep(300);

                r.LFmotor.setPower(0.2);
                r.LBmotor.setPower(0.2);
                r.RFmotor.setPower(0.2);
                r.RBmotor.setPower(0.2);

                sleep(300);

                r.LFmotor.setPower(0.3);
                r.LBmotor.setPower(0.3);
                r.RFmotor.setPower(0.3);
                r.RBmotor.setPower(0.3);

                sleep(300);

                r.LFmotor.setPower(0.4);
                r.LBmotor.setPower(0.4);
                r.RFmotor.setPower(0.4);
                r.RBmotor.setPower(0.4);

                sleep(300);

                r.LFmotor.setPower(0.5);
                r.LBmotor.setPower(0.5);
                r.RFmotor.setPower(0.5);
                r.RBmotor.setPower(0.5);

                sleep(300);

                break;

                //</editor-fold>

            }

            while (gamepad1.left_stick_y<0.7) {

                double drive = -this.gamepad1.left_stick_y;
                double turn  =  this.gamepad1.left_stick_x;
                double Turn  =  Range.clip(turn, -0.2, 0.2);

                r.LFpower = Range.clip(drive + Turn, -0.9, 0.9);
                r.LBpower = Range.clip(drive + Turn, -0.9, 0.9);
                r.RFpower = Range.clip(drive - Turn, -0.9, 0.9);
                r.RBpower = Range.clip(drive - Turn, -0.9, 0.9);

                //<editor-fold default="folded" desc="Geef motors bepaalde kracht">

                r.LFmotor.setPower(r.LFpower);
                r.LBmotor.setPower(r.LBpower);
                r.RFmotor.setPower(r.RFpower);
                r.RBmotor.setPower(r.RBpower);

                //</editor-fold>

            }



        }
    }
}