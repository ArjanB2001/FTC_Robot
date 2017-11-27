package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeleOpMode", group = "Linear Opmode")
public class TeleOpPeriod extends LinearOpMode {

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

            //Tank Mode is niet ingebruik
            //<editor-fold default="folded" desc="Tank Mode">

            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
//            robotTest.leftPower  = -gamepad1.left_stick_y ;
//            robotTest.rightPower = -gamepad1.right_stick_y ;

            //</editor-fold>  no

            //<editor-fold default="folded" desc="Master Control left_stick">

            //left stick op x-as en y-as, om vooruit, achteruit, links en rechts te gaan
            double drive = -this.gamepad1.left_stick_y;
            double turn  = -this.gamepad1.left_stick_x;
            r.LFpower = Range.clip(drive + turn, -0.2, 0.2);
            r.LBpower = Range.clip(drive + turn, -0.2, 0.2);
            r.RFpower = Range.clip(drive - turn, -0.2, 0.2);
            r.RBpower = Range.clip(drive - turn, -0.2, 0.2);

            //</editor-fold>

            //<editor-fold default="folded" desc="Crab Movement left&right_trigger">

            if(gamepad1.left_trigger>0){
                r.LFpower = -gamepad1.left_trigger;
                r.LBpower =  gamepad1.left_trigger;
                r.RFpower = -gamepad1.left_trigger;
                r.RBpower =  gamepad1.left_trigger;

            }

            if(gamepad1.right_trigger>0){
                r.LFpower =  gamepad1.right_trigger;
                r.LBpower = -gamepad1.right_trigger;
                r.RFpower =  gamepad1.right_trigger;
                r.RBpower = -gamepad1.right_trigger;

            }

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
