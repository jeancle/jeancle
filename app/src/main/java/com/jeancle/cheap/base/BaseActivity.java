package com.jeancle.cheap.base;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.jeancle.cheap.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeancle
 * on 2017/4/5.
 * 类说明:
 */
public abstract class BaseActivity extends FragmentActivity {
    private static final int REQUEST_WRITE_STORAGE = 112;
    private long exitTime = 0;
    private List<Activity> list = new ArrayList();


    /**
     * 返回键
     */
    protected abstract void back();

    /**
     * 初始化控件
     */
    protected abstract void setControlBasis();

    /**
     * 准备数据
     */
    protected abstract void prepareData();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.add(this);
        if (!isPower()) {
            return;
        }
        power();

    }

    /**
     * 判断是否有权限
     */
    private boolean isPower() {
        //是否拥有读写文件的权限,Android6.0及以上需开发者格外注意权限问题.
        boolean hasPermission = (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        if (!hasPermission) {
            //申请权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 112);
            return false;
        }

        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length <= 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            //无权限
            makeText("请开启权限");
        } else {
            //有权限
//            makeText("onRequestPermissionsResult 有权限");
            power();
        }
    }

    /**
     * 有权限操作
     */
    private void power() {
        setControlBasis();
        prepareData();

    }

    /**
     * 设置布局
     */
    protected void bindLayout(int ResId) {
        setContentView(ResId);
    }

    /**
     * 描述：退出程序
     */
    protected void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Log.e(getLocalClassName(), "再按一次退出程序");
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            Log.e(getLocalClassName(), "exit");

            for (int i = 0; i < list.size(); i++) {
                list.get(i).finish();
            }
            list.clear();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            back();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 设置左侧图片
     */
    protected void leftDrawable(int drawable) {
        ImageView iv_left = (ImageView) findViewById(R.id.iv_left);
        if (iv_left != null) {
            iv_left.setVisibility(View.VISIBLE);
            iv_left.setImageResource(drawable);
        }
    }

    /**
     * 设置右侧图片
     */
    protected void rightDrawable(int drawable) {
        ImageView iv_right = (ImageView) findViewById(R.id.iv_right);

        if (iv_right != null) {
            iv_right.setVisibility(View.VISIBLE);
            iv_right.setImageResource(drawable);
        }
    }

    /**
     * 设置左侧文字
     */
    protected void leftText(String text) {
        TextView tv_left = (TextView) findViewById(R.id.tv_left);
        if (tv_left != null) {
            tv_left.setVisibility(View.VISIBLE);
            tv_left.setText(text);

        }
    }

    /**
     * 设置右侧文字
     */
    protected void rightText(String text) {
        TextView tv_right = (TextView) findViewById(R.id.tv_right);
        if (tv_right != null) {
            tv_right.setVisibility(View.VISIBLE);
            tv_right.setText(text);

        }
    }

    /**
     * 设置标题
     */
    protected void setTitle(String text) {
        TextView tv_title = (TextView) findViewById(R.id.tv_title_classify);
        if (tv_title != null) {
            tv_title.setVisibility(View.VISIBLE);
            tv_title.setText(text);
        }
    }

    protected void makeText(final String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AlibcTradeSDK.destory();
    }
    public void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
