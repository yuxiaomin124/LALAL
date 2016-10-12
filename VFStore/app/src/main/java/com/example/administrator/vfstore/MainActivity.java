package com.example.administrator.vfstore;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.administrator.vfstore.collect.CollectFragment;
import com.example.administrator.vfstore.declare.DeclareActivity;
import com.example.administrator.vfstore.first.FirstFragment;
import com.example.administrator.vfstore.my.MyFragment;
import com.example.administrator.vfstore.order.OrderFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rbtnFirst, rbtnCollect, rbtnDeclare, rbtnOrder, rbtnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbtnFirst = (RadioButton) findViewById(R.id.rbtn_first);
        rbtnCollect = (RadioButton) findViewById(R.id.rbtn_collect);
        rbtnDeclare = (RadioButton) findViewById(R.id.rbtn_declare);
        rbtnOrder = (RadioButton) findViewById(R.id.rbtn_order);
        rbtnMy = (RadioButton) findViewById(R.id.rbtn_my);

        rbtnFirst.setOnClickListener(this);
        rbtnCollect.setOnClickListener(this);
        rbtnDeclare.setOnClickListener(this);
        rbtnOrder.setOnClickListener(this);
        rbtnMy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rbtn_first:
                replaceFragment(R.id.frame_replaceFr,new FirstFragment());

                rbtnFirst.setTextColor(0xffff4401);
                rbtnCollect.setTextColor(0xff6d6d6d);
                rbtnDeclare.setTextColor(0xff6d6d6d);
                rbtnOrder.setTextColor(0xff6d6d6d);
                rbtnMy.setTextColor(0xff6d6d6d);

                break;
            case R.id.rbtn_collect:
                replaceFragment(R.id.frame_replaceFr,new CollectFragment());
                rbtnFirst.setTextColor(0xfff53235);
                rbtnCollect.setTextColor(0xffff4401);
                rbtnDeclare.setTextColor(0xff6d6d6d);
                rbtnOrder.setTextColor(0xff6d6d6d);
                rbtnMy.setTextColor(0xff6d6d6d);

                break;
            case R.id.rbtn_declare:
                Intent intent = new Intent(this, DeclareActivity.class);
                startActivity(intent);
                rbtnFirst.setTextColor(0xfff53235);
                rbtnCollect.setTextColor(0xff6d6d6d);
                rbtnDeclare.setTextColor(0xffff4401);
                rbtnOrder.setTextColor(0xff6d6d6d);
                rbtnMy.setTextColor(0xff6d6d6d);

                break;
            case R.id.rbtn_order:
                replaceFragment(R.id.frame_replaceFr,new OrderFragment());
                rbtnFirst.setTextColor(0xfff53235);
                rbtnCollect.setTextColor(0xff6d6d6d);
                rbtnDeclare.setTextColor(0xff6d6d6d);
                rbtnOrder.setTextColor(0xffff4401);
                rbtnMy.setTextColor(0xff6d6d6d);
                break;
            case R.id.rbtn_my:
                replaceFragment(R.id.frame_replaceFr,new MyFragment());
                rbtnFirst.setTextColor(0xfff53235);
                rbtnCollect.setTextColor(0xff6d6d6d);
                rbtnDeclare.setTextColor(0xff6d6d6d);
                rbtnOrder.setTextColor(0xffff4401);
                rbtnMy.setTextColor(0xff6d6d6d);
                break;

        }
    }

    public void replaceFragment(int id, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.commit();
    }

}
