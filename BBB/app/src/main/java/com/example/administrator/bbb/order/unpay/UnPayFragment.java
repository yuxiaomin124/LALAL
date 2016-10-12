package com.example.administrator.bbb.order.unpay;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseFragment;
import com.example.administrator.bbb.tools.URLValues;
import com.example.administrator.bbb.tools.okh.NetTool;
import com.example.administrator.bbb.tools.okh.OnHttpCallBack;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-2.
 */
public class UnPayFragment extends BaseFragment {
    private UnpayAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected int initLayout() {
        return R.layout.fragment_order_unpay;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.rv_order_unpay);

    }

    @Override
    protected void initData() {
        mAdapter = new UnpayAdapter(getActivity());
        NetTool.getInstance().startRequest(URLValues.URL_UNPAY, UnpayBean.class, new OnHttpCallBack<UnpayBean>() {
            @Override
            public void onSuccess(UnpayBean response) {
                mAdapter.setUnpayBean(response);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
