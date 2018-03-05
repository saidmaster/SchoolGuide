package com.example.root.textanimation.ListViewStart;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.root.textanimation.Question.QuestionOneActivity;
import com.example.root.textanimation.R;

import java.io.Serializable;

/**
 * Created by root on 6/21/17.
 */

public class OnstartChoose extends ListActivity implements Serializable {

    // prevent back press
    @Override
    public void onBackPressed () {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);




        final String[] listtxtImage = {
                getString(R.string.collegien),
                getString(R.string.lyceen).toString(),
                getString(R.string.etudiant).toString(),
                getString(R.string.adulte).toString(),
                getString(R.string.parent).toString()
        };

        AdapterImageListe arrayAdapter = new AdapterImageListe(getBaseContext(), listtxtImage);
        setListAdapter(arrayAdapter);


    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        // Starting Questions Activity
        Intent intent = new Intent(OnstartChoose.this, QuestionOneActivity.class);
        startActivity(intent);

        // playing sound
        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.buttonstart);
        mediaPlayer.start();

        // Animations
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);

    }
}
