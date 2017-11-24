package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeleOpMode", group = "Linear Opmode")
public class TeleOpPeriod extends LinearOpMode {
    //om HardwareVar class te kunnen gebruiken
    HardwareVar r = new HardwareVar();

    public void runOpMode(){
        //robotTest. runt HardwareVar class
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
            double drive = this.gamepad1.left_stick_y;
            double turn  = this.gamepad1.left_stick_x;
            r.flp = Range.clip(drive + turn, -1.0, 1.0);
            r.blp = Range.clip(drive + turn, -1.0, 1.0);
            r.frp = Range.clip(drive - turn, -1.0, 1.0);
            r.brp = Range.clip(drive - turn, -1.0, 1.0);

            //</editor-fold>

            /*
            //<editor-fold default="folded" desc="Exact-left,right-Control right-stick">

            //right stick op x-as, om precies naar links en rechts te draaien.
            if (gamepad1.right_stick_x>0){
                leftPower  =-gamepad1.right_stick_x ;
                rightPower = gamepad1.right_stick_x ;
            } else if (gamepad1.right_stick_x<0){
                leftPower  =-gamepad1.right_stick_x;
                rightPower = gamepad1.right_stick_x;
            } else {
                telemetry.addData("Motors", "not active");
                telemetry.update();
            }

            //</editor-fold>

            //<editor-fold default="folded" desc="Exact-forward,back-Control left_right_trigger">

            //left- en right trigger om precies vooruit en achteruit te rijden
            // left trigger achteruit; right trigger vooruit
            if (gamepad1.left_trigger>0){
                leftPower = -gamepad1.left_trigger;
                rightPower = -gamepad1.left_trigger;
            } else if(gamepad1.right_trigger>0){
                leftPower = gamepad1.right_trigger;
                rightPower = gamepad1.right_trigger;
            } else {
                telemetry.addData("Motors", "not active");
                telemetry.update();
            }

            //</editor-fold>
            */

            //geef motors bepaalde kracht
            r.frontLeftDrive.setPower(r.flp);
            r.backLeftDrive.setPower(r.blp);
            r.frontRightDrive.setPower(r.frp);
            r.backRightDrive.setPower(r.brp);

        }
    }
}
