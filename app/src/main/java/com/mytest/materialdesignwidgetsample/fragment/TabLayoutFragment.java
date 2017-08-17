package com.mytest.materialdesignwidgetsample.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.mytest.materialdesignwidgetsample.R;
import com.mytest.materialdesignwidgetsample.adapter.MyFragmentPagerAdapter;

import butterknife.InjectView;

/**
 * Created by FJQ on 2017/8/17.
 */

public class TabLayoutFragment extends BaseFragment {
    @InjectView(R.id.tabLayout)
    TabLayout tabLayout;
    @InjectView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tablayout;
    }

    @Override
    protected void initView() {
//Fragment+ViewPager+FragmentViewPager组合的使用
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(mMainActivity.getSupportFragmentManager(),
                mContext);
        viewPager.setAdapter(adapter);
        //Tab占满屏幕的宽度
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
    }
}
