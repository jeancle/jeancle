package com.jeancle.cheap.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Jeancle
 * on 2017/4/11.
 * 类说明:
 */

public abstract class BaseFragment extends Fragment {
    protected View view;
    protected LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loadViewLayout(inflater, container);
        setControlBasis();
        prepareData();
        return view;
    }

    protected View findViewById(int id) {
        return view.findViewById(id);
    }

    /**
     * 描述：加载视图
     */
    protected abstract void loadViewLayout(LayoutInflater inflater, ViewGroup container);

    /**
     * 描述：设置控件基础
     */
    protected abstract void setControlBasis();

    /**
     * 描述：准备数据
     */
    protected abstract void prepareData();

    /**
     * 描述：toast提示
     *
     * @param msg
     */
    protected void makeText(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 描述：跳转页面
     *
     * @param intent
     */
    public void startActivity(Intent intent) {
        getActivity().startActivity(intent);
    }
}
