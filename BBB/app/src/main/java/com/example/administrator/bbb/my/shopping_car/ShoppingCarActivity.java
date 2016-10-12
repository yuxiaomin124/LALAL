package com.example.administrator.bbb.my.shopping_car;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseActivity;
import com.example.administrator.bbb.my.shopping_car.after.ShoppingCarAfterFragment;
import com.example.administrator.bbb.my.shopping_car.shopping_car_default.ShoppingCarDefultFragment;


/**
 * Created by Administrator on 2016-10-6.
 */
public class ShoppingCarActivity extends BaseActivity implements View.OnClickListener {
    private CheckBox ckEdit;
    private ImageView ivBack;

    @Override
    protected int initLayout() {
        return R.layout.activity_my_shopping_car;
    }

    @Override
    protected void initView() {
        ckEdit = (CheckBox) findViewById(R.id.ck_shopping_car_edit);
        ivBack = (ImageView) findViewById(R.id.iv_my_shopping_car_back);
    }

    @Override
    protected void initData() {
        replaceFragment(R.id.frame_my_shopping_car, new ShoppingCarDefultFragment());
        ckEdit.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ck_shopping_car_edit:
                if (ckEdit.isChecked()) {
                    replaceFragment(R.id.frame_my_shopping_car, new ShoppingCarAfterFragment());
                    ckEdit.setText("完成");
                } else {
                    replaceFragment(R.id.frame_my_shopping_car, new ShoppingCarDefultFragment());
                    ckEdit.setText("编辑");

                }
                break;
            case R.id.iv_my_shopping_car_back:
                finish();
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
