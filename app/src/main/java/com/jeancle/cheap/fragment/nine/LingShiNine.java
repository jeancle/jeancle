package com.jeancle.cheap.fragment.nine;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.page.AlibcPage;
import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseFragment;
import com.jeancle.cheap.util.UrlUtils;

/**
 * Created by Administrator on 2017-6-2.
 */

public class LingShiNine extends BaseFragment {
    public WebView mWebView;
    public WebView webView;
    public AlibcPage alibcPage;
    private WebChromeClient webChromeClient;
    private WebViewClient webViewClient;
    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.jiukuaijiu, container, false);
    }

    @Override
    protected void setControlBasis() {
        mWebView = (WebView) findViewById(R.id.wv_cart);
        webChromeClient = new WebChromeClient();
        webViewClient = new WebViewClient();
        mWebView.setOnKeyListener(backlistener);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setBuiltInZoomControls(true);
    }

    @Override
    protected void prepareData() {
        alibcPage = new AlibcPage(UrlUtils.cheapTicket);

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            AlibcTrade.show(getActivity(),  mWebView, webViewClient, webChromeClient, alibcPage, new AlibcShowParams(OpenType.H5, false),
                    null, null, new AlibcTradeCallback() {

                        @Override
                        public void onTradeSuccess(TradeResult tradeResult) {

                        }


                        @Override
                        public void onFailure(int i, String s) {

                        }
                    });
        }
    }
    private View.OnKeyListener backlistener =new View.OnKeyListener(){

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if   ((keyCode == KeyEvent. KEYCODE_BACK ) &&   mWebView.canGoBack()) {
                mWebView.goBack();
                return   true ;
            }
            return false;
        }
    };

}
