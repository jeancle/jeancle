package com.jeancle.cheap.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ali.auth.third.login.callback.LogoutCallback;
import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.adapter.login.AlibcLogin;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.page.AlibcPage;
import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static com.jeancle.cheap.util.UrlUtils.address;
@ContentView(R.layout.activity_setting)
public class SettingActivity extends BaseActivity implements View.OnClickListener {
    @ViewInject(R.id.tv_setting_cash)
    private TextView tv_setting_cash;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected void setControlBasis() {
        x.view().inject(this);
        leftDrawable(R.drawable.back);
        setTitle("设置");
        TextView tv_setting_address = (TextView) findViewById(R.id.tv_setting_address);
        TextView tv_setting_aboutus = (TextView) findViewById(R.id.tv_setting_aboutus);
        tv_setting_cash = (TextView) findViewById(R.id.tv_setting_cash);
        TextView tv_setting_check = (TextView) findViewById(R.id.tv_setting_check);
        TextView tv_setting_exit = (TextView) findViewById(R.id.tv_setting_exit);
        LinearLayout ll_setting_clear = (LinearLayout) findViewById(R.id.ll_setting_clear);
        tv_setting_address.setOnClickListener(this);
        tv_setting_aboutus.setOnClickListener(this);
        tv_setting_cash.setOnClickListener(this);
        tv_setting_check.setOnClickListener(this);
        tv_setting_exit.setOnClickListener(this);
        ll_setting_clear.setOnClickListener(this);

    }

    @Override
    protected void prepareData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_setting_address:
                AlibcPage alibcPage = new AlibcPage(address);
                AlibcTrade.show(this, alibcPage, new AlibcShowParams(OpenType.Native, false),
                        null, null, new AlibcTradeCallback() {

                            @Override
                            public void onTradeSuccess(TradeResult tradeResult) {

                            }


                            @Override
                            public void onFailure(int i, String s) {

                            }
                        });
                break;
            case R.id.tv_setting_aboutus:

                break;
            case R.id.ll_setting_clear:

                break;
            case R.id.tv_setting_check:

                break;
            case R.id.tv_setting_exit:
                AlibcLogin alibcLogin1 = AlibcLogin.getInstance();
                alibcLogin1.logout(this,new LogoutCallback() {
                    @Override
                    public void onSuccess() {
                        startActivity(new Intent(SettingActivity.this, MainActivity.class));

                    }


                    @Override
                    public void onFailure(int i, String s) {

                    }
                });
                break;

        }
    }
}
