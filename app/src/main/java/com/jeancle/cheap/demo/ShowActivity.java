package com.jeancle.cheap.demo;

import android.widget.TextView;

import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseActivity;

import org.xutils.view.annotation.ContentView;

/**
 * Created by Jeancle
 * on 2017/4/5.
 * 类说明:
 */
@ContentView(R.layout.show)
public class ShowActivity extends BaseActivity {
    public TextView tv_test;

    @Override
    protected void back() {
        //关闭当前也页面
        finish();
        //双击返回键 退出程序
        exit();
    }

    @Override
    protected void setControlBasis() {
        //初始化控件在这个方法
        tv_test = (TextView) findViewById(R.id.tv_test);
    }

    @Override
    protected void prepareData() {
        //设置数据在这个方法
        tv_test.setText("斯蒂芬");
    }
}
