package com.omnify.hire.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.omnify.hire.Adapters.RandomNumberAdapter;
import com.omnify.hire.R;
import com.omnify.hire.Model.RandomNumber;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by user on 23-Sep-17.
 */

public class RandomNumberFragment extends OmnifyFragment {

    List<Integer>  randomNumberList;

    @BindView(R.id.rv)
    RecyclerView recyclerView;

    @BindView(R.id.sort_button)
    Button sortButton;

    public RandomNumberFragment(){

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_random_number;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getInstance(){
        RandomNumberFragment randomNumberFragment=new RandomNumberFragment();
        return  randomNumberFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        randomNumberList=new ArrayList<>();
        for(int i=0;i<20;i++){
            randomNumberList.add(RandomNumber.getRandomNumber(2));
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RandomNumberAdapter(randomNumberList));
    }

    @OnClick(R.id.sort_button)
    public  void  sort(){
        replaceFragment(SortedNumberFragment.getInstance(randomNumberList),getFragmentContainer(),this);
    }
}
