package com.example.administrator.bbb.my.shopping_car.after;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseFragment;
import com.example.administrator.bbb.my.shopping_car.shopping_car_default.ShoppingCarDefultBean;
import com.example.administrator.bbb.tools.URLValues;
import com.example.administrator.bbb.tools.okh.NetTool;
import com.example.administrator.bbb.tools.okh.OnHttpCallBack;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-6.
 */
public class ShoppingCarAfterFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private ShoppingCarAfterAdapter mAfterAdapter;

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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        NetTool.getInstance().startRequest(URLValues.URL_MY_SHOPPING_CAR_DEFAULT, ShoppingCarAfterBean.class, new OnHttpCallBack<ShoppingCarAfterBean>() {
            @Override
            public void onSuccess(ShoppingCarAfterBean response) {
                mAfterAdapter.setAfterBeen(response);
                mRecyclerView.setAdapter(mAfterAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });


        //监听滑动状态 只要recyclerView是滑动状态 就把菜单关掉
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mAfterAdapter.closeMenu();
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mAfterAdapter.closeMenu();
            }
        });
    }
}
