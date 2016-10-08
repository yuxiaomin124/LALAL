package com.example.administrator.bbb.declare;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseActivity;


/**
 * Created by Administrator on 2016-10-5.
 */
public class RegisterUserActivity extends BaseActivity implements View.OnClickListener {
    private Button btnNext;

    @Override
    protected int initLayout() {
        return R.layout.activity_declare_register_user;
    }

    @Override
    protected void initView() {
        btnNext = (Button) findViewById(R.id.btn_declare_register_user_next);
    }

    @Override
    protected void initData() {
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_declare_register_user_next:
                Intent intent = new Intent(this,RegisterUserNextActivity.class);
                startActivity(intent);
                break;
        }
    }
}
