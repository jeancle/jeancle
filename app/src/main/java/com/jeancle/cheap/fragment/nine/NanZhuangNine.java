package com.jeancle.cheap.fragment.nine;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.GridView;
import android.widget.ListView;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.page.AlibcPage;
import com.jeancle.cheap.R;
import com.jeancle.cheap.activity.GoodsDetailActivity;
import com.jeancle.cheap.adapter.RecyclerAdapter;
import com.jeancle.cheap.adapter.TypeAdapter;
import com.jeancle.cheap.base.BaseFragment;
import com.jeancle.cheap.bean.GoodsBean;
import com.jeancle.cheap.bean.TicketsBean;
import com.jeancle.cheap.util.GetGoodsListUtil;
import com.jeancle.cheap.util.UrlUtils;
import com.jeancle.cheap.view.MyListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-6-2.
 */
@ContentView(R.layout.jiukuaijiu)
public class NanZhuangNine extends BaseFragment implements GetGoodsListUtil.GetTicketsFace, RecyclerAdapter.OnItemClickListener {
    @ViewInject(R.id.recyclerview)
    private RecyclerView recyclerview;
    private TypeAdapter typeAdapter;
    private RecyclerAdapter recyclerAdapter;
    private GridLayoutManager gridLayoutManager;
    private GetGoodsListUtil util;
    List<TicketsBean.TbkDgItemCouponGetResponseBean.ResultsBean.TbkCouponBean> list;
    private Intent intent;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = x.view().inject(this, inflater, container);
    }

    @Override
    protected void setControlBasis() {

    }

    @Override
    protected void prepareData() {
        list = new ArrayList<>();
        util = new GetGoodsListUtil(this);
        util.getTicketsList("女装", "1", "20");


    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }


    @Override
    public void setSuccess(List<TicketsBean.TbkDgItemCouponGetResponseBean.ResultsBean.TbkCouponBean> tbk_coupon) {
        list = tbk_coupon;
        recyclerAdapter = new RecyclerAdapter(getActivity());
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerview.setLayoutManager(gridLayoutManager);
        recyclerview.setAdapter(recyclerAdapter);
        recyclerAdapter.setOnItemClickListener(this);

        recyclerAdapter.setData(tbk_coupon);
        recyclerAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(int position) {
        intent = new Intent(getActivity(), GoodsDetailActivity.class);
        intent.putExtra("url", list.get(position).getCoupon_click_url());
        startActivity(intent);
    }

    @Override
    public void onLongClick(int position) {

    }
}
