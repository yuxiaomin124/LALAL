package com.example.administrator.bbb.order.receipt_goods;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-2.
 */
public class ReceiptGoodsFragment extends BaseFragment {
    private ReceiptGoodsAdapter mReceiptGoodsAdapter;
    private ArrayList<ReceiptGoodsBean> mBeen;
    private RecyclerView mRecyclerView;

    @Override
    protected int initLayout() {
        return R.layout.fragment_order_receipt_goods;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.rv_order_receipt_goods);
    }

    @Override
    protected void initData() {
        mReceiptGoodsAdapter = new ReceiptGoodsAdapter(getActivity());
        mBeen = new ArrayList<>();

        ReceiptGoodsBean bean = new ReceiptGoodsBean();
        for (int i = 0; i < 10; i++) {
            bean.setTitle("lallala");
            mBeen.add(bean);
        }

        mReceiptGoodsAdapter.setBeanArrayList(mBeen);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mReceiptGoodsAdapter);
    }
}

