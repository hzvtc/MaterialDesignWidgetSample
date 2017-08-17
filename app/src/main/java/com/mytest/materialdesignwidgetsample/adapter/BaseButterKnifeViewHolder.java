package com.mytest.materialdesignwidgetsample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by 2 on 2017/7/7.
 */

public class BaseButterKnifeViewHolder extends RecyclerView.ViewHolder {
    public BaseButterKnifeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }

    public void onDestroy(){
        ButterKnife.reset(this);
    }


}
