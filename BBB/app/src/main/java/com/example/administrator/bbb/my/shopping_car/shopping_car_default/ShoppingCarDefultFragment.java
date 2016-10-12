package com.example.administrator.bbb.my.shopping_car.shopping_car_default;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseFragment;
import com.example.administrator.bbb.tools.URLValues;
import com.example.administrator.bbb.tools.okh.NetTool;
import com.example.administrator.bbb.tools.okh.OnHttpCallBack;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-6.
 */
public class ShoppingCarDefultFragment extends BaseFragment {

    private ShoppingCarDefultAdapter mDefultAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected int initLayout() {
        return R.layout.activity_my_shopping_car_edit_default;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.rv_my_shopping_car_default);

    }

    @Override
    protected void initData() {
        mDefultAdapter = new ShoppingCarDefultAdapter(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        NetTool.getInstance().startRequest(URLValues.URL_MY_SHOPPING_CAR_DEFAULT, ShoppingCarDefultBean.class, new OnHttpCallBack<ShoppingCarDefultBean>() {
            @Override
            public void onSuccess(ShoppingCarDefultBean response) {
                mDefultAdapter.setDefultBean(response);
                mRecyclerView.setAdapter(mDefultAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
