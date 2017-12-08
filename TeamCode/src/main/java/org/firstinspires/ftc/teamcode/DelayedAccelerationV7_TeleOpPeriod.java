package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "DelayedAccelerationV7", group = "Linear Opmode")
public class DelayedAccelerationV7_TeleOpPeriod extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();

    public void runOpMode(){
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();
        //left stick op x-as en y-as, om vooruit, achteruit, links en rechts te gaan
        //maak drive en turn aan zodat je ze kan toevoegen in de Range.clip()
        double drive = -this.gamepad1.left_stick_y;
        double turn = this.gamepad1.left_stick_x;
        //om een limiet te stellen aan alleen het draaien  maken we turn nog een keer aan
        //waardoor je Range.clip kunt toevoegen
        double Turn = Range.clip(turn, -0.2, 0.2);

        while(opModeIsActive()){

            //<editor-fold default="folded" desc="Master Control left_stick">

            r.LFpower = Range.clip(drive + Turn, -0.6, 0.6);
            r.LBpower = Range.clip(drive + Turn, -0.6, 0.6);
            r.RFpower = Range.clip(drive - Turn, -0.6, 0.6);
            r.RBpower = Range.clip(drive - Turn, -0.6, 0.6);

            //</editor-fold>

            //<editor-fold default="folded" desc="Master Control left_stick (Sprinting)">

            while(gamepad1.a==true) {

                r.LFpower = Range.clip(drive + Turn, -1.0, 1.0);
                r.LBpower = Range.clip(drive + Turn, -1.0, 1.0);
                r.RFpower = Range.clip(drive - Turn, -1.0, 1.0);
                r.RBpower = Range.clip(drive - Turn, -1.0, 1.0);

            }

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
