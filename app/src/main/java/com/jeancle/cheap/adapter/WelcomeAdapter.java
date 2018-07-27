package com.jeancle.cheap.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Jeancle
 * on 2017/4/6.
 * 类说明:欢迎页适配器
 */

public class WelcomeAdapter extends FragmentPagerAdapter {
    private List<Fragment> datas;

    public WelcomeAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        datas = data;
    }


    @Override
    public Fragment getItem(int position) {
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }
}
