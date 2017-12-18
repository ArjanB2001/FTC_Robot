package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import static com.sun.tools.javac.main.Option.S;

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

            //<editor-fold default="folded" desc="Forward Backward trigger, Left Right dpad, Sprint a">

            double turnL;                                   //turn left
            double turnR;                                   //turn right
            double driveB = -this.gamepad1.left_trigger;    //drive backward
            double driveF = -this.gamepad1.right_trigger;   //drive forward
            double S;                                       //factor sprint

            if(gamepad1.dpad_left==true){
                turnL = 0.2;

            } else
                turnL = 0.0;

            if(gamepad1.dpad_right==true){
                turnR = -0.2;
            } else
                turnR = 0.0;

            if(gamepad1.a==true){
                S = 10;
            } else
                S = 1;

            double drive    = Range.clip(driveB + driveF, -0.1, 0.1);
            double turn     = Range.clip(turnL + turnR, -0.2, 0.2);
            double factor   = S;

            r.LFpower = Range.clip(drive * factor - turn, -1.0, 1.0);
            r.LBpower = Range.clip(drive * factor - turn, -1.0, 1.0);
            r.RFpower = Range.clip(drive * factor + turn, -1.0, 1.0);
            r.RBpower = Range.clip(drive * factor + turn, -1.0, 1.0);


            //</editor-fold>, , ,

            //<editor-fold default="folded" desc="Geef motors bepaalde kracht">

            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            //</editor-fold>

        }
    }
}
