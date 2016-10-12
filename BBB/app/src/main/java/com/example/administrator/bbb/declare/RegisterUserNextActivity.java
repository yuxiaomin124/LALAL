package com.example.administrator.bbb.declare;


import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseActivity;

/**
 * Created by Administrator on 2016-10-5.
 */
public class RegisterUserNextActivity extends BaseActivity implements View.OnClickListener {
    private Button btnSure;

    @Override
    protected int initLayout() {
        return R.layout.activity_declare_register_user_next;
    }

    @Override
    protected void initView() {
        btnSure = (Button) findViewById(R.id.btn_declare_register_user_next_sure);

    }

    @Override
    protected void initData() {
        btnSure.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_declare_register_user_next_sure:
                Intent intent = new Intent(this,DeclareActivity.class);
                startActivity(intent);
                break;
        }
    }
}
