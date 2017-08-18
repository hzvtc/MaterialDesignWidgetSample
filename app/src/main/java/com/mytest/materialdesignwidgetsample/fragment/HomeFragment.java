package com.mytest.materialdesignwidgetsample.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mytest.materialdesignwidgetsample.R;
import com.mytest.materialdesignwidgetsample.adapter.WidgetNameWAdapter;
import com.mytest.materialdesignwidgetsample.custom.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by FJQ on 2017/8/17.
 * 左右滑动式设计的
 */

public class HomeFragment extends BaseFragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    @InjectView(R.id.widgetName)
    RecyclerView widgetName;
    private List<String> widgetNameList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        widgetNameList = new ArrayList<>();
        widgetNameList.add("TabLayout");
        WidgetNameWAdapter mWidgetNameWAdapter = new WidgetNameWAdapter(mContext, widgetNameList);
        mWidgetNameWAdapter.setOnItemClickListner(new WidgetNameWAdapter.OnItemClickListner() {
            @Override
            public void OnItemClick(int pos) {
                Log.i(TAG, "OnItemClick: "+pos);
                switch (pos){
                    case 0:
                        goToFragement(new TabLayoutFragment());
                        break;
                }
            }
        });
        LinearLayoutManager topLayoutManager = new LinearLayoutManager(mContext);
        topLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        widgetName.setLayoutManager(topLayoutManager);
        widgetName.addItemDecoration(new DividerItemDecoration(mContext,
                DividerItemDecoration.HORIZONTAL_LIST));
        widgetName.setHasFixedSize(true);
        widgetName.setAdapter(mWidgetNameWAdapter);

    }


}
