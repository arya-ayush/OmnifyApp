package com.omnify.hire.Model;

import android.util.Log;

import java.util.Random;

/**
 * Created by user on 22-Sep-17.
 */

public class RandomNumber {

    private RandomNumber(){

    }


    public static int getRandomNumber(int randomNumberSize) {
        int min = 1;
        int max = 9;
        for (int i = 1; i < randomNumberSize; i++) {
            min = min * 10;
            max = max * 10 + 9;
        }
        Log.d("ayush", "min:" + min + " " + "max:" + max);

        Random random = new Random();
        int randomNumber = random.nextInt(max - min) + min;
        Log.i("ayush", "random:" + randomNumber);
        return randomNumber;
    }

}
