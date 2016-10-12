package com.example.administrator.bbb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.example.administrator.bbb.collect.CollectFragment;
import com.example.administrator.bbb.declare.DeclareActivity;
import com.example.administrator.bbb.first.FirstFragment;
import com.example.administrator.bbb.my.MyFragment;
import com.example.administrator.bbb.order.OrderFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rbtnFirst, rbtnCollect, rbtnDeclare, rbtnOrder, rbtnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }


    private void initView() {
        rbtnFirst = (RadioButton) findViewById(R.id.rbtn_first);
        rbtnCollect = (RadioButton) findViewById(R.id.rbtn_collect);
        rbtnDeclare = (RadioButton) findViewById(R.id.rbtn_declare);
        rbtnOrder = (RadioButton) findViewById(R.id.rbtn_order);
        rbtnMy = (RadioButton) findViewById(R.id.rbtn_my);
    }

    private void initData() {
        rbtnFirst.setOnClickListener(this);
        rbtnCollect.setOnClickListener(this);
        rbtnDeclare.setOnClickListener(this);
        rbtnOrder.setOnClickListener(this);
        rbtnMy.setOnClickListener(this);

        replaceFragment(R.id.frame_replaceFr, new FirstFragment());

        rbtnFirst.setTextColor(0xffff4401);
        rbtnCollect.setTextColor(0xff6d6d6d);
        rbtnDeclare.setTextColor(0xff6d6d6d);
        rbtnOrder.setTextColor(0xff6d6d6d);
        rbtnMy.setTextColor(0xff6d6d6d);

        BroadcastRegister();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbtn_first:
                replaceFragment(R.id.frame_replaceFr, new FirstFragment());

                rbtnFirst.setTextColor(0xfaf4810d);
                rbtnCollect.setTextColor(0xff6d6d6d);
                rbtnDeclare.setTextColor(0xff6d6d6d);
                rbtnOrder.setTextColor(0xff6d6d6d);
                rbtnMy.setTextColor(0xff6d6d6d);
                break;
            case R.id.rbtn_collect:
                replaceFragment(R.id.frame_replaceFr, new CollectFragment());
                rbtnFirst.setTextColor(0xff6d6d6d);
                rbtnCollect.setTextColor(0xfaf4810d);
                rbtnDeclare.setTextColor(0xff6d6d6d);
                rbtnOrder.setTextColor(0xff6d6d6d);
                rbtnMy.setTextColor(0xff6d6d6d);
                break;
            case R.id.rbtn_declare:
                Intent intent = new Intent(this, DeclareActivity.class);
                startActivity(intent);
                rbtnFirst.setTextColor(0xff6d6d6d);
                rbtnCollect.setTextColor(0xff6d6d6d);
                rbtnDeclare.setTextColor(0xfaf4810d);
                rbtnOrder.setTextColor(0xff6d6d6d);
                rbtnMy.setTextColor(0xff6d6d6d);

                break;
            case R.id.rbtn_order:
                replaceFragment(R.id.frame_replaceFr, new OrderFragment());
                rbtnFirst.setTextColor(0xff6d6d6d);
                rbtnCollect.setTextColor(0xff6d6d6d);
                rbtnDeclare.setTextColor(0xff6d6d6d);
                rbtnOrder.setTextColor(0xfaf4810d);
                rbtnMy.setTextColor(0xff6d6d6d);
                break;
            case R.id.rbtn_my:
                replaceFragment(R.id.frame_replaceFr, new MyFragment());
                rbtnFirst.setTextColor(0xff6d6d6d);
                rbtnCollect.setTextColor(0xff6d6d6d);
                rbtnDeclare.setTextColor(0xff6d6d6d);
                rbtnOrder.setTextColor(0xff6d6d6d);
                rbtnMy.setTextColor(0xfaf4810d);
                break;
        }
    }

    public void replaceFragment(int id, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.commit();
    }

    private BroadcastReceiver mBReceiverLoginSuccess = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                case MyFragment.ACTION_TAB:

                    replaceFragment(R.id.frame_replaceFr, new OrderFragment());
                    rbtnOrder.isChecked();
                    rbtnFirst.setTextColor(0xff6d6d6d);
                    rbtnCollect.setTextColor(0xff6d6d6d);
                    rbtnDeclare.setTextColor(0xff6d6d6d);
                    rbtnOrder.setTextColor(0xfaf4810d);
                    rbtnMy.setTextColor(0xff6d6d6d);
                    rbtnOrder.setChecked(true);
                    break;
            }
        }
    };

    private void BroadcastRegister() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MyFragment.ACTION_TAB);
        registerReceiver(mBReceiverLoginSuccess, intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBReceiverLoginSuccess);
    }
}
