package com.jeancle.cheap.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jeancle.cheap.R;
import com.jeancle.cheap.adapter.WelcomeAdapter;
import com.jeancle.cheap.base.BaseActivity;
import com.jeancle.cheap.fragment.welcome.PageFourFrament;
import com.jeancle.cheap.fragment.welcome.PageOneFrament;
import com.jeancle.cheap.fragment.welcome.PageThreeFrament;
import com.jeancle.cheap.fragment.welcome.PageTwoFrament;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_welcome)
public class WelcomeActivity extends BaseActivity {

    public ViewPager vp_welcome;
    private List<Fragment> datas;

    @Override
    protected void back() {

    }

    @Override
    protected void setControlBasis() {
        x.view().inject(this);
        vp_welcome = (ViewPager) findViewById(R.id.vp_welcome);
    }

    @Override
    protected void prepareData() {
        init();
    }

    private void init() {
        datas = new ArrayList();
        datas.add(new PageOneFrament());
        datas.add(new PageTwoFrament());
        datas.add(new PageThreeFrament());
        datas.add(new PageFourFrament());
        WelcomeAdapter welcomeAdapter = new WelcomeAdapter(getSupportFragmentManager(), datas);
        vp_welcome.setAdapter(welcomeAdapter);
    }


}
