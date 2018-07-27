package com.jeancle.cheap.demo;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseFragment;

/**
 * Created by Jeancle
 * on 2017/4/11.
 * 类说明:
 */

public class ShowFragment extends BaseFragment {
    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        this.inflater=inflater;
        //加载布局
        view=inflater.inflate(R.layout.show,container);
    }

    @Override
    protected void setControlBasis() {

    }

    @Override
    protected void prepareData() {

    }
}
