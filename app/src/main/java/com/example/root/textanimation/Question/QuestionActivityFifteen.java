package com.example.root.textanimation.Question;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.textanimation.R;
import com.example.root.textanimation.Utils.CollectDataFromRadioButton;
import com.example.root.textanimation.Utils.ValueStrings;

public class QuestionActivityFifteen extends AppCompatActivity {
    // prevent back press
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        AlertDialog.Builder builder = new AlertDialog.Builder(QuestionActivityFifteen.this);

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_fifteen);

        // back arrow
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // previous Activity
                Intent i = new Intent(QuestionActivityFifteen.this, QuestionActivityfoorteen.class);
                startActivity(i);

                // Removing last indx of the array
                CollectDataFromRadioButton.array_pop();
                // Animations
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);

            }
        });

        // Declation des TextView
        final TextView questionO1 = (TextView) findViewById(R.id.questionO1);
        final TextView questionO2 = (TextView) findViewById(R.id.questionO2);
        final TextView questionO3 = (TextView) findViewById(R.id.questionO3);
        TextView questionTitle = (TextView) findViewById(R.id.textView);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);


        anim.setDuration(3000); //You can manage the time of the blink with this parameter
        anim.setStartOffset(90);
        anim.setRepeatMode(Animation.REVERSE);


        questionO1.startAnimation(anim);
        questionO2.startAnimation(anim);
        questionO3.startAnimation(anim);
        questionTitle.startAnimation(anim);

        // cheicking a radioButton
        final RadioButton r1 = (RadioButton) findViewById(R.id.radioId1);
        final RadioButton r2 = (RadioButton) findViewById(R.id.radioId2);
        final RadioButton r3 = (RadioButton) findViewById(R.id.radioId3);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();

                // color of the back ground if the user check his choise
                questionO1.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionO2.setBackgroundColor(getResources().getColor(R.color.white));
                questionO3.setBackgroundColor(getResources().getColor(R.color.white));


                r1.setChecked(true);
                r2.setChecked(false);
                r3.setChecked(false);
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();

                // color of the back ground if the user check his choise
                questionO2.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionO1.setBackgroundColor(getResources().getColor(R.color.white));
                questionO3.setBackgroundColor(getResources().getColor(R.color.white));


                r2.setChecked(true);
                r1.setChecked(false);
                r3.setChecked(false);
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();

                // color of the back ground if the user check his choise
                questionO3.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionO1.setBackgroundColor(getResources().getColor(R.color.white));
                questionO2.setBackgroundColor(getResources().getColor(R.color.white));

                r3.setChecked(true);
                r2.setChecked(false);
                r1.setChecked(false);
            }
        });
        questionO1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();

                // color of the back ground if the user check his choise
                questionO1.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionO2.setBackgroundColor(getResources().getColor(R.color.white));
                questionO3.setBackgroundColor(getResources().getColor(R.color.white));


                r1.setChecked(true);
                r2.setChecked(false);
                r3.setChecked(false);
            }
        });
        questionO2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();

                // color of the back ground if the user check his choise
                questionO2.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionO1.setBackgroundColor(getResources().getColor(R.color.white));
                questionO3.setBackgroundColor(getResources().getColor(R.color.white));


                r2.setChecked(true);
                r1.setChecked(false);
                r3.setChecked(false);
            }
        });
        questionO3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // playing sound

                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
                mediaPlayer.start();

                // color of the back ground if the user check his choise
                questionO3.setBackgroundColor(getResources().getColor(R.color.greenColor));
                questionO1.setBackgroundColor(getResources().getColor(R.color.white));
                questionO2.setBackgroundColor(getResources().getColor(R.color.white));

                r3.setChecked(true);
                r2.setChecked(false);
                r1.setChecked(false);
            }
        });
        // onClick sur Button Prev

        Button btn_prev = (Button) findViewById(R.id.btnPrev);
        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // previous Activity
                Intent i = new Intent(QuestionActivityFifteen.this, QuestionActivityfoorteen.class);
                startActivity(i);

                // Removing last indx of the array
                CollectDataFromRadioButton.array_pop();
                // Animations
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        // start Next Question Activity
        Button btbB = (Button) findViewById(R.id.btnQuestionFifteen);
        btbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionActivityFifteen.this, QuestionActivitySixteen.class);

                if(r1.isChecked()){
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    CollectDataFromRadioButton.setRadioValue(ValueStrings.QUESTION_O_1);

                    // playing sound

                    MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.next_click_sound);
                    mediaPlayer.start();

                }
                else if (r2.isChecked()){
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    CollectDataFromRadioButton.setRadioValue(ValueStrings.QUESTION_O_2);

                    // playing sound

                    MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.next_click_sound);
                    mediaPlayer.start();
                }
                else if(r3.isChecked()){
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    CollectDataFromRadioButton.setRadioValue(ValueStrings.QUESTION_O_3);

                    // playing sound

                    MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.next_click_sound);
                    mediaPlayer.start();
                }
                else {
                    Snackbar.make(v, "Please select your choice", Snackbar.LENGTH_LONG)
                            .show();                }


            }
        });
    }
}
