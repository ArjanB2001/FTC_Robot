package org.firstinspires.ftc.teamcode;

import android.media.MediaPlayer;
import android.provider.MediaStore;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Music", group = "Linear Opmode")
public class MusicOpMode extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();





    public void runOpMode(){
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        r.wobbly.setLooping(true);
        waitForStart();

        while(opModeIsActive()){
            if(gamepad1.x && !r.playing) {
                r.wobbly.start();
                r.playing =true;
            } else if (gamepad1.x && r.playing) {
                r.wobbly.pause();
                r.wobbly.setLooping(true);
                r.playing = false;
            }

        }
    }
}
