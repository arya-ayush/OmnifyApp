package com.omnify.hire.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 23-Sep-17.
 */

public class QuickSort {

    public List<Integer> quickSort(List<String> list) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int n = Integer.parseInt(list.get(i));
            integerList.add(n);
        }
        Log.d("ayush",""+integerList.size());
        quick(0, (integerList.size() - 1), integerList);
        return integerList;
    }

    private void quick(int low, int high, List<Integer> list) {
        int i = low;
        int j = high;
        int pivot = list.get(low + (high - low) / 2);
        while (i <= j) {
            while (list.get(i) < pivot) {
                i++;
            }
            while (list.get(j) > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j, list);
                i++;
                j--;
            }
        }
        if (low < j)
            quick(low, j, list);
        if (i < high)
            quick(i, high, list);
    }

    private void exchangeNumbers(int i, int j, List<Integer> list) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
