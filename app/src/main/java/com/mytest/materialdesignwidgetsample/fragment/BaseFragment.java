package com.mytest.materialdesignwidgetsample.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mytest.materialdesignwidgetsample.MainActivity;
import com.mytest.materialdesignwidgetsample.R;

import butterknife.ButterKnife;

/**
 * Created by FJQ on 2017/8/17.
 */

public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected Activity activity;
    protected MainActivity mMainActivity;
    protected View rootView;
    protected boolean isStop;
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        mContext = activity;
        this.activity = activity;
        mMainActivity = (MainActivity) activity;
        super.onAttach(activity);
    }

    //加载应用的布局
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        }
        if (rootView != null) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, rootView);

    }

    public void goToFragement(BaseFragment fragment){
        FragmentTransaction fragmentTransaction = mMainActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onResume() {
        super.onResume();
        isStop = false;
        initView();
    }

    @Override
    public void onStop() {
        isStop=true;
        super.onStop();
    }

    //Fragment布局资源Id
    protected abstract int getLayoutId();

    //初始化用户界面
    protected abstract void initView();

}
