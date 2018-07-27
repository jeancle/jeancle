package com.jeancle.cheap.util;

import android.util.Log;

import com.google.gson.Gson;
import com.jeancle.cheap.bean.GoodsBean;
import com.jeancle.cheap.bean.TicketsBean;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-10-14.
 */

public class GetGoodsListUtil {
    GetGoodsFace goodsFace;
    GetTicketsFace ticketsFace;

    public GetGoodsListUtil(GetGoodsFace goodsFace) {
        this.goodsFace = goodsFace;
    }

    public GetGoodsListUtil(GetTicketsFace ticketsFace) {
        this.ticketsFace = ticketsFace;
    }


    public void getGoodsList(String classifyName, String page_no, String page_size) {
        String time = null;
        try {
            time = longToString(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");

            String signSecret = "be56dcbf2730baaecad0fcdf90d47df3" +
                    "app_key23772830" +
                    "fieldsnum_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick" +
                    "formatjson" +
                    "methodtaobao.tbk.item.get" +
                    "page_no" + NumberFormat.getInstance().parse(page_no) +
                    "page_size" + NumberFormat.getInstance().parse(page_size) +
                    "q" + classifyName +
                    "sign_methodmd5" +
                    "sorttotal_sales" +
                    "timestamp" + time +
                    "v2.0be56dcbf2730baaecad0fcdf90d47df3";
            byte[] bytes1 = signSecret.getBytes("UTF-8");
            String string = MD5.md5(bytes1);

            String url = "http://gw.api.taobao.com/router/rest?" +
                    "sign=" + string.toUpperCase() +
                    "&timestamp=" + time +
                    "&v=2.0" +
                    "&app_key=23772830&method=taobao.tbk.item.get" +
                    "&q=" + classifyName +
                    "&sort=total_sales" +//按销量
                    "&page_no=" + NumberFormat.getInstance().parse(page_no) +
                    "&page_size=" + NumberFormat.getInstance().parse(page_size) +
                    "&sign_method=md5&" +
                    "format=json" +
                    "&fields=num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick";
            NetWorkUtils.getData(url, new HttpUtils.ResponseHandler() {
                @Override
                public void onSuccess(String result) {
                    Gson gson = new Gson();
                    TicketsBean goodsBean = gson.fromJson(result, TicketsBean.class);
                    List<TicketsBean.TbkDgItemCouponGetResponseBean.ResultsBean.TbkCouponBean> tbk_coupon = goodsBean.getTbk_dg_item_coupon_get_response().getResults().getTbk_coupon();
                    Log.e("result==============", result);
                    ticketsFace.setSuccess(tbk_coupon);
                }

                @Override
                public void onFailure() {

                }
            });


        } catch (ParseException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public interface GetGoodsFace {
        void setSuccess(List<GoodsBean.TbkItemGetResponseBean.ResultsBean.NTbkItemBean> list);
    }

    public interface GetTicketsFace {
        void setSuccess(List<TicketsBean.TbkDgItemCouponGetResponseBean.ResultsBean.TbkCouponBean> tbk_coupon);
    }

//获取优惠券列表
// sign=6EE4E656061281EC3522F03609037E47
// http://gw.api.taobao.com/router/rest?
// app_key=2466625
// &adzone_id=143876757
// &force_sensitive_param_fuzzy=true
// &format=json
// 8&method=taobao.tbk.dg.item.coupon.get
// &partner_id=top-apitools
// &platform
// &q=%E5%A5%B3%E8%A1%AC%E8%A1%A3
// &sign_method=MD5
// &timestamp=2017-10-24+21%3A02%3A29
// &v=2.0&

    public void getTicketsList(String classifyName, String page_no, String page_size) {
        String time = null;
        try {
            time = longToString(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");

            String signSecret = "0c06aafa4c33f90b635fa0b1dccb2328" +
                    "adzone_id143876757" +
                    "app_key24666258" +
                    "formatjson" +
                    "methodtaobao.tbk.dg.item.coupon.get" +
                    "page_no" + NumberFormat.getInstance().parse(page_no) +
                    "page_size" + NumberFormat.getInstance().parse(page_size) +
                    "platform2" +
                    "q" + classifyName +
                    "sign_methodmd5" +
                    "timestamp" + time +
                    "v2.00c06aafa4c33f90b635fa0b1dccb2328";
            byte[] bytes1 = signSecret.getBytes("UTF-8");
            String string = MD5.md5(bytes1);

            String url = "http://gw.api.taobao.com/router/rest?" +
                    "sign=" + string.toUpperCase() +
                    "&app_key=24666258" +
                    "&adzone_id=" + NumberFormat.getInstance().parse(143876757 + "") +
                    "&format=json" +
                    "&method=taobao.tbk.dg.item.coupon.get" +
                    "&page_no=" + NumberFormat.getInstance().parse(page_no) +
                    "&page_size=" + NumberFormat.getInstance().parse(page_size) +
                    "&platform=" + NumberFormat.getInstance().parse(2 + "") +
                    "&q=" + classifyName +
                    "&sign_method=md5" +
                    "&timestamp=" + time +
                    "&v=2.0";
            NetWorkUtils.getData(url, new HttpUtils.ResponseHandler() {
                @Override
                public void onSuccess(String result) {
                    Log.e("result==============", result);
                    Gson gson = new Gson();
                    TicketsBean ticketsBean = gson.fromJson(result, TicketsBean.class);
                    List<TicketsBean.TbkDgItemCouponGetResponseBean.ResultsBean.TbkCouponBean> tbk_coupon = ticketsBean.getTbk_dg_item_coupon_get_response().getResults().getTbk_coupon();
                    ticketsFace.setSuccess(tbk_coupon);
                }

                @Override
                public void onFailure() {

                }
            });


        } catch (ParseException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
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
}
