package com.jeancle.cheap.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.page.AlibcPage;
import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static com.jeancle.cheap.R.id.wv_cart;

@ContentView(R.layout.activity_goods_detail)
public class GoodsDetailActivity extends BaseActivity {
    @ViewInject(R.id.iv_left)
    private ImageView iv_left;
    @ViewInject(R.id.wv_detail)
    private WebView wv_detail;
    private String url;
    private AlibcPage alibcPage;
    private WebChromeClient webChromeClient;
    private WebViewClient webViewClient;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected void setControlBasis() {
        x.view().inject(this);
        setTitle("商品详情");
        leftDrawable(R.drawable.back);

    }

    @Override
    protected void prepareData() {
        webChromeClient = new WebChromeClient();
        webViewClient = new WebViewClient();
        WebSettings webSettings = wv_detail.getSettings();
        webSettings.setBuiltInZoomControls(true);
        wv_detail.setOnKeyListener(backlistener);
        url = getIntent().getStringExtra("url");
        alibcPage = new AlibcPage(url);
        //设置页面打开方式
        AlibcTrade.show(this, wv_detail, webViewClient, webChromeClient, alibcPage, new AlibcShowParams(OpenType.Native, false), null, null, new AlibcTradeCallback() {

            @Override
            public void onTradeSuccess(TradeResult tradeResult) {

            }


            @Override
            public void onFailure(int i, String s) {

            }
        });

    }

    @Event(R.id.iv_left)
    private void iv_left(View view) {
        finish();
    }

    private View.OnKeyListener backlistener = new View.OnKeyListener() {

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if ((keyCode == KeyEvent.KEYCODE_BACK) && wv_detail.canGoBack()) {
                wv_detail.goBack();
                return true;
            }
            return false;
        }
    };
}
