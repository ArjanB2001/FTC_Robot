package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeleOpPeriodV3", group = "Linear Opmode")//
public class TeleOpPeriodV3 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();
    double degree;
    double drive;

    public void runOpMode(){
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();

        while(opModeIsActive()){
            drive    = Range.clip(gamepad1.right_trigger - gamepad1.left_trigger, -0.2, 0.2);

            if (drive > 0 && !gamepad1.dpad_right && !gamepad1.dpad_left) {
                r.LFpower = drive;
                r.LBpower = drive;
                r.RFpower = drive;
                r.RBpower = drive;
            } else if (drive < 0) {
                r.LFpower = drive;
                r.LBpower = drive;
                r.RFpower = drive;
                r.RBpower = drive;
            } else if (drive == 0 ) {
                r.LFpower = drive;
                r.LBpower = drive;
                r.RFpower = drive;
                r.RBpower = drive;
            }


            if (gamepad1.dpad_left && drive == 0) {
                r.LFpower = -1;
                r.LBpower = -1;
                r.RBpower =  1;
                r.RFpower =  1;
            }

            if (gamepad1.dpad_right && drive == 0) {
                r.LFpower =  1;
                r.LBpower =  1;
                r.RBpower =  -1;
                r.RFpower =  -1;
            }

            if (gamepad1.dpad_left && drive > 0) {
                r.LFpower = 0.1;
                r.LBpower = 0.1;
                r.RFpower = 1;
                r.RBpower = 1;
            }

            if (gamepad1.dpad_right && drive > 0) {
                r.LFpower = 1;
                r.LBpower = 1;
                r.RFpower = 0.1;
                r.RBpower = 0.1;
            }

            if (gamepad1.left_bumper) {
                r.LFpower = 0.3;
                r.LBpower =  -0.3;
                r.RFpower = -0.3;
                r.RBpower =  0.3;
            }

            if(gamepad1.right_bumper==true){
                r.LFpower =  -0.3;
                r.LBpower = 0.3;
                r.RFpower =  0.3;
                r.RBpower = -0.3;

            }



            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            degree = Range.clip(gamepad1.right_stick_x, 0  , 1.0) ;

            if(gamepad1.a) {
                r.servo1.setPosition(degree);
            }

            telemetry.addData("rotation LFmotor", r.LFmotor.getPower());
            telemetry.addData("rotation LBmotor", r.LBmotor.getPower());
            telemetry.addData("rotation RFmotor", r.RFmotor.getPower());
            telemetry.addData("rotation RBmotor", r.RBmotor.getPower());
            telemetry.addData("Degree", degree);
            telemetry.addData("ServoPos", r.servo1.getPosition());
            telemetry.update();


        }
    }
}
