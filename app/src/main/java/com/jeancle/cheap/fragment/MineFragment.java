package com.jeancle.cheap.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.adapter.login.AlibcLogin;
import com.alibaba.baichuan.android.trade.callback.AlibcLoginCallback;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.page.AlibcMyOrdersPage;
import com.alibaba.baichuan.android.trade.page.AlibcPage;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jeancle.cheap.activity.SettingActivity;
import com.jeancle.cheap.base.BaseFragment;
import com.jeancle.cheap.util.UrlUtils;
import com.jeancle.cheap.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * Created by Administrator on 2017-6-2.
 */
@ContentView(R.layout.mine_fragment)
public class MineFragment extends BaseFragment implements View.OnClickListener {


    private ImageView iv_headimg;
    private TextView tv_nick;
    private TextView tv_mine_cart;
    private TextView tv_mine_collection;
    private TextView tv_mine_ulike;
    private TextView tv_mine_setting;
    private TextView tv_mine_order;
    private LinearLayout ll_mine_cheap;
    private LinearLayout ll_mine_share;
    private LinearLayout ll_mine_watchtv;
    private String headImg;
    private String nick;
    private AlibcPage alibcPage;
    private AlibcMyOrdersPage alibcMyOrdersPage;


    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view =  x.view().inject(this, inflater, container);
    }

    @Override
    protected void setControlBasis() {
        iv_headimg = (ImageView) view.findViewById(R.id.iv_headimg);
        tv_nick = (TextView) view.findViewById(R.id.tv_nick);
        tv_mine_cart = (TextView) view.findViewById(R.id.tv_mine_cart);
        tv_mine_collection = (TextView) view.findViewById(R.id.tv_mine_collection);
        tv_mine_ulike = (TextView) view.findViewById(R.id.tv_mine_ulike);
        tv_mine_setting = (TextView) view.findViewById(R.id.tv_mine_setting);
        tv_mine_order = (TextView) view.findViewById(R.id.tv_mine_order);
        ll_mine_cheap = (LinearLayout) view.findViewById(R.id.ll_mine_cheap);
        ll_mine_share = (LinearLayout) view.findViewById(R.id.ll_mine_share);
        ll_mine_watchtv = (LinearLayout) view.findViewById(R.id.ll_mine_watchtv);
        tv_nick.setOnClickListener(this);
        tv_mine_cart.setOnClickListener(this);
        tv_mine_collection.setOnClickListener(this);
        tv_mine_ulike.setOnClickListener(this);
        ll_mine_cheap.setOnClickListener(this);
        ll_mine_share.setOnClickListener(this);
        ll_mine_watchtv.setOnClickListener(this);
        tv_mine_setting.setOnClickListener(this);
        tv_mine_order.setOnClickListener(this);
        iv_headimg.setOnClickListener(this);

    }

    @Override
    protected void prepareData() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_nick:
                 final AlibcLogin alibcLogin = AlibcLogin.getInstance();

                if (!alibcLogin.isLogin()) {
                    alibcLogin.showLogin(getActivity(), new AlibcLoginCallback() {
                        @Override
                        public void onSuccess() {
                            Log.e("--------","成功了");
                            Glide.with(getActivity()).load(alibcLogin.getSession().avatarUrl).apply(new RequestOptions().circleCrop()).into(iv_headimg);
                            tv_nick.setText(alibcLogin.getSession().nick);
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Log.e("--------",s);
                            tv_nick.setText("点我立即登录");
                            Glide.with(getActivity()).load(R.drawable.default_head).into(iv_headimg);
                        }
                    });
                }
                break;
            case R.id.tv_mine_cart:
                showPage(UrlUtils.cart);
                break;
            case R.id.tv_mine_order:
                AlibcMyOrdersPage alibcMyOrdersPage = new AlibcMyOrdersPage(0, false);
                AlibcTrade.show(getActivity(), alibcMyOrdersPage, new AlibcShowParams(OpenType.Native, false),
                        null, null, new AlibcTradeCallback() {

                            @Override
                            public void onTradeSuccess(TradeResult tradeResult) {

                            }


                            @Override
                            public void onFailure(int i, String s) {

                            }
                        });
                break;
            case R.id.tv_mine_collection:
                showPage(UrlUtils.collection);
                break;
            case R.id.tv_mine_ulike:
                showPage("");
                break;
            case R.id.ll_mine_cheap:
                showPage("");
                break;

            case R.id.ll_mine_share:
                showPage("");
                break;
            case R.id.ll_mine_watchtv:
                break;
            case R.id.tv_mine_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;


        }

    }

    private void showPage(String url) {
        alibcPage = new AlibcPage(url);
        AlibcTrade.show(getActivity(), alibcPage, new AlibcShowParams(OpenType.Native, false),
                null, null, new AlibcTradeCallback() {

                    @Override
                    public void onTradeSuccess(TradeResult tradeResult) {

                    }


                    @Override
                    public void onFailure(int i, String s) {

                    }
                });

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if ( AlibcLogin.getInstance().isLogin()) {
//            Glide.with(getActivity()).load(alibcLogin.getSession().avatarUrl).apply(new RequestOptions().circleCrop()).into(iv_headimg);
//            tv_nick.setText(alibcLogin.getSession().nick);
        } else {
//            tv_nick.setText("点我立即登录");
//            Glide.with(getActivity()).load(R.drawable.default_head).into(iv_headimg);

        }
    }

}
