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

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


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

@TeleOp(name="Gamepad", group="Linear Opmode")
//@Disabled
public class Gamepad extends LinearOpMode {

    // Declare OpMode members.
    HardwareVar robotTest = new HardwareVar();

    @Override
    public void runOpMode() {
        robotTest.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        robotTest.runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //<editor-fold default="folded" desc="Tank Mode">

            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
//            robotTest.leftPower  = -gamepad1.left_stick_y ;
//            robotTest.rightPower = -gamepad1.right_stick_y ;

            //</editor-fold>  no

            //<editor-fold default="folded" desc="Master Control left_stick">

            // Setup a variable for each drive wheel to save power level for telemetry
            double leftPower;
            double rightPower;

            // POV Mode uses left stick to go forward, and right stick to turn.
            //left stick op x-as en y-as, om vooruit, achteruit, links en rechts.
            double drive = -this.gamepad1.left_stick_y;
            double turn  =  -this.gamepad1.left_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            //</editor-fold>

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

            // Send calculated power to wheels
            robotTest.frontLeftDrive.setPower(leftPower);
            robotTest.frontRightDrive.setPower(rightPower);

            //<editor-fold default="folded" desc="Servo's a_b_button">

            if (gamepad1.b){
                robotTest.servo1.setPosition(0.4);
                robotTest.servo2.setPosition(0.4);
            } else if (gamepad1.a){
                robotTest.servo1.setPosition(0.1);
                robotTest.servo2.setPosition(0.1);
            }

            //</editor-fold>

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + robotTest.runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.addData("Status Servo's", robotTest.servo1.getPosition() + robotTest.servo2.getPosition());
            telemetry.update();

        }
    }
}
