package com.example.root.textanimation.Question;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.DialerFilter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.textanimation.ListViewStart.OnstartChoose;
import com.example.root.textanimation.R;
import com.example.root.textanimation.Utils.CollectDataFromRadioButton;
import com.example.root.textanimation.Utils.ValueStrings;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by root on 6/20/17.
 */

public class QuestionOneActivity extends AppCompatActivity {

    // prevent back press
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        AlertDialog.Builder builder = new AlertDialog.Builder(QuestionOneActivity.this);

        builder.setTitle(R.string.exit_title);

        // onClick on yes button
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });

            // on Click on no Button
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            // on Click on ignore button
        builder.setNeutralButton(R.string.ignore, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // nothing to do just go back to the same activity
                }
            });
            if(KeyEvent.KEYCODE_BACK == keyCode){
                builder.show();
            }

        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_one);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // previous Activity
                Intent i = new Intent(QuestionOneActivity.this, OnstartChoose.class);
                startActivity(i);

                // Animations
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);

            }
        });

        // Declation des TextView
        final TextView questionA1 = (TextView) findViewById(R.id.questionA1);
        final TextView questionA2 = (TextView) findViewById(R.id.questionA2);
        final TextView questionA3 = (TextView) findViewById(R.id.questionA3);
        final TextView questionTitle = (TextView) findViewById(R.id.textView);


        // checking a radioButton
        final RadioButton r1 = (RadioButton) findViewById(R.id.radioId1);
        final RadioButton r2 = (RadioButton) findViewById(R.id.radioId2);
        final RadioButton r3 = (RadioButton) findViewById(R.id.radioId3);


        questionA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check and uncheck radioButton
                r1.setChecked(true);
                r2.setChecked(false);
                r3.setChecked(false);

                // playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();

                // color of the back ground if the user check his choise
                questionA1.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionA3.setBackgroundColor(getResources().getColor(R.color.white));
                questionA2.setBackgroundColor(getResources().getColor(R.color.white));

            }
        });
        questionA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /// playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();


                r2.setChecked(true);
                r1.setChecked(false);
                r3.setChecked(false);

                // color of the back ground if the user check his choise
                questionA2.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionA3.setBackgroundColor(getResources().getColor(R.color.white));
                questionA1.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });
        questionA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();


                r3.setChecked(true);
                r2.setChecked(false);
                r1.setChecked(false);

                // color of the back ground if the user check his choise
                questionA3.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionA1.setBackgroundColor(getResources().getColor(R.color.white));
                questionA2.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check and uncheck radioButton
                r1.setChecked(true);
                r2.setChecked(false);
                r3.setChecked(false);

                // playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();

                // color of the back ground if the user check his choise
                questionA1.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionA3.setBackgroundColor(getResources().getColor(R.color.white));
                questionA2.setBackgroundColor(getResources().getColor(R.color.white));

            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /// playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();


                r2.setChecked(true);
                r1.setChecked(false);
                r3.setChecked(false);

                // color of the back ground if the user check his choise
                questionA2.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionA3.setBackgroundColor(getResources().getColor(R.color.white));
                questionA1.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();


                r3.setChecked(true);
                r2.setChecked(false);
                r1.setChecked(false);

                // color of the back ground if the user check his choise
                questionA3.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionA1.setBackgroundColor(getResources().getColor(R.color.white));
                questionA2.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });



        Animation anim = new AlphaAnimation(0.0f, 1.0f);


        anim.setDuration(3000); //You can manage the time of the blink with this parameter
        anim.setStartOffset(90);
        anim.setRepeatMode(Animation.REVERSE);


        questionA1.startAnimation(anim);
        questionA2.startAnimation(anim);
        questionA3.startAnimation(anim);
        questionTitle.startAnimation(anim);



        // onClick sur Button Prev

        Button btn_prev = (Button) findViewById(R.id.btnPrev);
        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // previous Activity
                Intent i = new Intent(QuestionOneActivity.this, OnstartChoose.class);
                startActivity(i);

                // Animations
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
        // onClick sur Button Suivant

        Button bQuestionOne = (Button) findViewById(R.id.btnQuestionOne);
        bQuestionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionOneActivity.this, QuestionTwoActivity.class);


                if(r1.isChecked()){
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    CollectDataFromRadioButton.setRadioValue(ValueStrings.QUESTION_A_1);

                    // playing sound

                    MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.next_click_sound);
                    mediaPlayer.start();

                    Toast.makeText(getBaseContext(), String.valueOf(CollectDataFromRadioButton.getValue().size()),Toast.LENGTH_LONG).show();

                }
                else if (r2.isChecked()){
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    CollectDataFromRadioButton.setRadioValue(ValueStrings.QUESTION_A_2);

                    MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.next_click_sound);
                    mediaPlayer.start();
                }
                else if(r3.isChecked()){
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    CollectDataFromRadioButton.setRadioValue(ValueStrings.QUESTION_A_3);

                    MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.next_click_sound);
                    mediaPlayer.start();
                }
                else {
                    Snackbar.make(v, "Please select your choice", Snackbar.LENGTH_LONG).show();
                }

            }
        });
    }


}
