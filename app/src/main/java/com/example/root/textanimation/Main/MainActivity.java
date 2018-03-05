package com.example.root.textanimation.Main;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.textanimation.ListViewStart.OnstartChoose;
import com.example.root.textanimation.R;

public class MainActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        // loading Logo on start apps
        new CountDownTimer(5000, 1000){
            @Override
            public void onTick(long millisUntilFinished){

                MainActivity.this.setContentView(R.layout.activity_main);
                MediaPlayer m = MediaPlayer.create(getBaseContext(), R.raw.backgroundmusic);
                m.start();

           }

            @Override
            public void onFinish(){
                //set the new Content of your activity
                Intent i = new Intent(MainActivity.this, OnstartChoose.class);
                MainActivity.this.startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);

            }
        }.start();
    }
}
