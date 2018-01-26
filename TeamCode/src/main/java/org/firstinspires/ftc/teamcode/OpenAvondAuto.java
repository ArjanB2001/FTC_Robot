package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.hitechnic.HiTechnicNxtColorSensor;
import com.qualcomm.hardware.matrix.MatrixDcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Open Avond Auto  ", group = "Linear Opmode")//
public class OpenAvondAuto extends LinearOpMode {

    HardwareVar r = new HardwareVar(); //Importeer motoren en servo's

    double degree;
    double drive;

    private MatrixDcMotorController motorController = null;
    private ServoController servoController = null;
    private DcMotor Linksvoor = hardwareMap.get(DcMotor.class, "LFmotor");
    public DcMotor Linksachter = hardwareMap.get(DcMotor.class, "LBmotor");
    public DcMotor Rechtsvoor = hardwareMap.get(DcMotor.class, "RFmotor");
    public DcMotor Rechtsachter = hardwareMap.get(DcMotor.class, "RBmotor");
    public Servo servo1;
    public Servo servo2;
    public HiTechnicNxtColorSensor kleurSensor = hardwareMap.get(HiTechnicNxtColorSensor.class, "colorSensor");



    public void runOpMode(){
        r.init(hardwareMap);


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


            telemetry.addData("rotation LFmotor", Linksvoor.getPower());
            telemetry.addData("rotation LBmotor", Linksachter.getPower());
            telemetry.addData("rotation RFmotor", Rechtsvoor.getPower());   //Informatie op Driver Station
            telemetry.addData("rotation RBmotor", Rechtsachter.getPower());
            telemetry.addData("Degree", degree);
            telemetry.addData("ServoPos", r.servo1.getPosition());
            telemetry.update();


        }
    }
