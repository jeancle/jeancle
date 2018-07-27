package com.jeancle.cheap.activity.login;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseActivity;

import org.xutils.view.annotation.ContentView;

@ContentView(R.id.activity_register)
public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_register_account;
    private EditText et_register_pwd;
    private EditText viewById;
    private TextView tv_register;
    private ImageView iv_left;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected void setControlBasis() {
        leftDrawable(R.drawable.back);
        setTitle("注册");
        et_register_account = (EditText) findViewById(R.id.et_register_account);
        et_register_pwd = (EditText) findViewById(R.id.et_register_pwd);
        viewById = (EditText) findViewById(R.id.et_register_confirm_pwd);
        tv_register = (TextView) findViewById(R.id.tv_register);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_left.setOnClickListener(this);
        tv_register.setOnClickListener(this);

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
            case R.id.tv_register:

                break;
        }
    }
}
