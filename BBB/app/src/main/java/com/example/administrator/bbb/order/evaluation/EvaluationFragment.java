package com.example.administrator.bbb.order.evaluation;


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
public class EvaluationFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private EvaluationAdapter mAdapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_order_evaluation;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.rv_order_evaluation);

    }

    @Override
    protected void initData() {
        mAdapter = new EvaluationAdapter(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        NetTool.getInstance().startRequest(URLValues.URL_RECEIPT_GOODS, EvaluationBean.class, new OnHttpCallBack<EvaluationBean>() {
            @Override
            public void onSuccess(EvaluationBean response) {
                mAdapter.setEvaluationBean(response);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
