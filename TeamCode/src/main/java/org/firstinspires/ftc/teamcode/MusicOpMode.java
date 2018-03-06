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
    Boolean playing = false;
    MediaPlayer wobbly = MediaPlayer.create(hardwareMap.appContext, R.raw.wobbly);




    public void runOpMode(){
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        wobbly.setLooping(true);
        waitForStart();

        while(opModeIsActive()){
            if(gamepad1.x && !playing) {
                wobbly.start();
                playing =true;
            } else if (gamepad1.x && playing) {
                wobbly.pause();
                wobbly.setLooping(true);
                playing = false;
            }

        }
    }
}
