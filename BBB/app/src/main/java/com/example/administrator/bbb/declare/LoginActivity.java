package com.example.administrator.bbb.declare;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseActivity;


/**
 * Created by Administrator on 2016-10-4.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private Button btnLogin;

    @Override
    protected int initLayout() {
        return R.layout.activity_declare_login;
    }

    @Override
    protected void initView() {

        btnLogin = (Button) findViewById(R.id.btn_declare_login_makesure);
    }

    @Override
    protected void initData() {

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_declare_login_makesure:
                Intent intent = new Intent();
                int resultCode = 200;
                intent.putExtra("back", "logined");
                this.setResult(resultCode,intent);
                finish();
                break;
        }
    }
}
