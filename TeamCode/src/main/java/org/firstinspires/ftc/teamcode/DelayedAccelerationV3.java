package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Delayed Acceleration V3", group = "Linear Opmode")
public class DelayedAccelerationV3 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();

    public void runOpMode() {
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();

        //constant
        while (opModeIsActive()) {


            if(gamepad1.left_stick_y<0.9){

                r.LFpower = 0.1 * gamepad1.left_stick_y;
                r.LBpower = 0.1 * gamepad1.left_stick_y;
                r.RFpower = 0.1 * gamepad1.left_stick_y;
                r.RBpower = 0.1 * gamepad1.left_stick_y;

                r.LFmotor.setPower(r.LFpower);
                r.LBmotor.setPower(r.LBpower);
                r.RFmotor.setPower(r.RFpower);
                r.RBmotor.setPower(r.RBpower);

            } else if (gamepad1.left_stick_y<0.8){

                r.LFpower = 0.2 * gamepad1.left_stick_y;
                r.LBpower = 0.2 * gamepad1.left_stick_y;
                r.RFpower = 0.2 * gamepad1.left_stick_y;
                r.RBpower = 0.2 * gamepad1.left_stick_y;

                r.LFmotor.setPower(r.LFpower);
                r.LBmotor.setPower(r.LBpower);
                r.RFmotor.setPower(r.RFpower);
                r.RBmotor.setPower(r.RBpower);

            } else if (gamepad1.left_stick_y<0.7){

                r.LFpower = 0.4 * gamepad1.left_stick_y;
                r.LBpower = 0.4 * gamepad1.left_stick_y;
                r.RFpower = 0.4 * gamepad1.left_stick_y;
                r.RBpower = 0.4 * gamepad1.left_stick_y;

                r.LFmotor.setPower(r.LFpower);
                r.LBmotor.setPower(r.LBpower);
                r.RFmotor.setPower(r.RFpower);
                r.RBmotor.setPower(r.RBpower);

            } else if (gamepad1.left_stick_y<0.6){

                r.LFpower = 0.6 * gamepad1.left_stick_y;
                r.LBpower = 0.6 * gamepad1.left_stick_y;
                r.RFpower = 0.6 * gamepad1.left_stick_y;
                r.RBpower = 0.6 * gamepad1.left_stick_y;

                r.LFmotor.setPower(r.LFpower);
                r.LBmotor.setPower(r.LBpower);
                r.RFmotor.setPower(r.RFpower);
                r.RBmotor.setPower(r.RBpower);

            } else if (gamepad1.left_stick_y<0.5){

                r.LFpower = 0.9 * gamepad1.left_stick_y;
                r.LBpower = 0.9 * gamepad1.left_stick_y;
                r.RFpower = 0.9 * gamepad1.left_stick_y;
                r.RBpower = 0.9 * gamepad1.left_stick_y;

                r.LFmotor.setPower(r.LFpower);
                r.LBmotor.setPower(r.LBpower);
                r.RFmotor.setPower(r.RFpower);
                r.RBmotor.setPower(r.RBpower);

            } else if (gamepad1.left_stick_y<0.4){

                r.LFpower = 1.1 * gamepad1.left_stick_y;
                r.LBpower = 1.1 * gamepad1.left_stick_y;
                r.RFpower = 1.1 * gamepad1.left_stick_y;
                r.RBpower = 1.1 * gamepad1.left_stick_y;

                r.LFmotor.setPower(r.LFpower);
                r.LBmotor.setPower(r.LBpower);
                r.RFmotor.setPower(r.RFpower);
                r.RBmotor.setPower(r.RBpower);

            } else if (gamepad1.left_stick_y<0.3){

                r.LFpower = 1.4 * gamepad1.left_stick_y;
                r.LBpower = 1.4 * gamepad1.left_stick_y;
                r.RFpower = 1.4 * gamepad1.left_stick_y;
                r.RBpower = 1.4 * gamepad1.left_stick_y;

                r.LFmotor.setPower(r.LFpower);
                r.LBmotor.setPower(r.LBpower);
                r.RFmotor.setPower(r.RFpower);
                r.RBmotor.setPower(r.RBpower);

            } else if (gamepad1.left_stick_y<0.2){

                r.LFpower = 1.7 * gamepad1.left_stick_y;
                r.LBpower = 1.7 * gamepad1.left_stick_y;
                r.RFpower = 1.7 * gamepad1.left_stick_y;
                r.RBpower = 1.7 * gamepad1.left_stick_y;

                r.LFmotor.setPower(r.LFpower);
                r.LBmotor.setPower(r.LBpower);
                r.RFmotor.setPower(r.RFpower);
                r.RBmotor.setPower(r.RBpower);

            } else if (gamepad1.left_stick_y<0.1){

                r.LFpower = 2 * gamepad1.left_stick_y;
                r.LBpower = 2 * gamepad1.left_stick_y;
                r.RFpower = 2 * gamepad1.left_stick_y;
                r.RBpower = 2 * gamepad1.left_stick_y;

                r.LFmotor.setPower(r.LFpower);
                r.LBmotor.setPower(r.LBpower);
                r.RFmotor.setPower(r.RFpower);
                r.RBmotor.setPower(r.RBpower);
            }


            }
        }
    }
