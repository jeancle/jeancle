package com.jeancle.cheap.demo;

import android.util.Log;

import com.google.gson.Gson;
import com.jeancle.cheap.bean.TestBean;
import com.jeancle.cheap.util.HttpUtils;
import com.jeancle.cheap.util.NetWorkUtils;

import java.util.List;

/**
 * Created by Jeancle
 * on 2017/4/10.
 * 类说明:
 */

public class HomeUIP {
    public NewsUIface face;

    public HomeUIP(NewsUIface face) {
        this.face = face;
    }

    public void getNews(String type, String key) {
        NetWorkUtils.getNetworkUtils().getNews(type, key, new HttpUtils.ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                Log.e("jeancle==", result);
                Gson gson = new Gson();
                TestBean bean = gson.fromJson(result, TestBean.class);
                List<TestBean.ResultBean.DataBean> data = bean.getResult().getData();
                if (data != null && data.size() > 0) {
                    face.getData(data);
                }
            }

            @Override
            public void onFailure() {

            }
        });
    }

    public interface NewsUIface {
        void getData(List<TestBean.ResultBean.DataBean> data);
    }
}
