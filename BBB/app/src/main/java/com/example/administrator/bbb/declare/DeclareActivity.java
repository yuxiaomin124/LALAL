package com.example.administrator.bbb.declare;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseActivity;


/**
 * Created by Administrator on 2016-9-30.
 */
public class DeclareActivity extends BaseActivity implements View.OnClickListener {
    private Button btnLogin,btnRegister;

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_declare_login:
                Intent intentLogin = new Intent(this,RegisterUserActivity.class);
                startActivityForResult(intentLogin,200);
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
