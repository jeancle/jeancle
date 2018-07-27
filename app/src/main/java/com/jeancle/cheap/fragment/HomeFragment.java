package com.jeancle.cheap.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TableLayout;
import android.widget.TextView;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.page.AlibcPage;

import com.jeancle.cheap.R;
import com.jeancle.cheap.adapter.TabAdapter;
import com.jeancle.cheap.base.BaseFragment;
import com.jeancle.cheap.fragment.nine.NanZhuangNine;
import com.jeancle.cheap.util.NoAdWebViewClient;
import com.jeancle.cheap.util.UrlUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-6-2.
 */
@ContentView(R.layout.home_fragment)
public class HomeFragment extends BaseFragment {
    private WebView mWebView;
    private WebChromeClient webChromeClient;
    private NoAdWebViewClient webViewClient;
    private AlibcPage alibcPage;
    @ViewInject(R.id.tv_home_taoqianggou)
    private TextView tv_home_taoqianggou;
    @ViewInject(R.id.tv_home_juhuasuan)
    private TextView tv_home_juhuasuan;
    @ViewInject(R.id.tv_home_lingjinbi)
    private TextView tv_home_lingjinbi;
    @ViewInject(R.id.tv_home_chongzhi)
    private TextView tv_home_chongzhi;
//    @ViewInject(R.id.vp_home_lunbo)
//    private ViewPager vp_home_lunbo;
    @ViewInject(R.id.vp_home_content)
    private ViewPager vp_home_content;
    @ViewInject(R.id.tl_home_title)
    private TabLayout tl_home_title;
    private List<String> titles;
    private List<Fragment> fragments;
    private TabAdapter tabAdapter;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = x.view().inject(this, inflater, container);
    }

    @Override
    protected void setControlBasis() {
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
    }

    @Override
    protected void prepareData() {
        getTitle();
        getFragments();
        tabAdapter = new TabAdapter(getActivity().getSupportFragmentManager(),titles,fragments);
        vp_home_content.setAdapter(tabAdapter);
        tl_home_title.setupWithViewPager(vp_home_content);


//        alibcPage = new AlibcPage(UrlUtils.home);
//        //设置页面打开方式
//        AlibcTrade.show(getActivity(), alibcPage, new AlibcShowParams(OpenType.H5, false), null, null, new AlibcTradeCallback() {
//
//            @Override
//            public void onTradeSuccess(TradeResult tradeResult) {
//
//            }
//
//
//            @Override
//            public void onFailure(int i, String s) {
//
//            }
//        });

    }

    private void getFragments() {
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
        fragments.add(new NanZhuangNine());
    }

    private void getTitle() {
        titles.add("女装");
        titles.add("男装");
        titles.add("女鞋");
        titles.add("男鞋");
        titles.add("童装");
        titles.add("童鞋");
        titles.add("母婴");
        titles.add("内衣");
        titles.add("居家");
        titles.add("美妆");
        titles.add("零食");
        titles.add("家电");
        titles.add("数码");
        titles.add("两性");

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
//        if (!hidden) {
//            AlibcTrade.show(getActivity(), mWebView, webViewClient, webChromeClient, alibcPage, new AlibcShowParams(OpenType.H5, false),
//                    null,null,new AlibcTradeCallback() {
//
//                        @Override
//                        public void onTradeSuccess(TradeResult tradeResult) {
//
//                        }
//
//
//                        @Override
//                        public void onFailure(int i, String s) {
//
//                        }
//                    });
//
//        }
    }

    private View.OnKeyListener backlistener = new View.OnKeyListener() {

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
                mWebView.goBack();
                return true;
            }
            return false;
        }
    };

}
