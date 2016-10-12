package com.example.administrator.bbb.my;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseFragment;
import com.example.administrator.bbb.declare.DeclareActivity;
import com.example.administrator.bbb.my.shopping_car.ShoppingCarActivity;
import com.example.administrator.bbb.my.wallet.WalletActivity;
import com.example.administrator.bbb.order.OrderFragment;

/**
 * Created by Administrator on 2016-9-30.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout reOrder, reShoppingCar, reWallet, reShare, reStore;
    private String loginSuccess;
    public static final String ACTION_TAB = "com.example.administrator.bbb.ACTION_TAB";
    private Intent mIntentTab;

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

        BroadcastRegister();

        mIntentTab = new Intent();
    }

    @Override
    public void onClick(View v) {
        SharedPreferences getSp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        switch (v.getId()) {
            case R.id.reLayout_my_order:
                if (getSp.getBoolean("Boolean", false)) {
                    if (loginSuccess != null && loginSuccess.equals("登录成功")) {
                        Toast.makeText(getActivity(), "订单", Toast.LENGTH_SHORT).show();

                        mIntentTab.putExtra("tab", "谈的的啊啊啊啊啊");
                        mIntentTab.setAction(ACTION_TAB);
                        Log.d("MyFragment", "什么啊");
                        getActivity().sendBroadcast(mIntentTab);
                    }
                    else {
                        jump();
                        Log.d("MyFragment", "不晓得啊");
                    }
                }else {
                    jump();
                    Log.d("MyFragment", "好吧好吧");
                }
                break;
            case R.id.reLayout_my_shopping_car:
                if (loginSuccess != null && loginSuccess.equals("登录成功")) {
                    Intent intent = new Intent(getActivity(), ShoppingCarActivity.class);
                    startActivity(intent);
                } else
                    jump();
                break;
            case R.id.reLayout_my_wallet:
                if (loginSuccess != null && loginSuccess.equals("登录成功")) {
                    Intent intentWallet = new Intent(getActivity(), WalletActivity.class);
                    startActivity(intentWallet);
                } else {
                    jump();
                }
                break;
            case R.id.reLayout_my_share:
                if (loginSuccess != null && loginSuccess.equals("登录成功")) {
                    Toast.makeText(getActivity(), "分享", Toast.LENGTH_SHORT).show();
                } else {
                    jump();
                }
                break;
            case R.id.reLayout_my_store:
                if (loginSuccess != null && loginSuccess.equals("登录成功")) {
                    Toast.makeText(getActivity(), "我的商铺", Toast.LENGTH_SHORT).show();
                } else {
                    jump();
                }
                break;
        }
    }

    private void jump() {
        Intent intent = new Intent(getActivity(), DeclareActivity.class);
        startActivity(intent);
    }

    private BroadcastReceiver mBReceiverLoginSuccess = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                case DeclareActivity.ACTION_LOGIN_SUCCESS:
                    loginSuccess = intent.getStringExtra("declareSuccess");
                    break;
            }
        }
    };

    private void BroadcastRegister() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DeclareActivity.ACTION_LOGIN_SUCCESS);
        getActivity().registerReceiver(mBReceiverLoginSuccess, intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(mBReceiverLoginSuccess);
    }
}
