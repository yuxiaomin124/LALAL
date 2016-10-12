package com.example.administrator.bbb.order;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;


import com.example.administrator.bbb.R;
import com.example.administrator.bbb.base.BaseFragment;
import com.example.administrator.bbb.order.after_sales.AfterSalesFragment;
import com.example.administrator.bbb.order.all.AllFragment;
import com.example.administrator.bbb.order.evaluation.EvaluationFragment;
import com.example.administrator.bbb.order.receipt_goods.ReceiptGoodsFragment;
import com.example.administrator.bbb.order.unpay.UnPayFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-9-30.
 */
public class OrderFragment extends BaseFragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragmentArrayList;
    private OrderTabAdapter mAdapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView() {
        mTabLayout = (TabLayout) getView().findViewById(R.id.tab_order);
        mViewPager = (ViewPager) getView().findViewById(R.id.view_pager);
    }

    @Override
    protected void initData() {
        mFragmentArrayList = new ArrayList<>();
        mAdapter = new OrderTabAdapter(getChildFragmentManager());

        mFragmentArrayList.add(new AllFragment());
        mFragmentArrayList.add(new UnPayFragment());
        mFragmentArrayList.add(new ReceiptGoodsFragment());
        mFragmentArrayList.add(new EvaluationFragment());
        mFragmentArrayList.add(new AfterSalesFragment());

        mAdapter.setFragmentArrayList(mFragmentArrayList);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.setTabTextColors(Color.BLACK,0xfaf4810d);
        mTabLayout.setSelectedTabIndicatorColor(0xfaf4810d);
    }
}
