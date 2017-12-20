package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeleOpModeTank", group = "Linear Opmode")
public class TeleOpPeriodTank extends LinearOpMode {

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

           // Tank Mode is niet ingebruik
           // <editor-fold default="folded" desc="Tank Mode">

             //Tank Mode uses one stick to control each wheel.
             //- This requires no math, but it is hard to drive forward slowly and keep straight.
            r.LFpower  = gamepad1.left_stick_y ;
            r.LBpower  = gamepad1.left_stick_y ;
            r.RFpower  = gamepad1.right_stick_y ;
            r.RBpower  = gamepad1.right_stick_y ;

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

        }
    }
}
