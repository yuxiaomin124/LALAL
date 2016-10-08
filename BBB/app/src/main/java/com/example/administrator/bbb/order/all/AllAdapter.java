package com.example.administrator.bbb.order.all;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.administrator.bbb.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-3.
 */
public class AllAdapter extends RecyclerView.Adapter<AllAdapter.ViewHolder> {
    private ArrayList<AllBean> mAllBeen;
    private Context mContext;


    public AllAdapter(Context context) {
        mContext = context;
    }

    public void setAllBeen(ArrayList<AllBean> allBeen) {
        mAllBeen = allBeen;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.fragment_order_all_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;
        viewHolder.title.setText(mAllBeen.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mAllBeen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_order_all_item_title);


        }
    }
}
