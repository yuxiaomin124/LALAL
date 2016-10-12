package com.example.administrator.bbb.order.receipt_goods;

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
public class ReceiptGoodsFragment extends BaseFragment {
    private ReceiptGoodsAdapter mReceiptGoodsAdapter;
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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        NetTool.getInstance().startRequest(URLValues.URL_RECEIPT_GOODS, ReceiptGoodsBean.class, new OnHttpCallBack<ReceiptGoodsBean>() {
            @Override
            public void onSuccess(ReceiptGoodsBean response) {
                mReceiptGoodsAdapter.setReceiptGoodsBean(response);
                mRecyclerView.setAdapter(mReceiptGoodsAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }
}

