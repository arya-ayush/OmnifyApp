package com.omnify.hire.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.omnify.hire.R;
import com.omnify.hire.Utils.DataParsing;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by user on 23-Sep-17.
 */

public class SortedNumberFragment extends OmnifyFragment implements MergeSortFragment.DataPass, QuickSortFragment.DataPass {

    private static final String LIST = "list";
    private String getList;
    private FragmentManager fragmentManager;
    private Type type;

    public SortedNumberFragment() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_sorted_number;
    }

    @Override
    protected String setToolbarTitle() {
        return "Sorted Number";
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager=getChildFragmentManager();
        Bundle bundle = getArguments();
        getList = bundle.getString(LIST);
        type = new TypeToken<List<String>>() {
        }.getType();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolBarTitleOnFragment();
        List<String> list = DataParsing.ToList(getList, type);
        addFragment(QuickSortFragment.getInstance(list), false, R.id.quicksort_container);
        addFragment(MergeSortFragment.getInstance(list), false, R.id.mergesort_container);
    }

    public static Fragment getInstance(List<Integer> randomNumberList) {
        SortedNumberFragment sortedNumberFragment = new SortedNumberFragment();
        Bundle bundle = new Bundle();
        String parsedList = DataParsing.ToString(randomNumberList);
        bundle.putString(LIST, parsedList);
        sortedNumberFragment.setArguments(bundle);
        return sortedNumberFragment;
    }

    private void addFragment(Fragment fragment, boolean addToBackStack, int container) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        if (fragmentManager.findFragmentById(container) == null) {
            transaction.add(container, fragment).commit();
        }
    }

    @Override
    public void sendData(int item) {
        if (fragmentManager.findFragmentById(R.id.table_container) == null)
            addFragment(TableFragment.getInstance(item), false, R.id.table_container);
        else if (fragmentManager.findFragmentById(R.id.table_container) != null) {
            Fragment fragment = fragmentManager.findFragmentById(R.id.table_container);
            if (fragment instanceof TableFragment)
                ((TableFragment) fragment).changeList(item);
        }
    }

    @Override
    public void send(int item) {
        if (fragmentManager.findFragmentById(R.id.table_container) == null)
            addFragment(TableFragment.getInstance(item), false, R.id.table_container);
        else if (fragmentManager.findFragmentById(R.id.table_container) != null) {
            Fragment fragment = fragmentManager.findFragmentById(R.id.table_container);
            if (fragment instanceof TableFragment)
                ((TableFragment) fragment).changeList(item);
        }
    }
}
