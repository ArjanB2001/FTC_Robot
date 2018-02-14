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

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.detectors.JewelDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import static com.qualcomm.hardware.bosch.BNO055IMU.MagPowerMode.SLEEP;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Autonomous PeriodV2 TR", group="Linear Opmode")
//@Disabled
public class AutonomousPeriodV2 extends LinearOpMode {

    // Declare OpMode members.
    HardwareVar r = new HardwareVar();
    private JewelDetector jewelDetector = null;
    @Override
    public void runOpMode() {
        r.init(hardwareMap);

        jewelDetector = new JewelDetector();
        jewelDetector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());

        //Jewel Detector Settings
        jewelDetector.areaWeight = 0.02;
        jewelDetector.detectionMode = JewelDetector.JewelDetectionMode.MAX_AREA; // PERFECT_AREA
        //jewelDetector.perfectArea = 6500; <- Needed for PERFECT_AREA
        jewelDetector.debugContours = true;
        jewelDetector.maxDiffrence = 15;
        jewelDetector.ratioWeight = 15;
        jewelDetector.minArea = 700;
        jewelDetector.enable();

        r.servo1.setPosition(0.75);
        r.servo2.setPosition(0.6);
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            if(jewelDetector.getLastOrder().toString() == "BLUE_RED") {
                r.servo2 .setPosition(0);
                sleep(800);

                r.powerAll(0.4);
                sleep(400);

                r.servo2.setPosition(0.6);
                sleep(600);

                r.powerAll(0);
                sleep(100);
                r.right(0.5);
                sleep(1250);
                r.powerAll(0);
                sleep(100);
                r.powerAll(0.3);
                sleep(700);
                r.powerAll(0);
                r.servo1.setPosition(1);
                sleep(100);
                r.powerAll(-0.3);
                sleep(300);
                r.powerAll(0);
                break;

            } else if(jewelDetector.getLastOrder().toString() == "RED_BLUE") {
                r.servo2.setPosition(0);
                sleep(800);
                r.powerAll(-0.4);
                sleep(600);
                r.powerAll(0);
                r.servo2.setPosition(0.6);
                r.powerAll(0.4);
                sleep(1650);
                r.powerAll(0);
                sleep(100);
                r.right(0.5);
                sleep(1200);
                r.powerAll(0);
                sleep(100);
                r.powerAll(0.3);
                sleep(800);
                r.powerAll(0);
                r.servo1.setPosition(1);
                r.powerAll(-0.3);
                sleep(300);
                r.powerAll(0 );
                break;
            }
            jewelDetector.disable();


            break;




            //Lees kleur

            //Bal omgooien

            //Terug draaien

            //90 graden draaien
            //0.76 meter naar voren

            // 90 graden terug draaien

            //iets naar voren

            //blok neerzetten

            //ietsje  pietsje naar achter

//            if(r.colorSensor.red() > r.colorSensor.blue() && r.colorSensor.red() >= 5 ) {
//
//            }
//
//
//            if(r.colorSensor.blue() > r.colorSensor.red() && r.colorSensor.blue() >= 5 ) {
//                telemetry.addData("kleur:", "Waarschijnlijk blauw");
//
//            }




//            telemetry.addData("Clear", r.colorSensor.alpha());
//            telemetry.addData("Red  ", r.colorSensor.red());
//            telemetry.addData("Green", r.colorSensor.green());
//            telemetry.addData("Blue ", r.colorSensor.blue());
//
//
//            telemetry.update();


        }
    }
}
