package com.example.hpm.mediarecorder;

import android.media.AudioFormat;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button record,play,stop,stopplayback;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        record=(Button)findViewById(R.id.button);
        play=(Button)findViewById(R.id.button2);
        stop=(Button)findViewById(R.id.button3);
        stopplayback=(Button)findViewById(R.id.button4);
        record.setOnClickListener(this);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        stopplayback.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.button:
                    mediaRecorder = new MediaRecorder();
                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                    mediaRecorder.setOutputFile(Environment.getExternalStorageDirectory() + "/musicc.3gpp");
                    try {
                        mediaRecorder.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaRecorder.start();
                    break;
                case R.id.button3:
                    mediaRecorder.stop();
                    mediaRecorder.release();
                    break;
                case R.id.button2:
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(Environment.getExternalStorageDirectory()+"/musicc.3gpp");
                        mediaPlayer.prepare();
                        mediaPlayer.start();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //mediaPlayer.release();
                    break;
                case R.id.button4:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
