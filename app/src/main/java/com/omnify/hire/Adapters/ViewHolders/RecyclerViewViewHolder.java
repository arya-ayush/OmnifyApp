package com.omnify.hire.Adapters.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.omnify.hire.R;
import com.omnify.hire.Utils.RegularTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 23-Sep-17.
 */

public class RecyclerViewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.number)
    public RegularTextView regularTextView;

    public RecyclerViewViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
