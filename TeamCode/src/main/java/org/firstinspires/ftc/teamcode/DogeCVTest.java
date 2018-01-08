package org.firstinspires.ftc.teamcode;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.detectors.*;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.io.IOException;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@TeleOp(name="DogeCV Glyph Detector", group="DogeCV")

public class DogeCVTest extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();


    private GlyphDetector glyphDetector = null;
    HardwareVar r = new HardwareVar();
    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {

        r.init(hardwareMap);
        telemetry.addData("Status", "Initialized");


        glyphDetector = new GlyphDetector();
        glyphDetector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());
        glyphDetector.minScore = 1;
        glyphDetector.downScaleFactor = 0.3;
        glyphDetector.speed = GlyphDetector.GlyphDetectionSpeed.SLOW;
        glyphDetector.enable();


    }

    @Override
    public void init_loop() {
        telemetry.addData("Status", "Initialized. Gyro Calibration");
    }

    @Override
    public void start() {
        runtime.reset();


    }

    @Override
    public void loop() {
        if (glyphDetector.getChosenGlyphOffset() < 110) {
            r.RBmotor.setPower(0.2);
            r.LBmotor.setPower(-0.2);


        } else if (glyphDetector.getChosenGlyphOffset() > 150) {
            //Naar rechts draaien
        } else if (glyphDetector.getChosenGlyphOffset() > 110 & glyphDetector.getChosenGlyphOffset() < 150) {
            telemetry.addData("Status", "MIDDEN");
        } else {
            telemetry.addData("Status", "IK WEET HET NIET MEER");
        }


        telemetry.addData("Status", "Run Time: " + runtime);
        telemetry.addData("Glyph Pos offset", glyphDetector.getChosenGlyphOffset());
        telemetry.addData("Glyph Pos X, Y", glyphDetector.getChosenGlyphPosition());


    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        glyphDetector.disable();
    }

}
