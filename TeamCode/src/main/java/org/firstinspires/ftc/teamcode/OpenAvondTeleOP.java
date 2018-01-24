package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Open Avond  TeleOP ", group = "Linear Opmode")//
public class OpenAvondTeleOP extends LinearOpMode {


    HardwareVar r = new HardwareVar(); //Importeer motoren en servo's
    double degree;
    double drive;

    public void runOpMode(){
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();

        waitForStart(); //wacht tot play ingedrukt wordt

        while(opModeIsActive()){
            drive    = Range.clip(gamepad1.right_trigger - gamepad1.left_trigger, -0.3, 0.3); //pak de waardes van de triggers van de gamepad

            if (drive > 0 && !gamepad1.dpad_right && !gamepad1.dpad_left) { //als deze knopjes worden ingedrukt
                r.LFpower = drive;
                r.LBpower = drive;   //Zet power naar Drive
                r.RFpower = drive;
                r.RBpower = drive;
            } else if (drive < 0) {
                r.LFpower = drive;
                r.LBpower = drive;
                r.RFpower = drive;
                r.RBpower = drive;
            } else if (drive == 0 ) {
                r.LFpower = drive;
                r.LBpower = drive;
                r.RFpower = drive;
                r.RBpower = drive;
            }


            if (gamepad1.dpad_left && drive == 0) {
                r.LFpower = -0.8;
                r.LBpower = -0.8;
                r.RBpower =  0.8;        //Naar links draaien om z'n as
                r.RFpower =  0.8;
            }

            if (gamepad1.dpad_right && drive == 0) {
                r.LFpower =  0.8;
                r.LBpower =  0.8;        // Naar rechts draaien om z'n as
                r.RBpower =  -0.8;
                r.RFpower =  -0.8;
                ;
            }

            if (gamepad1.dpad_left && drive > 0) {
                r.LFpower = 0;
                r.LBpower = 0;
                r.RFpower = 1;              //Naar links draaien
                r.RBpower = 1;
            }

            if (gamepad1.dpad_right && drive > 0) {
                r.LFpower = 1;
                r.LBpower = 1;
                r.RFpower = 0;              //Naar rechts draaien
                r.RBpower = 0;
            }

            if (gamepad1.left_bumper) {
                r.LFpower = 1;
                r.LBpower =  -1;       //Naar links driften
                r.RFpower = -0.9;
                r.RBpower =  0.9;
            }

            if(gamepad1.right_bumper==true){
                r.LFpower =  -1;
                r.LBpower =   1;       //Naar rechts driften
                r.RFpower =  0.9;
                r.RBpower = -0.9;

            }



            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);   //Zet poweer naar motoren
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);



            if(gamepad1.a) {
                r.servo1.setPosition(0.4);
                telemetry.addData("Servo:", "0.4");    //Als A ingedrukt --> Servo  op  0.4
            }

            if(gamepad1.y) {
                r.servo1.setPosition(0);                //Als Y ingedrukt --> Servo  op  0
                telemetry.addData("Servo:", "0");
            }

            if(gamepad1.b) {
                r.servo1.setPosition(1);
                telemetry.addData("Servo:", "1");       //Als B ingedrukt --> Servo  op  1
            }

            if(gamepad1.x) {
                r.servo1.setPosition(0.6);              //Als X ingedrukt --> Servo  op  0.6
                telemetry.addData("Servo:", "0.6");
            }


            telemetry.addData("rotation LFmotor", r.LFmotor.getPower());
            telemetry.addData("rotation LBmotor", r.LBmotor.getPower());
            telemetry.addData("rotation RFmotor", r.RFmotor.getPower());   //Informatie op Driver Station
            telemetry.addData("rotation RBmotor", r.RBmotor.getPower());
            telemetry.addData("Degree", degree);
            telemetry.addData("ServoPos", r.servo1.getPosition());
            telemetry.update();


        }
    }
}
