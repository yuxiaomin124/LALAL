package com.example.administrator.vfstore.order.all;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.vfstore.R;
import com.example.administrator.vfstore.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-2.
 */
public class AllFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private AllAdapter mAllAdapter;
    private ArrayList<AllBean> mBeanArrayList;

    @Override
    protected int initLayout() {
        return R.layout.fragment_order_all;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.rv_order_all);
    }

    @Override
    protected void initData() {
        mAllAdapter = new AllAdapter(getActivity());
        mBeanArrayList = new ArrayList<>();

        AllBean bean = new AllBean();
        for (int i = 0; i < 10; i++) {
            bean.setTitle("lallala");
            mBeanArrayList.add(bean);
        }

        mAllAdapter.setAllBeen(mBeanArrayList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAllAdapter);
    }
}
