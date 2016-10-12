package com.example.administrator.bbb.order.all;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseFragment;
import com.example.administrator.bbb.tools.RVOnItemClickListener;
import com.example.administrator.bbb.tools.URLValues;
import com.example.administrator.bbb.tools.okh.NetTool;
import com.example.administrator.bbb.tools.okh.OnHttpCallBack;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-2.
 */
public class AllFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private AllAdapter mAllAdapter;

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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        NetTool.getInstance().startRequest(URLValues.URL_ALL_ORDER, AllBean.class, new OnHttpCallBack<AllBean>() {
            @Override
            public void onSuccess(AllBean response) {
                mAllAdapter.setAllBeen(response);
                mRecyclerView.setAdapter(mAllAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        mAllAdapter.setMyOnClickListener(new RVOnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "houhou", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
