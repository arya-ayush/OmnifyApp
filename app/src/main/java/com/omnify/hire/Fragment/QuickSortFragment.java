package com.omnify.hire.Fragment;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.omnify.hire.Adapters.RandomNumberAdapter;
import com.omnify.hire.Adapters.SortListAdapter;
import com.omnify.hire.R;
import com.omnify.hire.Service.SortingService;
import com.omnify.hire.Utils.DataParsing;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;

/**
 * Created by user on 23-Sep-17.
 */

public class QuickSortFragment extends OmnifyFragment implements SortListAdapter.PositionClickedItem {

    private static final String QUICK = "quick";
    private String listString;
    private Type type;
    private SortingService sortingService;
    private DataPass dataPass;

    @BindView(R.id.sort_container)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_sort_number;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        listString = bundle.getString(QUICK);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataPass = (DataPass) getParentFragment();
        type = new TypeToken<List<String>>() {
        }.getType();
        List<String> stringList = DataParsing.ToList(listString, type);
        Intent intent = SortingService.getInstance(getContext(), stringList);
        getContext().startService(intent);
        getContext().bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

    }

    public static Fragment getInstance(List<String> list) {
        QuickSortFragment quickSortFragment = new QuickSortFragment();
        Bundle bundle = new Bundle();
        bundle.putString(QUICK, DataParsing.ToString(list));
        quickSortFragment.setArguments(bundle);
        return quickSortFragment;
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            SortingService.SortingBinder sortingBinder = (SortingService.SortingBinder) iBinder;
            sortingService = (SortingService) sortingBinder.getServeice();
            List<Integer> sortedList = sortingService.quickSort();
            if (sortedList.size() != 0) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(new SortListAdapter(sortedList, QuickSortFragment.this));
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            sortingService.stopSelf();
        }
    };


    @Override
    public int getClickedItemPosition(int position) {
        Log.d("ayush", "quick: " + position);
        dataPass.sendData(position);
        return position;
    }


    public interface DataPass {
        public void sendData(int item);
    }
}
