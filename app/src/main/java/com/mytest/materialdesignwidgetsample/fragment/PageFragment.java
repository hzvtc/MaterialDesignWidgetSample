package com.mytest.materialdesignwidgetsample.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.mytest.materialdesignwidgetsample.R;

import butterknife.InjectView;

/**
 * Created by FJQ on 2017/8/17.
 */

public class PageFragment extends BaseFragment {
    public static final String ARGS_PAGE = "args_page";
    @InjectView(R.id.textView)
    TextView textView;
    private int mPage;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();

        args.putInt(ARGS_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_page;
    }

    @Override
    protected void initView() {
        mPage = getArguments().getInt(ARGS_PAGE);
        textView.setText("第"+mPage+"页");
    }
}
