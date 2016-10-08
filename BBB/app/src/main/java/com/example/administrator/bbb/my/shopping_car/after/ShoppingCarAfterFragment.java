package com.example.administrator.bbb.my.shopping_car.after;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-6.
 */
public class ShoppingCarAfterFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private ShoppingCarAfterAdapter mAfterAdapter;
    private ArrayList<ShoppingCarAfterBean> mAfterBeen;

    @Override
    protected int initLayout() {
        return R.layout.activity_my_shopping_car_edit_after;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.rv_my_shopping_car_after);

    }

    @Override
    protected void initData() {
        mAfterAdapter = new ShoppingCarAfterAdapter(getActivity());
        mAfterBeen = new ArrayList<>();

        ShoppingCarAfterBean bean = new ShoppingCarAfterBean();
        for (int i = 0; i < 10; i++) {
            bean.setColor("lallala");
            mAfterBeen.add(bean);
        }

        mAfterAdapter.setAllBeen(mAfterBeen);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAfterAdapter);

    }
}
