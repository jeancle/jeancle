package com.jeancle.cheap.util;

import android.content.Context;
import android.content.res.Resources;

import com.jeancle.cheap.R;

/**
 * Created by Jeancle
 * on 2017/7/19.
 * 类说明:拦截广告
 */

public class ADFilterTool {
    public static boolean hasAd(Context context, String url) {
        Resources res = context.getResources();
        String[] adUrls = res.getStringArray(R.array.adBlockUrl);
        for (String adUrl : adUrls) {
            if (url.contains(adUrl)) {
                return true;
            }
        }
        return false;
    }
}
