package com.example.administrator.vfstore.collect.collect_adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2016/10/5.
 */
public class CollectTabAdapter extends FragmentPagerAdapter {
    private String[] title = {"品牌","商品"};
    private ArrayList<Fragment> mFragmentArrayList;

    public void setFragmentArrayList(ArrayList<Fragment> fragmentArrayList) {
        this.mFragmentArrayList = fragmentArrayList;
        notifyDataSetChanged();
    }

    public CollectTabAdapter(FragmentManager fm) {
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
