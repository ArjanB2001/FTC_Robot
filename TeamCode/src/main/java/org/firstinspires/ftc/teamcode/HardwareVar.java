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

import com.qualcomm.hardware.hitechnic.HiTechnicNxtColorSensor;
import com.qualcomm.hardware.matrix.MatrixDcMotorController;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

public class HardwareVar
{
    /* Public OpMode members. */
    private MatrixDcMotorController motorController = null;
    private ServoController         servoController = null;

    public DcMotor LFmotor;
    public DcMotor LBmotor;
    public DcMotor RFmotor;
    public DcMotor RBmotor;
//    public Servo servo1;
//    public Servo servo2;
//    public Servo legoServo;
//    public UltrasonicSensor         rangeSensor;
    public HiTechnicNxtColorSensor  colorSensor;
//    public TouchSensor              touchSensor;
    public double LFpower;
    public double LBpower;
    public double RFpower;
    public double RBpower;

    public ElapsedTime runtime = new ElapsedTime();

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
        RBmotor = ahwMap.get(DcMotor.class, "RBmotor");
        RFmotor = ahwMap.get(DcMotor.class, "RFmotor");
        LBmotor = ahwMap.get(DcMotor.class, "LBmotor");
        LFmotor = ahwMap.get(DcMotor.class, "LFmotor");

        LFmotor.setDirection(DcMotor.Direction.REVERSE);
        LBmotor.setDirection(DcMotor.Direction.REVERSE);
        RFmotor.setDirection(DcMotor.Direction.FORWARD);
        RBmotor.setDirection(DcMotor.Direction.REVERSE);

//        //Servo's
//        servo1 = ahwMap.get(Servo.class, "servo1");
//        servo2 = ahwMap.get(Servo.class, "servo2");
//        legoServo = ahwMap.get(Servo.class, "legoServo");
//
//        //Sensoren
//        rangeSensor = ahwMap.get(UltrasonicSensor.class, "rangeSensor");
        colorSensor = ahwMap.get(HiTechnicNxtColorSensor.class, "colorSensor");
//        touchSensor = ahwMap.get(TouchSensor.class, "touchSensor");
//
//        // Enable Servos
//        servoController.pwmEnable();       // Don't forget to enable Matrix Output
    }


    public void powerAll(double power) {
        LFmotor.setPower(power);
        RFmotor.setPower(power);
        LBmotor.setPower(power);
        RBmotor.setPower(power);
    }
}
