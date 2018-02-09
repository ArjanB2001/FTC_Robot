package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import static com.sun.tools.doclint.HtmlTag.B;

@TeleOp(name = "TeleOpPeriodV2_1", group = "Linear Opmode")//
public class TeleOpPeriodV2_1 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();
    double degree;

    public void runOpMode(){
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();

        while(opModeIsActive()) {

            //<editor-fold default="folded" desc="Forward Backward trigger, Left Right dpad, Sprint dpad_up">

            double turnL;                                     //links om draaien
            double turnR;                                     //rechts om draaien
            double driveF = this.gamepad1.right_trigger;            //naar voren rijden (drive forward)
            double driveB = this.gamepad1.left_trigger;             //naar achteren rijden (drive backward)
            double S;                                               //factor sprint
            double drive = Range.clip(driveF - driveB, -0.3, 0.3);  //omdat hij het anders niet doet
            //dit is om te bepalen of de snelheid positief of negatief is
            double B1 = 1;
            double B2 = 1;
            double B3 = 1;
            double B4 = 1;
            double B;

            if (gamepad1.dpad_left == true && drive>0) {
                //sturen tijdens rijden
                turnL = 0.25;
            } else if (gamepad1.dpad_left == true && drive<0) {
                //sturen tijdens achteruitrijden
                turnL = 0.25;
            } else if (gamepad1.dpad_left == true && drive == 0) {
                //op de plek draaien
                turnL = 0.4;
            } else {
                turnL = 0.0;
            }

            if (gamepad1.dpad_right == true && drive>0) {
                turnR = -0.25;
            } else if (gamepad1.dpad_right == true && drive<0) {
                turnR = -0.25;
            } else if (gamepad1.dpad_right == true && drive == 0) {
                turnR = -0.4;
            } else {
                turnR = 0.0;
            }

            if (gamepad1.dpad_up == true) {
                //dpad_up maakt de factor 5 i.p.v. 1 waardoor je een snelheids boost krijgt
                S = 5;
            } else {
                S = 1;
            }

            if (gamepad1.left_bumper==true) {
                B1 =  1;
                B2 = -1;
                B2 = -1;
                B3 =  1;
            }else if (gamepad1.right_bumper==true) {
                B1 = -1;
                B2 =  1;
                B3 =  1;
                B4 = -1;
            }

            if((gamepad1.left_bumper==true || gamepad1.right_bumper==true) && drive==0){
                B = 0.4;
            } else{
                B = 0;
            }

                double turn = Range.clip(turnL + turnR, -0.4, 0.4);

            //om links en rechts te gaan wordt de plus en min voor turn om gedraait
            //omdat wanneer je achteruitgaat de draairichting verkeerd was is deze om gedraait
            if(drive>=0) {
                r.LFpower = Range.clip(B1*(drive * S - turn)+B, -1.0, 1.0);
                r.LBpower = Range.clip(B2*(drive * S - turn)+B, -1.0, 1.0);
                r.RFpower = Range.clip(B3*(drive * S + turn)+B, -1.0, 1.0);
                r.RBpower = Range.clip(B4*(drive * S + turn)+B, -1.0, 1.0);
            } else if(drive<0){
                r.LFpower = Range.clip(B1*(drive * S + turn)+B, -1.0, 1.0);
                r.LBpower = Range.clip(B2*(drive * S + turn)+B, -1.0, 1.0);
                r.RFpower = Range.clip(B3*(drive * S - turn)+B, -1.0, 1.0);
                r.RBpower = Range.clip(B4*(drive * S - turn)+B, -1.0, 1.0);
            }

            //</editor-fold>

            //<editor-fold default="folded" desc="Set Motor Power">

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

            telemetry.addData("rotation LFmotor", r.LFmotor.getPower());
            telemetry.addData("rotation LBmotor", r.LBmotor.getPower());
            telemetry.addData("rotation RFmotor", r.RFmotor.getPower());
            telemetry.addData("rotation RBmotor", r.RBmotor.getPower());
            telemetry.update();


        }
    }
}
