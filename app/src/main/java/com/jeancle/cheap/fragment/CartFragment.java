package com.jeancle.cheap.fragment;

import android.os.Build;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.page.AlibcPage;
import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseFragment;
import com.jeancle.cheap.util.UrlUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2017-6-2.
 */
@ContentView(R.layout.cart_fragment)
public class CartFragment extends BaseFragment {
    @ViewInject(R.id.wv_cart)
    private WebView wv_cart;
    private AlibcPage alibcPage;
    private WebChromeClient webChromeClient;
    private WebViewClient webViewClient;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = x.view().inject(this, inflater, container);
    }

    @Override
    protected void setControlBasis() {
        webChromeClient = new WebChromeClient();
        webViewClient = new WebViewClient();
//        wv_cart.setOnKeyListener(backlistener);
        WebSettings webSettings = wv_cart.getSettings();
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
            AlibcTrade.show(getActivity(), wv_cart, webViewClient, webChromeClient, alibcPage, new AlibcShowParams(OpenType.H5, false),
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

    private View.OnKeyListener backlistener = new View.OnKeyListener() {

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if ((keyCode == KeyEvent.KEYCODE_BACK) && wv_cart.canGoBack()) {
                wv_cart.goBack();
                return true;
            }
            return false;
        }
    };

}
