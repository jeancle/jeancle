package com.jeancle.cheap.util;

import com.jeancle.cheap.MyApplication;
import com.jeancle.cheap.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeancle
 * on 2017/4/10.
 * 类说明:
 */

public class NetWorkUtils {


    protected MyApplication application;
    private static NetWorkUtils networkUtils;

    public static NetWorkUtils getNetworkUtils() {
        if (networkUtils == null) {
            networkUtils = new NetWorkUtils();
        }
        return networkUtils;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }

    private String getUrl(int id) {
        return application.getResources().getString(id);
    }

    /**
     * 测试数据
     */
    public void test(String key, HttpUtils.ResponseHandler responseHandler) {
        Map parem = new HashMap();
        parem.put("key", key);
        String url = getUrl(R.string.test);
        HttpUtils.post(url, parem, responseHandler);
    }

    /**
     * 新闻
     */
    public void getNews(String type, String key, HttpUtils.ResponseHandler responseHandler) {
        Map parem = new HashMap();
        parem.put("key", key);
        parem.put("type", type);
        String url = getUrl(R.string.news);
        HttpUtils.post(url, parem, responseHandler);
    }
    public static void getData(String url,HttpUtils.ResponseHandler responseHandler) {
        HttpUtils.get(url, responseHandler);
    }
}
