package com.mytest.materialdesignwidgetsample.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mytest.materialdesignwidgetsample.R;

import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by FJQ on 2017/8/17.
 * 1.注意对于竖直线性布局 item的父布局高度必须是wrap_content 否则导致竖向item占满全屏
 * 对于水平线性布局 tem的父布局宽度必须是wrap_content 否则导致横向item占满全屏
 */

public class WidgetNameWAdapter extends BaseButterKnifeReclerViewAdapter<String, WidgetNameWAdapter.ViewHolder> {
    public WidgetNameWAdapter(Context context, List<String> mDatas) {
        super(context, mDatas);
    }

    public interface OnItemClickListner{
        void OnItemClick(int pos);
    }
    private OnItemClickListner mOnItemClickListner;

    public void setOnItemClickListner(OnItemClickListner mOnItemClickListner) {
        this.mOnItemClickListner = mOnItemClickListner;
    }

    @Override
    protected ViewHolder getViewHolder(View rootView, int viewType) {
        return new ViewHolder(rootView);
    }

    @Override
    protected void initItemView(ViewHolder holder, String model, int position) {
        holder.textView.setText(model);
        holder.textView.setTag(position);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_widget;
    }



    class ViewHolder extends BaseButterKnifeViewHolder {
        @InjectView(R.id.textView)
        TextView textView;

        ViewHolder(View view) {
            super(view);
        }

        @OnClick(R.id.textView)
        public void onClick() {
            int position = (int) textView.getTag();
            if (mOnItemClickListner!=null){
                mOnItemClickListner.OnItemClick(position);
            }
        }
    }
}
