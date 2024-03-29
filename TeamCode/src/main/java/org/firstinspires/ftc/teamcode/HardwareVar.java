/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;
import android.media.MediaPlayer;

import com.qualcomm.hardware.hitechnic.HiTechnicNxtTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.hitechnic.HiTechnicNxtColorSensor;
import com.qualcomm.hardware.matrix.MatrixDcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.util.concurrent.TimeUnit;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

import static android.R.interpolator.linear;
import static com.sun.tools.javac.util.LayoutCharacters.LF;

public class HardwareVar extends LinearOpMode
{
    /* Public OpMode members. */
    private MatrixDcMotorController motorController = null;
    private ServoController         servoController = null;
    public DcMotor LFmotor;
    public DcMotor LBmotor;
    public DcMotor RFmotor;
    public DcMotor RBmotor;
    public Servo grijp;
    public Servo arm;
    public DcMotor Cmotor;
//    public Servo legoServo;
//    public UltrasonicSensor         rangeSensor;
    public HiTechnicNxtColorSensor  colorSensor;
    public HiTechnicNxtTouchSensor touchSensor;
    public double LFpower;
    public double LBpower;
    public double RFpower;
    public double RBpower;
    public double Cpower;

    public ElapsedTime runtime = new ElapsedTime();

    public double open = 1;
    public double close = 0.7;

    /* Constructor */
    public HardwareVar(){
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {

        // Initialize base Motor and Servo objects
        //super.init(ahwMap);

        // Initialize Matrix Motor and Servo objects
        motorController = ahwMap.get(MatrixDcMotorController.class, "matrixController");
        servoController = ahwMap.get(ServoController.class, "matrixController");

        //Motoren
        LFmotor = ahwMap.get(DcMotor.class, "LFmotor");
        LBmotor = ahwMap.get(DcMotor.class, "LBmotor");
        RFmotor = ahwMap.get(DcMotor.class, "RFmotor");
        RBmotor = ahwMap.get(DcMotor.class, "RBmotor");

        LFmotor.setDirection(DcMotor.Direction.FORWARD);
        LBmotor.setDirection(DcMotor.Direction.REVERSE);
        RFmotor.setDirection(DcMotor.Direction.FORWARD);
        RBmotor.setDirection(DcMotor.Direction.FORWARD);

        //Servo's
        grijp = ahwMap.get(Servo.class, "servo1");
        arm = ahwMap.get(Servo.class, "servo2");
        servoController.pwmEnable();       // Don't forget to enable Matrix Output

        //Sensoren
        colorSensor = ahwMap.get(HiTechnicNxtColorSensor.class, "colorSensor");
        //touchSensor = ahwMap.get(TouchSensor.class, "touchSensor");



    }

    //Een method die alle motoren dezelfde power geeft
    public void powerAll (double power){
        LFmotor.setPower(power);
        RFmotor.setPower(power);
        LBmotor.setPower(power);
        RBmotor.setPower(power);
    }

// Een method die de robot een bepaald aantal graden laat draaien, werkt nog niet.
    public void rotate(int degree) {
        int constant = 17;
        int time = constant * degree;
        LBmotor.setPower(0.2);
        RBmotor.setPower(0.2);
        //sleep(time);
        //LFmotor.setPower(0.2);
        //LBmotor.setPower(0.2);
   }

   public void left(double power) {
       LFmotor.setPower(-power);
       LBmotor.setPower(-power);
       RBmotor.setPower(power);
       RFmotor.setPower(power);
   }

    public void right(double power) {
        LFmotor.setPower(power);
        LBmotor.setPower(power);
        RBmotor.setPower(-power);
        RFmotor.setPower(-power);
    }


    //"Crab" method, moet nog worden getest met nieuwe wielen.
    public void crab(String direction) {
       if(direction == "left") {
           LFmotor.setPower(-0.2);
           LBmotor.setPower(0.2);
           RFmotor.setPower(0.2);
           RBmotor.setPower(-0.2);
       } else if(direction == "right") {
           LFmotor.setPower(0.2);
           LBmotor.setPower(-0.2);
           RFmotor.setPower(-0.2);
           RBmotor.setPower(0.2);
       } else {
           return;
       }
   }

   public void neutral() {
       grijp.setPosition(0);
       arm.setPosition(0);

   }


    public void runOpMode() {

    }
}
