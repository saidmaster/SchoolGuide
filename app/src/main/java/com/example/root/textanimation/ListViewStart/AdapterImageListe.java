package com.example.root.textanimation.ListViewStart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.textanimation.R;

/**
 * Created by root on 6/20/17.
 */

public class AdapterImageListe extends ArrayAdapter<String> {


    // Array Of Images

    private Integer[] arr_images = {
            R.drawable.box_collegien,
            R.drawable.box_lyceen,
            R.drawable.box_etudiant,
            R.drawable.box_adulte,
            R.drawable.box_parent

    };

    // Constructeur Obligatoir

    public AdapterImageListe(Context context, String[] values){
        super(context, R.layout.imagetxtlayout, values);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = layoutInflater.inflate(R.layout.imagetxtlayout, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.textLabel);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgView);

        textView.setText(getItem(position));

        if(convertView == null)
            imageView.setImageResource(arr_images[position]);

        else
            rowView = (View)convertView;

        return rowView;

    }
}

