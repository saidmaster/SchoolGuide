package com.example.root.textanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.root.textanimation.Geo.MapsActivity;
import com.example.root.textanimation.Utils.AlgoCollectionData;
import com.example.root.textanimation.Utils.CollectDataFromRadioButton;

public class Final_Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final__result);
        TextView textView = (TextView) findViewById(R.id.text_profil);

        // On Pass La valeur du profil au text vue
        textView.setText(AlgoCollectionData.showProfil(CollectDataFromRadioButton.getValue()));


        // button pour passer au Google Map
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent googleMap = new Intent(Final_Result.this, MapsActivity.class);
                startActivity(googleMap);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
            }
        });
    }


    // menu on
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.about:
            Intent intent1 = new Intent(Final_Result.this, About_us.class );
                startActivity(intent1);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
                break;
            case R.id.contact:

                Intent intents = new Intent(Intent.ACTION_SEND);
                intents.setType("text/plain");
                intents.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                Intent mailer = Intent.createChooser(intents, null);
                startActivity(mailer);


            case R.id.share:

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Link to the Aps");
                Intent share = Intent.createChooser(intent, null);
                startActivity(share);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
