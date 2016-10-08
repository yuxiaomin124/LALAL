package com.example.administrator.bbb.order.unpay;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-2.
 */
public class UnPayFragment extends BaseFragment {
    private UnpayAdapter mAdapter;
    private ArrayList<UnpayBean> mUnpayBeen;
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
        mUnpayBeen = new ArrayList<>();
        UnpayBean bean = new UnpayBean();
        for (int i = 0; i < 10; i++) {
            bean.setTitle("lallala");
            mUnpayBeen.add(bean);
        }

        mAdapter.setBeanArrayList(mUnpayBeen);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }
}
