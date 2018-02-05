package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import static android.R.attr.rotation;
import static com.qualcomm.robotcore.util.Range.clip;
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

        while(opModeIsActive()){

            //<editor-fold default="folded" desc="Forward Backward trigger, Left Right dpad, Sprint dpad_up">

            double turnL;                                   //turn left
            double turnR;                                   //turn right
            double driveF = this.gamepad1.right_trigger;    //drive forward
                   driveF = Range.clip(driveF, -0.2, 0.2);
            double driveB = this.gamepad1.left_trigger;     //drive backward
                   driveB = Range.clip(driveB, -0.2, 0.2);
            double S;                                       //factor sprint
            double drive = Range.clip(driveF - driveB, -0.1, 0.1); //omdat hij het anders niet doet

            if(gamepad1.dpad_left==true && driveF>0){
                turnL = 0.15;
            } else if(gamepad1.dpad_left==true && driveF<0) {
                turnL = 0.15;
            } else if (gamepad1.dpad_left==true) {
                turnL = 0.3;
            } else {
                turnL = 0.0;
            }

            if(gamepad1.dpad_right==true && driveF>0){
                turnR = 0.15;
            } else if(gamepad1.dpad_right==true && driveF<0){
                turnR = 0.15;
            } else if(gamepad1.dpad_right==true){
                turnR = 0.3;
            } else {
                turnR = 0.0;
            }

            if(gamepad1.dpad_up==true){
                S = 5;
            } else {
                S = 1;
            }

            if(drive>=0) {
                r.LFpower = Range.clip(driveF * S - turnL, -1.0, 1.0);
                r.LBpower = Range.clip(driveF * S - turnL, -1.0, 1.0);
                r.RFpower = Range.clip(driveF * S + turnR, -1.0, 1.0);
                r.RBpower = Range.clip(driveF * S + turnR, -1.0, 1.0);
            } else if(drive<0){
                r.LFpower = Range.clip(driveB * S + turnL, -1.0, 1.0);
                r.LBpower = Range.clip(driveB * S + turnL, -1.0, 1.0);
                r.RFpower = Range.clip(driveB * S - turnR, -1.0, 1.0);
                r.RBpower = Range.clip(driveB * S - turnR, -1.0, 1.0);
            }

            //</editor-fold>

            //<editor-fold default="folded" desc="Crab Movement bumper">

            if(gamepad1.left_bumper==true){
                r.LFpower =  0.3;
                r.LBpower = -0.3;      //meer binnen,minder buiten
                r.RFpower = -0.3;     //alleen minder binnen
                r.RBpower =  0.3;

            }

            if(gamepad1.right_bumper==true){
                r.LFpower = -0.3;
                r.LBpower =  0.3;
                r.RFpower =  0.3;
                r.RBpower = -0.3;

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
