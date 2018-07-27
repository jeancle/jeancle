package com.jeancle.cheap.activity.login;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseActivity;

import org.xutils.view.annotation.ContentView;

@ContentView(R.id.activity_login)
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    public TextView tv_register;
    public EditText et_account;
    public EditText et_pwd;
    public TextView tv_login;
    public TextView tv_forget;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected void setControlBasis() {
        tv_register = (TextView) findViewById(R.id.tv_register);
        et_account = (EditText) findViewById(R.id.et_account);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        tv_login = (TextView) findViewById(R.id.tv_login);
        tv_forget = (TextView) findViewById(R.id.tv_forget);
        tv_register.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        tv_forget.setOnClickListener(this);
    }

    @Override
    protected void prepareData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login:

                break;
            case R.id.tv_forget:
                Intent intent1 = new Intent(this, FindPwdActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
