package com.jeancle.cheap.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.ImageView;

import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

@ContentView(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {
    private boolean isFirst = true;
    private ImageView iv_background;

    @Override
    protected void back() {
    }

    @Override
    protected void setControlBasis() {
        x.view().inject(this);
        iv_background = (ImageView) findViewById(R.id.iv_background);
    }

    @Override
    protected void prepareData() {
        initState();
        Message message = handler.obtainMessage(100);
        handler.sendMessageDelayed(message, 1500);
    }

    final Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                    boolean isFirst = preferences.getBoolean("isFirst", true);
                    if (isFirst) {
                        isFirst = false;
                        SharedPreferences data = getSharedPreferences("data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = data.edit();
                        editor.putBoolean("isFirst", isFirst);
                        editor.commit();
                        Intent intent = new Intent(SplashActivity.this, WelcomeActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    finish();
                    break;
            }

            super.handleMessage(msg);
        }
    };

    public void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

}
