package com.jeancle.cheap.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jeancle
 * on 2017/4/7.
 * 类说明:网络请求工具
 */

public class HttpUtils {
    //获取当前设备的CPU数
    public static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    //核心池大小设为CPU数加1
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    //设置线程池的最大大小
    private static final int MAX_POOL_SIZE = 2 * CPU_COUNT + 1;
    //存活时间
    private static final long KEEP_ALIVE = 5L;
    //创建线程池对象
    public static final Executor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,
            MAX_POOL_SIZE, KEEP_ALIVE, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    public static void get(final String url, final ResponseHandler responseHandler) {
        final Handler mHandler = new Handler(Looper.getMainLooper());
        /**
         * 待完善  需要详细区分 result为空时的原因
         */
        //创建一个新的请求任务
        Runnable requestRunnable = new Runnable() {
            @Override
            public void run() {
                final String result = new HttpUtil().MethodGet(url);
                if (result != null) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            //result不为空表明请求成功，回调onSuccess方法
                            responseHandler.onSuccess(result);
                        }
                    });
                } else {
                    responseHandler.onFailure();
                }
            }
        };
        threadPoolExecutor.execute(requestRunnable);
    }

    public static void post(final String url, final Map param, final ResponseHandler responseHandler) {
        final Handler mHandler = new Handler(Looper.getMainLooper());
/**
 * 待完善  需要详细区分 result为空时的原因
 */
        //创建一个新的请求任务
        Runnable requestRunnable = new Runnable() {
            @Override
            public void run() {
                final String result = new HttpUtil().MethodPost(url, param);
                if (result != null) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            //result不为空表明请求成功，回调onSuccess方法
                            responseHandler.onSuccess(result);
                        }
                    });
                } else {
                    responseHandler.onFailure();
                }
            }
        };
        threadPoolExecutor.execute(requestRunnable);
    }

    public interface ResponseHandler {
        void onSuccess(String result);

        void onFailure();
    }

    public static class HttpUtil {
        /**
         * Get请求
         */
        public String MethodGet(String path) {
            Log.e(">>>>>>>>>", "11===2222");
            HttpURLConnection connection = null;
            try {
                URL url = new URL(path);
                connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setUseCaches(false);
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("GET");
                connection.connect();
                Log.e(">>>>>>>>>", "11===3333");
                if (connection.getResponseCode() == 200) {
                    InputStream inputStream = connection.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(inputStream);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    int line = 0;
                    while ((line = bis.read()) != -1) {
                        bos.write(line);
                    }
                    bis.close();
                    bos.close();
                    inputStream.close();
                    byte[] bytes = bos.toByteArray();
                    String data = new String(bytes);
                    Log.e(">>>>>>>>>", "11===" + data);
                    return data;
                } else {
                    Log.e(">>>>>>>>>", "请求失败");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
            return null;
        }


        /**
         * Post请求
         */
        public String MethodPost(String url, Map param) {
            String outCharset = null;

            if (outCharset == null) {
                outCharset = "UTF-8";
            }
            HttpURLConnection conn = null;
            try {
                URL u = new URL(url);
                conn = (HttpURLConnection) u.openConnection();
                StringBuffer sb = null;
                if (param != null) {//如果请求参数不为空
                    Log.e("======", "请求了");
                    sb = new StringBuffer();
                    //默认为false,post方法需要写入参数,设定true
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    //设定post方法,默认get
                    //获得输出流
                    OutputStream out = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, outCharset));
                    //将参数封装成键值对的形式
                    Iterator iterator = param.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry next = (Map.Entry) iterator.next();
                        sb.append(next.getKey()).append("=").append(next.getValue()).append("&");
                    }
                    writer.write(sb.deleteCharAt(sb.toString().length() - 1).toString());
                    writer.close();//如果忘记关闭输出流将造成参数未完全写入的情况
                }
                conn.connect();//建立连接
                if (conn.getResponseCode() == 200) {
                    InputStream in = conn.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(in);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    int line = 0;
                    while ((line = bis.read()) != -1) {
                        bos.write(line);
                    }
                    bis.close();
                    bos.close();
                    in.close();
                    byte[] bytes = bos.toByteArray();
                    return new String(bytes);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                if (conn != null)//关闭连接
                    conn.disconnect();
            }

            return null;
        }


    }
}
