package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import static com.sun.tools.javac.main.Option.S;

@TeleOp(name = "TeleOpPeriodV2", group = "Linear Opmode")//
public class TeleOpPeriodV2 extends LinearOpMode {

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

            if (gamepad1.dpad_left == true && drive > 0) {
                //sturen tijdens rijden
                turnL = 0.35;
            } else if (gamepad1.dpad_left == true && drive < 0) {
                //sturen tijdens achteruitrijden
                turnL = 0.35;
            } else if (gamepad1.dpad_left == true && drive == 0) {
                //op de plek draaien
                turnL = 0.4;
            } else {
                turnL = 0.0;
            }

            if(gamepad1.dpad_right==true && drive>=0){
                turnR = -0.35;
            } else if(gamepad1.dpad_right==true && drive<0){
                turnR = -0.35;
            } else if(gamepad1.dpad_right==true && drive==0){
                turnR = -0.4;
            } else {
                turnR = 0.0;
            }

            if(gamepad1.dpad_up==true){
                //dpad_up maakt de factor 5 i.p.v. 1 waardoor je een snelheids boost krijgt
                S = 5;
            } else {
                S = 1;
            }

            double turn = Range.clip(turnL + turnR, -0.4, 0.4);

            //om links en rechts te gaan wordt de plus en min voor turn om gedraait
            //omdat wanneer je achteruitgaat de draairichting verkeerd was is deze om gedraait
            if(drive>=0) {
                r.LFpower = Range.clip(drive * S - turn, -1.0, 1.0);
                r.LBpower = Range.clip(drive * S - turn, -1.0, 1.0);
                r.RFpower = Range.clip(drive * S + turn, -1.0, 1.0);
                r.RBpower = Range.clip(drive * S + turn, -1.0, 1.0);
            } else if(drive<0){
                r.LFpower = Range.clip(drive * S + turn, -1.0, 1.0);
                r.LBpower = Range.clip(drive * S + turn, -1.0, 1.0);
                r.RFpower = Range.clip(drive * S - turn, -1.0, 1.0);
                r.RBpower = Range.clip(drive * S - turn, -1.0, 1.0);
            }

            //</editor-fold>

            //<editor-fold default="folded" desc="Crab Movement bumper">

            if(gamepad1.left_bumper==true){
                r.LFpower =  0.8;
                r.LBpower = -0.8;      //meer binnen,minder buiten
                r.RFpower = -0.8;     //alleen minder binnen
                r.RBpower =  0.8;

            }

            if(gamepad1.right_bumper==true){
                r.LFpower = -0.8;
                r.LBpower =  0.8;
                r.RFpower =  0.8;
                r.RBpower = -0.8;

            }

            //</editor-fold>

            //<editor-fold default="folded" desc="Set Motor Power">

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

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
