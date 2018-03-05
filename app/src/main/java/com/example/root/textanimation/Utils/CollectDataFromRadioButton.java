package com.example.root.textanimation.Utils;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by root on 6/22/17.
 */

public class CollectDataFromRadioButton {

    public CollectDataFromRadioButton(){}
    public  static ArrayList<String> sb = new ArrayList<String>();

    public static  void setRadioValue(String value){
        sb.add(value);
    }

    public static ArrayList<String> getValue(){
        return sb;
    }

    // Removing the last index if the user click on previous Activity
    public static void array_pop(){
        int lastIndex = sb.size() -1;
        sb.remove(lastIndex);
        for (String str : sb){
            Log.d("Element ", str);
        }
        Log.d("Message => ",String.valueOf(lastIndex));
    }

}
