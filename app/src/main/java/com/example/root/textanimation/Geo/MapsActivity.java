package com.example.root.textanimation.Geo;

import com.example.root.textanimation.Question.QuestionActivityNine;
import com.example.root.textanimation.R;
import com.example.root.textanimation.Utils.AlgoCollectionData;
import com.example.root.textanimation.Utils.CollectDataFromRadioButton;
import com.example.root.textanimation.Utils.ValueStrings;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.wearable.view.DismissOverlayView;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MapsActivity extends Activity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {


    // prevent back press
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MapsActivity.this);

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
    /**
     * Overlay that shows a short help text when first launched. It also provides an option to
     * exit the app.
     */
    private DismissOverlayView mDismissOverlay;

    /**
     * The map. It is initialized when the map has been fully loaded and is ready to be used.
     *
     * @see #onMapReady(com.google.android.gms.maps.GoogleMap)
     */
    private GoogleMap mMap;

    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        // Set the layout. It only contains a MapFragment and a DismissOverlay.
        setContentView(R.layout.activity_maps);

        // Retrieve the containers for the root of the layout and the map. Margins will need to be
        // set on them to account for the system window insets.
        final FrameLayout topFrameLayout = (FrameLayout) findViewById(R.id.root_container);
        final FrameLayout mapFrameLayout = (FrameLayout) findViewById(R.id.map_container);

        // Set the system view insets on the containers when they become available.
        topFrameLayout.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                // Call through to super implementation and apply insets
                insets = topFrameLayout.onApplyWindowInsets(insets);

                FrameLayout.LayoutParams params =
                        (FrameLayout.LayoutParams) mapFrameLayout.getLayoutParams();

                // Add Wearable insets to FrameLayout container holding map as margins
                params.setMargins(
                        insets.getSystemWindowInsetLeft(),
                        insets.getSystemWindowInsetTop(),
                        insets.getSystemWindowInsetRight(),
                        insets.getSystemWindowInsetBottom());
                mapFrameLayout.setLayoutParams(params);

                return insets;
            }
        });

        // Obtain the DismissOverlayView and display the introductory help text.
        mDismissOverlay = (DismissOverlayView) findViewById(R.id.dismiss_overlay);
        mDismissOverlay.setIntroText(R.string.intro_text);
        mDismissOverlay.showIntroIfNecessary();

        // Obtain the MapFragment and set the async listener to be notified when the map is ready.
        MapFragment mapFragment =
                (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Map is ready to be used.
        mMap = googleMap;

        // Set the long click listener as a way to exit the map.
        mMap.setOnMapLongClickListener(this);

        // to show the profil from the list of choice

        String profil = AlgoCollectionData.showProfil(CollectDataFromRadioButton.getValue());

        if (profil.equals(ValueStrings.PROFIL_1)) {

            //Mine Rabat
            LatLng Mine = new LatLng(34.0001751, -6.856704);
            mMap.addMarker(new MarkerOptions().position(Mine).title("Mine Rabat"));


            // ENSIAS ,
            LatLng ENSIAS = new LatLng(33.9843118, -6.8697906);
            mMap.addMarker(new MarkerOptions().position(ENSIAS).title("École Nationale Supérieure d'Informatique et d'Analyse des Systèmes"));

            //National Institute of Post and Communication,
            LatLng NIPC = new LatLng(33.979679, -6.8688477);
            mMap.addMarker(new MarkerOptions().position(NIPC).title("National Institute of Post and Communication"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(NIPC));

        }else if(profil.equals(ValueStrings.PROFIL_2)) {


            //Faculty of Science, Ibn Zahr
            LatLng ibnzhr = new LatLng(30.4060231, -9.5444022);
            mMap.addMarker(new MarkerOptions().position(ibnzhr).title("culty of Science, Ibn Zahr"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ibnzhr));

            // cadi ayad 31.6443019, -8.0211568
            int heightCa = 100;
            int widthCa = 100;
            BitmapDrawable bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.university_cadi_ayad);
            Bitmap b = bitmapdraw.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, widthCa, heightCa, false);

            LatLng CADIAYAD = new LatLng(31.6443019, -8.0211568);
            mMap.addMarker(new MarkerOptions().position(CADIAYAD).title("Université Cadi Ayyad (Présidence, Marrakech)").icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

        }else if(profil.equals(ValueStrings.PROFIL_3)) {

            // National School of Applied Sciences
            LatLng nsas = new LatLng(30.4038619, -9.5323399);

            mMap.addMarker(new MarkerOptions().position(nsas).title("culty of Science, Ibn Zahr"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(nsas));

            // Faculty Science And Technology De Tanger,
            LatLng FSTtanger = new LatLng(35.7206772, -5.9192927);

            mMap.addMarker(new MarkerOptions().position(FSTtanger).title("Faculty Science And Technology De Tanger"));
        }else if(profil.equals(ValueStrings.PROFIL_4)) {


            //National School of Commerce and Management,
            LatLng nscm = new LatLng(30.4020255, -9.5573676);
            mMap.addMarker(new MarkerOptions().position(nscm).title("National School of Commerce and Management"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(nscm));
        }
        else if(profil.equals(ValueStrings.PROFIL_5)){
                // ENSA ,
                LatLng ENSA = new LatLng(34.0107235,-6.8480866);
                mMap.addMarker(new MarkerOptions().position(ENSA).title("National School De L'administration"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(ENSA));
        }
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        // Display the dismiss overlay with a button to exit this activity.
        mDismissOverlay.show();
    }
}
