package com.example.administrator.bbb.declare;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseActivity;


/**
 * Created by Administrator on 2016-9-30.
 */
public class DeclareActivity extends BaseActivity implements View.OnClickListener {
    private Button btnLogin,btnRegister;
    private Intent mIntentLogin;
    public static final String ACTION_LOGIN_SUCCESS = "com.example.administrator.bbb.ACTION_LOGIN_SUCCESS";

    @Override
    protected int initLayout() {
        return R.layout.activity_declare;
    }

    @Override
    protected void initView() {
        btnLogin = (Button) findViewById(R.id.btn_declare_login);
        btnRegister = (Button) findViewById(R.id.btn_declare_register);
    }

    @Override
    protected void initData() {
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        mIntentLogin = new Intent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_declare_login:

                mIntentLogin.putExtra("declareSuccess", "登录成功");
                mIntentLogin.setAction(ACTION_LOGIN_SUCCESS);
                sendBroadcast(mIntentLogin);

                SharedPreferences sp = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("Boolean",true);
                editor.apply();

                finish();
                break;
            case R.id.btn_declare_register:
                Intent intentRegister = new Intent(this,RegisterUserActivity.class);
                startActivity(intentRegister);
                finish();
                break;
        }
    }
}
