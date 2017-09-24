package com.omnify.hire.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omnify.hire.Adapters.ViewHolders.RecyclerViewViewHolder;
import com.omnify.hire.R;

import java.util.List;

/**
 * Created by user on 23-Sep-17.
 */

public class SortListAdapter extends RecyclerView.Adapter<RecyclerViewViewHolder> {

    List<Integer> randomNumberList;
    private Context context;
    public SortListAdapter.PositionClickedItem position;

    public SortListAdapter(List<Integer> randomNumberList, Fragment fragment) {
        this.randomNumberList = randomNumberList;
        position = (SortListAdapter.PositionClickedItem) fragment;
    }

    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.rv_random_number_single_viewholder, parent, false);
        return new RecyclerViewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewViewHolder holder, final int position) {
        holder.regularTextView.setText("" + randomNumberList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SortListAdapter.this.position.getClickedItemPosition(randomNumberList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return randomNumberList == null ? 0 : randomNumberList.size();
    }

    public interface PositionClickedItem {
        public int getClickedItemPosition(int position);
    }

}
