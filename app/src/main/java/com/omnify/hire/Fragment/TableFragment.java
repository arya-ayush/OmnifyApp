package com.omnify.hire.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.omnify.hire.Adapters.TableAdapter;
import com.omnify.hire.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by user on 23-Sep-17.
 */

public class TableFragment extends OmnifyFragment {

    private static final String ITEM_CLICKED = "clicked";
    List<Integer> list = new ArrayList<>();

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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int item = getArguments().getInt(ITEM_CLICKED);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new TableAdapter(addTable(item)));
    }

    public static Fragment getInstance(int item) {
        TableFragment tableFragment = new TableFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ITEM_CLICKED, item);
        tableFragment.setArguments(bundle);
        return tableFragment;
    }

    private List<Integer> addTable(int number) {
        for (int i = 0; i < 10; i++)
            list.add(number * (i + 1));
        return list;
    }

    public void changeList(int number) {
        list.clear();
        for (int i = 0; i < 10; i++)
            list.add(number * (i + 1));
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
