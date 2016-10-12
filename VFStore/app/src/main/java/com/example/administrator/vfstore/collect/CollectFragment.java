package com.example.administrator.vfstore.collect;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.administrator.vfstore.R;
import com.example.administrator.vfstore.base.BaseFragment;
import com.example.administrator.vfstore.collect.collect_adapter.CollectTabAdapter;
import com.example.administrator.vfstore.collect.collect_fragment.CollectBrandFragment;
import com.example.administrator.vfstore.collect.collect_fragment.CollectCommodityFragment;
import com.example.administrator.vfstore.order.OrderTabAdapter;
import com.example.administrator.vfstore.order.after_sales.AfterSalesFragment;
import com.example.administrator.vfstore.order.all.AllFragment;
import com.example.administrator.vfstore.order.evaluation.EvaluationFragment;
import com.example.administrator.vfstore.order.receipt_goods.ReceiptGoodsFragment;
import com.example.administrator.vfstore.order.unpay.UnPayFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-9-30.
 */
public class CollectFragment extends BaseFragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragmentArrayList;
    private CollectTabAdapter mAdapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_collect;
    }

    @Override
    protected void initView() {
        mTabLayout = (TabLayout) getView().findViewById(R.id.tab_order);
        mViewPager = (ViewPager) getView().findViewById(R.id.view_pager);
    }

    @Override
    protected void initData() {
        {
            mFragmentArrayList = new ArrayList<>();
            mAdapter = new CollectTabAdapter(getChildFragmentManager());

            mFragmentArrayList.add(new CollectBrandFragment());
            mFragmentArrayList.add(new CollectCommodityFragment());


            mAdapter.setFragmentArrayList(mFragmentArrayList);
            mViewPager.setAdapter(mAdapter);
            mTabLayout.setupWithViewPager(mViewPager);

            mTabLayout.setTabTextColors(Color.BLACK,Color.RED);
            mTabLayout.setSelectedTabIndicatorColor(Color.RED);
        }
    }
}
