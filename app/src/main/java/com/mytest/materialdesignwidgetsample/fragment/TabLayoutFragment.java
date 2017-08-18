package com.mytest.materialdesignwidgetsample.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.mytest.materialdesignwidgetsample.R;
import com.mytest.materialdesignwidgetsample.adapter.MyFragmentPagerAdapter;

import butterknife.InjectView;

/**
 * Created by FJQ on 2017/8/17.
 * 标签--TabLayout--TabLayout provides a horizontal layout to display tabs
 * 内容的变化--ViewPager+Fragmen
 * 用Map来管理标题和fragment的对应关系
 */

public class TabLayoutFragment extends BaseFragment {
    private static final String TAG = TabLayoutFragment.class.getSimpleName();
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
        //Tab占满屏幕宽度 平分宽度
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i(TAG, "onTabSelected: "+tab.getPosition());
                Toast.makeText(mContext,"onTabSelected: "+tab.getPosition(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.i(TAG, "onTabUnselected: "+tab.getPosition());
                Toast.makeText(mContext,"onTabUnselected: "+tab.getPosition(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.i(TAG, "onTabReselected: "+tab.getPosition());
                Toast.makeText(mContext,"onTabReselected: "+tab.getPosition(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
