package com.example.administrator.bbb.my.shopping_car.shopping_car_default;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-6.
 */
public class ShoppingCarDefultFragment extends BaseFragment {

    private ShoppingCarDefultAdapter mDefultAdapter;
    private ArrayList<ShoppingCarDefultBean> mDefultBeen;
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
        mDefultBeen = new ArrayList<>();

        ShoppingCarDefultBean bean = new ShoppingCarDefultBean();
        for (int i = 0; i < 10; i++) {
            bean.setColor("lallala");
            mDefultBeen.add(bean);
        }

        mDefultAdapter.setAllBeen(mDefultBeen);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mDefultAdapter);
    }
}
