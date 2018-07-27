package com.jeancle.cheap.activity.login;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseActivity;

import org.xutils.view.annotation.ContentView;

@ContentView(R.id.activity_forget_pwd)
public class FindPwdActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_findpwd_phone;
    private TextView tv_findpwd_getcode;
    private EditText et_findpwd_code;
    private EditText et_findpwd_new_pwd;
    private EditText et_findpwd_confirm_pwd;
    private TextView tv_findpwd_confirm;
    private ImageView iv_left;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected void setControlBasis() {
        setTitle("找回密码");
        leftDrawable(R.drawable.back);
        et_findpwd_phone = (EditText) findViewById(R.id.et_findpwd_phone);
        tv_findpwd_getcode = (TextView) findViewById(R.id.tv_findpwd_getcode);
        et_findpwd_code = (EditText) findViewById(R.id.et_findpwd_code);
        et_findpwd_new_pwd = (EditText) findViewById(R.id.et_findpwd_new_pwd);
        et_findpwd_confirm_pwd = (EditText) findViewById(R.id.et_findpwd_confirm_pwd);
        tv_findpwd_confirm = (TextView) findViewById(R.id.tv_findpwd_confirm);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_left.setOnClickListener(this);
        tv_findpwd_getcode.setOnClickListener(this);
        tv_findpwd_confirm.setOnClickListener(this);
    }

    @Override
    protected void prepareData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_findpwd_getcode:

                break;
            case R.id.tv_findpwd_confirm:

                break;
        }
    }
}
