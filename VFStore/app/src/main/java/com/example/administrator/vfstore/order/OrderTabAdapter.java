package com.example.administrator.vfstore.order;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-2.
 */
public class OrderTabAdapter extends FragmentPagerAdapter {
    private String[] title = {"全部","待付款","待收货","待评价","售后"};
    private ArrayList<Fragment> mFragmentArrayList;

    public void setFragmentArrayList(ArrayList<Fragment> fragmentArrayList) {
        this.mFragmentArrayList = fragmentArrayList;
        notifyDataSetChanged();
    }

    public OrderTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArrayList != null && mFragmentArrayList.size() > 0 ? mFragmentArrayList.get(position) : null;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
