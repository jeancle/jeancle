package com.jeancle.cheap.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseActivity;
import com.jeancle.cheap.bean.TestBean;
import com.jeancle.cheap.bean.TicketsBean;
import com.jeancle.cheap.fragment.CartFragment;
import com.jeancle.cheap.fragment.HomeFragment;
import com.jeancle.cheap.fragment.MineFragment;
import com.jeancle.cheap.util.GetGoodsListUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, GetGoodsListUtil.GetTicketsFace {
    List<TestBean.ResultBean.DataBean> list;
    @ViewInject(R.id.rg_menu)
    private RadioGroup rg_menu;
    @ViewInject(R.id.rb_home)
    public RadioButton rb_home;
    @ViewInject(R.id.rb_cart)
    private RadioButton rb_cart;
    @ViewInject(R.id.rb_mine)
    private RadioButton rb_mine;
    @ViewInject(R.id.fl_container)
    private FrameLayout fl_container;
    public HomeFragment homeFragment;
    public CartFragment cartFragment;
    public MineFragment mineFragment;
    public Fragment[] fragments;

    @Override
    protected void back() {
        exit();
    }

    @Override
    protected void setControlBasis() {
        x.view().inject(this);
//        initState();
        rb_home.setChecked(true);
        rg_menu.setOnCheckedChangeListener(this);

    }

    @Override
    protected void prepareData() {
        setDefaultFragment();

//        GetGoodsListUtil util = new GetGoodsListUtil(this);
//        util.getTicketsList("女裙子", "1", "10");

    }


    // formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        return sDateTime;
    }

    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        loadMine();
        rb_home.setChecked(true);
    }

    private void setDefaultFragment() {
        homeFragment = new HomeFragment();
        cartFragment = new CartFragment();
        mineFragment = new MineFragment();
        fragments = new Fragment[]{homeFragment, cartFragment, mineFragment};
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_container, fragments[0])
                .add(R.id.fl_container, fragments[1]).hide(fragments[1])
                .add(R.id.fl_container, fragments[2]).hide(fragments[2])
                .commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                loadHome();
                break;
            case R.id.rb_cart:
                loadCart();
                break;
            case R.id.rb_mine:
                loadMine();
                break;
        }
    }

    private void loadMine() {
        getSupportFragmentManager().beginTransaction()
                .show(fragments[2])
                .hide(fragments[0])
                .hide(fragments[1])
                .commit();
    }


    private void loadCart() {
        getSupportFragmentManager().beginTransaction()
                .show(fragments[1])
                .hide(fragments[0])
                .hide(fragments[2])
                .commit();
    }

    private void loadHome() {
        getSupportFragmentManager().beginTransaction()
                .show(fragments[0])
                .hide(fragments[1])
                .hide(fragments[2])
                .commit();
    }

    @Override
    public void setSuccess(List<TicketsBean.TbkDgItemCouponGetResponseBean.ResultsBean.TbkCouponBean> tbk_coupon) {

    }
}
