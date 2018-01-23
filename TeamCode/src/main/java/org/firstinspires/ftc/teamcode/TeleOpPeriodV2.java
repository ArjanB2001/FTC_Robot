package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import static android.R.attr.rotation;
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
            double driveB = this.gamepad1.left_trigger;     //drive backward
            double driveF = this.gamepad1.right_trigger;    //drive forward
            double S;                                       //factor sprint
            if(gamepad1.dpad_left==true){
                turnL = 0.2;
            } else
                turnL = 0.0;

            if(gamepad1.dpad_right==true){
                turnR = -0.2;
            } else {
                turnR = 0.0;
            }

            if(gamepad1.dpad_up==true){
                S = 5;
            } else {
                S = 1;
            }

            double drive    = Range.clip(driveF - driveB, -0.2, 0.2);
            double turn     = Range.clip(turnL + turnR, -0.2, 0.2);
            double factor   = S;

            if(drive<0) {
                r.LFpower = Range.clip(drive * factor + turn, -1.0, 1.0);
                r.LBpower = Range.clip(drive * factor + turn, -1.0, 1.0);
                r.RFpower = Range.clip(drive * factor - turn, -1.0, 1.0);
                r.RBpower = Range.clip(drive * factor - turn, -1.0, 1.0);
            } else{
                r.LFpower = Range.clip(drive * factor + turn, -1.0, 1.0);
                r.LBpower = Range.clip(drive * factor + turn, -1.0, 1.0);
                r.RFpower = Range.clip(drive * factor - turn, -1.0, 1.0);
                r.RBpower = Range.clip(drive * factor - turn, -1.0, 1.0);
            }

            //</editor-fold>

            //<editor-fold default="folded" desc="Crab Movement bumper">

            if(gamepad1.left_bumper==true){
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
