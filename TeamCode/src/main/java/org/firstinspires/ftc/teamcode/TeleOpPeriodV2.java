package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeleOp PeriodV2", group = "Linear Opmode")
public class TeleOpPeriodV2 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();

    public void runOpMode(){
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();

        while(opModeIsActive()){

            //<editor-fold default="folded" desc="Left Right dpad">

            if(gamepad1.dpad_left==true){
                double TurnLeft = 0.2;

                r.LFpower =  TurnLeft;
                r.LBpower =  TurnLeft;
                r.RFpower =  TurnLeft;
                r.RBpower =  TurnLeft;

            }

            if(gamepad1.dpad_right==true){
                double TurnRight = -0.2;

                r.LFpower =  TurnRight;
                r.LBpower =  TurnRight;
                r.RFpower =  TurnRight;
                r.RBpower =  TurnRight;

            }

           // double turn =

            double driveBackward = this.gamepad1.left_trigger;
            double driveForward  = this.gamepad1.right_trigger;

         //   r.LFpower = Range.clip(driveForward - driveBackward + turn, -1.0, 1.0);
           // r.LBpower = Range.clip(driveForward - driveBackward + turn, -1.0, 1.0);
           // r.RFpower = Range.clip(driveForward - driveBackward - turn, -1.0, 1.0);
           // r.RBpower = Range.clip(driveForward - driveBackward - turn, -1.0, 1.0);

            //</editor-fold>

            //<editor-fold default="folded" desc="Geef motors bepaalde kracht">

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

        }
    }
}
