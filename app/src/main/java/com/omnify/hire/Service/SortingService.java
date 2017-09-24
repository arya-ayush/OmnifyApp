package com.omnify.hire.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.omnify.hire.Model.MergeSort;
import com.omnify.hire.Model.QuickSort;
import com.omnify.hire.Utils.DataParsing;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 23-Sep-17.
 */

public class SortingService extends Service {

    private IBinder sortingBinder;
    private static final String LIST = "list";
    private String list1;
    private List<String> toSort = new ArrayList<>();


    @Override
    public void onCreate() {
        super.onCreate();
        sortingBinder = new SortingBinder();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return sortingBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        list1 = intent.getStringExtra(LIST);
        Type type = new TypeToken<List<String>>() {
        }.getType();
        toSort = DataParsing.ToList(list1, type);
        return START_REDELIVER_INTENT;
    }



    public static Intent getInstance(Context context, List<String> listToSort) {
        Intent intent = new Intent(context, SortingService.class);
        String sort = DataParsing.ToString(listToSort);
        intent.putExtra(LIST, sort);
        return intent;
    }

    public List<Integer> quickSort() {
        QuickSort quickSort = new QuickSort();
        return quickSort.quickSort(toSort);
    }

    public List<Integer> mergeSort() {
        MergeSort mergeSort = new MergeSort();
        return mergeSort.mergeSort(toSort);
    }


    public class SortingBinder extends Binder {

        public Service getServeice() {
            return SortingService.this;
        }
    }


}
