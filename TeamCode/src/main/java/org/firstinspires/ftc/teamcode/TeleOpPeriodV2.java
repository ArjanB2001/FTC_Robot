package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeleOpPeriodV2", group = "Linear Opmode")//
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

            //<editor-fold default="folded" desc="Forward Backward trigger, Left Right dpad">

            double turn;
            double Turn;

            if(gamepad1.dpad_left==true){
                turn = 0.2;

            } else
                turn = 0.0;

            if(gamepad1.dpad_right==true){
                Turn = -0.2;
            } else
                Turn = 0.0;

            double driveBackward = -this.gamepad1.left_trigger;
            double driveForward  = -this.gamepad1.right_trigger;

            r.LFpower = Range.clip(driveForward - driveBackward - turn - Turn, -0.6, 0.6);
            r.LBpower = Range.clip(driveForward - driveBackward - turn - Turn, -0.6, 0.6);
            r.RFpower = Range.clip(driveForward - driveBackward + turn + Turn, -0.6, 0.6);
            r.RBpower = Range.clip(driveForward - driveBackward + turn + Turn, -0.6, 0.6);

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
