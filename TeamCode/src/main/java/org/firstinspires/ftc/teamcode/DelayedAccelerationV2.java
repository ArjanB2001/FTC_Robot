package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Delayed Acceleration V2", group = "Linear Opmode")
public class DelayedAccelerationV2 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();

    public void runOpMode() {
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();

        //only backwards
        while (opModeIsActive()) {

            r.LFpower = 0;
            r.LBpower = 0;
            r.RFpower = 0;
            r.RBpower = 0;

            while (gamepad1.left_stick_y>0){

                r.LFpower = r.LFpower + 0.1;
                r.LBpower = r.LBpower + 0.1;
                r.RFpower = r.RFpower + 0.1;
                r.RBpower = r.RBpower + 0.1;

                r.LFmotor.setPower(r.LFpower);
                r.LBmotor.setPower(r.LBpower);
                r.RFmotor.setPower(r.RFpower);
                r.RBmotor.setPower(r.RBpower);

                sleep(300);

            }
        }
    }
}