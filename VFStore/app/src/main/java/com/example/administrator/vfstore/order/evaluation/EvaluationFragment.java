package com.example.administrator.vfstore.order.evaluation;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.vfstore.R;
import com.example.administrator.vfstore.base.BaseFragment;
import com.example.administrator.vfstore.order.unpay.UnpayAdapter;
import com.example.administrator.vfstore.order.unpay.UnpayBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-2.
 */
public class EvaluationFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private EvaluationAdapter mAdapter;
    private ArrayList<EvaluationBean> mBeanArrayList;

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
        mBeanArrayList = new ArrayList<>();

        EvaluationBean bean = new EvaluationBean();
        for (int i = 0; i < 10; i++) {
            bean.setTitle("lallala");
            mBeanArrayList.add(bean);
        }

        mAdapter.setBeanArrayList(mBeanArrayList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }
}
