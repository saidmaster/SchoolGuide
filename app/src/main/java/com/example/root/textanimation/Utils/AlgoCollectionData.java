package com.example.root.textanimation.Utils;

import java.util.ArrayList;

/**
 * Created by root on 6/22/17.
 */

public class AlgoCollectionData {

    public AlgoCollectionData(){}

    public static String showProfil(ArrayList<String> strings){

        String profil = null;
        Integer sum = 0;
        for(int i = 0; i < strings.size() ; i++){

            sum += Integer.valueOf(strings.get(i));
        }

        if(sum == 20 ){
            profil = ValueStrings.PROFIL_1;
        }
        else if(sum > 20 && sum < 30 ){
            profil = ValueStrings.PROFIL_2;
        }
        else if(sum >= 30 && sum < 40 ){
            profil = ValueStrings.PROFIL_3;
        }
        else if(sum >= 40 && sum < 50 ){
            profil = ValueStrings.PROFIL_4;
        }
        else if(sum > 50 && sum <= 60 ){
            profil = ValueStrings.PROFIL_5;
        }
         return profil;
    }
}
