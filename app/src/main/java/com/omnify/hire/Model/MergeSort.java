package com.omnify.hire.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 23-Sep-17.
 */

public class MergeSort {

    private int[] temp;
    private int number;

    public List<Integer> mergeSort(List<String> list) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int n = Integer.parseInt(list.get(i));
            integerList.add(n);
        }
        number = integerList.size();
        this.temp = new int[number];
        Log.d("ayush",""+integerList.size());
        divideAndSort(0,(integerList.size()-1),integerList);
        return integerList;
    }

    private void divideAndSort(int low, int high,List<Integer> list) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            divideAndSort(low, middle,list);
            divideAndSort(middle + 1, high,list);
            merge(low, middle, high,list);
        }
    }

    private void merge(int low, int middle, int high,List<Integer> integerList) {
        for (int i = low; i <= high; i++) {
            temp[i] = integerList.get(i);
        }
        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (temp[i] <= temp[j]) {
                integerList.set(k, temp[i]);
                i++;
            } else {
                integerList.set(k, temp[j]);
                j++;
            }
            k++;
        }

        while (i <= middle) {
            integerList.set(k, temp[i]);
            k++;
            i++;
        }
    }



}
