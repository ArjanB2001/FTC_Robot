package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Open Avond Auto  ", group = "Linear Opmode")//
public class OpenAvondAuto extends LinearOpMode {


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

            r.powerAll(0.2);  // Zet alle motoren op 1

            sleep(2000);    // Wacht 2 seconden

            r.powerAll(0);  // Zet alle motoren op 0

            sleep(200);     // Wacht 0.2 seconden

            r.left(1);    // Draaien op 0.3 power naar links

            sleep(500);     // Wacht 0.5 seconden

            r.right(1);   // Draai 0.3 power naar rechts

              sleep(500);     // wacht 0.5 seconden

            r.powerAll(0);  // Stop

            break;
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
