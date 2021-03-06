package com.mytest.materialdesignwidgetsample.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mytest.materialdesignwidgetsample.fragment.PageFragment;

/**
 * Created by FJQ on 2017/8/17.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] titles = new String[]{"Tab1", "Tab2", "Tab3", "Tab4", "Tab5","Tab1", "Tab2", "Tab3", "Tab4", "Tab5"};
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];

    }
}
