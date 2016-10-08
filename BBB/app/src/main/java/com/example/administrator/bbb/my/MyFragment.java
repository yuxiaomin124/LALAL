package com.example.administrator.bbb.my;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseFragment;
import com.example.administrator.bbb.declare.DeclareActivity;
import com.example.administrator.bbb.my.shopping_car.ShoppingCarActivity;
import com.example.administrator.bbb.my.wallet.WalletActivity;

/**
 * Created by Administrator on 2016-9-30.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout reOrder, reShoppingCar, reWallet, reShare, reStore;

    @Override
    protected int initLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        reOrder = (RelativeLayout) getView().findViewById(R.id.reLayout_my_order);
        reShoppingCar = (RelativeLayout) getView().findViewById(R.id.reLayout_my_shopping_car);
        reWallet = (RelativeLayout) getView().findViewById(R.id.reLayout_my_wallet);
        reShare = (RelativeLayout) getView().findViewById(R.id.reLayout_my_share);
        reStore = (RelativeLayout) getView().findViewById(R.id.reLayout_my_store);

    }

    @Override
    protected void initData() {
        reOrder.setOnClickListener(this);
        reShoppingCar.setOnClickListener(this);
        reWallet.setOnClickListener(this);
        reShare.setOnClickListener(this);
        reStore.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reLayout_my_order:
                jump();

                break;
            case R.id.reLayout_my_shopping_car:
//                jump();
                Intent intent = new Intent(getActivity(),ShoppingCarActivity.class);
                startActivity(intent);
                break;
            case R.id.reLayout_my_wallet:

                Intent intentWallet = new Intent(getActivity(), WalletActivity.class);
                startActivity(intentWallet);
//                jump();
                break;
            case R.id.reLayout_my_share:


//                jump();
                break;
            case R.id.reLayout_my_store:
//                jump();
                break;
        }
    }

    private void jump() {
        Intent intent = new Intent(getActivity(), DeclareActivity.class);
        startActivity(intent);
    }
}
